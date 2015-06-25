package defeatedcrow.addonforamt.jpaddon.common.item;

import java.util.Random;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemAdvGrater extends Item {
	
	private final String texName;

	public ItemAdvGrater (int maxDamage, String name){
		super ();
		this.texName = name;
		this.setMaxStackSize(1);
		this.setMaxDamage(maxDamage);
		this.setNoRepair();
	}
	
	@Override
	public boolean doesContainerItemLeaveCraftingGrid(ItemStack par1ItemStack)
	{
		return false;
	}
	
	@Override
	public boolean hasContainerItem(ItemStack stack)
    {
        return true;
    }
	
	@Override
	public ItemStack getContainerItem(ItemStack item)
    {
        if (item.getItem() == this)
        {
        	Random rand = Item.itemRand;
        	boolean flag = item.attemptDamageItem(1, rand);
            return flag ? null : item;
        }
        return super.getContainerItem(item);
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister){
		this.itemIcon = par1IconRegister.registerIcon("amtjp:tools/" + this.texName);
	}
}
