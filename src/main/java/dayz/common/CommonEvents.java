package dayz.common;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.EntityInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.WorldEvent;

import com.mojang.realmsclient.exception.McoHttpException;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.SideOnly;
import dayz.common.blocks.BlocksDayZ;
import dayz.common.effects.EffectDayZ;
import dayz.common.entities.EntityZombieDayZ;
import dayz.common.gui.GuiMainMenuDayZ;
import dayz.common.items.weapons.ItemGunAuto;
import dayz.common.misc.ChatHandler;
import dayz.common.misc.DamageType;
import dayz.common.misc.LootManager;




public class CommonEvents
{
    @SubscribeEvent
    public void worldLoad(WorldEvent.Load event)
    {
        for (Object obj : event.world.loadedTileEntityList)
        {
            if (obj instanceof TileEntityChest)
            {
                TileEntityChest chest = (TileEntityChest) obj;
                if (event.world.getBlock(chest.xCoord, chest.yCoord, chest.zCoord) == BlocksDayZ.chestLoot)
                {
                    boolean continueChecking = true;
                    int slotNumber = 0;
                    while (continueChecking == true)
                    {
                        if (chest.getStackInSlot(slotNumber) == null && slotNumber < 27)
                        {
                            if (slotNumber == 26)
                            {
                                WeightedRandomChestContent.generateChestContents(event.world.rand, LootManager.loot, chest, event.world.rand.nextInt(5) + 1);
                                ChatHandler.logDebug("Refilled chest at " + chest.xCoord + ", " + chest.yCoord + ", " + chest.zCoord + ".");
                                continueChecking = false;
                            }
                            else
                            {
                                slotNumber++;
                            }
                        }
                        else
                        {
                            continueChecking = false;
                        }
                    }
                }
            }
        }
    }
    
    @SubscribeEvent
	public void onGuiOpenEvent(GuiOpenEvent event) {
		
    	if (event.gui instanceof GuiMainMenu) {
				
    			event.setCanceled(true);
    			
				Minecraft.getMinecraft().currentScreen=(
				
						new GuiMainMenuDayZ());
				
//			} else {
				
//					Minecraft.getMinecraft().displayGuiScreen(
//							
//							new GuiMainMenuDayZ());
			
}
    
    	
    	
		}
		
    @SubscribeEvent
    public void playerInteract(EntityInteractEvent event)
    {
//		if (event.target != null && event.target instanceof EntityPlayer && event.entityPlayer.getCurrentEquippedItem().getItem() == Items.healBloodbag.getItemById())
 //       {
  //          ((EntityPlayer) event.target).heal(20F);
   //         event.entityPlayer.getCurrentEquippedItem().stackSize--;
    //    }
    }

    /*
    @SubscribeEvent
    public void onEntityUpdate(LivingUpdateEvent event)
    {
   //     if (event.entityLiving.isPotionActive(EffectDayZ.bleeding))
        {
    //        if (event.entityLiving.getActivePotionEffect(EffectDayZ.bleeding).getDuration() == 0)
            {
                event.entityLiving.removePotionEffect(EffectDayZ.bleeding.id);
                return;
            }
    //        if (event.entityLiving.worldObj.rand.nextInt(20) == 0)
            {
                event.entityLiving.attackEntityFrom(DamageType.bleedOut, 2);
            }
        }
   //     if (event.entityLiving.isPotionActive(EffectDayZ.zombification))
        {
     //       if (event.entityLiving.getActivePotionEffect(EffectDayZ.zombification).getDuration() == 0)
            {
       //         event.entityLiving.removePotionEffect(EffectDayZ.zombification.id);
         //       return;
            }
           // if (event.entityLiving.worldObj.rand.nextInt(20) == 0)
            {
                if (event.entityLiving.getHealth() > 1.0F)
                {
                    event.entityLiving.attackEntityFrom(DamageType.zombieInfection, 1.0F);
                }
                else
                {
                    EntityZombieDayZ var2 = new EntityZombieDayZ(event.entityLiving.worldObj);
                    var2.setLocationAndAngles(event.entityLiving.posX, event.entityLiving.posY, event.entityLiving.posZ, event.entityLiving.rotationYaw, event.entityLiving.rotationPitch);
                    event.entityLiving.worldObj.spawnEntityInWorld(var2);
                    event.entityLiving.attackEntityFrom(DamageType.zombieInfection, 1.0F);
                }
            }
        }
    }
    */
}
