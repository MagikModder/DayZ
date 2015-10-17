package dayz.common;

import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.event.terraingen.WorldTypeEvent;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import dayz.common.misc.Config;
import dayz.common.world.WorldTypesDayZ;
import dayz.common.world.generation.StructureHandlerDayZ;
import dayz.common.world.genlayer.GenLayerDayZ;

public class CommonEventsTerrain
{
    @SubscribeEvent
    public void initBiomeGens(WorldTypeEvent.InitBiomeGens event)
    {
        if (event.worldType instanceof WorldTypesDayZ)
        {
            event.newBiomeGens = GenLayerDayZ.getGenLayers(event.seed, (WorldTypesDayZ)event.worldType);
        }
    }

    @SubscribeEvent
    public void populateChunk(PopulateChunkEvent.Populate event)
    {
        if (event.world.getWorldInfo().getTerrainType() instanceof WorldTypesDayZ)
        {
            if (event.type == PopulateChunkEvent.Populate.EventType.LAKE)
            {
                event.setResult(Result.DENY);
            }
            if (event.type == PopulateChunkEvent.Populate.EventType.LAVA)
            {
                event.setResult(Result.DENY);
            }
            if (event.type == PopulateChunkEvent.Populate.EventType.DUNGEON)
            {
                event.setResult(Result.DENY);
            }
        }

        if (event.world.getWorldInfo().getTerrainType() instanceof WorldTypesDayZ && event.world.rand.nextInt(Config.structureGenerationChance) == 0)
        {
            for (int i = 0; i < 12; ++i)
            {
                int x = event.chunkX * 16 + event.rand.nextInt(16) + 8;
                int y = event.rand.nextInt(128);
                int z = event.chunkZ * 16 + event.rand.nextInt(16) + 8;

                StructureHandlerDayZ.generateStructure(event.world, event.rand, x, y, z);
            }
        }
    }
}
