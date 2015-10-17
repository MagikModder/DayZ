package dayz.common.items;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.util.EnumHelper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import dayz.DayZ;
import dayz.common.blocks.Blocks;
import dayz.common.effects.Effect;
import dayz.common.items.food.ItemCanEmpty;
import dayz.common.items.food.ItemDrinkBottle;
import dayz.common.items.food.ItemDrinkCanned;
import dayz.common.items.food.ItemFoodCanned;
import dayz.common.items.misc.ItemFirestarter;
import dayz.common.items.misc.ItemHeal;
import dayz.common.items.weapons.ItemAk74u;
import dayz.common.items.weapons.ItemAmmo;
import dayz.common.items.weapons.ItemDbShotgun;
import dayz.common.items.weapons.ItemEnfield;
import dayz.common.items.weapons.ItemGlock17;
import dayz.common.items.weapons.ItemGunAuto;
import dayz.common.items.weapons.ItemGunSemi;
import dayz.common.items.weapons.ItemMakarov;
import dayz.common.items.weapons.ItemMelee;
import dayz.common.items.weapons.ItemRemington;
import dayz.common.items.weapons.ItemUsp;

public class DayZItems
{
    public static Item itemMatches;
    private static int itemMatchesId;
    public static Item healBandage;
    private static int healBandageId;
    public static Item healAntibiotics;
    private static int healAntibioticsId;
    public static Item healBloodbag;
    private static int healBloodbagId;

    public static Item gunAk74u;
    private static int gunAk74uId;
    public static Item gunMakarov;
    private static int gunMakarovId;
    public static Item gunRemington;
    private static int gunRemingtonId;
    public static Item gunLeeEnfield;
    private static int gunLeeEnfieldId;
    public static Item gunGlock17;
    private static int gunGlock17Id;
    public static Item gunDoubleBarreledShotgun;
    private static int gunDoubleBarreledShotgunId;
    public static Item gunUsp;
    private static int gunUspId;
    //public static Item gunAk74;
    //private static int gunAk74Id;

    public static Item ammoAk74u;
    private static int ammoAk74uId;
    public static Item ammoMakarov;
    private static int ammoMakarovId;
    public static Item ammoRemington;
    private static int ammoRemingtonId;
    public static Item ammoLeeEnfield;
    private static int ammoLeeEnfieldId;
    public static Item ammoGlock17;
    private static int ammoGlock17Id;
    public static Item ammoDoubleBarreledShotgun;
    private static int ammoDoubleBarreledShotgunId;
    public static Item ammoUsp;
    private static int ammoUspId;
    //public static Item ammoAk74;
    //private static int ammoAk74Id;
    
    public static Item camoHelmet;
    private static int camoHelmetId;
    public static Item camoChest;
    private static int camoChestId;
    public static Item camoLegs;
    private static int camoLegsId;
    public static Item camoBoots;
    private static int camoBootsId;

    public static Item foodCanned;
    private static int foodCannedId;
    public static Item foodCanEmpty;
    private static int foodCanEmptyId;
    public static Item drinkCanEmpty;
    private static int drinkCanEmptyId;
    public static Item drinkCanned;
    private static int drinkCannedId;

    public static Item drinkWhiskeyBottle;
    private static int drinkWhiskeyBottleId;
    public static Item drinkCiderBottle;
    private static int drinkCiderBottleId;
    public static Item drinkVodkaBottle;
    private static int drinkVodkaBottleId;

    public static Item meleeBaseballBat;
    private static int meleeBaseballBatId;
    public static Item meleeBaseballBatNailed;
    private static int meleeBaseballBatNailedId;
    public static Item meleePlank;
    private static int meleePlankId;
    public static Item meleePlankNailed;
    private static int meleePlankNailedId;
    public static Item meleePipe;
    private static int meleePipeId;
    public static Item meleeCrowbar;
    private static int meleeCrowbarId;
    public static Item meleeMachete;
    private static int meleeMacheteId;

