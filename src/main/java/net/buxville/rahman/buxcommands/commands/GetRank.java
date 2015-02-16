package net.buxville.rahman.buxcommands.commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.buxville.rahman.buxcommands.BuxCommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public class GetRank {

	@SuppressWarnings("deprecation")
	public static void GRCommand(Player p, String[] args, BuxCommands plugin) {
		Player targetPlayer = null;
		String targetPlayerName;
		if (args.length == 0) {
			targetPlayer = p;
			String[] groups = BuxCommands.getPerms().getPlayerGroups(null,
					targetPlayer);
			targetPlayerName = targetPlayer.getName();
			PermGroups(p, targetPlayerName, groups, plugin);
			return;
		} else {
			OfflinePlayer OfflinetargetPlayer = Bukkit.getServer().getPlayer(
					args[0]);
			if (OfflinetargetPlayer == null) {
				OfflinetargetPlayer = Bukkit.getServer().getOfflinePlayer(
						args[0]);
				if (OfflinetargetPlayer == null
						|| !OfflinetargetPlayer.hasPlayedBefore()) {
					p.sendMessage(ChatColor.RED + "Unknown Player: " + args[0]);
					return;
				}
			}
			String[] groups = BuxCommands.getPerms().getPlayerGroups(null,
					OfflinetargetPlayer);
			targetPlayerName = OfflinetargetPlayer.getName();
			PermGroups(p, targetPlayerName, groups, plugin);
			return;
		}
	}

	private static void PermGroups(Player p, String targetPlayerName,
			String[] groups, BuxCommands plugin) {
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

		StringBuilder sb = new StringBuilder();
		sb.append(ChatColor.GREEN + targetPlayerName + "'s ranks are: ");
		List<String> groupandcolor = plugin.getConfig().getStringList(
				"groupandcolor");
		HashMap<String, String> rankcolors = new HashMap<String, String>();
		for (String thisgroup : groupandcolor) {
			String[] splitgroup = thisgroup.split(":");
			rankcolors.put(splitgroup[0], splitgroup[1]);
		}
		for (String indigroup : playergroups) {
			if (rankcolors.containsKey(indigroup)) {
				if (rankcolors.get(indigroup).contains(",")) {
					String[] splits = rankcolors.get(indigroup).split(",");
					StringBuilder sb2 = new StringBuilder();
					for (String split : splits) {
						ChatColor chatcolor = ChatColor.valueOf(split);
						sb2.append(chatcolor.toString());
					}
					String str = (sb2.toString() + indigroup + ChatColor.WHITE + ", ");
					sb.append(str);
				} else {
					ChatColor chatcolor = ChatColor.valueOf(rankcolors
							.get(indigroup));
					String str = (chatcolor + indigroup + ChatColor.WHITE + ", ");
					sb.append(str);
				}
			} else {
				String str = (ChatColor.WHITE + indigroup + ChatColor.WHITE + ", ");
				sb.append(str);
			}
		}
		String pmessage = sb.toString();
		String finalmessage = pmessage.substring(0, pmessage.length() - 2);
		p.sendMessage(finalmessage);
		return;
	}
}