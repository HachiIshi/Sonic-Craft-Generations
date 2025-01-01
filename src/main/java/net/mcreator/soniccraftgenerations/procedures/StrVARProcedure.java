package net.mcreator.soniccraftgenerations.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.soniccraftgenerations.init.SonicCraftGenerationsModAttributes;

public class StrVARProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "Strength" + new java.text.DecimalFormat("##.##").format(((LivingEntity) entity).getAttribute(SonicCraftGenerationsModAttributes.STRENGTH.get()).getValue());
	}
}
