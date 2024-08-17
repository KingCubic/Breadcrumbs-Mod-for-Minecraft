package com.KingCubic.Crumbs;

import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;

public class ChatModifiers {
  private static String[] codes = new String[] { 
      EnumChatFormatting.BLACK
      .toString(), EnumChatFormatting.DARK_BLUE
      .toString(), EnumChatFormatting.DARK_GREEN
      .toString(), EnumChatFormatting.DARK_AQUA
      .toString(), EnumChatFormatting.DARK_RED
      .toString(), EnumChatFormatting.DARK_PURPLE
      .toString(), EnumChatFormatting.GOLD
      .toString(), EnumChatFormatting.GRAY
      .toString(), EnumChatFormatting.DARK_GRAY
      .toString(), EnumChatFormatting.BLUE
      .toString(), 
      EnumChatFormatting.GREEN
      .toString(), EnumChatFormatting.AQUA
      .toString(), EnumChatFormatting.RED
      .toString(), EnumChatFormatting.LIGHT_PURPLE
      .toString(), EnumChatFormatting.YELLOW
      .toString(), EnumChatFormatting.WHITE
      .toString(), EnumChatFormatting.BOLD
      .toString(), EnumChatFormatting.ITALIC
      .toString(), EnumChatFormatting.OBFUSCATED
      .toString(), EnumChatFormatting.RESET
      .toString(), 
      EnumChatFormatting.UNDERLINE
      .toString(), EnumChatFormatting.STRIKETHROUGH
      .toString() };
  
  public static void sendMessage(ICommandSender target, String msg) {
    target.addChatMessage((IChatComponent)new ChatComponentText(ColourCode(msg)));
  }
  
  public static String ColourCode(String string) {
    return string
      .replaceAll("&0", codes[0])
      .replaceAll("&1", codes[1])
      .replaceAll("&2", codes[2])
      .replaceAll("&3", codes[3])
      .replaceAll("&4", codes[4])
      .replaceAll("&5", codes[5])
      .replaceAll("&6", codes[6])
      .replaceAll("&7", codes[7])
      .replaceAll("&8", codes[8])
      .replaceAll("&9", codes[9])
      .replaceAll("&a", codes[10])
      .replaceAll("&b", codes[11])
      .replaceAll("&c", codes[12])
      .replaceAll("&d", codes[13])
      .replaceAll("&e", codes[14])
      .replaceAll("&f", codes[15])
      .replaceAll("&l", codes[16])
      .replaceAll("&o", codes[17])
      .replaceAll("&k", codes[18])
      .replaceAll("&r", codes[19])
      .replaceAll("&n", codes[20])
      .replaceAll("&m", codes[21]);
  }
}