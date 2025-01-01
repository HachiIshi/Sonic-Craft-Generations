package net.mcreator.soniccraftgenerations.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.soniccraftgenerations.world.inventory.MilesElectricMenu;
import net.mcreator.soniccraftgenerations.procedures.StrVARProcedure;
import net.mcreator.soniccraftgenerations.procedures.HealthProcedure;
import net.mcreator.soniccraftgenerations.procedures.CdVARProcedure;
import net.mcreator.soniccraftgenerations.network.MilesElectricButtonMessage;
import net.mcreator.soniccraftgenerations.SonicCraftGenerationsMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class MilesElectricScreen extends AbstractContainerScreen<MilesElectricMenu> {
	private final static HashMap<String, Object> guistate = MilesElectricMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_new_piskel1png_1;
	ImageButton imagebutton_new_piskel1png_11;
	ImageButton imagebutton_new_piskel1png_12;
	ImageButton imagebutton_new_piskel1png_13;

	public MilesElectricScreen(MilesElectricMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 250;
		this.imageHeight = 150;
	}

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

		guiGraphics.blit(new ResourceLocation("sonic_craft_generations:textures/screens/mileselectric.png"), this.leftPos + -55, this.topPos + -1, 0, 0, 350, 150, 350, 150);

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
		guiGraphics.drawString(this.font,

				HealthProcedure.execute(entity), 60, 55, -16724992, false);
		guiGraphics.drawString(this.font,

				StrVARProcedure.execute(entity), 60, 69, -16724992, false);
		guiGraphics.drawString(this.font,

				CdVARProcedure.execute(entity), 111, 36, -16724992, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_new_piskel1png_1 = new ImageButton(this.leftPos + 44, this.topPos + 66, 15, 15, 0, 0, 15, new ResourceLocation("sonic_craft_generations:textures/screens/atlas/imagebutton_new_piskel1png_1.png"), 15, 30, e -> {
			if (true) {
				SonicCraftGenerationsMod.PACKET_HANDLER.sendToServer(new MilesElectricButtonMessage(0, x, y, z));
				MilesElectricButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_new_piskel1png_1", imagebutton_new_piskel1png_1);
		this.addRenderableWidget(imagebutton_new_piskel1png_1);
		imagebutton_new_piskel1png_11 = new ImageButton(this.leftPos + 44, this.topPos + 81, 15, 15, 0, 0, 15, new ResourceLocation("sonic_craft_generations:textures/screens/atlas/imagebutton_new_piskel1png_11.png"), 15, 30, e -> {
		});
		guistate.put("button:imagebutton_new_piskel1png_11", imagebutton_new_piskel1png_11);
		this.addRenderableWidget(imagebutton_new_piskel1png_11);
		imagebutton_new_piskel1png_12 = new ImageButton(this.leftPos + 44, this.topPos + 97, 15, 15, 0, 0, 15, new ResourceLocation("sonic_craft_generations:textures/screens/atlas/imagebutton_new_piskel1png_12.png"), 15, 30, e -> {
		});
		guistate.put("button:imagebutton_new_piskel1png_12", imagebutton_new_piskel1png_12);
		this.addRenderableWidget(imagebutton_new_piskel1png_12);
		imagebutton_new_piskel1png_13 = new ImageButton(this.leftPos + 44, this.topPos + 51, 15, 15, 0, 0, 15, new ResourceLocation("sonic_craft_generations:textures/screens/atlas/imagebutton_new_piskel1png_13.png"), 15, 30, e -> {
			if (true) {
				SonicCraftGenerationsMod.PACKET_HANDLER.sendToServer(new MilesElectricButtonMessage(3, x, y, z));
				MilesElectricButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:imagebutton_new_piskel1png_13", imagebutton_new_piskel1png_13);
		this.addRenderableWidget(imagebutton_new_piskel1png_13);
	}
}
