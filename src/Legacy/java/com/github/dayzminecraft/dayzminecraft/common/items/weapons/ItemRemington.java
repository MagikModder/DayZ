package com.github.dayzminecraft.dayzminecraft.common.items.weapons;

import net.minecraft.item.Item;

import com.github.dayzminecraft.dayzminecraft.common.items.ModItems;

public class ItemRemington implements IGun {
  @Override
  public int getRounds() {
    return 6;
  }

  @Override
  public int getDamage() {
    return 20;
  }

  @Override
  public String getReloadSound() {
    return "reload";
  }

  @Override
  public String getShootSound() {
    return "remington";
  }

  @Override
  public Item getAmmo() {
    return ModItems.ammoRemington;
  }
}