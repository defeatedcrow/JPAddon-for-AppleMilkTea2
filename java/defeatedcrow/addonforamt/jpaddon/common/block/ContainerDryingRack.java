package defeatedcrow.addonforamt.jpaddon.common.block;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerDryingRack extends Container {

	private TileDryingRack tile;

	private int[] lastStart = { 0, 0, 0, 0 };
	private int[] lastNeed = { 0, 0, 0, 0 };
	private int[] lastDay = { 0, 0, 0, 0 };

	public ContainerDryingRack(EntityPlayer player, TileDryingRack par2TileEntity) {
		this.tile = par2TileEntity;

		// 材料
		int j;
		for (j = 0; j < 4; ++j) {
			this.addSlotToContainer(new Slot(this.tile, j, 53 + j * 18, 63));
		}

		// 完成品
		int k;
		for (k = 0; k < 4; ++k) {
			this.addSlotToContainer(new SlotFurnace(player, this.tile, 4 + k, 53 + k * 18, 13));
			this.addSlotToContainer(new SlotFurnace(player, this.tile, 8 + k, 53 + k * 18, 31));
		}

		int i;

		// 1 ～ 3段目のインベントリ
		for (i = 0; i < 3; ++i) {
			for (int h = 0; h < 9; ++h) {
				this.addSlotToContainer(new Slot(player.inventory, h + i * 9 + 9, 8 + h * 18, 84 + i * 18));
			}
		}

		// 4段目のインベントリ
		for (i = 0; i < 9; ++i) {
			this.addSlotToContainer(new Slot(player.inventory, i, 8 + i * 18, 142));
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer par1EntityPlayer) {
		return this.tile.isUseableByPlayer(par1EntityPlayer);
	}

	@Override
	public void addCraftingToCrafters(ICrafting par1ICrafting) {
		super.addCraftingToCrafters(par1ICrafting);
		for (int i = 0; i < 4; i++) {
			par1ICrafting.sendProgressBarUpdate(this, i, this.tile.startDays[i]);
			par1ICrafting.sendProgressBarUpdate(this, 4 + i, this.tile.needDays[i]);
			par1ICrafting.sendProgressBarUpdate(this, 8 + i, this.tile.days[i]);
		}
	}

	// 更新を送る
	@Override
	public void detectAndSendChanges() {
		super.detectAndSendChanges();

		for (int i = 0; i < this.crafters.size(); ++i) {
			ICrafting icrafting = (ICrafting) this.crafters.get(i);
			int j = i & 3;

			if (i < 4) {
				if (this.lastStart[i] != this.tile.startDays[i]) {
					icrafting.sendProgressBarUpdate(this, i, this.tile.startDays[i]);
				}
				this.lastStart[i] = this.tile.startDays[i];
			} else if (i < 8) {
				if (this.lastNeed[i] != this.tile.needDays[i]) {
					icrafting.sendProgressBarUpdate(this, i, this.tile.needDays[i]);
				}
				this.lastNeed[i] = this.tile.needDays[i];
			} else {
				if (this.lastDay[j] != this.tile.days[j]) {
					icrafting.sendProgressBarUpdate(this, j, this.tile.days[j]);
				}
				this.lastDay[j] = this.tile.days[j];
			}

		}
	}

	// 更新する
	@Override
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int par1, int par2) {
		int j = par1 & 3;
		if (par1 < 4) {
			this.tile.startDays[j] = par2;
		} else if (par1 < 8) {
			this.tile.needDays[j] = par2;
		} else {
			this.tile.days[j] = par2;
		}
	}

	// Shiftクリック
	@Override
	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2) {
		ItemStack itemstack = null;
		if (par2 > 48)
			par2 = 48;
		Slot slot = (Slot) this.inventorySlots.get(par2);

		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			// カーソルを排出スロットにあわせているとき
			if (par2 < 12) {
				// アイテムの移動(スロット3～39へ)
				if (!this.mergeItemStack(itemstack1, 12, 48, true)) {
					return null;
				}
				slot.onSlotChange(itemstack1, itemstack);
			}
			// それ以外
			else {
				// アイテムの移動(スロット0～3へ)
				if (!this.mergeItemStack(itemstack1, 0, 4, false)) {
					return null;
				}
				slot.onSlotChange(itemstack1, itemstack);
			}

			if (itemstack1.stackSize == 0) {
				slot.putStack((ItemStack) null);
			} else {
				slot.onSlotChanged();
			}

			if (itemstack1.stackSize == itemstack.stackSize) {
				return null;
			}

			slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
		}

		return itemstack;
	}

}
