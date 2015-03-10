package net.buxville.rahman.buxcommands;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.permission.Permission;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandException;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

/*TODO
 * 
 * GetRank
 * Calculator
 * 
 * */

public class BuxCommands extends JavaPlugin {
	private String logPrefix = "BuxCommands: ";
	public static Chat chat = null;
	public static Permission perms = null;
	private final Logger logger = Logger.getLogger("Minecraft.BuxCommands");
	public Map<Player, Player> replyTarget = new HashMap<Player, Player>();

	public void onEnable() {
		if (!setupChat()) {
			log(Level.WARNING, "Warn - No Chat Plugin");
		}
		if (!setupPermissions()) {
			log(Level.SEVERE, "Disabled - No Permissions Plugin");
			getServer().getPluginManager().disablePlugin(this);
		}
		this.getCommand("w").setExecutor(new BuxCommandsExecutor(this));
		this.getCommand("whisper").setExecutor(new BuxCommandsExecutor(this));
		this.getCommand("r").setExecutor(new BuxCommandsExecutor(this));
		this.getCommand("reply").setExecutor(new BuxCommandsExecutor(this));
		this.getCommand("acc").setExecutor(new BuxCommandsExecutor(this));
		this.getCommand("den").setExecutor(new BuxCommandsExecutor(this));
		this.getCommand("getrank").setExecutor(new BuxCommandsExecutor(this));
		this.getCommand("groll").setExecutor(new BuxCommandsExecutor(this));
		this.getCommand("hat").setExecutor(new BuxCommandsExecutor(this));
		this.getCommand("tpahere").setExecutor(new BuxCommandsExecutor(this));
		this.getCommand("tpchere").setExecutor(new BuxCommandsExecutor(this));
		this.getCommand("tpcto").setExecutor(new BuxCommandsExecutor(this));
		this.getCommand("who").setExecutor(new BuxCommandsExecutor(this));
		this.getCommand("whohide").setExecutor(new BuxCommandsExecutor(this));
		this.getCommand("forcechannel").setExecutor(new BuxCommandsExecutor(this));

		getServer().getPluginManager().registerEvents(new BuxCommandsListener(this), this);

		saveDefaultConfig();
	}

	public boolean setupChat() {
		RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager()
				.getRegistration(Chat.class);
		BuxCommands.setChat(((Chat) rsp.getProvider()));
		return BuxCommands.getChat() != null;
	}

	private boolean setupPermissions() {
		RegisteredServiceProvider<Permission> rsp = getServer()
				.getServicesManager().getRegistration(Permission.class);
		BuxCommands.perms = ((Permission) rsp.getProvider());
		return BuxCommands.getPerms() != null;
	}

	public void log(Level level, String message) {
		this.logger.log(level, this.logPrefix + message);
	}

	public static Chat getChat() {
		return chat;
	}

	public static void setChat(Chat chat) {
		BuxCommands.chat = chat;
	}

	public static Permission getPerms() {
		return perms;
	}

	public static void setPerms(Permission perm) {
		BuxCommands.perms = perm;
	}

	public void onDisable() {
		System.out.println(logPrefix + " shutting down.");
	}
	
	// Whisper method
	
	public String joinArgs(String[] args, String separator, int offset) {
		StringBuilder sb = new StringBuilder();
		for (int i = offset; i < args.length; i++) {
			if (i > offset) {
				sb.append(" ");
			}
			sb.append(args[i]);
		}
		return sb.toString();
	}
	
	public Player matchSinglePlayer(String playerName) throws CommandException	{
		if ((playerName.charAt(0) == '@') && (playerName.length() >= 2)) {
			@SuppressWarnings("deprecation")
			Player player = getServer().getPlayerExact(playerName.substring(1));
			if (player == null) {
				throw new CommandException("Player not found.");
			}
			return player;
		}

		@SuppressWarnings("deprecation")
		List<Player> matchingPlayers = getServer().matchPlayer(playerName);
		if ((matchingPlayers == null) || (matchingPlayers.isEmpty())) {
			throw new CommandException("Player not found.");
		}
		if (matchingPlayers.size() > 1) {
			throw new CommandException("More than one player found! Use @<name> for exact matching.");
		}
		return (Player)matchingPlayers.get(0);
	}
	
	public void messagePlayer(Player sender, Player receiver, String message) {
		receiver.sendMessage(ChatColor.AQUA + "(" + ChatColor.BLUE + "From " + sender.getName() + ChatColor.AQUA + "): " + ChatColor.BLUE + message);
		sender.sendMessage(ChatColor.AQUA + "(" + ChatColor.BLUE + "To " + receiver.getName() + ChatColor.AQUA + "): " + ChatColor.BLUE + message);

		this.replyTarget.put(receiver, sender);
	}

}