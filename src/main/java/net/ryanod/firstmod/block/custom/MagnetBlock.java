package net.ryanod.firstmod.block.custom;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.ryanod.firstmod.block.ModBlocks;
import net.ryanod.firstmod.item.ModItems;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MagnetBlock extends Block {
    public MagnetBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (!pLevel.isClientSide()) {
            ItemStack item = pPlayer.getInventory().getSelected();
            int range = 0;
            if (item.is(ModItems.ANCIENT_DEBRIS_MAGNET.get())) {
                range = 50;
            } else if (item.is(ModItems.DIAMOND_MAGNET.get())) {
                range = 30;
            } else if (item.is(ModItems.IRON_MAGNET.get())) {
                range = 20;
            } else if (item.is(ModItems.METAL_MAGNET.get())) {
                range = 10;
            }

            boolean foundBlock = false;

            for (int x = -(range / 2); x <= (range / 2) && !foundBlock; x++) {
                for (int y = -(range / 2); y <= (range / 2) && !foundBlock; y++) {
                    for (int i = 0; i <= pPos.getY() + 64; i++) {
                        BlockState state = pLevel.getBlockState(pPos.offset(x, -i, y));

                        if (isOreConditional(state, item)) {
                            pPlayer.getInventory().add(new ItemStack(state.getBlock()));
                            pLevel.setBlock(pPos.offset(x, -i, y), Blocks.AIR.getStateForPlacement(new BlockPlaceContext(pPlayer, pHand, new ItemStack(Items.AIR), pHit)), 0);
                            pLevel.explode(pPlayer, pPos.getX(), pPos.getY() - i, pPos.getZ(), 1, Level.ExplosionInteraction.BLOCK);
                            pPlayer.sendSystemMessage(Component.literal(I18n.get(state.getBlock().getDescriptionId()) + " extracted"));
                            foundBlock = true;

                            break;
                        }
                    }
                }
            }

            if (!foundBlock) {
                pPlayer.sendSystemMessage(Component.literal("No ores found"));
            }
        }

        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable BlockGetter pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        pTooltip.add(Component.translatable("tooltip.firstmod.magnet_block"));
        super.appendHoverText(pStack, pLevel, pTooltip, pFlag);
    }

    private boolean isOreConditional(BlockState state, ItemStack item) {
        if (item.is(ModItems.ANCIENT_DEBRIS_MAGNET.get())) {
            return state.is(Blocks.ANCIENT_DEBRIS);
        } else if (item.is(ModItems.DIAMOND_MAGNET.get())) {
            return state.is(Blocks.DIAMOND_ORE)
                    || state.is(Blocks.DEEPSLATE_DIAMOND_ORE);
        } else if (item.is(ModItems.IRON_MAGNET.get())) {
            return state.is(Blocks.IRON_ORE)
                    || state.is(Blocks.DEEPSLATE_IRON_ORE);
        } else if (item.is(ModItems.METAL_MAGNET.get())) {
            return state.is(Blocks.IRON_ORE)
                    || state.is(Blocks.COPPER_ORE)
                    || state.is(Blocks.DIAMOND_ORE)
                    || state.is(Blocks.GOLD_ORE)
                    || state.is(Blocks.LAPIS_ORE)
                    || state.is(Blocks.EMERALD_ORE)
                    || state.is(Blocks.REDSTONE_ORE)
                    || state.is(ModBlocks.TUNGSTEN_ORE.get())
                    || state.is(Blocks.DEEPSLATE_IRON_ORE)
                    || state.is(Blocks.DEEPSLATE_COPPER_ORE)
                    || state.is(Blocks.DEEPSLATE_DIAMOND_ORE)
                    || state.is(Blocks.DEEPSLATE_GOLD_ORE)
                    || state.is(Blocks.DEEPSLATE_LAPIS_ORE)
                    || state.is(Blocks.DEEPSLATE_EMERALD_ORE)
                    || state.is(Blocks.DEEPSLATE_REDSTONE_ORE)
                    || state.is(ModBlocks.DEEPSLATE_TUNGSTEN_ORE.get())
                    || state.is(Blocks.ANCIENT_DEBRIS);
        } return false;
    }
}
