package dayz.common.items.misc;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import dayz.common.items.ItemMod;

public class ItemFirestarter extends ItemMod
{
    public ItemFirestarter(int itemId, int numOfUses)
    {
        super();
        setMaxDamage(numOfUses);
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int xCoord, int yCoord, int zCoord, int blockSide, float xHitCoord, float yHitCoord, float zHitCoord)
    {
        if (blockSide == 0)
        {
            --yCoord;
        }

        if (blockSide == 1)
        {
            ++yCoord;
        }

        if (blockSide == 2)
        {
            --zCoord;
        }

        if (blockSide == 3)
        {
            ++zCoord;
        }

        if (blockSide == 4)
        {
            --xCoord;
        }

        if (blockSide == 5)
        {
            ++xCoord;
        }

        if (!entityPlayer.canPlayerEdit(xCoord, yCoord, zCoord, blockSide, itemStack))
        {
            return false;
        }
        else
        {
            Block var11 = world.getBlock(xCoord, yCoord, zCoord);

            if (var11 == Blocks.fire)
            {
                world.playSoundEffect(xCoord + 0.5D, yCoord + 0.5D, zCoord + 0.5D, "fire.ignite", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
                world.setBlock(xCoord, yCoord, zCoord, Blocks.fire);
            }

            itemStack.damageItem(1, entityPlayer);
            return true;
        }
    }
}
