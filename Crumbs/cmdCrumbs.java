package com.KingCubic.Crumbs;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;

public class cmdCrumbs extends CommandBase {
	public void processCommand(ICommandSender sender, String[] args) throws CommandException {
		if (args.length < 1) {
		     ChatModifiers.sendMessage(sender, "\n                 &cCrumbs Usage\n");
		     ChatModifiers.sendMessage(sender, "");
		     ChatModifiers.sendMessage(sender, " &8&l* &r&f/crumbs lifespan (time) &8- &fHow long a crumb line lasts.");
		     ChatModifiers.sendMessage(sender, " &8&l* &r&f/crumbs size (size) &8- &fChange the crumb size. (1-20)");
		     ChatModifiers.sendMessage(sender, " &8&l* &r&f/crumbs on (or off) &8- &f Toggle all crumbs on/off.");
		     ChatModifiers.sendMessage(sender, " &8&l* &r&f/crumbs toggle (ns, ew, y) &8- &fToggle certain crumbs.");
		     ChatModifiers.sendMessage(sender, " &8&l* &r&f  (North/South, East/West, Y coords in chat.)");
		     ChatModifiers.sendMessage(sender, " &8&l* &r&f/crumbs color (color) Available colors: ");
		     ChatModifiers.sendMessage(sender, " &8&l* &r&cRed, &6Orange, &aGreen, &eYellow, &dPurple, &fWhite.");
		     ChatModifiers.sendMessage(sender, " &8&l* &r&fFor help on setting up the HUD /crumbs hud help.");
		     ChatModifiers.sendMessage(sender, " &8&l* &r&fTo disable chat messages alone: /crumbs chat");
		     return;
		}
		if (args[0].toLowerCase().equals("lifespan")) {
			Long lifespan = null;
			try {
				lifespan = Long.valueOf(Integer.parseInt(args[1]) * (1000L));
			} catch (Exception exception) {}
			Crumbs.lifeSpan = lifespan;
			ChatModifiers.sendMessage(sender, "&fYour crumbs will now be active for " + lifespan / 1000 + " &fseconds.");	
		}
		if (args[0].toLowerCase().equals("toggle")) {
			String a = null;
			try {
				a = args[1].toLowerCase();
			} catch (Exception exception) {}
			if (a.equals("ns")) {
				Crumbs.XEnabled = Boolean.valueOf(!Crumbs.XEnabled);
				if (Boolean.valueOf(Crumbs.XEnabled)) {
					ChatModifiers.sendMessage(sender, "&fYour n/s coords and lines are now enabled.");
				} else {
					ChatModifiers.sendMessage(sender, "&fYour n/s coords and lines are now disabled.");
				}
			}
			if (a.equals("y")) {
				Crumbs.YEnabled = Boolean.valueOf(!Crumbs.YEnabled);
				if (Boolean.valueOf(Crumbs.YEnabled)) {
					ChatModifiers.sendMessage(sender, "&fYour y coords are now enabled.");
				} else {
					ChatModifiers.sendMessage(sender, "&fYour y coords are now disabled.");
				}
			}
			if (a.equals("ew")) {
				Crumbs.ZEnabled = Boolean.valueOf(!Crumbs.ZEnabled);
				if (Boolean.valueOf(Crumbs.ZEnabled)) {
					ChatModifiers.sendMessage(sender, "&fYour e/w coords and lines are now enabled.");
				} else {
					ChatModifiers.sendMessage(sender, "&fYour e/w coords and lines are now disabled.");
				}
			}
		}
		if (args[0].toLowerCase().equals("size")) {
			Long preSize = null;
			try {
				preSize = Long.valueOf(Integer.parseInt(args[1]));
			} catch (Exception exception) {}
			Crumbs.size = preSize;
			ChatModifiers.sendMessage(sender, "&fYour crumb size is set to " + preSize + ".");	
		}
		if (args[0].toLowerCase().equals("color")) {
			String a = null;
			try {
				a = args[1];
			} catch (Exception exception) {}
			if (a.equals("red")) {
				Crumbs.red = 0.89D;
				Crumbs.green = 0.05D;
				Crumbs.blue = 0.01D;
				ChatModifiers.sendMessage(sender, "&cYour crumbs are now red!");
			}
			if (a.equals("orange")) {
				Crumbs.red = 1.0D;
				Crumbs.green = 0.60D;
				Crumbs.blue = 0.01D;
				ChatModifiers.sendMessage(sender, "&6Your crumbs are now orange!");
			}
			if (a.equals("green")) {
				Crumbs.red = 0.01D;
				Crumbs.green = 0.89D;
				Crumbs.blue = 0.01D;
				ChatModifiers.sendMessage(sender, "&aYour crumbs are now green!");
			}
			if (a.equals("yellow")) {
				Crumbs.red = 0.89D;
				Crumbs.green = 0.89D;
				Crumbs.blue = 0.01D;
				ChatModifiers.sendMessage(sender, "&eYour crumbs are now yellow!");
			}
			if (a.equals("purple")) {
				Crumbs.red = 0.69D;
				Crumbs.green = 0.61D;
				Crumbs.blue = 0.85D;
				ChatModifiers.sendMessage(sender, "&dYour crumbs are now purple!");
			}
			if (a.equals("white")) {
				Crumbs.red = 0.95D;
				Crumbs.green = 0.95D;
				Crumbs.blue = 1.0D;
				ChatModifiers.sendMessage(sender, "&fYour crumbs are now white!");
			}
		}
		if (args[0].toLowerCase().equals("on")) {
			Crumbs.XEnabled = true;
			Crumbs.ZEnabled = true;
			Crumbs.YEnabled = true;
			ChatModifiers.sendMessage(sender, "&fAll of your crumbs are on!");
		}
		if (args[0].toLowerCase().equals("off")) {
			Crumbs.XEnabled = false;
			Crumbs.ZEnabled = false;
			Crumbs.YEnabled = false;
			ChatModifiers.sendMessage(sender, "&fAll of your crumbs are off!");
		}
		if (args[0].toLowerCase().equals("hud")) {
			if (args[1].toLowerCase().equals("help")) {
				ChatModifiers.sendMessage(sender, " &8&l           &cHUD Help");
				ChatModifiers.sendMessage(sender, "");
				ChatModifiers.sendMessage(sender, " &8&l* &r&fTo move the HUD, type /crumbs hud move x (num)");
				ChatModifiers.sendMessage(sender, " &8&l* &r&fOr /crumbs hud move y (num)");
				ChatModifiers.sendMessage(sender, " &8&l* &r&fDefault num is 0,0. Increasing these moves");
				ChatModifiers.sendMessage(sender, " &8&l* &r&fit further away from the top left corner.");
				ChatModifiers.sendMessage(sender, " &8&l* &r&fOnce you get the position you want,");
				ChatModifiers.sendMessage(sender, " &8&l* &r&fthe mod will save its position permanently,");
				ChatModifiers.sendMessage(sender, " &8&l* &r&fso you only have to do this once.");
				ChatModifiers.sendMessage(sender, " &8&l* &r&f/crumbs hud (on/off) to toggle the HUD.");
				ChatModifiers.sendMessage(sender, "");
				ChatModifiers.sendMessage(sender, " &8&l* &r&fIf you are confused, try (/crumbs hud move x 10)");
			}
			if (args[1].toLowerCase().equals("move")) {
				if (args[2].toLowerCase().equals("x")) {
					int x = 0;
					try {
						x = Integer.parseInt(args[3]) * 10;
					} catch (Exception exception) {}	
					Coords.coordsX = x;
					Coords.saveSettings();
				}
				if (args[2].toLowerCase().equals("y")) {
					int y = 0;
					try {
						y = Integer.parseInt(args[3]) * 10;
					} catch (Exception exception) {}	
					Coords.coordsY = y;
					Coords.saveSettings();
				}	
			}
			if (args[1].toLowerCase().equals("on")) {
				Coords.loadSettings();
				Crumbs.HUD = true;
				ChatModifiers.sendMessage(sender, "&fYour HUD is on.");
			}
			if (args[1].toLowerCase().equals("off")) {
				Crumbs.HUD = false;
				ChatModifiers.sendMessage(sender, "&fYour HUD is off.");
			}
		}
	}
	
	@Override
	public String getCommandName() {
		return "crumbs";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		return "";
	}
	
	 @Override
	    public boolean canCommandSenderUseCommand(ICommandSender sender) {
	    	return true;
	    } 
	
}