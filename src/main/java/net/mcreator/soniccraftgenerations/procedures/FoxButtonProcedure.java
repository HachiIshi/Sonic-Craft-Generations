package net.mcreator.soniccraftgenerations.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.soniccraftgenerations.network.SonicCraftGenerationsModVariables;

public class FoxButtonProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			String _setval = "Fox";
			entity.getCapability(SonicCraftGenerationsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.Race = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
