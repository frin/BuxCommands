package net.buxville.rahman.buxcommands;

import org.bukkit.command.Command;

import net.buxville.rahman.buxcommands.commands.GlobalRoll;
import net.buxville.rahman.buxcommands.commands.Hat;
import net.buxville.rahman.buxcommands.commands.Who;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BuxCommandsExecutor implements CommandExecutor {
	public BuxCommandsExecutor(BuxCommands plugin) {
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		//Alcmene
		if(cmd.getName().equalsIgnoreCase("alcmene")) {
			if (sender instanceof Player) {
				p.sendMessage("Butter my butt and call me a biscuit.");
				return false;
			} else {
				sender.sendMessage("You do not have permissions to do this!");
				return false;
			}
		}
		//Gala
		if((cmd.getName().equalsIgnoreCase("galateyah"))) {
			if (sender instanceof Player) {
				p.sendMessage("Ta.");
				return false;
			} else {
				sender.sendMessage("You do not have permissions to do this!");
				return false;
			}
		}
		//Global Roll
		if((cmd.getName().equalsIgnoreCase("groll"))) {
			if ((sender instanceof Player) && (p.hasPermission("buxcommands.groll"))) {
				GlobalRoll.GRollCommand(p, args);
				return false;
			} else {
				sender.sendMessage("You do not have permissions to do this!");
				return false;
			}
		}
		//Hat Command
		if((cmd.getName().equalsIgnoreCase("hat"))) {
			if ((sender instanceof Player) && (p.hasPermission("buxcommands.hat"))) {
				Hat.HatCommand(p);
				return false;
			} else {
				sender.sendMessage("You do not have permissions to do this!");
				return false;
			}
		}
		//Mumnut
		if((cmd.getName().equalsIgnoreCase("mumnut"))) {
			if (sender instanceof Player) {
				p.sendMessage("Praise the Messiah.");
				return false;
			} else {
				sender.sendMessage("You do not have permissions to do this!");
				return false;
			}
		}
		//Rahman
		if((cmd.getName().equalsIgnoreCase("rahman"))) {
			if (sender instanceof Player) {
				p.sendMessage("My body is ready.");
				return false;
			} else {
				sender.sendMessage("You do not have permissions to do this!");
				return false;
			}
		}
		//Raven
		if((cmd.getName().equalsIgnoreCase("raven")) && (p.hasPermission("buxcommands.raven"))) {
			if (sender instanceof Player) {
				p.sendMessage("In Serbia, I would kill you with my bare hands.");
				return false;
			} else {
				sender.sendMessage("You do not have permissions to do this!");
				return false;
			}
		}
		//tnkl
		if(cmd.getName().equalsIgnoreCase("tnkl")) {
			if (sender instanceof Player) {
				p.sendMessage("I live on a healthy diet of 3 maple syrups a day. Poutine > Putin.");
				return false;
			} else {
				sender.sendMessage("You do not have permissions to do this!");
				return false;
			}
		}
		//Who Command
		if((cmd.getName().equalsIgnoreCase("who"))) {
			if (sender instanceof Player) {
				Who.WhoCommand(p);
				return false;
			} else {
				sender.sendMessage("You do not have permissions to do this!");
				return false;
			}
		}
		return false;
	}

}
