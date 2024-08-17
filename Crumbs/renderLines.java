package com.KingCubic.Crumbs;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;

public class renderLines {

	public void render(EntityPlayerSP player, Long init, float pT) {
			double cX = player.prevPosX + (player.posX - player.prevPosX) * pT;
			double cY = player.prevPosY + (player.posY - player.prevPosY) * pT;
			double cZ = player.prevPosZ + (player.posZ - player.prevPosZ) * pT;
			int render = Minecraft.getMinecraft().gameSettings.renderDistanceChunks;
			int radius = render * 16;
			 if((init + Crumbs.lifeSpan.longValue() > System.currentTimeMillis()) && Crumbs.ZEnabled) {
				 GL11.glPushMatrix();
				    GL11.glDisable(3553);
				    GL11.glEnable(2848);
				    GL11.glBlendFunc(770, 771);
				    GL11.glEnable(3042);
				    GL11.glDisable(2929);
				    GL11.glLineWidth(Crumbs.size);
				    GL11.glTranslated(-cX, -cY, -cZ);
				    GL11.glColor4d(Crumbs.red, Crumbs.green, Crumbs.blue, 1.0D);
				    GL11.glBegin(3);
				    GL11.glVertex3d((double) ExplosionLocation.pX + radius, (double) ExplosionLocation.pY, (double) ExplosionLocation.pZ);
				    GL11.glVertex3d((double) ExplosionLocation.pX - radius, (double) ExplosionLocation.pY, (double) ExplosionLocation.pZ);
				    GL11.glEnd();
				    GL11.glDisable(3042);
				    GL11.glTranslated(0.0D, 0.0D, 0.0D);
				    GL11.glDisable(2848);
				    GL11.glEnable(2929);
				    GL11.glEnable(3553);
				    GL11.glPopMatrix();
			 }
			 if((init + Crumbs.lifeSpan.longValue() > System.currentTimeMillis()) && Crumbs.XEnabled) {
				 GL11.glPushMatrix();
				    GL11.glDisable(3553);
				    GL11.glEnable(2848);
				    GL11.glBlendFunc(770, 771);
				    GL11.glEnable(3042);
				    GL11.glDisable(2929);
				    GL11.glLineWidth(Crumbs.size);
				    GL11.glTranslated(-cX, -cY, -cZ);
				    GL11.glColor4d(Crumbs.red, Crumbs.green, Crumbs.blue, 1.0D);
				    GL11.glBegin(3);
				    GL11.glVertex3d((double) ExplosionLocation.pX, (double) ExplosionLocation.pY, (double) ExplosionLocation.pZ + radius);
				    GL11.glVertex3d((double) ExplosionLocation.pX, (double) ExplosionLocation.pY, (double) ExplosionLocation.pZ - radius);
				    GL11.glEnd();
				    GL11.glDisable(3042);
				    GL11.glTranslated(0.0D, 0.0D, 0.0D);
				    GL11.glDisable(2848);
				    GL11.glEnable(2929);
				    GL11.glEnable(3553);
				    GL11.glPopMatrix();
			 }
	}
	
}
