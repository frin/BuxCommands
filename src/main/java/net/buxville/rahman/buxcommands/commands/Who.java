package net.buxville.rahman.buxcommands.commands;

import java.util.ArrayList;
import java.util.List;

import net.buxville.rahman.buxcommands.BuxCommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Who {
	static List<Player> playerhide = new ArrayList<Player>();
	public static void WhoCommand(Player p) {
		//Who code block
		Player[] players = Bukkit.getServer().getOnlinePlayers();
	    StringBuilder sb = new StringBuilder();
	    sb.append(ChatColor.DARK_GREEN).append("Players Online (").append(players.length).append("): ");
	    for (Player player : players) {
	    	String prefix = BuxCommands.getChat().getPlayerPrefix(player);
	    	String suffix = BuxCommands.getChat().getPlayerSuffix(player);
	    	sb.append(prefix).append(player.getName()).append(suffix);
	    	sb.append(", ");
	    }
	    sb.delete(sb.length() - 2, sb.length());
	    p.sendMessage(sb.toString());
	    return;
		    
	}
	
	private static void WhoHide(Player p) {
		if (playerhide.contains(p)) {
			playerhide.remove(p);
			p.sendMessage(ChatColor.GREEN + "Now visible to who!");
			return;
		}
		if (!playerhide.contains(p)){
			playerhide.add(p);
			p.sendMessage(ChatColor.GREEN + "Now invisivle to who!");
		return;
		} else {
			p.sendMessage(ChatColor.RED + "Error.");
			return;
		}
	}
}
