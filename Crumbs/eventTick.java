package com.KingCubic.Crumbs;
import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.command.ICommandSender;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.client.event.sound.PlaySoundEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
public class eventTick {
  @SubscribeEvent
	public void checkExplosionSound(PlaySoundEvent event) {
	    ICommandSender sender = Minecraft.getMinecraft().thePlayer;
		String a = event.sound.getSoundLocation().toString();
		if (Crumbs.lightningTime != System.currentTimeMillis()) {
			Crumbs.lightningTime = 0L;
		if (a.endsWith("thunder")) {
			Crumbs.lightningTime = System.currentTimeMillis();
		} else {
	  	if (a.endsWith("explode") && (Crumbs.lightningTime != System.currentTimeMillis())) {
		float x = event.sound.getXPosF();
		float y = event.sound.getYPosF();
		float z = event.sound.getZPosF();
			if ((x != ExplosionLocation.getExpX()) || (z != ExplosionLocation.getExpZ())) {
				if (Boolean.valueOf(Crumbs.XEnabled)) {
					ChatModifiers.sendMessage(sender, "X: " + (int)x);		
				}
				if (Boolean.valueOf(Crumbs.YEnabled)) {
					ChatModifiers.sendMessage(sender, "Y: " + (int)Math.ceil(y));
				}
				if (Boolean.valueOf(Crumbs.ZEnabled)) {
					ChatModifiers.sendMessage(sender, "Z: " + (int)z);
				}
				ExplosionLocation.setExpX(x);
				ExplosionLocation.setExpY((float)Math.ceil(y));
				ExplosionLocation.setExpZ(z);
				ExplosionLocation.setTime(System.currentTimeMillis());
			}
		}
	  	}
	  	}
  }
  @SubscribeEvent
	public void update(RenderWorldLastEvent event) {
		EntityPlayerSP player = null;
		try {
		player = (Minecraft.getMinecraft()).thePlayer;
		} catch (Exception exception) {}
		if (ExplosionLocation.time != null) {
	  	Crumbs.renderer.render(player, ExplosionLocation.time, event.partialTicks);
		}
  	}
  @SubscribeEvent
  public void overlay(RenderGameOverlayEvent event) {
	  Minecraft mc = Minecraft.getMinecraft();
	  if (event.type != RenderGameOverlayEvent.ElementType.CROSSHAIRS || (event.isCancelable()))
		  return;
	  if (mc.currentScreen != null)
		  return;
	  	if ((Crumbs.HUD) && (ExplosionLocation.time != null)) {
	  		GL11.glPushMatrix();
	  		GL11.glEnable(3042);
	  		GlStateManager.scale(1.5, 1.5, 1.5);	
	  		String textX = "X: " + (int)ExplosionLocation.pX;
	  		String textY = "Y: " + (int)Math.ceil(ExplosionLocation.pY);
	  		String textZ = "Z: " + (int)ExplosionLocation.pZ;
	  		mc.fontRendererObj.drawString("Last Shot:", Coords.coordsX, Coords.coordsY, 16733268);
	  		if (Crumbs.YEnabled)
	  		mc.fontRendererObj.drawString(textY, Coords.coordsX, Coords.coordsY + 10, 16777215);
	  		if (Crumbs.XEnabled)
	  		mc.fontRendererObj.drawString(textX, Coords.coordsX, Coords.coordsY + 20, 16777215);
	  		if (Crumbs.ZEnabled && Crumbs.XEnabled)
	  		mc.fontRendererObj.drawString(textZ, Coords.coordsX, Coords.coordsY + 30, 16777215);
	  		if (Crumbs.ZEnabled && !Crumbs.XEnabled)
	  		mc.fontRendererObj.drawString(textZ, Coords.coordsX, Coords.coordsY + 20, 16777215);
	  		GlStateManager.scale(0,0,0);
	  		GL11.glDisable(3042);
	  		GL11.glPopMatrix();
	  	}
  }
}
  
 
