package net.mcreator.soniccraftgenerations.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class HealthProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "Health" + new java.text.DecimalFormat("##.##").format(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getValue());
	}
}
