package com.KingCubic.Crumbs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import net.minecraft.client.Minecraft;

public class Coords {
public static int coordsX;
public static int coordsY;

public Coords() {
	coordsX = 0;
	coordsY = 0;
}

public static void saveSettings() {
    File settings = new File((Minecraft.getMinecraft()).mcDataDir, "coordsmod.settings");
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter(settings));
      writer.write(coordsX + ":" + coordsY);
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    } 
  }
public static void loadSettings() {
    File settings = new File((Minecraft.getMinecraft()).mcDataDir, "coordsmod.settings");
    if (!settings.exists())
      return; 
    try {
      BufferedReader reader = new BufferedReader(new FileReader(settings));
      String[] options = reader.readLine().split(":");
      Coords.coordsX = Integer.valueOf(options[0]).intValue();
      Coords.coordsY = Integer.valueOf(options[1]).intValue();
      reader.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e2) {
      e2.printStackTrace();
    } 
}

}