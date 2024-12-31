
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.soniccraftgenerations.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.soniccraftgenerations.SonicCraftGenerationsMod;

public class SonicCraftGenerationsModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SonicCraftGenerationsMod.MODID);
	public static final RegistryObject<CreativeModeTab> SONIC_CRAFT_GENERATIONS = REGISTRY.register("sonic_craft_generations", () -> CreativeModeTab.builder().title(Component.translatable("item_group.sonic_craft_generations.sonic_craft_generations"))
			.icon(() -> new ItemStack(SonicCraftGenerationsModItems.CREATIVE_TAB_ICON.get())).displayItems((parameters, tabData) -> {
				tabData.accept(SonicCraftGenerationsModItems.CHAOS_EMERALD_GREEN.get());
				tabData.accept(SonicCraftGenerationsModItems.CHAOS_EMERALD_RED.get());
				tabData.accept(SonicCraftGenerationsModItems.CHAOS_EMERALD_BLUE.get());
				tabData.accept(SonicCraftGenerationsModItems.CHAOS_EMERALD_CYAN.get());
				tabData.accept(SonicCraftGenerationsModItems.CHAOS_EMERALD_PURPLE.get());
				tabData.accept(SonicCraftGenerationsModItems.CHAOS_EMERALD_YELLOW.get());
				tabData.accept(SonicCraftGenerationsModItems.CHAOS_EMERALD_WHITE.get());
			})

			.build());
}
