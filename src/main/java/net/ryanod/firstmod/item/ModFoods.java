package net.ryanod.firstmod.item;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties TUNGSTEN_SCRAPS = new FoodProperties.Builder().nutrition(2)
            .effect(new MobEffectInstance(MobEffects.POISON, 600), 0.6f).build();
}
