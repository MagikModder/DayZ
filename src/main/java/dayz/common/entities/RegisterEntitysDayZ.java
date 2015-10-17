package dayz.common.entities;

import cpw.mods.fml.common.registry.EntityRegistry;
import dayz.DayZ;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;

public class RegisterEntitysDayZ {

	public static void load(){
		registerEntity();
	}
	
	
	public static void registerEntity(){
		
		
		createEntity(EntityCrawler.class, "Crawler", 0x7D6706, 0x9C8627);
		createEntity(EntityBullet.class, "Bullet", 0x7D6706, 0x9C8627);
		createEntity(EntityZombieDayZ.class, "ZombieDayZ", 0x7D6706, 0x9C8627);
		
		
	}
	
	
	public static void createEntity(Class entityClass, String entityName, int solidColor, int spotColor){
		int randomId = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(entityClass, entityName, randomId);
		EntityRegistry.registerModEntity(entityClass, entityName, randomId, DayZ.INSTANCE, 64, 1, true);
		EntityRegistry.addSpawn(entityClass, 2, 0, 1, EnumCreatureType.creature, BiomeGenBase.forest);
	}












	
	
}
