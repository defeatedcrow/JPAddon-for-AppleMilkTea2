package defeatedcrow.addonforamt.jpaddon.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import defeatedcrow.addonforamt.jpaddon.common.block.ContainerDryingRack;
import defeatedcrow.addonforamt.jpaddon.common.block.TileDryingRack;

public class GuiDryingRack extends GuiContainer {

	private TileDryingRack tile;

	public GuiDryingRack(EntityPlayer player, TileDryingRack par2TileEntity) {
		super(new ContainerDryingRack(player, par2TileEntity));
		this.tile = par2TileEntity;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int x, int y) {
		// インベントリ名の描画
		String s = this.tile.hasCustomInventoryName() ? this.tile.getInventoryName() : I18n.format(
				this.tile.getInventoryName(), new Object[0]);
		this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 2, 4210752);

		String mode = StatCollector.translateToLocal("amtjp.dryingrack.Mode") + ":";
		String dry = StatCollector.translateToLocal("amtjp.dryingrack.drying");
		String ferm = StatCollector.translateToLocal("amtjp.dryingrack.fermentation");

		this.fontRendererObj.drawString(I18n.format(mode, new Object[0]), 133, this.ySize - 107 + 2, 16777215);
		if (tile.DryOrFerm()) {
			this.fontRendererObj.drawString(I18n.format(dry, new Object[0]), 133, this.ySize - 98 + 2, 16777215);
		} else {
			this.fontRendererObj.drawString(I18n.format(ferm, new Object[0]), 133, this.ySize - 98 + 2, 16777215);
		}

	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int x, int y) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

		this.mc.getTextureManager().bindTexture(new ResourceLocation("amtjp", this.GuiTexPass()));

		// かまど描画処理
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
		int i1;
		int i2 = 0;
		int dry = tile.DryOrFerm() ? 12 : 24;
		int dryamp = tile.getDryLevel();
		int fermamp = tile.getFermLevel();

		// progress bar
		for (int j = 0; j < 4; j++) {
			i1 = this.tile.getCookProgressScaled(12, j);
			this.drawTexturedModalRect(k + 53 + j * 18, l + 49 + 12 - i1, 176, dry - i1, 16, i1);
		}

		// sun icon
		if (tile.DryOrFerm()) {
			switch (dryamp) {
			case 0:
				i2 = 78;
				break;
			case 1:
				i2 = 0;
				break;
			case 2:
				i2 = 26;
				break;
			default:
				i2 = 13;
				break;
			}
		} else {
			switch (fermamp) {
			case 0:
				i2 = 78;
				break;
			case 1:
				i2 = 39;
				break;
			case 2:
				i2 = 52;
				break;
			default:
				i2 = 65;
				break;
			}
		}
		this.drawTexturedModalRect(k + 140, l + 46, 192, i2, 13, 13);

	}

	public String GuiTexPass() {
		return "textures/gui/dryer.png";
	}

}
