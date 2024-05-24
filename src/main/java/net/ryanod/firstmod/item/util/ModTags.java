package net.ryanod.firstmod.item.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.ryanod.firstmod.FirstMod;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> ORES_FOR_DETECTOR = tag("ores_for_detector");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(FirstMod.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> DETECTOR = tag("detector");
        public static final TagKey<Item> MAGNET = tag("magnet");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(FirstMod.MOD_ID, name));
        }
    }
}
