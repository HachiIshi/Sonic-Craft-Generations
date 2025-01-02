
package net.mcreator.soniccraftgenerations.network;

import net.mcreator.soniccraftgenerations.SonicCraftGenerationsMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SkillSwitchMessage {

	int type, pressedms;

	public SkillSwitchMessage(int type, int pressedms) {
		this.type = type;
		this.pressedms = pressedms;
	}

	public SkillSwitchMessage(FriendlyByteBuf buffer) {
		this.type = buffer.readInt();
		this.pressedms = buffer.readInt();
	}

	public static void buffer(SkillSwitchMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.type);
		buffer.writeInt(message.pressedms);
	}

	public static void handler(SkillSwitchMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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

			SkillSwitchOnKeyPressedProcedure.execute();
		}

	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		SonicCraftGenerationsMod.addNetworkMessage(SkillSwitchMessage.class, SkillSwitchMessage::buffer, SkillSwitchMessage::new, SkillSwitchMessage::handler);
	}

}
