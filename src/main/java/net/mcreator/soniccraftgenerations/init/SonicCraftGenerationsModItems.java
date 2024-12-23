
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.soniccraftgenerations.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

import net.mcreator.soniccraftgenerations.item.ChaosEmeraldGreenItem;
import net.mcreator.soniccraftgenerations.SonicCraftGenerationsMod;

public class SonicCraftGenerationsModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, SonicCraftGenerationsMod.MODID);
	public static final RegistryObject<Item> CHAOS_EMERALD_GREEN = REGISTRY.register("chaos_emerald_green", () -> new ChaosEmeraldGreenItem());
	// Start of user code block custom items
	// End of user code block custom items
}