    public static void loadItems()
    {
        gunAk74u = new ItemGunAuto(gunAk74uId, new ItemAk74u()).setUnlocalizedName("gunAk74u");
        gunMakarov = new ItemGunSemi(gunMakarovId, new ItemMakarov()).setUnlocalizedName("gunMakarov");
        gunRemington = new ItemGunSemi(gunRemingtonId, new ItemRemington()).setUnlocalizedName("gunRemington");
        gunLeeEnfield = new ItemGunSemi(gunLeeEnfieldId, new ItemEnfield()).setUnlocalizedName("gunLeeEnfield");
        gunGlock17 = new ItemGunAuto(gunGlock17Id, new ItemGlock17()).setUnlocalizedName("gunGlock17");
        gunDoubleBarreledShotgun = new ItemGunSemi(gunDoubleBarreledShotgunId, new ItemDbShotgun()).setUnlocalizedName("gunDoubleBarreledShotgun");
        gunUsp = new ItemGunSemi(gunUspId, new ItemUsp()).setUnlocalizedName("gunUsp");
        //gunAk74 = new ItemGunAuto(gunAk74Id, new ItemAk74()).setUnlocalizedName("gunAk74");
        //LanguageRegistry.addName(gunAk74, "Ak-74");

        ammoAk74u = new ItemAmmo(ammoAk74uId).setUnlocalizedName("ammoAk74u");
        ammoMakarov = new ItemAmmo(ammoMakarovId).setUnlocalizedName("ammoMakarov");
        ammoRemington = new ItemAmmo(ammoRemingtonId).setUnlocalizedName("ammoRemington");
        ammoLeeEnfield = new ItemAmmo(ammoLeeEnfieldId).setUnlocalizedName("ammoLeeEnfield");
        ammoGlock17 = new ItemAmmo(ammoGlock17Id).setUnlocalizedName("ammoGlock17");
        ammoDoubleBarreledShotgun = new ItemAmmo(ammoDoubleBarreledShotgunId).setUnlocalizedName("ammoDoubleBarreledShotgun");
        ammoUsp = new ItemAmmo(ammoUspId).setUnlocalizedName("ammoUsp");
        //ammoAk74 = new ItemAmmo(ammoAk74Id).setUnlocalizedName("ammoAk74");

        itemMatches = (new ItemFirestarter(itemMatchesId, 8)).setUnlocalizedName("itemMatches");

        healBandage = new ItemHeal(healBandageId, 0, Effect.bleeding).subNames("Stops bleeding").setUnlocalizedName("healBandage");
        healAntibiotics = new ItemHeal(healAntibioticsId, 0, Effect.zombification).subNames("Stops infection").setUnlocalizedName("healAntibiotics");
        healBloodbag = new ItemMod(healBloodbagId).subNames("Cannot be self-applied").setUnlocalizedName("healBloodbag");

 //       camoHelmet = (new ItemCamo(camoHelmetId,EnumHelper.addArmorMaterial(name, durability, reductionAmounts, enchantability), 4, 0)).setUnlocalizedName("camoHelmet");
  //      camoChest = (new ItemCamo(camoChestId, DayZ.enumArmorMaterialCamo, 4, 1)).setUnlocalizedName("camoChest");
    //    camoLegs = (new ItemCamo(camoLegsId, DayZ.enumArmorMaterialCamo, 4, 2)).setUnlocalizedName("camoLegs");
      //  camoBoots = (new ItemCamo(camoBootsId, DayZ.enumArmorMaterialCamo, 4, 3)).setUnlocalizedName("camoBoots");

        foodCanEmpty = new ItemCanEmpty(foodCanEmptyId, true).setUnlocalizedName("foodCanEmpty");
        foodCanned = new ItemFoodCanned(foodCannedId, 4).setUnlocalizedName("foodCanned");

        drinkCanEmpty = new ItemCanEmpty(drinkCanEmptyId, false).setUnlocalizedName("drinkCanEmpty");
        drinkCanned = new ItemDrinkCanned(drinkCannedId, 4).setUnlocalizedName("drinkCanned");

        drinkWhiskeyBottle = new ItemDrinkBottle(drinkWhiskeyBottleId, 4).isAlcohol(true).setUnlocalizedName("drinkWhiskeyBottle");
        drinkCiderBottle = new ItemDrinkBottle(drinkCiderBottleId, 4).setUnlocalizedName("drinkCiderBottle");
        drinkVodkaBottle = new ItemDrinkBottle(drinkVodkaBottleId, 4).isAlcohol(true).setUnlocalizedName("drinkVodkaBottle");

        meleeBaseballBat = new ItemMelee(meleeBaseballBatId, 6).setUnlocalizedName("meleeBaseballBat");
        meleeBaseballBatNailed = new ItemMelee(meleeBaseballBatNailedId, 8).setUnlocalizedName("meleeBaseballBatNailed");
        meleePlank = new ItemMelee(meleePlankId, 7).setUnlocalizedName("meleePlank");
        meleePlankNailed = new ItemMelee(meleePlankNailedId, 8).setUnlocalizedName("meleePlankNailed");
        meleePipe = new ItemMelee(meleePipeId, 8).setUnlocalizedName("meleePipe");
        meleeCrowbar = new ItemMelee(meleeCrowbarId, 8).setUnlocalizedName("meleeCrowbar");
        meleeMachete = new ItemMelee(meleeMacheteId, 7).setUnlocalizedName("meleeMachete");

        GameRegistry.addShapelessRecipe(new ItemStack(meleeBaseballBatNailed, 1), new Object[]
        { new ItemStack(meleeBaseballBat, 1), new ItemStack(Blocks.nailBlock, 1, 0) });

        GameRegistry.addShapelessRecipe(new ItemStack(meleePlankNailed, 1), new Object[]
        { new ItemStack(meleePlank, 1), new ItemStack(Blocks.nailBlock, 1, 0) });

        GameRegistry.addRecipe(new ItemStack(meleePlank, 1), new Object[]
        { "#", "#", "#", Character.valueOf('#'), Blocks.nailBlock });

        GameRegistry.addRecipe(new ItemStack(meleeBaseballBat, 1), new Object[]
        { "##!", Character.valueOf('#'), Blocks.nailBlock, Character.valueOf('!'), DayZItems.meleePipe });
    }

