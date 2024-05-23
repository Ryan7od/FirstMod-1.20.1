package net.ryanod.firstmod.item.custom;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class MetalMagnetItem extends Item {
    public MetalMagnetItem(Properties pProperty) {
        super(pProperty);
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext pContext) {
        if (!pContext.getLevel().isClientSide()) {
            BlockPos positionClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean foundBlock = false;

            for (int i = 0; i <= positionClicked.getY() + 64; i++) {
                BlockState state = pContext.getLevel().getBlockState(positionClicked.below(i));

                if (isOre(state)) {
                    player.getInventory().add(new ItemStack(state.getBlock()));
                    pContext.getLevel().setBlock(positionClicked.below(i), Blocks.AIR.getStateForPlacement(new BlockPlaceContext(pContext)), 0);
                    pContext.getLevel().explode(player, positionClicked.getX(), positionClicked.getY()-i, positionClicked.getZ(), 1, Level.ExplosionInteraction.BLOCK);
                    foundBlock = true;
                    
                    break;
                }
            }

            if (!foundBlock) {
                player.sendSystemMessage(Component.literal("No ores found"));
            }
        }

        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(),
                player -> player.broadcastBreakEvent(player.getUsedItemHand()));

        return InteractionResult.SUCCESS;
    }


    private boolean isOre(BlockState state) {
        return state.is(Blocks.IRON_ORE)
                || state.is(Blocks.COPPER_ORE)
                || state.is(Blocks.DIAMOND_ORE)
                || state.is(Blocks.GOLD_ORE)
                || state.is(Blocks.LAPIS_ORE)
                || state.is(Blocks.EMERALD_ORE)
                || state.is(Blocks.REDSTONE_ORE)
                || state.is(Blocks.DEEPSLATE_IRON_ORE)
                || state.is(Blocks.DEEPSLATE_COPPER_ORE)
                || state.is(Blocks.DEEPSLATE_DIAMOND_ORE)
                || state.is(Blocks.DEEPSLATE_GOLD_ORE)
                || state.is(Blocks.DEEPSLATE_LAPIS_ORE)
                || state.is(Blocks.DEEPSLATE_EMERALD_ORE)
                || state.is(Blocks.DEEPSLATE_REDSTONE_ORE)
                || state.is(Blocks.ANCIENT_DEBRIS);
    }
}
