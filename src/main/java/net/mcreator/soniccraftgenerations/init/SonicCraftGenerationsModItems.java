
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.soniccraftgenerations.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

import net.mcreator.soniccraftgenerations.item.CreativeTabIconItem;
import net.mcreator.soniccraftgenerations.item.ChaosEmeraldYellowItem;
import net.mcreator.soniccraftgenerations.item.ChaosEmeraldWhiteItem;
import net.mcreator.soniccraftgenerations.item.ChaosEmeraldRedItem;
import net.mcreator.soniccraftgenerations.item.ChaosEmeraldPurpleItem;
import net.mcreator.soniccraftgenerations.item.ChaosEmeraldGreenItem;
import net.mcreator.soniccraftgenerations.item.ChaosEmeraldCyanItem;
import net.mcreator.soniccraftgenerations.item.ChaosEmeraldBlueItem;
import net.mcreator.soniccraftgenerations.SonicCraftGenerationsMod;

public class SonicCraftGenerationsModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, SonicCraftGenerationsMod.MODID);
	public static final RegistryObject<Item> CHAOS_EMERALD_GREEN = REGISTRY.register("chaos_emerald_green", () -> new ChaosEmeraldGreenItem());
	public static final RegistryObject<Item> CHAOS_EMERALD_RED = REGISTRY.register("chaos_emerald_red", () -> new ChaosEmeraldRedItem());
	public static final RegistryObject<Item> CHAOS_EMERALD_BLUE = REGISTRY.register("chaos_emerald_blue", () -> new ChaosEmeraldBlueItem());
	public static final RegistryObject<Item> CHAOS_EMERALD_CYAN = REGISTRY.register("chaos_emerald_cyan", () -> new ChaosEmeraldCyanItem());
	public static final RegistryObject<Item> CHAOS_EMERALD_PURPLE = REGISTRY.register("chaos_emerald_purple", () -> new ChaosEmeraldPurpleItem());
	public static final RegistryObject<Item> CHAOS_EMERALD_YELLOW = REGISTRY.register("chaos_emerald_yellow", () -> new ChaosEmeraldYellowItem());
	public static final RegistryObject<Item> CREATIVE_TAB_ICON = REGISTRY.register("creative_tab_icon", () -> new CreativeTabIconItem());
	public static final RegistryObject<Item> CHAOS_EMERALD_WHITE = REGISTRY.register("chaos_emerald_white", () -> new ChaosEmeraldWhiteItem());
	// Start of user code block custom items
	// End of user code block custom items
}
