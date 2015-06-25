package defeatedcrow.addonforamt.jpaddon.common.block;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.util.ForgeDirection;
import buildcraft.api.transport.IPipeConnection;
import buildcraft.api.transport.IPipeTile.PipeType;
import cpw.mods.fml.common.Optional;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import defeatedcrow.addonforamt.jpaddon.AJPLogger;
import defeatedcrow.addonforamt.jpaddon.api.IDryerRecipe;
import defeatedcrow.addonforamt.jpaddon.api.IFermenterRecipe;
import defeatedcrow.addonforamt.jpaddon.api.RecipeManagerJP;
import defeatedcrow.addonforamt.jpaddon.util.TimeCounter;

@Optional.InterfaceList({ @Optional.Interface(iface = "buildcraft.api.transport.IPipeConnection", modid = "BuildCraftAPI|transport"), })
public class TileDryingRack extends TileEntity implements ISidedInventory, IPipeConnection {

	protected int[] days = {
			0,
			0,
			0,
			0 };
	protected int[] startDays = {
			-1,
			-1,
			-1,
			-1 };
	protected int[] needDays = {
			0,
			0,
			0,
			0 };
	protected boolean[] finish = {
			false,
			false,
			false,
			false };

	private int today = 0;

	protected int[] lastAmounts = {
			0,
			0,
			0,
			0 };

	@Override
	public void readFromNBT(NBTTagCompound par1NBTTagCompound) {
		super.readFromNBT(par1NBTTagCompound);

		// アイテムの読み込み
		NBTTagList nbttaglist = par1NBTTagCompound.getTagList("Items", 10);
		this.dryItems = new ItemStack[this.getSizeInventory()];

		for (int i = 0; i < nbttaglist.tagCount(); ++i) {
			NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
			byte b0 = nbttagcompound1.getByte("Slot");

			if (b0 >= 0 && b0 < this.dryItems.length) {
				this.dryItems[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
			}
		}

		for (int i = 0; i < 4; i++) {
			this.startDays[i] = par1NBTTagCompound.getInteger("Days" + i);
			this.needDays[i] = par1NBTTagCompound.getInteger("Needs" + i);
			this.days[i] = par1NBTTagCompound.getInteger("Pass" + i);
			this.finish[i] = par1NBTTagCompound.getBoolean("Finish" + i);
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound par1NBTTagCompound) {
		super.writeToNBT(par1NBTTagCompound);

		// 燃焼時間や調理時間などの書き込み
		for (int i = 0; i < 4; i++) {
			par1NBTTagCompound.setInteger("Days" + i, (short) this.startDays[i]);
			par1NBTTagCompound.setInteger("Needs" + i, (short) this.needDays[i]);
			par1NBTTagCompound.setInteger("Pass" + i, (short) this.days[i]);
			par1NBTTagCompound.setBoolean("Finish", this.finish[i]);
		}

		// アイテムの書き込み
		NBTTagList nbttaglist = new NBTTagList();

		for (int i = 0; i < this.dryItems.length; ++i) {
			if (this.dryItems[i] != null) {
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setByte("Slot", (byte) i);
				this.dryItems[i].writeToNBT(nbttagcompound1);
				nbttaglist.appendTag(nbttagcompound1);
			}
		}

		par1NBTTagCompound.setTag("Items", nbttaglist);

	}

	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound nbtTagCompound = new NBTTagCompound();
		this.writeToNBT(nbtTagCompound);
		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, nbtTagCompound);
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
		this.readFromNBT(pkt.func_148857_g());
	}

	/* --- GUI用 --- */

	@SideOnly(Side.CLIENT)
	public int getCookProgressScaled(int size, int num) {
		Minecraft minecraft = Minecraft.getMinecraft();
		float f = TimeCounter.currentTime(minecraft.theWorld) / 24.0F;
		float progress = this.days[num] + f;
		int need = this.needDays[num];
		return need == 0 ? 0 : (int) (progress * size) / need;
	}

