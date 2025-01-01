package net.mcreator.soniccraftgenerations.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.soniccraftgenerations.network.SonicCraftGenerationsModVariables;
import net.mcreator.soniccraftgenerations.init.SonicCraftGenerationsModAttributes;

public class ESusedForHealthProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(SonicCraftGenerationsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SonicCraftGenerationsModVariables.PlayerVariables())).ChaosDrive >= 1) {
			((LivingEntity) entity).getAttribute(SonicCraftGenerationsModAttributes.MAXHEALTH.get()).setBaseValue((((LivingEntity) entity).getAttribute(SonicCraftGenerationsModAttributes.MAXHEALTH.get()).getValue() + 1));
			{
				double _setval = (entity.getCapability(SonicCraftGenerationsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SonicCraftGenerationsModVariables.PlayerVariables())).ChaosDrive - 1;
				entity.getCapability(SonicCraftGenerationsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ChaosDrive = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
