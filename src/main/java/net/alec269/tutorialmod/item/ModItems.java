package net.alec269.tutorialmod.item;

import net.alec269.tutorialmod.TutorialMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

// items are registered via the "ModItems" class
public class ModItems {
   // register in a DeferredRegister of type Item
   public static final DeferredRegister<Item> ITEMS =
      DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);
   // a DeferredRegister is like a list
   
   //# ADD Item
   public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire",
      () -> new Item(new Item.Properties()));
   
   //# register method
   public static void register(IEventBus eventBus) {
      ITEMS.register(eventBus);
   }
}
