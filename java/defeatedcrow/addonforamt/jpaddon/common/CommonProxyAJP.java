package defeatedcrow.addonforamt.jpaddon.common;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import defeatedcrow.addonforamt.jpaddon.client.gui.GuiDryingRack;
import defeatedcrow.addonforamt.jpaddon.client.item.ModelHaori;
import defeatedcrow.addonforamt.jpaddon.client.item.ModelKimonoTite;
import defeatedcrow.addonforamt.jpaddon.common.block.ContainerDryingRack;
import defeatedcrow.addonforamt.jpaddon.common.block.TileAlabasterLamp;
import defeatedcrow.addonforamt.jpaddon.common.block.TileChandelier;
import defeatedcrow.addonforamt.jpaddon.common.block.TileDryingRack;

public class CommonProxyAJP implements IGuiHandler {

	public int getRenderID() {
		return -1;
	}

	public void registerRenderers() {
	}

	public int addArmor(String armor) {
		return 0;
	}

	public World getClientWorld() {

		return null;
	}

	public void registerFluidTex() {
	}

	public void registerTileEntity() {
		GameRegistry.registerTileEntity(TileDryingRack.class, "amtjp.tile.drying_rack");
		GameRegistry.registerTileEntity(TileAlabasterLamp.class, "amtjp.tile.lamp_alabaster");
		GameRegistry.registerTileEntity(TileChandelier.class, "amtjp.tile.chandelier");
	}

	// GUIの登録
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (!world.blockExists(x, y, z))
			return null;

		TileEntity tileentity = world.getTileEntity(x, y, z);
		if (tileentity instanceof TileDryingRack) {
			return new ContainerDryingRack(player, (TileDryingRack) tileentity);
		}

		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (!world.blockExists(x, y, z))
			return null;

		TileEntity tileentity = world.getTileEntity(x, y, z);
		if (tileentity instanceof TileDryingRack) {
			return new GuiDryingRack(player, (TileDryingRack) tileentity);
		}

		return null;
	}

	public ModelKimonoTite getKimonoModel() {
		return null;
	}

	public ModelHaori getHaoriModel() {
		return null;
	}

	public void loadNEI() {
	}

	public boolean vanillaFancyRenderMode() {
		return false;
	}

}
