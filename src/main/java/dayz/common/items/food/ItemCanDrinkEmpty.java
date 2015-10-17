package dayz.common.items.food;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dayz.DayZ;
import dayz.common.items.ItemMod;

public class ItemCanDrinkEmpty extends ItemMod
{
    private IIcon[] icons;

    public ItemCanDrinkEmpty(int itemId)
    {
        super(itemId);
        setHasSubtypes(true);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int damage)
    {
        return itemIcon = icons[damage];
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
	@SideOnly(Side.CLIENT)
    public void getSubItems(int itemId, CreativeTabs creativeTab, List containerList)
    {
        for (int damage = 0; damage < 6; ++damage)
        {
        }
    }

    @Override
    public void registerIcons(IIconRegister par1IconRegister)
    {
        icons = new IIcon[6];

        for (int damage = 0; damage < 6; ++damage)
        {
            icons[damage] = par1IconRegister.registerIcon(DayZ.meta.modId + ":" + getUnlocalizedName().substring(getUnlocalizedName().indexOf(".") + 1) + damage);
        }
    }
}