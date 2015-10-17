package dayz;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.Metadata;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import dayz.common.CommonEvents;
import dayz.common.CommonProxy;
import dayz.common.blocks.BlocksDayZ;
import dayz.common.effects.EffectDayZ;
import dayz.common.entities.RegisterEntitysDayZ;
import dayz.common.items.RegisterItemsDayZ;
import dayz.common.misc.CreativeTab;
import dayz.common.thirst.Thirst;
import dayz.common.world.WorldTypesDayZ;
import dayz.common.world.biomes.BiomesDayZ;
import dayz.common.world.generation.StructureHandlerDayZ;

//@NetworkMod(clientSideRequired = true, serverSideRequired = false)
@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class DayZ
{
    public Thirst thirst;
    
   // public static EnumArmorMaterial enumArmorMaterialCamo = EnumHelper.addArmorMaterial("camo", 29, new int[]
    //{ 2, 6, 5, 2 }, 9);

    public static CreativeTabs creativeTab = new CreativeTab();

    @Instance("DayZ")
    public static DayZ INSTANCE;
    
    @Metadata
    public static ModMetadata meta;

    @SidedProxy(modId = "DayZ", clientSide = "dayz.client.ClientProxy", serverSide = "dayz.common.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preload(FMLPreInitializationEvent event)
    {
    	
        MinecraftForge.EVENT_BUS.register(new CommonEvents());
    	FMLCommonHandler.instance().bus().register(new CommonEvents());
    	
    	RegisterItemsDayZ.load();
    	RegisterEntitysDayZ.load();
    	
    	
        BlocksDayZ.loadBlocks();
        BiomesDayZ.loadBiomes();
        BiomesDayZ.addVillages();
        WorldTypesDayZ.loadWorldTypes();
        StructureHandlerDayZ.addDefaultStructures();
        
        proxy.preload(event);
    }

    @EventHandler
    public void load(FMLInitializationEvent event)
    {
        proxy.load(event);
    }

    @EventHandler
    public void postload(FMLPostInitializationEvent event)
    {
        proxy.postload(event);
    }
    
    @EventHandler
    public void serverStarting(FMLServerStartingEvent event)
    {
        proxy.serverStarting(event);
    }

    public static Thirst thirst()
    {
        return INSTANCE.thirst;
    }
}