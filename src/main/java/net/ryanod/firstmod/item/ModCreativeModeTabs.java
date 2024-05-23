package net.ryanod.firstmod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.ryanod.firstmod.FirstMod;
import net.ryanod.firstmod.block.ModBlocks;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FirstMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MATERIALS_TAB = CREATIVE_MODE_TABS.register("materials_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.TUNGSTEN.get()))
                    .title(Component.translatable("creativetab.materials_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.TUNGSTEN.get());
                        pOutput.accept(ModItems.RAW_TUNGSTEN.get());
                        pOutput.accept(ModItems.TUNGSTEN_SCRAPS.get());

                        pOutput.accept(ModBlocks.TUNGSTEN_BLOCK.get());
                        pOutput.accept(ModBlocks.TUNGSTEN_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_TUNGSTEN_ORE.get());

                        pOutput.accept(ModItems.METAL_DETECTOR.get());
                        pOutput.accept(ModItems.IRON_DETECTOR.get());
                        pOutput.accept(ModItems.DIAMOND_DETECTOR.get());
                        pOutput.accept(ModItems.ANCIENT_DEBRIS_DETECTOR.get());

                        pOutput.accept(ModItems.METAL_MAGNET.get());
                        pOutput.accept(ModItems.IRON_MAGNET.get());
                        pOutput.accept(ModItems.DIAMOND_MAGNET.get());
                        pOutput.accept(ModItems.ANCIENT_DEBRIS_MAGNET.get());
                        pOutput.accept(ModBlocks.MAGNET_BLOCK.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
