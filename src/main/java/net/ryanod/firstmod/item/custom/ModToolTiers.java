package net.ryanod.firstmod.item.custom;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;
import net.ryanod.firstmod.FirstMod;
import net.ryanod.firstmod.item.ModItems;
import net.ryanod.firstmod.item.util.ModTags;

import java.util.List;

public class ModToolTiers {
    public static final Tier TUNGSTEN = new TierSortingRegistry().registerTier(
            new ForgeTier(5, 2300, 12f, 5f, 25,
                    ModTags.Blocks.NEEDS_TUNGSTEN_TOOL, () -> Ingredient.of(ModItems.TUNGSTEN.get())),
            new ResourceLocation(FirstMod.MOD_ID, "tungsten"), List.of(Tiers.NETHERITE), List.of()
    );
}
