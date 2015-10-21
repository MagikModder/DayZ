package dayz.common.items.weapons;

import net.minecraft.item.Item;

public class ItemAk74 extends ItemGunAuto implements IGun
{
    public ItemAk74(IGun iGun) {
		super(iGun);
		
	}

	@Override
    public int getRounds()
    {
        return 30;
    }

    @Override
    public int getDamage()
    {
        return 12;
    }

    @Override
    public String getReloadSound()
    {
        return "reload";
    }

    @Override
    public String getShootSound()
    {
        return "ak74";
    }

    @Override
    public Item getAmmo()
    {
    	return null;
        //return Items.ammoAk74;
    }
}