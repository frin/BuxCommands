package net.buxville.rahman.buxcommands.commands;

import net.buxville.rahman.buxcommands.BuxCommands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ForceChannel {
	public static void ForceChannelCommand(Player p, BuxCommands plugin, String[] args, String label) {
		// Force Channel code block
		if (args.length != 2) {
			p.sendMessage(ChatColor.RED + "Usage: /" + label + " <player> <channel>");
			return;
		}

		@SuppressWarnings("deprecation")
		Player targetPlayer = plugin.getServer().getPlayerExact(args[0]);
		if ((targetPlayer == null) || (!targetPlayer.isOnline())) {
			p.sendMessage(ChatColor.RED + "Player does not exist.");
			return;
		}

		targetPlayer.performCommand("ch " + args[1]);

		p.sendMessage(ChatColor.GREEN + targetPlayer.getName() + " has been forced in to channel " + ChatColor.WHITE + args[1] + ChatColor.GREEN + ".");
		targetPlayer.sendMessage(ChatColor.DARK_RED + "You have been forced in to channel " + ChatColor.WHITE + args[1] + ChatColor.DARK_RED + " by " + 
				ChatColor.WHITE + p.getName() + ChatColor.DARK_RED + ".");
		return;
	}
}