    public static void itemConfig(Configuration config)
    {
        itemMatchesId = config.get(Configuration.CATEGORY_GENERAL, "itemMatchesId", 7100).getInt();
        healBandageId = config.get(Configuration.CATEGORY_GENERAL, "healBandageId", 7101).getInt();
        healAntibioticsId = config.get(Configuration.CATEGORY_GENERAL, "healAntibioticsId", 7102).getInt();
        healBloodbagId = config.get(Configuration.CATEGORY_GENERAL, "healBloodbagId", 7103).getInt();

        gunAk74uId = config.get(Configuration.CATEGORY_GENERAL, "gunAk74uId", 7104).getInt();
        gunMakarovId = config.get(Configuration.CATEGORY_GENERAL, "gunMakarovId", 7105).getInt();
        gunRemingtonId = config.get(Configuration.CATEGORY_GENERAL, "gunRemingtonId", 7106).getInt();
        gunLeeEnfieldId = config.get(Configuration.CATEGORY_GENERAL, "gunLeeEnfieldId", 7107).getInt();
        gunGlock17Id = config.get(Configuration.CATEGORY_GENERAL, "gunGlock17Id", 7108).getInt();
        gunDoubleBarreledShotgunId = config.get(Configuration.CATEGORY_GENERAL, "gunDoubleBarreledShotgunId", 7109).getInt();
        
        ammoAk74uId = config.get(Configuration.CATEGORY_GENERAL, "ammoAk74uId", 7110).getInt();
        ammoMakarovId = config.get(Configuration.CATEGORY_GENERAL, "ammoMakarovId", 7111).getInt();
        ammoRemingtonId = config.get(Configuration.CATEGORY_GENERAL, "ammoRemingtonId", 7112).getInt();
        ammoLeeEnfieldId = config.get(Configuration.CATEGORY_GENERAL, "ammoLeeEnfieldId", 7113).getInt();
        ammoGlock17Id = config.get(Configuration.CATEGORY_GENERAL, "ammoGlock17Id", 7114).getInt();
        ammoDoubleBarreledShotgunId = config.get(Configuration.CATEGORY_GENERAL, "ammoDoubleBarreledShotgunId", 7115).getInt();

        camoHelmetId = config.get(Configuration.CATEGORY_GENERAL, "camoHelmetId", 7116).getInt();
        camoChestId = config.get(Configuration.CATEGORY_GENERAL, "camoChestId", 7117).getInt();
        camoLegsId = config.get(Configuration.CATEGORY_GENERAL, "camoLegsId", 7118).getInt();
        camoBootsId = config.get(Configuration.CATEGORY_GENERAL, "camoBootsId", 7119).getInt();

        foodCannedId = config.get(Configuration.CATEGORY_GENERAL, "foodCannedId", 7120).getInt();
        foodCanEmptyId = config.get(Configuration.CATEGORY_GENERAL, "foodCanEmptyId", 7121).getInt();
        drinkCanEmptyId = config.get(Configuration.CATEGORY_GENERAL, "drinkCanEmptyId", 7122).getInt();
        drinkCannedId = config.get(Configuration.CATEGORY_GENERAL, "drinkCannedId", 7123).getInt();

        drinkWhiskeyBottleId = config.get(Configuration.CATEGORY_GENERAL, "drinkWhiskeyBottleId", 7124).getInt();
        drinkCiderBottleId = config.get(Configuration.CATEGORY_GENERAL, "drinkCiderBottleId", 7125).getInt();
        drinkVodkaBottleId = config.get(Configuration.CATEGORY_GENERAL, "drinkVodkaBottleId", 7126).getInt();

        meleeBaseballBatId = config.get(Configuration.CATEGORY_GENERAL, "meleeBaseballBatId", 7127).getInt();
        meleeBaseballBatNailedId = config.get(Configuration.CATEGORY_GENERAL, "meleeBaseballBatNailedId", 7128).getInt();
        meleePlankId = config.get(Configuration.CATEGORY_GENERAL, "meleePlankId", 7129).getInt();
        meleePlankNailedId = config.get(Configuration.CATEGORY_GENERAL, "meleePlankNailedId", 7130).getInt();
        meleePipeId = config.get(Configuration.CATEGORY_GENERAL, "meleePipeId", 7131).getInt();
        meleeCrowbarId = config.get(Configuration.CATEGORY_GENERAL, "meleeCrowbarId", 7132).getInt();
        meleeMacheteId = config.get(Configuration.CATEGORY_GENERAL, "meleeMacheteId", 7133).getInt();
        
        gunUspId = config.get(Configuration.CATEGORY_GENERAL, "gunUspId", 7134).getInt();
        //gunAk74Id = config.get(Configuration.CATEGORY_ITEM, "gunAk74Id", 7135).getInt();
        ammoUspId = config.get(Configuration.CATEGORY_GENERAL, "ammoUspId", 7136).getInt();
        //ammoAk74Id = config.get(Configuration.CATEGORY_ITEM, "ammoAk74Id", 7137).getInt();
    }
    
    private static void registerArmor(Item item, String name)
	{
		String unlocalizedName = name.toLowerCase().replaceAll(" ", "_").replaceAll("'", "");
		item.setUnlocalizedName(unlocalizedName);
	
		GameRegistry.registerItem(item, unlocalizedName);
	}
}
