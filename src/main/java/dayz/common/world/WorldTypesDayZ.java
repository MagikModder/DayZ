package dayz.common.world;

import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderGenerate;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerHills;
import net.minecraftforge.common.config.Configuration;
import dayz.common.world.biomes.BiomesDayZ;

public class WorldTypesDayZ extends WorldType
{
    public WorldTypesDayZ(String name) {
		super(name);
		
	}

	private static int DAYZ_ID;
    public static WorldTypesDayZ DAYZ;
    private static int SNOW_ID;
    public static WorldTypesDayZ SNOW;


    public static void loadWorldTypes()
    {
        DAYZ = (new WorldTypesDayZ("DAYZBASE"));
        SNOW = (new WorldTypesDayZ("DAYZSNOW"));
    }

    public static void worldTypeConfig(Configuration config)
    {
        DAYZ_ID = config.get("worldtype", "dayzId", 12).getInt();
        SNOW_ID = config.get("worldtype", "snowId", 13).getInt();
    }

    @Override
    public WorldChunkManager getChunkManager(World world)
    {
        return new WorldChunkManager(world);
    }

    @Override
    public IChunkProvider getChunkGenerator(World world, String generatorOptions)
    {
        return new ChunkProviderGenerate(world, world.getSeed(), world.getWorldInfo().isMapFeaturesEnabled());
    }

    /**
     * Returns an array of large, "major" biomes, such
     * as forest, desert, or taiga in the overworld.
     * 
     * @see GenLayerBiomes (for the array of biomes used in the overworld)
     */
    public BiomeGenBase[] setMajorBiomes()
    {
        if (this == DAYZ)
        {
            return new BiomeGenBase[]
            { BiomesDayZ.biomeForest };
        }
        else if (this == SNOW)
        {
            return new BiomeGenBase[]
            { BiomesDayZ.biomeSnowPlains };
        }
        return null;
    }

    /**
     * Returns a "minor" biome based on conditions of
     * modder's choosing. Examples of such biomes in
     * the overworld include the hilly or mountainous areas
     * within larger biomes such as tundra or jungle, as
     * well as the splotches of forest across the plains.
     * 
     * @param biomegenbase
     *            the "major" biome(s) on top of which this biome generates
     * @param genlayer
     *            the GenLayer generating these biomes; use to retrieve the
     *            genlayer.nextInt() method for random biome generation
     *            instead of random.nextInt()
     * @see GenLayerHills (for the overworld's minor biome generation)
     */
    public BiomeGenBase setMinorBiomes(BiomeGenBase biome, GenLayer genLayer)
    {
        if (this == DAYZ)
        {
            return BiomesDayZ.biomePlains;
        }
        else if (this == SNOW)
        {
            return BiomesDayZ.biomeSnowMountains;
        }
        return null;
    }

    /**
     * Returns a biome generated in the pattern of
     * overworld oceans; note that this does not mean
     * the biome generated is or must be an actual ocean
     * biome.
     * 
     * @params See the "setMinorBiomes" method.
     */
    public BiomeGenBase setOceanBiomes(BiomeGenBase biome, GenLayer genLayer)
    {
        return null;
    }

    /**
     * Returns a biome generated in the pattern of
     * overworld rivers; note that this does not mean
     * the biome generated is or must be an actual river
     * biome.
     * 
     * @params See the "setMinorBiomes" method.
     */
    public BiomeGenBase setRiverBiomes(BiomeGenBase biome, GenLayer genLayer)
    {
        if (this == DAYZ)
        {
            return BiomesDayZ.biomeRiver;
        }
        else if (this == SNOW)
        {
            return BiomesDayZ.biomeRiver;
        }
        return null;
    }

    /**
     * Returns a biome generated consistently along the
     * border of two separate biomes.
     * 
     * @param biomegenbase
     *            the biome on one side of the border
     * @param biomegenbase1
     *            the biome on the other side of the border
     * @param genlayer
     *            See the "setMinorBiomes" method.
     */
    public BiomeGenBase setBorderBiomes(BiomeGenBase biome1, BiomeGenBase biome2, GenLayer genLayer)
    {
        return null;
    }

    /**
     * Returns a biome that can be generated anywhere;
     * only the rarity of the biome, not its generation
     * overtop of other biomes, can be defined.
     * 
     * @param genlayer
     *            See the "setMinorBiomes" method.
     */
    public BiomeGenBase setMiscellaneousBiomes(GenLayer genLayer)
    {
        return null;
    }

    @Override
    public int getSpawnFuzz()
    {
        return 100;
    }
}