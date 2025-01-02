package net.mcreator.soniccraftgenerations.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.soniccraftgenerations.network.SonicCraftGenerationsModVariables;

public class XpVarProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "XP: " + new java.text.DecimalFormat("##").format((entity.getCapability(SonicCraftGenerationsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SonicCraftGenerationsModVariables.PlayerVariables())).xp) + "/"
				+ new java.text.DecimalFormat("##").format((entity.getCapability(SonicCraftGenerationsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SonicCraftGenerationsModVariables.PlayerVariables())).level
						* (10 + Math.floor((entity.getCapability(SonicCraftGenerationsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SonicCraftGenerationsModVariables.PlayerVariables())).level / 5)));
	}
}
