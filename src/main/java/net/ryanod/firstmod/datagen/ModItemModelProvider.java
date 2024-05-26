package net.ryanod.firstmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
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

        handheldItem(ModItems.TUNGSTEN_SWORD);
        handheldItem(ModItems.TUNGSTEN_PICKAXE);
        handheldItem(ModItems.TUNGSTEN_AXE);
        handheldItem(ModItems.TUNGSTEN_HOE);
        handheldItem(ModItems.TUNGSTEN_SHOVEL);

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

    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(FirstMod.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                mcLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }
    
    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                mcLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()) + "_bottom");
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> basedOn) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture", new ResourceLocation(FirstMod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(basedOn.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> basedOn) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture", new ResourceLocation(FirstMod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(basedOn.get()).getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> basedOn) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("texture", new ResourceLocation(FirstMod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(basedOn.get()).getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(FirstMod.MOD_ID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(FirstMod.MOD_ID, "item/" + item.getId().getPath()));
    }
}
