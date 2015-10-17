package dayz.common.items.weapons;

import dayz.DayZ;
import dayz.common.entities.EntityBullet;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemGlock17 extends Item implements IGun
{
    

	@Override
    public int getRounds()
    {
        return 17;
    }

    @Override
    public int getDamage()
    {
        return 6;
    }

    @Override
    public String getReloadSound()
    {
        return "reload";
    }

    @Override
    public String getShootSound()
    {
        return "glock";
    }

    @Override
    public Item getAmmo()
    {
        return null;
    }
    
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        if (itemstack.getItemDamage() < this.getRounds())
        {
            EntityBullet entitybullet = new EntityBullet(world, entityplayer, this.getDamage());
            world.playSoundAtEntity(entityplayer, DayZ.meta.modId + ":" + this.getShootSound(), 1.0F, 1.0F);
            itemstack.damageItem(1, entityplayer);

            if (!world.isRemote)
            {
                world.spawnEntityInWorld(entitybullet);
            }
        }
        else
        {
            entityplayer.setItemInUse(itemstack, getMaxItemUseDuration(itemstack));
        }
        return itemstack;
    }
}