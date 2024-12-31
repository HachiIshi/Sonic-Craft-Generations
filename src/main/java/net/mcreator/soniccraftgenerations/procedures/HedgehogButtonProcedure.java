package net.mcreator.soniccraftgenerations.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.soniccraftgenerations.network.SonicCraftGenerationsModVariables;

public class HedgehogButtonProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			String _setval = "Hedgehog";
			entity.getCapability(SonicCraftGenerationsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.scg_playerRace = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
