package com.KingCubic.Crumbs;

import net.minecraft.entity.Entity;
import net.minecraft.util.Vec3;
import net.minecraftforge.event.world.ExplosionEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ExplosionLocation {
	public static float pX;
	public static float pY;
	public static float pZ;
	public static Long time;
	public ExplosionLocation() {
	}
	
	public static float getExpX() {
		return pX;
	}
	public static float getExpY() {
		return pY;
	}
	public static float getExpZ() {
		return pZ;
	}
	public static Long getTime() {
		return time;
	}
	public static void setExpX(float x) {
		pX = x;
	}
	public static void setExpY(float y) {
		pY = y;
	}
	public static void setExpZ(float z) {
		pZ = z;
	}
	public static void setTime(Long t) {
		time = t;
	}
}
