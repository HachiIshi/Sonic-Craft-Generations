package net.mcreator.soniccraftgenerations.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.soniccraftgenerations.network.SonicCraftGenerationsModVariables;

public class SkillSwitchOnKeyPressedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = (entity.getCapability(SonicCraftGenerationsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SonicCraftGenerationsModVariables.PlayerVariables())).skillSlot + (entity.isShiftKeyDown() ? -1 : 1);
			entity.getCapability(SonicCraftGenerationsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.skillSlot = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if ((entity.getCapability(SonicCraftGenerationsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SonicCraftGenerationsModVariables.PlayerVariables())).skillSlot < 1) {
			{
				double _setval = 6;
				entity.getCapability(SonicCraftGenerationsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.skillSlot = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((entity.getCapability(SonicCraftGenerationsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SonicCraftGenerationsModVariables.PlayerVariables())).skillSlot > 6) {
			{
				double _setval = 1;
				entity.getCapability(SonicCraftGenerationsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.skillSlot = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
