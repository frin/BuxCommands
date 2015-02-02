package net.buxville.rahman.buxcommands.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import net.buxville.rahman.buxcommands.BuxCommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerQuitEvent;

public class Who {
	static List<UUID> playerhide = new ArrayList<UUID>();
	public static void WhoCommand(Player p) {
		//Who code block
		Player[] players = Bukkit.getServer().getOnlinePlayers();
	    StringBuilder sb = new StringBuilder();
	    sb.append(ChatColor.DARK_GREEN).append("Players Online (").append(players.length-playerhide.size()).append("): ");
	    for (Player player : players) {
	    	if (!playerhide.contains(player.getUniqueId())){
	    		String prefix = BuxCommands.getChat().getPlayerPrefix(player);
		    	String suffix = BuxCommands.getChat().getPlayerSuffix(player);
		    	sb.append(prefix).append(player.getName()).append(suffix);
		    	sb.append(", ");
	    	}
	    }
	    sb.delete(sb.length() - 2, sb.length());
	    p.sendMessage(sb.toString());
	    return;	    
	}
	
	public static void WhoHide(Player p) {
		if (playerhide.contains(p.getUniqueId())) {
			playerhide.remove(p.getUniqueId());
			p.sendMessage(ChatColor.GREEN + "Now visible to who!");
			return;
		}
		if (!playerhide.contains(p.getUniqueId())){
			playerhide.add(p.getUniqueId());
			p.sendMessage(ChatColor.GREEN + "Now invisivle to who!");
			return;
		} else {
			p.sendMessage(ChatColor.RED + "Error.");
			return;
		}
	}
	
	public void onquit(PlayerQuitEvent e){
		Player p = e.getPlayer();
		if (playerhide.contains(p.getUniqueId())){
			playerhide.remove(p.getUniqueId());
		}
	}
}
