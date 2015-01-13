package net.buxville.rahman.buxcommands.commands;

import java.security.SecureRandom;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class GlobalRoll {
	public static void GRollCommand(Player p, String[] args) {
		if (args.length != 2) {
		      p.sendMessage(ChatColor.RED + "Usage: /groll  <min> <max>");
		      return;
		    }
			final SecureRandom randomNumberGenerator = new SecureRandom();
		    int min = 0;
		    int max = 0;
		    try {
		      min = Integer.parseInt(args[0]);
		      max = Integer.parseInt(args[1]);
		    } catch (NumberFormatException localNumberFormatException) {
		    }
		    if (min >= max) {
		      p.sendMessage(ChatColor.RED + "Usage: /groll <min> <max>");
		      return;
		    }

		    int roll = randomNumberGenerator.nextInt(max - min + 1) + min;
		   Bukkit.broadcastMessage(
		      ChatColor.WHITE + "[" + ChatColor.GOLD + "Roll" + ChatColor.WHITE + "]" + ChatColor.GOLD + " The server rolled a " + ChatColor.WHITE + roll + 
		      ChatColor.YELLOW + " (" + min + "-" + max + ")" + ChatColor.GOLD + ".");

		    return;
		}
}



