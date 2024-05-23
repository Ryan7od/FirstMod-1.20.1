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
import net.ryanod.firstmod.block.ModBlocks;
import org.jetbrains.annotations.NotNull;

public class IronMagnetItem extends Item {
    public IronMagnetItem(Properties pProperty) {
        super(pProperty);
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext pContext) {
        if (!pContext.getLevel().isClientSide()&&
                !pContext.getLevel()
                        .getBlockState(pContext.getClickedPos())
                        .is(ModBlocks.MAGNET_BLOCK.get())) {
            BlockPos positionClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean foundBlock = false;

            for (int i = 0; i <= positionClicked.getY() + 64; i++) {
                BlockState state = pContext.getLevel().getBlockState(positionClicked.below(i));

                if (isOre(state)) {
                    player.getInventory().add(new ItemStack(state.getBlock()));
                    pContext.getLevel().setBlock(positionClicked.below(i), Blocks.AIR.getStateForPlacement(new BlockPlaceContext(pContext)), 0);
                    pContext.getLevel().explode(player, positionClicked.getX(), positionClicked.getY()-i, positionClicked.getZ(), 1, Level.ExplosionInteraction.BLOCK);
                    player.sendSystemMessage(Component.literal(I18n.get(state.getBlock().getDescriptionId())+ " extracted"));
                    foundBlock = true;
                    
                    break;
                }
            }

            if (!foundBlock) {
                player.sendSystemMessage(Component.literal("No iron found"));
            }
        }

        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(),
                player -> player.broadcastBreakEvent(player.getUsedItemHand()));

        return InteractionResult.SUCCESS;
    }

    private boolean isOre(BlockState state) {
        return state.is(Blocks.IRON_ORE)
                || state.is(Blocks.DEEPSLATE_IRON_ORE);
    }
}
