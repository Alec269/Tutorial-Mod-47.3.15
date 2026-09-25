package net.alec269.tutorialmod.item;

import net.alec269.tutorialmod.TutorialMod;
import net.alec269.tutorialmod.item.custom.FuelItem;
import net.alec269.tutorialmod.item.custom.MetalDetectorItem;

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
   public static final RegistryObject<Item> SAPPHIRE = ITEMS.register(
      "sapphire", () -> new Item(
         new Item.Properties()
      )
   );
   
   public static final RegistryObject<Item> RAW_SAPPHIRE = ITEMS.register(
      "raw_sapphire", () -> new Item(
         new Item.Properties()
      )
   );
   
   // Custom Item ------------------------------------------
   public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register(
      "metal_detector", () -> new MetalDetectorItem(
         new Item.Properties().durability(500)
      )
   );
   
   // Food ------------------------------------------
   public static final RegistryObject<Item> STRAWBERRY = ITEMS.register(
      "strawberry", () -> new Item(
         new Item.Properties().food(ModFoods.STRAWBERRY)
      )
   );
   
   // Fuel ------------------------------------------
   public static final RegistryObject<Item> PINE_CONE = ITEMS.register(
      "pine_cone", () -> new FuelItem(
         new Item.Properties(),
         400
      )
   );
   
   //# register method
   public static void register(IEventBus eventBus) {
      ITEMS.register(eventBus);
   }
}
