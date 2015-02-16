package net.buxville.rahman.buxcommands.commands;

import net.buxville.rahman.buxcommands.BuxCommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

public class Who {
	public static void WhoCommand(Player p) {
		// Who code block
		Player[] players = Bukkit.getServer().getOnlinePlayers();
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		int i = 0;
		for (Player player : players) {
			if (!player.hasMetadata("playerhide")) {
				String prefix = BuxCommands.getChat().getPlayerPrefix(player);
				String suffix = BuxCommands.getChat().getPlayerSuffix(player);
				sb2.append(prefix).append(player.getName()).append(suffix);
				sb2.append(", ");
				i = i + 1;
			}
		}
		sb.append(ChatColor.DARK_GREEN).append("Players Online (").append(i)
				.append("): ");
		if (sb2.length() > 0) {
			sb2.delete(sb2.length() - 2, sb2.length());
		}
		p.sendMessage(sb.toString() + sb2.toString());
		return;
	}

	public static void WhoHide(Player p, BuxCommands plugin) {
		if (p.hasMetadata("playerhide")) {
			p.removeMetadata("playerhide", plugin);
			p.sendMessage(ChatColor.GRAY + "Visible to /who.");
		} else {
			p.setMetadata("playerhide",
					new FixedMetadataValue(plugin, true));
			p.sendMessage(ChatColor.GRAY + "Invisible to /who.");
		}
	}
}