	/*--- クラフト処理 ---*/

	public void addDays(int add) {
		for (int i = 0; i < 4; i++) {
			if (startDays[i] > 0) {
				days[i] += add;
			}
		}
	}

	@Override
	public void updateEntity() {
		if (!worldObj.isRemote) {
			this.onServerUpdate();
		}

		boolean flag = true;
		if (flag) {
			boolean needUpdate = false;

			// slot毎の処理
			for (int i = 0; i < 4; i++) {
				ItemStack in = this.getStackInSlot(i);
				ItemStack out = this.getStackInSlot(i + 4);
				ItemStack sec = this.getStackInSlot(i + 8);

				if (this.finish[i] && out == null) {
					this.finish[i] = false;
					needUpdate = true;
				}

				if (in != null) {
					boolean fin = false;

					if (startDays[i] > -1) {
						if (this.days[i] >= this.needDays[i]) {
							AJPLogger
									.debugInfo("Today : " + today + ", needDay : " + needDays[i] + "Pass : " + days[i]);
							fin = true;
						} else {
							int today = TimeCounter.getDay(worldObj) & Short.MAX_VALUE;
							int pass = today - this.startDays[i];
							if (pass > 0) { // 日数が進んだ
								if (this.DryOrFerm()) {
									this.days[i] += this.getDryLevel() * pass;
								} else {
									this.days[i] += this.getFermLevel() * pass;
								}
								this.startDays[i] = today;
								AJPLogger.debugInfo("Pass : " + days[i]);
								needUpdate = true;
							} else if (pass < -1) { // 何らかの原因で時間が戻った
								// スタート日時の再設定
								this.startDays[i] = today;
							}
						}

						if (fin && this.canCraft(in)) {

							ItemStack result = null;
							ItemStack container = null;
							if (this.DryOrFerm()) {
								IDryerRecipe recipe = RecipeManagerJP.dryerRecipe.getRecipe(in);
								result = recipe.getOutput();
								container = recipe.getSecondary(in);
							} else {
								IFermenterRecipe recipe = RecipeManagerJP.fermRecipe.getRecipe(in);
								result = recipe.getOutput();
								container = recipe.getSecondary(in);
							}

							boolean flag1 = false;
							boolean flag2 = false;

							if (result != null) {
								if (out == null) {
									flag1 = true;
								} else {
									if (out.isItemEqual(result)) {
										int st = out.stackSize + result.stackSize;
										flag1 = (st <= this.getInventoryStackLimit() && st <= out.getMaxStackSize());
									}
								}

								if (flag1) {
									if (container != null) {
										if (sec == null) {
											flag2 = true;
										} else {
											if (sec.isItemEqual(container)) {
												int st = sec.stackSize + container.stackSize;
												flag2 = (st <= this.getInventoryStackLimit() && st <= sec
														.getMaxStackSize());
											}
										}
									} else {
										flag2 = true;
									}
								}
							}

							// 処理
							if (flag1 && flag2) {
								// リザルト増加
								if (out == null) {
									this.setInventorySlotContents(i + 4, result.copy());
								} else {
									this.getStackInSlot(i + 4).stackSize += result.stackSize;
								}

								if (container != null) {
									if (sec == null) {
										this.setInventorySlotContents(i + 8, container.copy());
									} else {
										this.getStackInSlot(i + 8).stackSize += container.stackSize;
									}
								}

								// 減少
								if (this.decrStackSize(i, 1) != null) {
									this.finish[i] = true;
									this.startDays[i] = -1;
									this.needDays[i] = 0;
									this.days[i] = 0;
									this.markDirty();
									needUpdate = true;
								}
							}
						}

					} else {
						if (this.canCraft(in)) {
							// 開始判定
							if (this.DryOrFerm()) {
								int today = TimeCounter.getDay(worldObj) & Short.MAX_VALUE;
								AJPLogger.debugInfo("Today : " + today);

								IDryerRecipe recipe = RecipeManagerJP.dryerRecipe.getRecipe(in);
								if (recipe != null) {
									this.startDays[i] = today;
									this.needDays[i] = recipe.getTime();

									String s = "Start dryer : " + in.getDisplayName() + " / " + recipe.getTime();
									AJPLogger.debugInfo(s);
								}
								needUpdate = true;
							} else {
								IFermenterRecipe recipe = RecipeManagerJP.fermRecipe.getRecipe(in);
								if (recipe != null) {
									this.startDays[i] = TimeCounter.getDay(worldObj) & Short.MAX_VALUE;
									this.needDays[i] = recipe.getTime();

									String s = "Start fermenter : " + in.getDisplayName() + " / " + recipe.getTime();
									AJPLogger.debugInfo(s);
								}
								needUpdate = true;
							}
						}
					}
				} else {
					if (this.startDays[i] > -1) {
						this.startDays[i] = -1;
						this.needDays[i] = 0;
						this.days[i] = 0;
					}
				}
			}

			if (needUpdate) {
				markDirty();
				this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
			}
		}
	}

