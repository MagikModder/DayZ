package dayz.common.items.food;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dayz.DayZ;
import dayz.common.items.ItemMod;

public class ItemCanEmpty extends ItemMod
{
    private IIcon[] icons;
	private boolean isFood;
	
    public ItemCanEmpty(int itemId, boolean isFood)
    {
        super(itemId);
        setHasSubtypes(true);
        this.isFood = isFood;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int damage)
    {
    	int j = MathHelper.clamp_int(damage, 0, 5);
        return icons[j];
    }

    @SideOnly(Side.CLIENT)
    public void getSubItems(int itemId, CreativeTabs creativeTab, List containerList)
    {
        for (int damage = 0; damage < 6; ++damage)
        {
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        String[] names = new String[] {"Empty_Beer", "Empty_Lemon_Soda", "Empty_Cola", "Empty_Cola", "Empty_Energy_Drink", "Empty_Orange_Soda"};
        if (isFood)
    	{
        	names = new String[] {"Empty_Canned_Beans", "Empty_Canned_Soup", "Empty_Canned_Pasta", "Empty_Canned_Fish", "Empty_Canned_Pickles", "Empty_Canned_Fruit"};
    	}
        int i = MathHelper.clamp_int(itemStack.getItemDamage(), 0, 5);
        return super.getUnlocalizedName() + "." + names[i].toLowerCase();
    }
    
    @Override
    public void registerIcons(IIconRegister par1IconRegister)
    {
        icons = new IIcon[6];
        String itemName = "drinkCanEmpty";
        for (int damage = 0; damage < 6; ++damage)
        {
        	if (isFood)
        	{
        		itemName = "foodCanEmpty";
        	}
            icons[damage] = par1IconRegister.registerIcon(DayZ.meta.modId + ":" + itemName.substring(itemName.indexOf(".") + 1) + damage);
        }
    }
}