package dayz.client;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.sound.SoundLoadEvent;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dayz.DayZ;


@SideOnly(Side.CLIENT)
public class ClientEvents
{
	
	Minecraft mc = Minecraft.getMinecraft();
	EntityPlayer player = mc.thePlayer;

	@SubscribeEvent
    public void onSoundsLoaded(SoundLoadEvent event)
    {
          	ClientSound.Shootgun(player, 20, 1);
  		  
    }
}