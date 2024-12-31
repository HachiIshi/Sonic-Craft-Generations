package net.mcreator.soniccraftgenerations.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.soniccraftgenerations.world.inventory.RaceguiMenu;
import net.mcreator.soniccraftgenerations.network.RaceguiButtonMessage;
import net.mcreator.soniccraftgenerations.SonicCraftGenerationsMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class RaceguiScreen extends AbstractContainerScreen<RaceguiMenu> {
	private final static HashMap<String, Object> guistate = RaceguiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_hedgehog;
	Button button_fox;
	Button button_echidna;

	public RaceguiScreen(RaceguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 0;
	}

	private static final ResourceLocation texture = new ResourceLocation("sonic_craft_generations:textures/screens/racegui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(new ResourceLocation("sonic_craft_generations:textures/screens/echidnaicon-export.png"), this.leftPos + 126, this.topPos + -18, 0, 0, 32, 28, 32, 28);

		guiGraphics.blit(new ResourceLocation("sonic_craft_generations:textures/screens/foxicon.png"), this.leftPos + -18, this.topPos + -18, 0, 0, 32, 26, 32, 26);

		guiGraphics.blit(new ResourceLocation("sonic_craft_generations:textures/screens/hedgehogicon.png"), this.leftPos + -154, this.topPos + -19, 0, 0, 32, 26, 32, 26);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
	}

	@Override
	public void init() {
		super.init();
		button_hedgehog = Button.builder(Component.translatable("gui.sonic_craft_generations.racegui.button_hedgehog"), e -> {
			if (true) {
				SonicCraftGenerationsMod.PACKET_HANDLER.sendToServer(new RaceguiButtonMessage(0, x, y, z));
				RaceguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + -174, this.topPos + 27, 67, 20).build();
		guistate.put("button:button_hedgehog", button_hedgehog);
		this.addRenderableWidget(button_hedgehog);
		button_fox = Button.builder(Component.translatable("gui.sonic_craft_generations.racegui.button_fox"), e -> {
			if (true) {
				SonicCraftGenerationsMod.PACKET_HANDLER.sendToServer(new RaceguiButtonMessage(1, x, y, z));
				RaceguiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + -18, this.topPos + 27, 40, 20).build();
		guistate.put("button:button_fox", button_fox);
		this.addRenderableWidget(button_fox);
		button_echidna = Button.builder(Component.translatable("gui.sonic_craft_generations.racegui.button_echidna"), e -> {
			if (true) {
				SonicCraftGenerationsMod.PACKET_HANDLER.sendToServer(new RaceguiButtonMessage(2, x, y, z));
				RaceguiButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 115, this.topPos + 27, 61, 20).build();
		guistate.put("button:button_echidna", button_echidna);
		this.addRenderableWidget(button_echidna);
	}
}
