package net.ryanod.firstmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.ryanod.firstmod.FirstMod;
import net.ryanod.firstmod.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, FirstMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.TUNGSTEN);
        simpleItem(ModItems.RAW_TUNGSTEN);
        simpleItem(ModItems.TUNGSTEN_SCRAPS);
        simpleItem(ModItems.METAL_DETECTOR);
        simpleItem(ModItems.METAL_MAGNET);
        simpleItem(ModItems.IRON_DETECTOR);
        simpleItem(ModItems.IRON_MAGNET);
        simpleItem(ModItems.DIAMOND_DETECTOR);
        simpleItem(ModItems.DIAMOND_MAGNET);
        simpleItem(ModItems.ANCIENT_DEBRIS_DETECTOR);
        simpleItem(ModItems.ANCIENT_DEBRIS_MAGNET);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(FirstMod.MOD_ID, "item/" +item.getId().getPath()));
    }
}
