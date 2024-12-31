
package net.mcreator.soniccraftgenerations.network;

import net.mcreator.soniccraftgenerations.SonicCraftGenerationsMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class MenuOpenMessage {

	int type, pressedms;

	public MenuOpenMessage(int type, int pressedms) {
		this.type = type;
		this.pressedms = pressedms;
	}

	public MenuOpenMessage(FriendlyByteBuf buffer) {
		this.type = buffer.readInt();
		this.pressedms = buffer.readInt();
	}

	public static void buffer(MenuOpenMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.type);
		buffer.writeInt(message.pressedms);
	}

	public static void handler(MenuOpenMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			pressAction(context.getSender(), message.type, message.pressedms);
		});
		context.setPacketHandled(true);
	}

	public static void pressAction(Player entity, int type, int pressedms) {
		Level world = entity.level();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(entity.blockPosition()))
			return;

		if (type == 0) {

			MilesElectricOpenProcedure.execute();
		}

	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		SonicCraftGenerationsMod.addNetworkMessage(MenuOpenMessage.class, MenuOpenMessage::buffer, MenuOpenMessage::new, MenuOpenMessage::handler);
	}

}
