package defeatedcrow.addonforamt.jpaddon.common.entity;

public class FoodType {
	
	private FoodType(){}
	
	public static enum Dish
	{
		White,
		Obon,
		SquarePlate,
		Glass,
		SoupBowl,
		RiceBowl,
		WoodBowl,
		Mag,
		None;
	}
	
	public static enum Soup
	{
		None,
		Soup,
		Rice,
		WoodSoup,
		WoodRice,
		Drink;
	}
	
	public static enum Deco
	{
		None,
		SoupInner,
		Kobathi,
		Masuzushi,
		Shake,
		Mothi,
		Oniman,
		Cake,
		Brownie,
		Senbei,
		Swissroll;
	}

}
