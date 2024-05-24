package net.ryanod.firstmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.ryanod.firstmod.FirstMod;
import net.ryanod.firstmod.block.ModBlocks;
import net.ryanod.firstmod.item.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, FirstMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ModTags.Blocks.ORES_FOR_DETECTOR)
                .add(ModBlocks.TUNGSTEN_ORE.get(),
                     ModBlocks.DEEPSLATE_TUNGSTEN_ORE.get()
                )
                .addTags(Tags.Blocks.ORES);

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.TUNGSTEN_ORE.get(),
                     ModBlocks.DEEPSLATE_TUNGSTEN_ORE.get(),
                     ModBlocks.MAGNET_BLOCK.get()
                );

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.TUNGSTEN_BLOCK.get());

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.TUNGSTEN_ORE.get(),
                     ModBlocks.DEEPSLATE_TUNGSTEN_ORE.get(),
                     ModBlocks.MAGNET_BLOCK.get(),
                     ModBlocks.TUNGSTEN_BLOCK.get()
                );
    }
}
