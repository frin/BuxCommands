package net.buxville.rahman.buxcommands.commands;

import net.buxville.rahman.buxcommands.BuxCommands;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Who {
	public static boolean WhoCommand(Player p) {
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
	    return true;
		    
}
}
