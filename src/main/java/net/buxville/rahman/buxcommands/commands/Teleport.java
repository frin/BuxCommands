package net.buxville.rahman.buxcommands.commands;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Teleport {
	public static HashMap<UUID, UUID> tprequests = new HashMap<UUID, UUID>();
	//get map
	public static HashMap<UUID, UUID> getTPReq() {
		return tprequests;
	}
	
	//set map
	public static void setTpReq(HashMap<UUID,UUID> tprequests) {
		Teleport.tprequests = tprequests;
	}
	//TPChere commands
	public static void TPChere(Player p, String[] args) {
		if (args.length == 0) {
			p.sendMessage(ChatColor.RED + "To use this command correctly, use /tpchere [player].");
		}
		if (args.length == 1) {
	          @SuppressWarnings("deprecation")
			List<Player> ts = Bukkit.getServer().matchPlayer(args[0]);
	          if (ts.size() > 0) {
	            Player tg = (Player)ts.get(0);
	            if ((tg != null) && (p.isOnline()) && (!tg.equals(p))) {
	              tg.sendMessage(ChatColor.WHITE + p.getName() + ChatColor.DARK_GREEN + 
	                " would like to teleport you to their current location. Type " + ChatColor.YELLOW + "/acc" + ChatColor.DARK_GREEN + 
	                " or " + ChatColor.YELLOW + "/den" + ChatColor.DARK_GREEN + ".");
	              p.sendMessage(ChatColor.DARK_GREEN + "You have sent a teleport request to " + ChatColor.WHITE + tg.getName() + ChatColor.DARK_GREEN + 
	                ".");
	              getTPReq().put(tg.getUniqueId(), p.getUniqueId());
	            } else {
	              p.sendMessage(ChatColor.RED + "Invalid player.");
	            }
	          } else {
	            p.sendMessage(ChatColor.RED + "Invalid player.");
	          }
	          return;
	        }
	}
	//TPAll command
	public static void TPACommand(Player p) {
		Player[] onlinePlayers = Bukkit.getOnlinePlayers();
		int tpRequestsSent = 0;
        for (Player targetPlayer : onlinePlayers) {
          if ((targetPlayer == null) || (!targetPlayer.isOnline())) {
            continue;
          }
          targetPlayer.sendMessage(ChatColor.WHITE + p.getName() + ChatColor.DARK_GREEN + 
                  " would like to teleport you to their current location. Type " + ChatColor.YELLOW + "/acc" + ChatColor.DARK_GREEN + " or " + 
                  ChatColor.YELLOW + "/den" + ChatColor.DARK_GREEN + ".");
                tpRequestsSent++;
                getTPReq().put(targetPlayer.getUniqueId(), p.getUniqueId());
              }
        p.sendMessage(ChatColor.DARK_GREEN + "You have sent a teleport request to " + ChatColor.WHITE + tpRequestsSent + ChatColor.DARK_GREEN + 
                " player(s).");
        return;
	}

	//Accept Command
	public static void Acc(Player p) {
		UUID ts = (UUID) getTPReq().get(p.getUniqueId());
        if (ts != null) {
          Player tg = Bukkit.getPlayer(ts);
          if ((tg != null) && (tg.isOnline())) {
            p.teleport(tg.getLocation());
            p.sendMessage(ChatColor.DARK_GREEN + "You have accepted " + ChatColor.WHITE + tg.getName() + ChatColor.DARK_GREEN + 
              "'s teleport request.");
            tg.sendMessage(ChatColor.WHITE + p.getName() + ChatColor.DARK_GREEN + " has accepted your teleport request.");
            getTPReq().remove(p.getUniqueId());
          }
          else {
            p.sendMessage("Player is no longer online.");
            getTPReq().remove(p.getUniqueId());
          }
          return;
        }
	}
	
	//Decline Command
	public static void Den(Player p) {
		UUID ts = (UUID)getTPReq().get(p.getUniqueId());
        if (ts != null) {
          p.sendMessage(ChatColor.DARK_GREEN + "You have denied the players teleport request.");
          Player tg = Bukkit.getPlayer(ts);
          if ((tg != null) && (tg.isOnline())) {
            tg.sendMessage(ChatColor.WHITE + p.getName() + ChatColor.DARK_GREEN + " has denied your teleport request.");
          }
          getTPReq().remove(p.getUniqueId());
          return;
        }
	}
}
