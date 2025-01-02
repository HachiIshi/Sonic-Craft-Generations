package net.mcreator.soniccraftgenerations.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.Entity;

import net.mcreator.soniccraftgenerations.network.SonicCraftGenerationsModVariables;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

@Mod.EventBusSubscriber
public class EntityDiesProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!(entity instanceof Player)) {
			{
				final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(65 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Player && !(entityiterator == entity && (entityiterator instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false))) {
						{
							double _setval = (entityiterator.getCapability(SonicCraftGenerationsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SonicCraftGenerationsModVariables.PlayerVariables())).xp
									+ Math.round(entity.getPersistentData().getDouble("level") * 0.5) + 1;
							entityiterator.getCapability(SonicCraftGenerationsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.xp = _setval;
								capability.syncPlayerVariables(entityiterator);
							});
						}
					}
				}
			}
		}
	}
}
