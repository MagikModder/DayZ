package dayz.client;

import net.minecraft.entity.Entity;

public class ClientSound {

	

	public static void playSound(String name, Entity entity, float volume, float pitch)
	{
		entity.worldObj.playSoundAtEntity(entity, ("DayZ:" + name), (float)volume, (float) pitch);
	}
	
	
	public static void MainMenuMusic(Entity entity, float volume, float pitch)
	{
		playSound("mainmenumusic", entity, volume, pitch);
	}

	public static void Shootgun(Entity entity, float volume, float pitch)
	{
		
		  String[] soundFiles =
		        { "ak74", "ak74u", "makarov", "remington", "reload", "leeenfield", "glock", "dbshotgun", "usp" };
		        for (String soundFile : soundFiles)
		        {
		       
		playSound("" + soundFiles, entity, volume, pitch);
		
		        }
	}

}
