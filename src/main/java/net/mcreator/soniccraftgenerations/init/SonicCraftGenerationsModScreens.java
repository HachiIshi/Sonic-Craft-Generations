
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.soniccraftgenerations.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.soniccraftgenerations.client.gui.RaceguiScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class SonicCraftGenerationsModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(SonicCraftGenerationsModMenus.RACEGUI.get(), RaceguiScreen::new);
		});
	}
}
