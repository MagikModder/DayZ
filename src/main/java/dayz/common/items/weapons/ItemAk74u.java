package dayz.common.items.weapons;

import net.minecraft.item.Item;

public class ItemAk74u extends ItemGunAuto implements IGun
{
    public ItemAk74u(IGun iGun) {
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
        return 10;
    }

    @Override
    public String getReloadSound()
    {
        return "reload";
    }

    @Override
    public String getShootSound()
    {
        return "ak74u";
    }

	@Override
	public Item getAmmo() {
		// TODO Auto-generated method stub
		return null;
	}

//    @Override
//   public Item getAmmo()
//    {
//        return DayZItems.ammoAk74u;
//    }
}