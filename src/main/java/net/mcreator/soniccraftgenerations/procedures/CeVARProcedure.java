package net.mcreator.soniccraftgenerations.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.soniccraftgenerations.network.SonicCraftGenerationsModVariables;

public class CeVARProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "Chaos Energy " + new java.text.DecimalFormat("##.##").format((entity.getCapability(SonicCraftGenerationsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SonicCraftGenerationsModVariables.PlayerVariables())).MaxChaosEnergy);
	}
}
