package net.ryanod.firstmod.item.custom;

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

public class AncientDebrisDetectorItem extends Item {
    public AncientDebrisDetectorItem(Properties pProperty) {
        super(pProperty);
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext pContext) {
        if (pContext.getLevel().isClientSide()) {
            BlockPos positionClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean foundBlock = false;

            for(int x = -2; x <= 2; x++) {
                for (int z = -2; z <= 2; z++) {
                    for (int i = 0; i <= positionClicked.getY() + 64; i++) {
                        BlockState state = pContext.getLevel().getBlockState(positionClicked.offset(x, -i, z));

                        if (isOre(state)) {
                            outputOreCoords(positionClicked.offset(x, -i, z), player, state.getBlock());
                            foundBlock = true;

                            break;
                        }
                    }
                }
            }

            if (!foundBlock) {
                player.sendSystemMessage(Component.literal("No ancient debris found"));
            }
        }

        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(),
                player -> player.broadcastBreakEvent(player.getUsedItemHand()));

        return InteractionResult.SUCCESS;
    }

    private void outputOreCoords(BlockPos blockPos, Player player, Block block) {
        player.sendSystemMessage(Component.literal("Found " + I18n.get(block.getDescriptionId()) + " at ("
        + blockPos.getX() + ", " + blockPos.getY() + ", " + blockPos.getZ() + ")"));
    }

    private boolean isOre(BlockState state) {
        return state.is(Blocks.ANCIENT_DEBRIS);
    }
}
