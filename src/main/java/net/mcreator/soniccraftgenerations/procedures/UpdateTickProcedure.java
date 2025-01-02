package net.mcreator.soniccraftgenerations.procedures;

import net.minecraftforge.eventbus.api.Event;

@Mod.EventBusSubscriber
public class UpdateTickProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event);
		}
	}

	public static void execute() {
		execute(null);
	}

	private static void execute(@Nullable Event event) {
	}
}