	// レシピが存在するかだけ見る
	private boolean canCraft(ItemStack in) {
		if (in == null) {
			return false;
		} else {
			if (this.DryOrFerm()) {
				List<IDryerRecipe> driers = new ArrayList<IDryerRecipe>(RecipeManagerJP.dryerRecipe.getRecipes());
				if (driers.isEmpty())
					return false;
				for (IDryerRecipe recipe : driers) {
					if (recipe.matches(in)) {
						return true;
					}
				}
			} else {
				List<IFermenterRecipe> ferms = new ArrayList<IFermenterRecipe>(RecipeManagerJP.fermRecipe.getRecipes());
				if (ferms.isEmpty())
					return false;
				for (IFermenterRecipe recipe : ferms) {
					if (recipe.matches(in)) {
						return true;
					}
				}
			}
			return false;
		}
	}

	private void onServerUpdate() {
		boolean flag = false;
		for (int i = 0; i < 3; i++) {
			if (this.getStackInSlot(i) != null) {
				Item item = this.getStackInSlot(i).getItem();
				int l = item.getIdFromItem(item) + this.getStackInSlot(i).stackSize;
				if (l != lastAmounts[i]) {
					lastAmounts[i] = l;
					flag = true;
				}
			}
		}

		if (flag) {
			this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
		}
	}

	/* --- 稼働条件判定 --- */

	public boolean DryOrFerm() {
		if (worldObj.canBlockSeeTheSky(xCoord, yCoord + 1, zCoord)
				|| worldObj.getBlockLightValue(xCoord, yCoord + 1, zCoord) > 10) {
			return true;
		} else if (worldObj.provider.isHellWorld) {
			return true;
		} else {
			return false;
		}
	}

