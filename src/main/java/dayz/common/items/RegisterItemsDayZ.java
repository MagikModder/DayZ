package dayz.common.items;

import cpw.mods.fml.common.registry.GameRegistry;
import dayz.DayZ;
import dayz.Reference;
import dayz.common.items.weapons.ItemGlock17;
import net.minecraft.item.Item;

public class RegisterItemsDayZ {
	public static void load(){
		
		
		register();
		
		
	}
	
	
	public static Item Glock;
	
	
	
	public static void register()
	{
		
		Glock = new ItemGlock17();
		
		registerTheItem(Glock, "gunGlock17");


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}







	private static void registerTheItem(Item item, String name)
	{
		String unlocalizedName = name.toLowerCase().replaceAll(" ", "_").replaceAll("'", "");
		item.setUnlocalizedName(unlocalizedName);
		item.setTextureName(Reference.MODID + ":" + unlocalizedName);
		item.setCreativeTab(DayZ.creativeTab);
		
		GameRegistry.registerItem(item, unlocalizedName);
	}










}
