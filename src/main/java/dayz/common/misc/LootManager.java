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
import dayz.common.blocks.BlocksDayZ;
import dayz.common.items.RegisterItemsDayZ;

public class LootManager
{
    public static WeightedRandomChestContent[] loot = new WeightedRandomChestContent[] {};

    public static void init()
    {
       
        registerAllItems();
        
      
    }

    private static void loadDayZ() 
    {
        addLoot(new ItemStack(RegisterItemsDayZ.Glock), 7);
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
        addLoot(new ItemStack(BlocksDayZ.barbedWire), 3);
    
        for (int i = 0; i < 7; i++)
        {
        }
    }
}
