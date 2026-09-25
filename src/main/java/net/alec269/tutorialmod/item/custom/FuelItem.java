
package net.alec269.tutorialmod.item.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;

import javax.annotation.Nullable;

public class FuelItem extends Item {
   private int burnTime = 0;
   
   public FuelItem(Properties pProperties, int burn_time_in_ticks) {
      super(pProperties);
      this.burnTime = burn_time_in_ticks;
   }
   
   @Override
   public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
      return this.burnTime;
   }
}
