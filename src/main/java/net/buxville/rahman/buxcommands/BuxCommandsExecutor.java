package net.buxville.rahman.buxcommands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;

import net.buxville.rahman.buxcommands.commands.ForceChannel;
import net.buxville.rahman.buxcommands.commands.GetRank;
import net.buxville.rahman.buxcommands.commands.GlobalRoll;
import net.buxville.rahman.buxcommands.commands.Hat;
import net.buxville.rahman.buxcommands.commands.Teleport;
import net.buxville.rahman.buxcommands.commands.Whisper;
import net.buxville.rahman.buxcommands.commands.WhisperReply;
import net.buxville.rahman.buxcommands.commands.Who;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BuxCommandsExecutor implements CommandExecutor {
	public static String chatPrefix = "[BuxCommands]";
	BuxCommands plugin;

	public BuxCommandsExecutor(BuxCommands instance) {
		plugin = instance;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (!(sender instanceof Player)) {
			System.out.println("You cannot perform this command.");
			return false;
		}
		Player p = (Player) sender;
		System.out.println("received command "+cmd.getName());
		// Tp all players to here Commands
		if ((cmd.getName().equalsIgnoreCase("acc"))) {
			if (p instanceof Player) {
				Teleport.Acc(p);
				return false;
			} else {
				p.sendMessage(chatPrefix + ChatColor.RED
						+ " You do not have permissions to do this!");
				return false;
			}
		}
		// Den Command
		if ((cmd.getName().equalsIgnoreCase("den"))) {
			if (p instanceof Player) {
				Teleport.Den(p);
				return false;
			} else {
				p.sendMessage(chatPrefix + ChatColor.RED
						+ " You do not have permissions to do this!");
				return false;
			}
		}
		// Hat Command
		if ((cmd.getName().equalsIgnoreCase("getrank"))) {
			if (p instanceof Player) {
				GetRank.GRCommand(p, args, plugin);
				return false;
			} else {
				p.sendMessage(chatPrefix + ChatColor.RED
						+ " You do not have permissions to do this!");
				return false;
			}
		}
		// Global Roll
		if ((cmd.getName().equalsIgnoreCase("groll"))) {
			if ((p instanceof Player) && (p.hasPermission("buxcommands.groll"))) {
				GlobalRoll.GRollCommand(p, args);
				return false;
			} else {
				p.sendMessage(chatPrefix + ChatColor.RED
						+ " You do not have permissions to do this!");
				return false;
			}
		}
		// Hat Command
		if ((cmd.getName().equalsIgnoreCase("hat"))) {
			if ((p instanceof Player) && (p.hasPermission("buxcommands.hat"))) {
				Hat.HatCommand(p);
				return false;
			} else {
				p.sendMessage(chatPrefix + ChatColor.RED
						+ " You do not have permissions to do this!");
				return false;
			}
		}
		// Tp all players to here Command
		if ((cmd.getName().equalsIgnoreCase("tpahere"))) {
			if ((p instanceof Player) && (p.hasPermission("buxcommands.tpa"))) {
				Teleport.TPACommand(p);
				return false;
			} else {
				p.sendMessage(chatPrefix + ChatColor.RED
						+ " You do not have permissions to do this!");
				return false;
			}
		}
		// Tp a player to here Command
		if ((cmd.getName().equalsIgnoreCase("tpchere"))) {
			if ((p instanceof Player) && (p.hasPermission("buxcommands.tpc"))) {
				Teleport.TPChere(p, args);
				return false;
			} else {
				p.sendMessage(chatPrefix + ChatColor.RED
						+ " You do not have permissions to do this!");
				return false;
			}
		}
		// Tp to a player Command
		if ((cmd.getName().equalsIgnoreCase("tpcto"))) {
			if ((p instanceof Player) && (p.hasPermission("buxcommands.tpcto"))) {
				Teleport.TPCto(p, args);
				return false;
			} else {
				p.sendMessage(chatPrefix + ChatColor.RED
						+ " You do not have permissions to do this!");
				return false;
			}
		}
		// Who Command
		if ((cmd.getName().equalsIgnoreCase("who"))) {
			if (p instanceof Player) {
				Who.WhoCommand(p);
				return false;
			} else {
				p.sendMessage(chatPrefix + ChatColor.RED
						+ " You do not have permissions to do this!");
				return false;
			}
		}
		// Who Hide Command
		if ((cmd.getName().equalsIgnoreCase("whohide"))) {
			if ((p instanceof Player)
					&& (p.hasPermission("buxcommands.whohide"))) {
				Who.WhoHide(p, plugin);
				return false;
			} else {
				p.sendMessage(chatPrefix + ChatColor.RED
						+ " You do not have permissions to do this!");
				return false;
			}
		}
		// Whisper Command
		if (cmd.getName().equalsIgnoreCase("w") || cmd.getName().equalsIgnoreCase("whisper")) {
			if (p instanceof Player) {
				Whisper.WhisperCommand(p, plugin, args, label);
				return false;
			}
			else {
				p.sendMessage(chatPrefix + ChatColor.RED + " You do not have permissions to do this!");
				return false;
			}
		}
		// Whisper Reply Command
		if (cmd.getName().equalsIgnoreCase("r") || cmd.getName().equalsIgnoreCase("reply")) {
			if (p instanceof Player) {
				WhisperReply.WhisperReplyCommand(p, plugin, args, label);
				return false;
			}
			else {
				p.sendMessage(chatPrefix + ChatColor.RED + " You do not have permissions to do this!");
				return false;
			}
		}
		// Force Channel Command
		if (cmd.getName().equalsIgnoreCase("forcechannel")) {
			if (p instanceof Player && p.hasPermission("buxcommands.forcechannel")) {
				ForceChannel.ForceChannelCommand(p, plugin, args, label);
				return false;
			}
			else {
				p.sendMessage(chatPrefix + ChatColor.RED + "You do not have permissions to do this!");
				return false;
			}
		}
		return false;
	}

}
