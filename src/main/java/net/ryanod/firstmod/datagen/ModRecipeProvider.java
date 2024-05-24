package net.ryanod.firstmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.ryanod.firstmod.FirstMod;
import net.ryanod.firstmod.block.ModBlocks;
import net.ryanod.firstmod.item.ModItems;
import net.ryanod.firstmod.item.util.ModTags;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> TUNGSTEN_SMELTABLES = List.of(
            ModBlocks.TUNGSTEN_ORE.get(), ModBlocks.DEEPSLATE_TUNGSTEN_ORE.get(), ModItems.RAW_TUNGSTEN.get()
    );

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        oreBlasting(consumer, TUNGSTEN_SMELTABLES, RecipeCategory.MISC, ModItems.TUNGSTEN.get(), 0.25f, 200, "tungsten");
        oreSmelting(consumer, TUNGSTEN_SMELTABLES, RecipeCategory.MISC, ModItems.TUNGSTEN.get(), 0.25f, 100, "tungsten");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TUNGSTEN_BLOCK.get())
                .pattern("TTT")
                .pattern("TNT")
                .pattern("TTT")
                .define('T', ModItems.TUNGSTEN.get())
                .define('N', Items.NETHERITE_INGOT)
                .unlockedBy(getHasName(ModItems.TUNGSTEN.get()), has(ModItems.TUNGSTEN.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TUNGSTEN.get(), 9)
                .requires(ModBlocks.TUNGSTEN_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.TUNGSTEN_BLOCK.get()), has(ModBlocks.TUNGSTEN_BLOCK.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TUNGSTEN_SCRAPS.get(), 4)
                .requires(ModItems.TUNGSTEN.get())
                .unlockedBy(getHasName(ModItems.TUNGSTEN.get()), has(ModItems.TUNGSTEN.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.METAL_DETECTOR.get())
                .pattern(" DS")
                .pattern("RCD")
                .pattern("II ")
                .define('D', Items.DIAMOND)
                .define('S', Items.STICK)
                .define('R', Items.REDSTONE)
                .define('C', Items.COMPASS)
                .define('I', Items.IRON_INGOT)
                .unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND))
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .unlockedBy(getHasName(Items.REDSTONE), has(Items.REDSTONE))
                .unlockedBy(getHasName(Items.COMPASS), has(Items.COMPASS))
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.IRON_DETECTOR.get())
                .pattern("III")
                .pattern("IDI")
                .pattern("III")
                .define('D', ModTags.Items.DETECTOR)
                .define('I', Items.IRON_INGOT)
                .unlockedBy(getHasName(ModItems.METAL_DETECTOR.get()), has(ModItems.METAL_DETECTOR.get()))
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.DIAMOND_DETECTOR.get())
                .pattern("ddd")
                .pattern("dDd")
                .pattern("ddd")
                .define('D', ModTags.Items.DETECTOR)
                .define('d', Items.DIAMOND)
                .unlockedBy(getHasName(ModItems.METAL_DETECTOR.get()), has(ModItems.METAL_DETECTOR.get()))
                .unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ANCIENT_DEBRIS_DETECTOR.get())
                .pattern("AAA")
                .pattern("ADA")
                .pattern("AAA")
                .define('D', ModTags.Items.DETECTOR)
                .define('A', Items.ANCIENT_DEBRIS)
                .unlockedBy(getHasName(ModItems.METAL_DETECTOR.get()), has(ModItems.METAL_DETECTOR.get()))
                .unlockedBy(getHasName(Items.ANCIENT_DEBRIS), has(Items.ANCIENT_DEBRIS))
                .save(consumer);


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.DIAMOND_MAGNET.get())
                .pattern("E E")
                .pattern("IDI")
                .pattern("IRI")
                .define('D', ModItems.DIAMOND_DETECTOR.get())
                .define('E', Items.ENDER_EYE)
                .define('R', Items.REDSTONE)
                .define('I', Items.IRON_INGOT)
                .unlockedBy(getHasName(ModItems.DIAMOND_DETECTOR.get()), has(ModItems.DIAMOND_DETECTOR.get()))
                .unlockedBy(getHasName(Items.ENDER_EYE), has(Items.ENDER_EYE))
                .unlockedBy(getHasName(Items.REDSTONE), has(Items.REDSTONE))
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.IRON_MAGNET.get())
                .pattern("E E")
                .pattern("IDI")
                .pattern("IRI")
                .define('D', ModItems.IRON_DETECTOR.get())
                .define('E', Items.ENDER_EYE)
                .define('R', Items.REDSTONE)
                .define('I', Items.IRON_INGOT)
                .unlockedBy(getHasName(ModItems.IRON_DETECTOR.get()), has(ModItems.IRON_DETECTOR.get()))
                .unlockedBy(getHasName(Items.ENDER_EYE), has(Items.ENDER_EYE))
                .unlockedBy(getHasName(Items.REDSTONE), has(Items.REDSTONE))
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ANCIENT_DEBRIS_MAGNET.get())
                .pattern("E E")
                .pattern("IDI")
                .pattern("IRI")
                .define('D', ModItems.ANCIENT_DEBRIS_DETECTOR.get())
                .define('E', Items.ENDER_EYE)
                .define('R', Items.REDSTONE)
                .define('I', Items.IRON_INGOT)
                .unlockedBy(getHasName(ModItems.ANCIENT_DEBRIS_DETECTOR.get()), has(ModItems.ANCIENT_DEBRIS_DETECTOR.get()))
                .unlockedBy(getHasName(Items.ENDER_EYE), has(Items.ENDER_EYE))
                .unlockedBy(getHasName(Items.REDSTONE), has(Items.REDSTONE))
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.METAL_MAGNET.get())
                .pattern("E E")
                .pattern("IDI")
                .pattern("IRI")
                .define('D', ModItems.METAL_DETECTOR.get())
                .define('E', Items.ENDER_EYE)
                .define('R', Items.REDSTONE)
                .define('I', Items.IRON_INGOT)
                .unlockedBy(getHasName(ModItems.METAL_DETECTOR.get()), has(ModItems.METAL_DETECTOR.get()))
                .unlockedBy(getHasName(Items.ENDER_EYE), has(Items.ENDER_EYE))
                .unlockedBy(getHasName(Items.REDSTONE), has(Items.REDSTONE))
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MAGNET_BLOCK.get(), 2)
                .pattern("SSS")
                .pattern("SMS")
                .pattern("SSS")
                .define('M', ModTags.Items.MAGNET)
                .define('S', Items.NETHER_STAR)
                .unlockedBy(getHasName(ModItems.METAL_MAGNET.get()), has(ModItems.METAL_MAGNET.get()))
                .unlockedBy(getHasName(Items.NETHER_STAR), has(Items.NETHER_STAR))
                .save(consumer);
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        Iterator var9 = pIngredients.iterator();

        while(var9.hasNext()) {
            ItemLike itemlike = (ItemLike)var9.next();
            SimpleCookingRecipeBuilder.generic(Ingredient.of(new ItemLike[]{itemlike}), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup)
                    .unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, FirstMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}
