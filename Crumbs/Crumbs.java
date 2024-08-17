package com.KingCubic.Crumbs;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import net.minecraft.client.Minecraft;
import net.minecraft.command.ICommand;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
@Mod(modid = "KingCubicCrumbs", version = "1.3", acceptedMinecraftVersions = "[1.8.9]")
public class Crumbs
{
    public static final String MODID = "KingCubicCrumbs";
    public static final String VERSION = "1.3";
	public static final String MODNAME = "KingCubic's Crumbs";
	public static boolean XEnabled = Boolean.valueOf(false);
	public static boolean ZEnabled = Boolean.valueOf(false);
	public static boolean YEnabled = Boolean.valueOf(false);
	public static Long lifeSpan = 4000L;
	public static renderLines renderer = new renderLines();
	public static Long lightningTime = 0L;
	public static float size = 5.0f;
	public static double red = 0.89D;
	public static double blue = 0.05D;
	public static double green = 0.01D;
	public static boolean HUD = Boolean.valueOf(false);
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	ClientCommandHandler.instance.registerCommand((ICommand)new cmdCrumbs());
        MinecraftForge.EVENT_BUS.register(new eventTick());
    }
}

