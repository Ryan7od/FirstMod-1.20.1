package net.ryanod.firstmod.item;

import net.minecraft.world.item.*;
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
    public static final RegistryObject<Item> TUNGSTEN_SCRAPS = ITEMS.register("tungsten_scraps",
            () -> new Item(new Item.Properties().food(ModFoods.TUNGSTEN_SCRAPS)));
    public static final RegistryObject<Item> TUNGSTEN_STAFF = ITEMS.register("tungsten_staff",
            () -> new TungstenStaffItem(new Item.Properties().durability(1000)));

    public static final RegistryObject<Item> TUNGSTEN_SWORD = ITEMS.register("tungsten_sword",
            () -> new SwordItem(ModToolTiers.TUNGSTEN, 5, 3, new Item.Properties()));
    public static final RegistryObject<Item> TUNGSTEN_PICKAXE = ITEMS.register("tungsten_pickaxe",
            () -> new PickaxeItem(ModToolTiers.TUNGSTEN, 1, 2, new Item.Properties()));
    public static final RegistryObject<Item> TUNGSTEN_AXE = ITEMS.register("tungsten_axe",
            () -> new AxeItem(ModToolTiers.TUNGSTEN, 8, 1, new Item.Properties()));
    public static final RegistryObject<Item> TUNGSTEN_HOE = ITEMS.register("tungsten_hoe",
            () -> new HoeItem(ModToolTiers.TUNGSTEN, 0, 0, new Item.Properties()));
    public static final RegistryObject<Item> TUNGSTEN_SHOVEL = ITEMS.register("tungsten_shovel",
            () -> new ShovelItem(ModToolTiers.TUNGSTEN, 0, 0, new Item.Properties()));

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
