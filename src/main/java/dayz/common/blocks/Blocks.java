package dayz.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Blocks
{
    public static Block barbedWire;
    private static int barbedWireId;
    public static Block chestLoot;
    private static int chestLootId;
    public static Block chainFence;
    private static int chainFenceId;
    public static Block sandbagBlock;
    private static int sandbagBlockId;
    public static Block nailBlock;
    private static int nailBlockId;

    public static void loadBlocks()
    {
        barbedWire = new BlockBarbedWire(barbedWireId).setHardness(3F).setResistance(2F);
        GameRegistry.registerBlock(barbedWire, "barbedWire");
        chestLoot = new BlockChestDayZ(chestLootId, 0);
        GameRegistry.registerBlock(chestLoot, "chestLoot");
        chainFence = (new BlockFence(chainFenceId, "chainFence", Material.iron)).setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeCloth);
        GameRegistry.registerBlock(chainFence, "chainFence");
        sandbagBlock = (new BlockMod(sandbagBlockId, Material.clay)).setHardness(2.0F).setResistance(10.0F).setStepSound(Block.soundTypeCloth);
        GameRegistry.registerBlock(sandbagBlock, "sandbagBlock");
        nailBlock = new BlockNails(nailBlockId, Material.circuits).setHardness(1F).setResistance(1F);
        GameRegistry.registerBlock(nailBlock, "nailBlock");

        GameRegistry.addRecipe(new ItemStack(nailBlock, 8), new Object[]
        { "#", "#", Character.valueOf('#'), Items.iron_ingot });
    }

    public static void blockConfig(Configuration config)
    {
        barbedWireId = config.get(Configuration.CATEGORY_GENERAL, "barbedwireID", 160, "Barbed Wire Block ID").getInt();
        chestLootId = config.get(Configuration.CATEGORY_GENERAL, "dayzchestallID", 161, "All Item Chest Block ID").getInt();
        chainFenceId = config.get(Configuration.CATEGORY_GENERAL, "chainlinkfenceID", 164, "Chainlink Fence Block ID").getInt();
        sandbagBlockId = config.get(Configuration.CATEGORY_GENERAL, "sandbagblockID", 165, "Sandbag Block ID").getInt();
        nailBlockId = config.get(Configuration.CATEGORY_GENERAL, "nailsID", 166, "Nail Block ID").getInt();
    }
}
