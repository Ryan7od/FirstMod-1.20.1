package net.ryanod.firstmod.item.custom;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.*;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeManager;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.border.WorldBorder;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.ChunkSource;
import net.minecraft.world.level.chunk.ChunkStatus;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.entity.EntityTypeTest;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.PositionalRandomFactory;
import net.minecraft.world.level.lighting.LevelLightEngine;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.storage.LevelData;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.ticks.LevelTickAccess;
import net.ryanod.firstmod.block.ModBlocks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Predicate;

import static net.minecraft.core.Direction.Axis.X;

public class AncientDebrisMagnetItem extends Item {
    public AncientDebrisMagnetItem(Properties pProperty) {
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

            for (int x = -2; x <= 2 && !foundBlock; x++) {
                for (int z = -2; z <= 2 && !foundBlock; z++) {
                    for (int y = 0; y <= positionClicked.getY() + 64; y++) {
                        BlockState state = pContext.getLevel().getBlockState(positionClicked.offset(x, -y, z));

                        if (isOre(state)) {
                            player.getInventory().add(new ItemStack(state.getBlock()));
                            pContext.getLevel().setBlock(positionClicked.offset(x, -y, z), Blocks.AIR.getStateForPlacement(new BlockPlaceContext(pContext)), 0);
                            pContext.getLevel().explode(player, positionClicked.getX()+x, positionClicked.getY()-y, positionClicked.getZ()+z, 1, Level.ExplosionInteraction.BLOCK);
                            player.sendSystemMessage(Component.literal(I18n.get(state.getBlock().getDescriptionId())+ " extracted"));
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

    private boolean isOre(BlockState state) {
        return state.is(Blocks.ANCIENT_DEBRIS);
    }
}
