package defeatedcrow.addonforamt.jpaddon.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import defeatedcrow.addonforamt.jpaddon.AJPLogger;
import defeatedcrow.addonforamt.jpaddon.AddonJPCore;
import defeatedcrow.addonforamt.jpaddon.client.block.RenderAlabasterChandelier;
import defeatedcrow.addonforamt.jpaddon.client.block.RenderAlabasterLamp;
import defeatedcrow.addonforamt.jpaddon.client.block.RenderBlockDryingRack;
import defeatedcrow.addonforamt.jpaddon.client.block.RenderOres;
import defeatedcrow.addonforamt.jpaddon.client.block.RenderTileAlabasterChandelier;
import defeatedcrow.addonforamt.jpaddon.client.block.RenderTileAlabasterLamp;
import defeatedcrow.addonforamt.jpaddon.client.block.RenderTileDryingRack;
import defeatedcrow.addonforamt.jpaddon.client.entity.RenderEntityGlassDish;
import defeatedcrow.addonforamt.jpaddon.client.entity.RenderEntityJPBowl;
import defeatedcrow.addonforamt.jpaddon.client.entity.RenderEntityJPDish;
import defeatedcrow.addonforamt.jpaddon.client.entity.RenderEntityJPDrink;
import defeatedcrow.addonforamt.jpaddon.client.entity.RenderEntityNoDish;
import defeatedcrow.addonforamt.jpaddon.client.entity.RenderEntityRiceBowl;
import defeatedcrow.addonforamt.jpaddon.client.entity.RenderEntityRoastPig;
import defeatedcrow.addonforamt.jpaddon.client.entity.RenderEntitySquareDish;
import defeatedcrow.addonforamt.jpaddon.client.entity.RenderEntityWhiteDish;
import defeatedcrow.addonforamt.jpaddon.client.entity.RenderEntityWoodBowl;
import defeatedcrow.addonforamt.jpaddon.client.entity.RenderWindProjectile;
import defeatedcrow.addonforamt.jpaddon.client.item.ModelHaori;
import defeatedcrow.addonforamt.jpaddon.client.item.ModelKimonoTite;
import defeatedcrow.addonforamt.jpaddon.client.item.RenderItemRoastPig;
import defeatedcrow.addonforamt.jpaddon.common.CommonProxyAJP;
import defeatedcrow.addonforamt.jpaddon.common.block.TileAlabasterLamp;
import defeatedcrow.addonforamt.jpaddon.common.block.TileChandelier;
import defeatedcrow.addonforamt.jpaddon.common.block.TileDryingRack;
import defeatedcrow.addonforamt.jpaddon.common.entity.EntityGlassBowl;
import defeatedcrow.addonforamt.jpaddon.common.entity.EntityJPBowl;
import defeatedcrow.addonforamt.jpaddon.common.entity.EntityJPDish;
import defeatedcrow.addonforamt.jpaddon.common.entity.EntityJPDrinks;
import defeatedcrow.addonforamt.jpaddon.common.entity.EntityJPRice;
import defeatedcrow.addonforamt.jpaddon.common.entity.EntityNoDish;
import defeatedcrow.addonforamt.jpaddon.common.entity.EntityRoastPig;
import defeatedcrow.addonforamt.jpaddon.common.entity.EntitySquarePlate;
import defeatedcrow.addonforamt.jpaddon.common.entity.EntityWhiteDish;
import defeatedcrow.addonforamt.jpaddon.common.entity.EntityWoodBowl;
import defeatedcrow.addonforamt.jpaddon.common.entity.WindProjectile;
import defeatedcrow.addonforamt.jpaddon.plugin.nei.AJPPluginNEI;

public class ClientProxyAJP extends CommonProxyAJP {

	private static final ModelKimonoTite kimonoModel = new ModelKimonoTite();
	private static final ModelHaori haoriModel = new ModelHaori();

	@Override
	public World getClientWorld() {
		return FMLClientHandler.instance().getClient().theWorld;
	}

	@Override
	public int getRenderID() {
		return RenderingRegistry.getNextAvailableRenderId();
	}

