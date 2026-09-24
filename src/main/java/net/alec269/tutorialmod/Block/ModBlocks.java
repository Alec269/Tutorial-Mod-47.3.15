package net.alec269.tutorialmod.Block;

import net.alec269.tutorialmod.TutorialMod;
import net.alec269.tutorialmod.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
   public static final DeferredRegister<Block> BLOCKS =
      DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID);
   //
   
   public static
   final RegistryObject<Block> SAPPHIRE_BLOCK = registerblock("sapphire_block",
      () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
         .sound(SoundType.AMETHYST))
   );
   
   public static
   final RegistryObject<Block> RAW_SAPPHIRE_BLOCK = registerblock("raw_sapphire_block",
      () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
         .sound(SoundType.DRIPSTONE_BLOCK))
   );
   
   //# ORES ------------------------------------
   public static
   final RegistryObject<Block> SAPPHIRE_ORE = registerblock("sapphire_ore",
      () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_ORE)
         .strength(2f).requiresCorrectToolForDrops(),
         UniformInt.of(3, 6)
      )
   );
   //
   public static
   final RegistryObject<Block> DEEPSLATE_SAPPHIRE_ORE = registerblock("deepslate_sapphire_ore",
      () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_IRON_ORE)
         .strength(2.5f).requiresCorrectToolForDrops(),
         UniformInt.of(3, 7)
      )
   );
   //
   public static
   final RegistryObject<Block> NETHERRACK_SAPPHIRE_ORE = registerblock("netherrack_sapphire_ore",
      () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.NETHERRACK)
         .strength(1f).requiresCorrectToolForDrops(),
         UniformInt.of(2, 8)
      )
   );
   //
   public static
   final RegistryObject<Block> END_STONE_SAPPHIRE_ORE = registerblock("end_stone_sapphire_ore",
      () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE)
         .strength(4f).requiresCorrectToolForDrops(),
         UniformInt.of(6, 10)
      )
   );
   
   //
   private static <T extends Block> RegistryObject<T> registerblock(String name, Supplier<T> block) {
      RegistryObject<T> toReturn = BLOCKS.register(name, block);
      registerBlockItem(name, toReturn);
      return toReturn;
   }
   
   private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
      return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
   }
   
   public static void register(IEventBus eventBus) {
      BLOCKS.register(eventBus);
   }
}
