package dayz.common.items.weapons;

import dayz.DayZ;
import dayz.common.entities.EntityBullet;
import dayz.common.items.RegisterItemsDayZ;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemGlock17 extends ItemGunSemi implements IGun
{
    

	public ItemGlock17(IGun iGun) {
		super(iGun);
		
	
	}

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
        return RegisterItemsDayZ.GlockAmmo;
    }
    

}