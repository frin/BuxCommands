package net.buxville.rahman.buxcommands;

import java.util.logging.Level;
import java.util.logging.Logger;

import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.permission.Permission;

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
	public void onEnable() {
		if (!setupChat()) {
		      log(Level.WARNING, "Warn - No Chat Plugin");
		 }
		if (!setupPermissions()) {
		      log(Level.SEVERE, "Disabled - No Permissions Plugin");
		      getServer().getPluginManager().disablePlugin(this);
		}
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
	}
	
	public boolean setupChat() {
	    RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
	    BuxCommands.setChat(((Chat)rsp.getProvider()));
	    return BuxCommands.getChat() != null;
	}
	
	private boolean setupPermissions() {
	    RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
	    BuxCommands.perms = ((Permission)rsp.getProvider());
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


}