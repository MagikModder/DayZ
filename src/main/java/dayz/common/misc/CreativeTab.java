package dayz.common.misc;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import dayz.common.items.DayZItems;

public class CreativeTab extends CreativeTabs
{
    public CreativeTab()
    {
        super("creativeTabDayZ");
    }

    @Override
    public ItemStack getIconItemStack()
    {
        return new ItemStack(DayZItems.gunAk74u, 1, 0);
    }

	@Override
	public Item getTabIconItem() {
	
		return DayZItems.gunGlock17;
	}
}