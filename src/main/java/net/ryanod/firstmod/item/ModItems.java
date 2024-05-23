package net.ryanod.firstmod.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.ryanod.firstmod.FirstMod;
import net.ryanod.firstmod.item.custom.*;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FirstMod.MOD_ID);

    public static final RegistryObject<Item> TUNGSTEN = ITEMS.register("tungsten",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_TUNGSTEN = ITEMS.register("raw_tungsten",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            () -> new MetalDetectorItem(new Item.Properties().durability(100)));
    public static final RegistryObject<Item> IRON_DETECTOR = ITEMS.register("iron_detector",
            () -> new IronDetectorItem(new Item.Properties().durability(200)));
    public static final RegistryObject<Item> DIAMOND_DETECTOR = ITEMS.register("diamond_detector",
            () -> new DiamondDetectorItem(new Item.Properties().durability(50)));
    public static final RegistryObject<Item> ANCIENT_DEBRIS_DETECTOR = ITEMS.register("ancient_debris_detector",
            () -> new AncientDebrisDetectorItem(new Item.Properties().durability(50).fireResistant()));

    public static final RegistryObject<Item> METAL_MAGNET = ITEMS.register("metal_magnet",
            () -> new MetalMagnetItem(new Item.Properties().durability(100)));
    public static final RegistryObject<Item> IRON_MAGNET = ITEMS.register("iron_magnet",
            () -> new IronMagnetItem(new Item.Properties().durability(200)));
    public static final RegistryObject<Item> DIAMOND_MAGNET = ITEMS.register("diamond_magnet",
            () -> new DiamondMagnetItem(new Item.Properties().durability(50)));
    public static final RegistryObject<Item> ANCIENT_DEBRIS_MAGNET = ITEMS.register("ancient_debris_magnet",
            () -> new AncientDebrisMagnetItem(new Item.Properties().durability(50).fireResistant()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
