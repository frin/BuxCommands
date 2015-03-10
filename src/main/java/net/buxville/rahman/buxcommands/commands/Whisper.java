package net.buxville.rahman.buxcommands.commands;

import net.buxville.rahman.buxcommands.BuxCommands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandException;
import org.bukkit.entity.Player;

public class Whisper {
	public static void WhisperCommand(Player p, BuxCommands plugin, String[] args, String label) {
		// Whisper code block
		System.out.println("doing my own whisper!");
		if ((args.length < 2) || (args[0].equals(""))) {
			p.sendMessage(ChatColor.RED + "/" + label + " <target> <message>");
			return;
		}
		try {
			Player receiver = plugin.matchSinglePlayer(args[0]);
			if ((receiver == null) || (!receiver.isOnline())) {
				throw new CommandException("Player not found.");
			}
			plugin.messagePlayer(p, receiver, plugin.joinArgs(args, " ", 1));
		}
		catch (CommandException e) {
			p.sendMessage(ChatColor.RED + e.getMessage());
		}
		return;
	}
}
