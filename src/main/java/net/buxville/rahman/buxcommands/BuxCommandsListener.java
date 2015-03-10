package net.buxville.rahman.buxcommands;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class BuxCommandsListener implements Listener {
	private BuxCommands plugin;

	public BuxCommandsListener(BuxCommands plugin) {
		this.plugin = plugin;
	}

	@EventHandler(priority=EventPriority.MONITOR)
	public void onPlayerQuit(PlayerQuitEvent event) {
		this.plugin.replyTarget.remove(event.getPlayer());
	    while (this.plugin.replyTarget.values().remove(event.getPlayer()));
	}
}
