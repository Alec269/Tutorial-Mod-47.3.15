package net.alec269.tutorialmod.item.custom;

import net.alec269.tutorialmod.Block.ModBlocks;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class MetalDetectorItem extends Item {
   public MetalDetectorItem(Item.Properties properties) {
      super(properties);
   }
   
   @Override
   public @NotNull InteractionResult useOn(UseOnContext pContext) {
      if (!pContext.getLevel().isClientSide()) {
         
         BlockPos positionClicked = pContext.getClickedPos();
         Player player = pContext.getPlayer();
         
         boolean foundBlock = false;
         //? scan logic
         // `positionClicked.getY()` + 64 bcs, pos number is counted up from 0 but 'Y_min = -64'
         // there are extra 64 blocks below 'y = 0'
         var distanceToLowestPoint = positionClicked.getY() + 64;
         
         for (int i = 0; i <= distanceToLowestPoint; i++) {
            // positionClicked.below(i) is relative to clicked pos
            BlockState state = pContext.getLevel().getBlockState(positionClicked.below(i));
            // so 'i' is how many blocks you have to go from clicked pos
            if (valuableBlock(state)) {
               assert player != null;
               outputValuablesCoordinate(positionClicked.below(i), player, state.getBlock());
               foundBlock = true;
               break;
            }
         }
         
         if (!foundBlock) {
            assert player != null;
            player.sendSystemMessage(Component.literal("No valuables found!"));
         }
         
         assert pContext.getPlayer() != null;
         // Damage the item on use
         pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(),
            player1 -> player1.broadcastBreakEvent(player1.getUsedItemHand()));
         
         return InteractionResult.SUCCESS;
      }
      return super.useOn(pContext);
   }
   
   private void outputValuablesCoordinate(BlockPos blockPos, Player player, Block block) {
      player.sendSystemMessage(
         Component.literal(
            "Found " + I18n.get(block.getDescriptionId()) + " at "
               + "[ " + blockPos.getX() + " " + blockPos.getY() + " " + blockPos.getZ() + " ]"
         )
      );
   }
   
   
   private boolean valuableBlock(BlockState state) {
      return (
         state.is(Blocks.IRON_ORE)
            || state.is(Blocks.ANCIENT_DEBRIS)
            || state.is(Blocks.DIAMOND_ORE)
            || state.is(Blocks.EMERALD_ORE)
            || state.is(Blocks.REDSTONE_ORE)
            || state.is(Blocks.LAPIS_ORE)
            || state.is(Blocks.GOLD_ORE)
            || state.is(Blocks.COPPER_ORE)
            || state.is(Blocks.COAL_ORE)
            || state.is(Blocks.DEEPSLATE_IRON_ORE)
            || state.is(Blocks.DEEPSLATE_DIAMOND_ORE)
            || state.is(Blocks.DEEPSLATE_EMERALD_ORE)
            || state.is(Blocks.DEEPSLATE_REDSTONE_ORE)
            || state.is(Blocks.DEEPSLATE_LAPIS_ORE)
            || state.is(Blocks.DEEPSLATE_GOLD_ORE)
            || state.is(Blocks.DEEPSLATE_COPPER_ORE)
            || state.is(Blocks.DEEPSLATE_COAL_ORE)
            || state.is(Blocks.NETHER_GOLD_ORE)
            || state.is(Blocks.NETHER_QUARTZ_ORE)
            || state.is(ModBlocks.SAPPHIRE_ORE.get())
            || state.is(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get())
            || state.is(ModBlocks.NETHERRACK_SAPPHIRE_ORE.get())
            || state.is(ModBlocks.END_STONE_SAPPHIRE_ORE.get())
      );
   }
}
