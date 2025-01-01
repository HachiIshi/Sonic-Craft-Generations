/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.soniccraftgenerations.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.EntityType;

import net.mcreator.soniccraftgenerations.SonicCraftGenerationsMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SonicCraftGenerationsModAttributes {
	public static final DeferredRegister<Attribute> ATTRIBUTES = DeferredRegister.create(ForgeRegistries.ATTRIBUTES, SonicCraftGenerationsMod.MODID);
	public static final RegistryObject<Attribute> CURRENTHEALTH = ATTRIBUTES.register("current_health", () -> (new RangedAttribute("attribute." + SonicCraftGenerationsMod.MODID + ".current_health", 20, 0, 1000000)).setSyncable(true));
	public static final RegistryObject<Attribute> MAXHEALTH = ATTRIBUTES.register("max_health", () -> (new RangedAttribute("attribute." + SonicCraftGenerationsMod.MODID + ".max_health", 20, 20, 1000000)).setSyncable(true));
	public static final RegistryObject<Attribute> STRENGTH = ATTRIBUTES.register("strength", () -> (new RangedAttribute("attribute." + SonicCraftGenerationsMod.MODID + ".strength", 2, 2, 1000000)).setSyncable(true));
	public static final RegistryObject<Attribute> DEFENSE = ATTRIBUTES.register("defense", () -> (new RangedAttribute("attribute." + SonicCraftGenerationsMod.MODID + ".defense", 1, 1, 1000000)).setSyncable(true));

	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		event.enqueueWork(() -> {
			ATTRIBUTES.register(FMLJavaModLoadingContext.get().getModEventBus());
		});
	}

	@SubscribeEvent
	public static void addAttributes(EntityAttributeModificationEvent event) {
		event.add(EntityType.PLAYER, CURRENTHEALTH.get());
		event.add(EntityType.PLAYER, CURRENTHEALTH.get());
		event.add(EntityType.PLAYER, MAXHEALTH.get());
		event.add(EntityType.PLAYER, MAXHEALTH.get());
		event.add(EntityType.PLAYER, STRENGTH.get());
		event.add(EntityType.PLAYER, STRENGTH.get());
	}

	@Mod.EventBusSubscriber
	private class Utils {
		@SubscribeEvent
		public static void persistAttributes(PlayerEvent.Clone event) {
			Player oldP = event.getOriginal();
			Player newP = (Player) event.getEntity();
			newP.getAttribute(MAXHEALTH.get()).setBaseValue(oldP.getAttribute(MAXHEALTH.get()).getBaseValue());
			newP.getAttribute(STRENGTH.get()).setBaseValue(oldP.getAttribute(STRENGTH.get()).getBaseValue());
		}
	}
}
