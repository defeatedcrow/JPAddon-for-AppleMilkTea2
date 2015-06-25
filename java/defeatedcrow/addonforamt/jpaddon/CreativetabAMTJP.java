package defeatedcrow.addonforamt.jpaddon;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CreativetabAMTJP extends CreativeTabs {
	
	//クリエイティブタブのアイコン画像や名称の登録クラス
	public CreativetabAMTJP(String type)
	{
		super(type);
	}
 
	@Override
	@SideOnly(Side.CLIENT)
	public String getTranslatedTabLabel()
	{
		return "AddonforAMT-JP";
	}

	@Override
	public Item getTabIconItem() {
		return AddonJPCore.materials;
	}
	

}
