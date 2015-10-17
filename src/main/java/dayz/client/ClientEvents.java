package dayz.client;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import dayz.DayZ;

public class ClientEvents
{

	@SubscribeEvent
    public void onSoundsLoaded(SoundLoadEvent event)
    {
        String[] soundFiles =
        { "ak74", "ak74u", "makarov", "remington", "reload", "leeenfield", "glock", "dbshotgun", "usp" };
        for (String soundFile : soundFiles)
        {
       //     event.manager.playSound(DayZ.meta.modId + ":" + soundFile + ".ogg");
        }
    }
}