package net.ryanod.firstmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.ryanod.firstmod.FirstMod;
import net.ryanod.firstmod.item.ModItems;
import net.ryanod.firstmod.item.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, FirstMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ModTags.Items.DETECTOR)
                .add(ModItems.METAL_DETECTOR.get(),
                        ModItems.IRON_DETECTOR.get(),
                        ModItems.DIAMOND_DETECTOR.get(),
                        ModItems.ANCIENT_DEBRIS_DETECTOR.get()
                );
        this.tag(ModTags.Items.MAGNET)
                .add(ModItems.METAL_MAGNET.get(),
                        ModItems.IRON_MAGNET.get(),
                        ModItems.DIAMOND_MAGNET.get(),
                        ModItems.ANCIENT_DEBRIS_MAGNET.get()
                );
    }
}
