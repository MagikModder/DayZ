package dayz.common.misc;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import dayz.common.items.RegisterItemsDayZ;

public class CreativeTab extends CreativeTabs
{
    public CreativeTab()
    {
        super("creativeTabDayZ");
    }



	@Override
	public Item getTabIconItem() {
	
		return RegisterItemsDayZ.Glock;
	}
}