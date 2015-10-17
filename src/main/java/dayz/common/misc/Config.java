package dayz.common.misc;

import java.io.File;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import dayz.common.blocks.BlocksDayZ;
import dayz.common.effects.EffectDayZ;
import dayz.common.world.WorldTypesDayZ;
import dayz.common.world.biomes.BiomesDayZ;
import net.minecraftforge.common.config.Configuration;

public class Config
{
    public static boolean debug;
    public static int structureGenerationChance;
    public static boolean canSpawnZombiesInDefaultWorld;

    public static void init(FMLPreInitializationEvent event)
    {
        Configuration config = new Configuration(new File(event.getModConfigurationDirectory(), "DayZ Config.txt"));

        config.load();

        BlocksDayZ.blockConfig(config);
        WorldTypesDayZ.worldTypeConfig(config);
        EffectDayZ.effectConfig(config);

        debug = config.get(Configuration.CATEGORY_GENERAL, "debug", false, "Should DayZ log extra information?").getBoolean(false);
        structureGenerationChance = config.get(Configuration.CATEGORY_GENERAL, "structureGenerationChance", 5, "1 in x chance to generate a structure in a given chunk").getInt(5);
        canSpawnZombiesInDefaultWorld = config.get(Configuration.CATEGORY_GENERAL, "canSpawnZombiesInDefaultWorld", false, "Should DayZ zombies generate in the surface world?").getBoolean(false);

        config.save();
    }
}