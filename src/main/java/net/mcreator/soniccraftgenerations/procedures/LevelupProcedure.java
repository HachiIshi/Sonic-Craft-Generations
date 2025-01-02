package net.mcreator.soniccraftgenerations.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.soniccraftgenerations.network.SonicCraftGenerationsModVariables;

public class LevelupProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(SonicCraftGenerationsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new SonicCraftGenerationsModVariables.PlayerVariables())).xp > (entity.getCapability(SonicCraftGenerationsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SonicCraftGenerationsModVariables.PlayerVariables())).level
						* (10 + Math.floor((entity.getCapability(SonicCraftGenerationsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SonicCraftGenerationsModVariables.PlayerVariables())).level / 5))) {
			{
				double _setval = (entity.getCapability(SonicCraftGenerationsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SonicCraftGenerationsModVariables.PlayerVariables())).xp
						- (entity.getCapability(SonicCraftGenerationsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SonicCraftGenerationsModVariables.PlayerVariables())).level
								* (10 + Math.floor((entity.getCapability(SonicCraftGenerationsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SonicCraftGenerationsModVariables.PlayerVariables())).level / 5));
				entity.getCapability(SonicCraftGenerationsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.xp = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = (entity.getCapability(SonicCraftGenerationsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SonicCraftGenerationsModVariables.PlayerVariables())).level + 1;
				entity.getCapability(SonicCraftGenerationsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.level = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = (entity.getCapability(SonicCraftGenerationsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SonicCraftGenerationsModVariables.PlayerVariables())).ChaosDrive + 3;
				entity.getCapability(SonicCraftGenerationsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ChaosDrive = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
