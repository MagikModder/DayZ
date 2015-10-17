package dayz.common;

import net.minecraft.entity.player.EntityPlayer;
import dayz.DayZ;
import dayz.common.thirst.PlayerDataNBT;

public class CommonPlayerHandler
{
    public void onPlayerLogin(EntityPlayer entityPlayer)
    {
        PlayerDataNBT.loadData(entityPlayer);
        DayZ.thirst().thirstMap.put(entityPlayer.getDisplayName(), PlayerDataNBT.getPlayerData(entityPlayer).thirstLevel);
    }

    public void onPlayerLogout(EntityPlayer entityPlayer)
    {
        PlayerDataNBT data = PlayerDataNBT.getPlayerData(entityPlayer);
        data.thirstLevel = DayZ.thirst().thirstMap.get(entityPlayer.getDisplayName());
        PlayerDataNBT.putPlayerData(entityPlayer.getDisplayName(), data);
        PlayerDataNBT.saveData(entityPlayer);
    }

    public void onPlayerChangedDimension(EntityPlayer entityPlayer)
    {

    }

    public void onPlayerRespawn(EntityPlayer entityPlayer)
    {
        DayZ.thirst().thirstMap.put(entityPlayer.getDisplayName(), 0);
    }
}
