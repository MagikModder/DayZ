package dayz.common.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.swing.text.ComponentView;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.ChestGenHooks;
import cpw.mods.fml.common.Loader;
import dayz.common.blocks.Blocks;
import dayz.common.items.DayZItems;

public class LootManager
{
    public static WeightedRandomChestContent[] loot = new WeightedRandomChestContent[] {};

    public static void init()
    {
       
        registerAllItems();
        
      
    }

    private static void loadDayZ() 
    {
        addLoot(new ItemStack(DayZItems.gunMakarov), 7);
        addLoot(new ItemStack(DayZItems.gunGlock17), 7);
        addLoot(new ItemStack(DayZItems.ammoUsp), 7);	
        addLoot(new ItemStack(DayZItems.gunMakarov), 5);
        addLoot(new ItemStack(DayZItems.gunGlock17), 5);
        addLoot(new ItemStack(DayZItems.gunUsp), 5);
        addLoot(new ItemStack(DayZItems.ammoAk74u), 5);
        addLoot(new ItemStack(DayZItems.ammoLeeEnfield), 5);
        addLoot(new ItemStack(DayZItems.ammoDoubleBarreledShotgun), 5);
        addLoot(new ItemStack(DayZItems.ammoRemington), 5);
        addLoot(new ItemStack(DayZItems.gunLeeEnfield), 1);
        addLoot(new ItemStack(DayZItems.gunDoubleBarreledShotgun), 1);
        addLoot(new ItemStack(DayZItems.gunAk74u), 1);
        addLoot(new ItemStack(DayZItems.gunRemington), 1);
	}

	
	public static void addLoot(ItemStack itemStack, int itemWorth)
    {
        ArrayList<WeightedRandomChestContent> contents = new ArrayList<WeightedRandomChestContent>(Arrays.asList(loot));
        contents.add(new WeightedRandomChestContent(itemStack, 1, 1, itemWorth));
        loot = contents.toArray(new WeightedRandomChestContent[0]);

        ChestGenHooks.addItem(ChestGenHooks.BONUS_CHEST, new WeightedRandomChestContent(itemStack, 1, 1, itemWorth));
        ChestGenHooks.addItem(ChestGenHooks.VILLAGE_BLACKSMITH, new WeightedRandomChestContent(itemStack, 1, 1, itemWorth));
    }

    public static void registerAllItems()
    {
        addLoot(new ItemStack(Blocks.barbedWire), 3);
        addLoot(new ItemStack(DayZItems.camoHelmet), 3);
        addLoot(new ItemStack(DayZItems.camoChest), 3);
        addLoot(new ItemStack(DayZItems.camoLegs), 3);
        addLoot(new ItemStack(DayZItems.camoBoots), 3);
        addLoot(new ItemStack(DayZItems.meleeBaseballBatNailed), 5);
        addLoot(new ItemStack(DayZItems.meleePipe), 5);
        addLoot(new ItemStack(DayZItems.meleePlankNailed), 5);
        addLoot(new ItemStack(DayZItems.meleeCrowbar), 5);
        addLoot(new ItemStack(DayZItems.meleeMachete), 5);
        addLoot(new ItemStack(Items.map), 5);
        addLoot(new ItemStack(Items.coal), 5);
        addLoot(new ItemStack(Items.iron_ingot), 5);
        addLoot(new ItemStack(Items.writable_book), 5);
        addLoot(new ItemStack(Items.arrow), 5);
        addLoot(new ItemStack(Items.bone), 5);
        addLoot(new ItemStack(DayZItems.healBloodbag), 5);
        addLoot(new ItemStack(Blocks.barbedWire), 5);
        addLoot(new ItemStack(DayZItems.healBandage), 7);
        addLoot(new ItemStack(DayZItems.meleeBaseballBat), 7);
        addLoot(new ItemStack(DayZItems.meleePlank), 7);
        addLoot(new ItemStack(DayZItems.drinkWhiskeyBottle), 7);
        addLoot(new ItemStack(DayZItems.drinkCiderBottle), 7);
        addLoot(new ItemStack(DayZItems.drinkVodkaBottle), 7);
        addLoot(new ItemStack(Blocks.nailBlock), 7);
        addLoot(new ItemStack(DayZItems.healAntibiotics), 9);

        for (int i = 0; i < 7; i++)
        {
        }
    }
}
