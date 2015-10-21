package dayz.common.items;

import cpw.mods.fml.common.registry.GameRegistry;
import dayz.DayZ;
import dayz.Reference;
import dayz.common.items.weapons.ItemAk74;
import dayz.common.items.weapons.ItemAk74u;
import dayz.common.items.weapons.ItemAmmo;
import dayz.common.items.weapons.ItemGlock17;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;

public class RegisterItemsDayZ {
	public static void load(){
		
		
		register();
		
		
	}
	
	
	public static Item Glock;
	public static Item Remington;
	public static Item Enfield;
	public static Item RayGun;
	public static Item DBShotgun;
	public static Item AK74;
	public static Item AK74u;
	public static Item Usp;
	public static Item Makarov;
	public static Item Melee;
	
	
	public static Item GlockAmmo;
	public static Item AK74Ammo;
	public static Item AK74uAmmo;
	public static Item ShotgunAmmo;
	public static Item MakarovAmmo;
	public static Item EnfieldAmmo;
	public static Item UspAmmo;
	
	
	public static Item CanDrinkEmpty;
	public static Item CanEmpty;
	public static Item CannedFood;
	public static Item CannedDrink;
	public static Item Canteen;
	public static Item Apple; 
	public static Item OldApple;
	public static Item Fruit;
	
	public static Item Heal;
	public static Item Firestarter;
	
	public static void register()
	{
		
	//	Glock = new ItemGlock17(null);
	//	AK74 = new ItemAk74(null);
	//	AK74u = new ItemAk74u(null);
		
		
		GlockAmmo = new ItemAmmo();
		AK74Ammo = new ItemAmmo();
		AK74uAmmo = new ItemAmmo();
		EnfieldAmmo = new ItemAmmo();
		MakarovAmmo = new ItemAmmo();
		ShotgunAmmo = new ItemAmmo();
		UspAmmo = new ItemAmmo();
		
		
		
	//registerTheItem(Glock, "gunGlock17");


		registerTheItem(GlockAmmo, "ammoGlock17");
		registerTheItem(AK74Ammo, "ammoAk74");
		registerTheItem(AK74uAmmo, "ammoAk74u");
		registerTheItem(EnfieldAmmo, "ammoLeeEnfield");
		registerTheItem(MakarovAmmo, "ammoMakarov");
		registerTheItem(ShotgunAmmo, "ammoRemington");
		registerTheItem(UspAmmo, "ammoUsp");
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
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
