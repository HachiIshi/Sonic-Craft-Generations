
package net.mcreator.soniccraftgenerations.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.soniccraftgenerations.world.inventory.MilesElectricMenu;
import net.mcreator.soniccraftgenerations.procedures.ESusedForStrengthProcedure;
import net.mcreator.soniccraftgenerations.procedures.ESusedForHealthProcedure;
import net.mcreator.soniccraftgenerations.procedures.CDusedForCEProcedure;
import net.mcreator.soniccraftgenerations.SonicCraftGenerationsMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class MilesElectricButtonMessage {
	private final int buttonID, x, y, z;

	public MilesElectricButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public MilesElectricButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(MilesElectricButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(MilesElectricButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = MilesElectricMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			ESusedForStrengthProcedure.execute(entity);
		}
		if (buttonID == 2) {

			CDusedForCEProcedure.execute(entity);
		}
		if (buttonID == 3) {

			ESusedForHealthProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		SonicCraftGenerationsMod.addNetworkMessage(MilesElectricButtonMessage.class, MilesElectricButtonMessage::buffer, MilesElectricButtonMessage::new, MilesElectricButtonMessage::handler);
	}
}
