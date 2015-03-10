package net.buxville.rahman.buxcommands.commands;

import net.buxville.rahman.buxcommands.BuxCommands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandException;
import org.bukkit.entity.Player;

public class WhisperReply {
	public static void WhisperReplyCommand(Player p, BuxCommands plugin, String[] args, String label) {
		// Whisper code block
		if (args.length < 1) {
			p.sendMessage(ChatColor.RED + "/" + label + " <message>");
			return;
		}
		try {
			Player receiver = plugin.replyTarget.get(p);
			if ((receiver == null) || (!receiver.isOnline())) {
				plugin.replyTarget.remove(p);
				throw new CommandException("Player not found.");
			}
			plugin.messagePlayer(p, receiver, plugin.joinArgs(args, " ", 0));
		}
		catch (CommandException e) {
			p.sendMessage(ChatColor.RED + e.getMessage());
		}
		return;
	}
}
