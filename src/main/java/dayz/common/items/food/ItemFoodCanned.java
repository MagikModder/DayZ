package dayz.common.items.food;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dayz.DayZ;
import dayz.common.items.ItemMod;
import dayz.common.items.DayZItems;

public class ItemFoodCanned extends ItemMod
{
    public ItemFoodCanned(int id, int healAmount)
    {
        super(id);
        setHasSubtypes(true);
        this.healAmount = healAmount;
        setHasSubtypes(true);
    }

    @SideOnly(Side.CLIENT)
    private IIcon[] icons;
	private String[] names = new String[] {"Canned_Beans", "Canned_Soup", "Canned_Pasta", "Canned_Fish", "Canned_Pickles", "Canned_Fruit"};

    private float saturationModifier;
    private int healAmount;
    private boolean alwaysEdible;

    @Override
    public ItemStack onEaten(ItemStack itemStack, World world, EntityPlayer entityPlayer)
    {
		entityPlayer.inventory.addItemStackToInventory(new ItemStack(DayZItems.foodCanEmpty, 1, itemStack.getItemDamage()));
        --itemStack.stackSize;
        entityPlayer.getFoodStats().addStats(healAmount, saturationModifier);
        world.playSoundAtEntity(entityPlayer, "random.burp", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
        onFoodEaten(itemStack, world, entityPlayer);
        return itemStack;
    }

    protected void onFoodEaten(ItemStack itemStack, World world, EntityPlayer entityPlayer)
    {
		entityPlayer.inventory.addItemStackToInventory(new ItemStack(DayZItems.foodCanEmpty, getDamage(itemStack)));
    }

    @Override
    public int getMaxItemUseDuration(ItemStack itemStack)
    {
        return 32;
    }

    @Override
    public EnumAction getItemUseAction(ItemStack itemStack)
    {
        return EnumAction.eat;
    }
    
    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
    	int i = MathHelper.clamp_int(itemStack.getItemDamage(), 0, 5);
        return super.getUnlocalizedName() + "." + names[i].toLowerCase();
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer)
    {
        if (entityPlayer.canEat(alwaysEdible))
        {
            entityPlayer.setItemInUse(itemStack, getMaxItemUseDuration(itemStack));
        }

        return itemStack;
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
    public void registerIcons(IIconRegister register)
    {
        icons = new IIcon[6];

        for (int damage = 0; damage < 6; ++damage)
        {
            icons[damage] = register.registerIcon(DayZ.meta.modId + ":" + new String("foodCanned").substring(new String("foodCanned").indexOf(".") + 1) + damage);
        }
    }
}