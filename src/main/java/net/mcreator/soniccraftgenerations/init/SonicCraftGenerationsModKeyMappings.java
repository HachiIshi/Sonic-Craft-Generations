
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.soniccraftgenerations.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.soniccraftgenerations.network.SkillSwitchMessage;
import net.mcreator.soniccraftgenerations.network.MilesMenuOpenMessage;
import net.mcreator.soniccraftgenerations.network.ChaosEnergyChargeMessage;
import net.mcreator.soniccraftgenerations.SonicCraftGenerationsMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class SonicCraftGenerationsModKeyMappings {
	public static final KeyMapping MILES_MENU_OPEN = new KeyMapping("key.sonic_craft_generations.miles_menu_open", GLFW.GLFW_KEY_M, "key.categories.scgens") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				SonicCraftGenerationsMod.PACKET_HANDLER.sendToServer(new MilesMenuOpenMessage(0, 0));
				MilesMenuOpenMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping CHAOS_ENERGY_CHARGE = new KeyMapping("key.sonic_craft_generations.chaos_energy_charge", GLFW.GLFW_KEY_C, "key.categories.scg") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				SonicCraftGenerationsMod.PACKET_HANDLER.sendToServer(new ChaosEnergyChargeMessage(0, 0));
				ChaosEnergyChargeMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				CHAOS_ENERGY_CHARGE_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - CHAOS_ENERGY_CHARGE_LASTPRESS);
				SonicCraftGenerationsMod.PACKET_HANDLER.sendToServer(new ChaosEnergyChargeMessage(1, dt));
				ChaosEnergyChargeMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping SKILL_SWITCH = new KeyMapping("key.sonic_craft_generations.skill_switch", GLFW.GLFW_KEY_C, "key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				SonicCraftGenerationsMod.PACKET_HANDLER.sendToServer(new SkillSwitchMessage(0, 0));
				SkillSwitchMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	private static long CHAOS_ENERGY_CHARGE_LASTPRESS = 0;

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(MILES_MENU_OPEN);
		event.register(CHAOS_ENERGY_CHARGE);
		event.register(SKILL_SWITCH);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				MILES_MENU_OPEN.consumeClick();
				CHAOS_ENERGY_CHARGE.consumeClick();
				SKILL_SWITCH.consumeClick();
			}
		}
	}
}