	public int getDryLevel() {

		int l = 1;
		BiomeGenBase biome = this.worldObj.getBiomeGenForCoords(xCoord, zCoord);

		if (biome.isHighHumidity()) {
			l -= 1;
		}
		if (BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.WET)) {
			l -= 1;
		}
		if (BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.OCEAN)) {
			l += 1;
		}
		if (BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.HOT)) {
			l += 1;
		}
		if (BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.DRY)) {
			l += 2;
		} else if (worldObj.isRaining()) {
			l -= 2;
		}

		if (l < 0)
			l = 0;
		return l;
	}

	public int getFermLevel() {

		int l = 1;
		BiomeGenBase biome = this.worldObj.getBiomeGenForCoords(xCoord, zCoord);

		if (biome.isHighHumidity()) {
			l += 2;
		}
		if (BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.WET)
				|| BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.FOREST)
				|| BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.MUSHROOM)) {
			l += 1;
		}
		if (BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.HOT)) {
			l += 1;
		}
		if (BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.COLD)) {
			l -= 1;
		}
		if (BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.DRY)) {
			l -= 2;
		}

		if (l < 0)
			l = 0;
		return l;
	}

	/* --- inventory --- */

	private static final int[] slots_top = new int[] {
			0,
			1,
			2,
			3 };
	private static final int[] slots_bottom = new int[] {
			4,
			5,
			6,
			7,
			8,
			9,
			10,
			11 };
	private static final int[] slots_sides = new int[] {
			0,
			1,
			2,
			3,
			4,
			5,
			6,
			7,
			8,
			9,
			10,
			11 };

	public ItemStack[] dryItems = new ItemStack[12];

	@Override
	public int getSizeInventory() {
		return this.dryItems.length;
	}

	// インベントリ内の任意のスロットにあるアイテムを取得
	@Override
	public ItemStack getStackInSlot(int par1) {
		par1 = MathHelper.clamp_int(par1, 0, (this.getSizeInventory() - 1));
		return this.dryItems[par1];
	}

	@Override
	public ItemStack decrStackSize(int par1, int par2) {
		par1 = MathHelper.clamp_int(par1, 0, (this.getSizeInventory() - 1));
		if (this.dryItems[par1] != null) {
			ItemStack itemstack = null;

			if (this.dryItems[par1].stackSize <= par2) {
				itemstack = this.dryItems[par1];
				this.dryItems[par1] = null;
				return itemstack;
			} else {
				itemstack = this.dryItems[par1].splitStack(par2);

				if (this.dryItems[par1].stackSize == 0) {
					this.dryItems[par1] = null;
				}

				return itemstack;
			}
		} else {
			return null;
		}
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int par1) {
		par1 = MathHelper.clamp_int(par1, 0, this.getSizeInventory() - 1);
		if (this.dryItems[par1] != null) {
			ItemStack itemstack = this.dryItems[par1];
			this.dryItems[par1] = null;
			return itemstack;
		} else {
			return null;
		}
	}

	@Override
	public void setInventorySlotContents(int par1, ItemStack par2ItemStack) {

		if (par1 > 11)
			par1 = par1 & 3;// 存在しないスロットに入れようとすると強制的に材料スロットに変更される。

		this.dryItems[par1] = par2ItemStack;

		if (par2ItemStack != null && par2ItemStack.stackSize > this.getInventoryStackLimit()) {
			par2ItemStack.stackSize = this.getInventoryStackLimit();
		}
	}

	@Override
	public String getInventoryName() {
		return StatCollector.translateToLocal("amtjp.dryingrack.guiname");
	}

	@Override
	public boolean hasCustomInventoryName() {
		return true;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer) {
		return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : par1EntityPlayer
				.getDistanceSq(this.xCoord + 0.5D, this.yCoord + 0.5D, this.zCoord + 0.5D) <= 64.0D;
	}

	@Override
	public void openInventory() {
	}

	@Override
	public void closeInventory() {
	}

	@Override
	public boolean isItemValidForSlot(int par1, ItemStack par2ItemStack) {
		return par1 < 3 ? true : false;
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int par1) {
		return par1 == 0 ? slots_bottom : (par1 == 1 ? slots_top : slots_sides);
	}

	@Override
	public boolean canInsertItem(int par1, ItemStack par2ItemStack, int par3) {
		return this.isItemValidForSlot(par1, par2ItemStack);
	}

	@Override
	public boolean canExtractItem(int par1, ItemStack par2ItemStack, int par3) {
		return par1 > 3 && par1 < 12;
	}

	@Optional.Method(modid = "BuildCraftAPI|transport")
	@Override
	public ConnectOverride overridePipeConnection(PipeType type, ForgeDirection with) {
		return type == PipeType.ITEM ? ConnectOverride.CONNECT : ConnectOverride.DISCONNECT;
	}

}
