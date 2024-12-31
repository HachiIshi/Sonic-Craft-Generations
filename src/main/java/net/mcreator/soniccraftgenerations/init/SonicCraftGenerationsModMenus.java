
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.soniccraftgenerations.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.soniccraftgenerations.world.inventory.RaceguiMenu;
import net.mcreator.soniccraftgenerations.world.inventory.MilesElectricMenu;
import net.mcreator.soniccraftgenerations.SonicCraftGenerationsMod;

public class SonicCraftGenerationsModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, SonicCraftGenerationsMod.MODID);
	public static final RegistryObject<MenuType<RaceguiMenu>> RACEGUI = REGISTRY.register("racegui", () -> IForgeMenuType.create(RaceguiMenu::new));
	public static final RegistryObject<MenuType<MilesElectricMenu>> MILES_ELECTRIC = REGISTRY.register("miles_electric", () -> IForgeMenuType.create(MilesElectricMenu::new));
}
