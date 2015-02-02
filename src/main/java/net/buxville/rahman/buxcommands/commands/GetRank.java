package net.buxville.rahman.buxcommands.commands;

import java.util.ArrayList;
import java.util.List;

import net.buxville.rahman.buxcommands.BuxCommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public class GetRank {

	@SuppressWarnings("deprecation")
	public static void GRCommand(Player p, String[] args) {
		Player targetPlayer = null;
	    String targetPlayerName;
		if (args.length == 0) {
	      targetPlayer = p;
	      String[] groups = BuxCommands.getPerms().getPlayerGroups(null, targetPlayer);
	      targetPlayerName = targetPlayer.getName();
	      PermGroups(p,targetPlayerName,groups);
	      return;
	    } else {
	      OfflinePlayer OfflinetargetPlayer = Bukkit.getServer().getPlayer(args[0]);
	      if (OfflinetargetPlayer == null) {
	    	  OfflinetargetPlayer = Bukkit.getServer().getOfflinePlayer(args[0]);
	    	  if (OfflinetargetPlayer == null || !OfflinetargetPlayer.hasPlayedBefore()) {
		          p.sendMessage(ChatColor.RED + "Unknown Player: " + args[0]);
		          return;
	    	  }
	      }
	      String[] groups = BuxCommands.getPerms().getPlayerGroups(null, OfflinetargetPlayer);
	      targetPlayerName = OfflinetargetPlayer.getName();
	      PermGroups(p,targetPlayerName,groups);
	      return;
	    }
	}
	
	private static void PermGroups(Player p, String targetPlayerName, String[] groups) {
		List<String> playergroups = new ArrayList<String>();
		for (String group : groups) {
			String[] splitGroup = group.split("-");
			if (splitGroup.length > 1) {
				playergroups.add(splitGroup[0] + " Level " + splitGroup[1]);
			} else {
				playergroups.add(group);
			}
		}
		if (playergroups.isEmpty()) {
		      playergroups.add("Peasant");
		      }
		p.sendMessage(String.format(ChatColor.GREEN + "%s%s: %s", new Object[] { targetPlayerName + "'s ranks are", ChatColor.GREEN, join(playergroups, ", ")}));
	    return;
	}
	private static String join(List<String> elems, String delimiter) {
	    StringBuilder sb = new StringBuilder();
	    if ((elems == null) || (elems.isEmpty())) {
	      return "";
	    }

	    for (String str : elems) {
	      if (sb.length() > 0) {
	        sb.append(delimiter);
	      }
	      sb.append(str);
	    }
	    return sb.toString();
	  }
}