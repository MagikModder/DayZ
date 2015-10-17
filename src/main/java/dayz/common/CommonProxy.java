package dayz.common;

import java.util.logging.Level;
import java.util.logging.Logger;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import dayz.DayZ;
import dayz.common.blocks.BlocksDayZ;
import dayz.common.effects.EffectDayZ;
import dayz.common.entities.EntityBullet;
import dayz.common.entities.EntityCrawler;
import dayz.common.entities.EntityZombieDayZ;
import dayz.common.misc.ChatHandler;
import dayz.common.misc.Config;
import dayz.common.misc.LootManager;
import dayz.common.thirst.Thirst;
import dayz.common.world.WorldTypesDayZ;
import dayz.common.world.biomes.BiomesDayZ;
import dayz.common.world.generation.StructureHandlerDayZ;

public class CommonProxy
{
    public void preload(FMLPreInitializationEvent event)
    {
        ChatHandler.log = Logger.getLogger(DayZ.meta.modId);
        MinecraftForge.EVENT_BUS.register(new CommonEvents());
        MinecraftForge.TERRAIN_GEN_BUS.register(new CommonEventsTerrain());
        Config.init(event);
        ChatHandler.logInfo("Config loaded.");
    }

    @SuppressWarnings("deprecation")
	public void load(FMLInitializationEvent event)
    {



        LanguageRegistry.instance().addStringLocalization("generator.DAYZBASE", "en_US", "Day Z Original");
        LanguageRegistry.instance().addStringLocalization("generator.DAYZSNOW", "en_US", "Day Z Snow");
        LanguageRegistry.instance().addStringLocalization("itemGroup.creativeTabDayZ", "en_US", "Day Z");
        LanguageRegistry.instance().addStringLocalization("death.attack.bleedOut", "%1$s lost too much blood");
        LanguageRegistry.instance().addStringLocalization("death.attack.zombieInfection", "%1$s became a zombie");
        LanguageRegistry.instance().addStringLocalization("death.attack.thirstDeath", "%1$s ran out of water");
    }

    public void postload(FMLPostInitializationEvent event)
    {
        LootManager.init();

        if (Loader.isModLoaded("ThirstMod"))
        {
            ChatHandler.logException(Level.SEVERE, "Thirst Mod is not compatible with DayZ, DayZ has it's own thirst system. Remove the Thirst Mod to fix this error.");
        }

        if (FMLCommonHandler.instance().getEffectiveSide().isServer())
        {
            Logger.getLogger("Minecraft").info("Day Z " + DayZ.meta.version + " Loaded.");

            Logger.getLogger("Minecraft").info("Make sure your server.properties has one of the lines to create a DayZ world.");
            Logger.getLogger("Minecraft").info("level-type=DAYZBASE            -           To create the original DayZ world.");
            Logger.getLogger("Minecraft").info("level-type=DAYZSNOW            -                  To create snowy DayZ world.");
        }
    }

    public void serverStarting(FMLServerStartingEvent event)
    {
        DayZ.INSTANCE.thirst = new Thirst();
    }
}