	@Override
	public void registerRenderers() {
		RenderingRegistry.registerBlockHandler(new RenderBlockDryingRack());
		RenderingRegistry.registerBlockHandler(new RenderOres());
		RenderingRegistry.registerBlockHandler(new RenderAlabasterLamp());
		RenderingRegistry.registerBlockHandler(new RenderAlabasterChandelier());

		MinecraftForgeClient.registerItemRenderer(AddonJPCore.roastPig, new RenderItemRoastPig());

		RenderingRegistry.registerEntityRenderingHandler(EntityJPDish.class, new RenderEntityJPDish());
		RenderingRegistry.registerEntityRenderingHandler(EntityJPBowl.class, new RenderEntityJPBowl());
		RenderingRegistry.registerEntityRenderingHandler(EntityJPRice.class, new RenderEntityRiceBowl());
		RenderingRegistry.registerEntityRenderingHandler(EntityWoodBowl.class, new RenderEntityWoodBowl());
		RenderingRegistry.registerEntityRenderingHandler(EntitySquarePlate.class, new RenderEntitySquareDish());
		RenderingRegistry.registerEntityRenderingHandler(EntityGlassBowl.class, new RenderEntityGlassDish());
		RenderingRegistry.registerEntityRenderingHandler(EntityNoDish.class, new RenderEntityNoDish());
		RenderingRegistry.registerEntityRenderingHandler(EntityJPDrinks.class, new RenderEntityJPDrink());
		RenderingRegistry.registerEntityRenderingHandler(EntityRoastPig.class, new RenderEntityRoastPig());
		RenderingRegistry.registerEntityRenderingHandler(WindProjectile.class, new RenderWindProjectile());
		RenderingRegistry.registerEntityRenderingHandler(EntityWhiteDish.class, new RenderEntityWhiteDish());
	}

	@Override
	public void registerTileEntity() {
		ClientRegistry.registerTileEntity(TileDryingRack.class, "amtjp.tile.drying_rack", new RenderTileDryingRack());
		ClientRegistry.registerTileEntity(TileAlabasterLamp.class, "amtjp.tile.lamp_alabaster",
				new RenderTileAlabasterLamp());
		ClientRegistry.registerTileEntity(TileChandelier.class, "amtjp.tile.chandelier_alabaster",
				new RenderTileAlabasterChandelier());
	}

	@Override
	public int addArmor(String armor) {
		return RenderingRegistry.addNewArmourRendererPrefix(armor);
	}

	@Override
	public void registerFluidTex() {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void onTextureStitch(TextureStitchEvent.Post event) {
		AddonJPCore.shoyu_young.setIcons(AddonJPCore.fluidDummy.getIcon(0, 0));
		AddonJPCore.komezu_young.setIcons(AddonJPCore.fluidDummy.getIcon(0, 1));
		AddonJPCore.shoyu.setIcons(AddonJPCore.fluidDummy.getIcon(0, 2));
		AddonJPCore.komezu.setIcons(AddonJPCore.fluidDummy.getIcon(0, 3));
	}

	@Override
	public ModelKimonoTite getKimonoModel() {
		return kimonoModel;
	}

	@Override
	public ModelHaori getHaoriModel() {
		return haoriModel;
	}

	@Override
	public void loadNEI() {
		if (Loader.isModLoaded("NotEnoughItems")) {
			try {
				AJPPluginNEI.load();
			} catch (Exception e) {
				AJPLogger.failLoadingModInfo("NotEnoughItems");
				e.printStackTrace(System.err);
			}
		}
	}

	@Override
	public boolean vanillaFancyRenderMode() {
		return Minecraft.getMinecraft().gameSettings.fancyGraphics;
	}

	@Override
	public boolean jumpWithCleaver() {
		EntityClientPlayerMP player = FMLClientHandler.instance().getClient().thePlayer;
		if (player != null && player.isEntityAlive()) {
			float yaw = player.rotationYaw;
			double newMX = (-MathHelper.sin(yaw / 180.0F * (float) Math.PI) * MathHelper.cos(player.rotationPitch
					/ 180.0F * (float) Math.PI));
			double newMZ = (MathHelper.cos(yaw / 180.0F * (float) Math.PI) * MathHelper.cos(player.rotationPitch
					/ 180.0F * (float) Math.PI));
			double newMY = ((-MathHelper.sin(player.rotationPitch / 180.0F * (float) Math.PI)));
			player.motionX += newMX * 0.5D;
			player.motionZ += newMZ * 0.5D;
			player.motionY += 0.25D + newMY * 0.5D;
		}
		return true;
	}
}
