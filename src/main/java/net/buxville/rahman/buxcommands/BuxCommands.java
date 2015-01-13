package net.buxville.rahman.buxcommands;

import java.util.logging.Level;
import java.util.logging.Logger;

import net.milkbowl.vault.chat.Chat;
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
	private final Logger logger = Logger.getLogger("Minecraft.BuxCommands");
	public void onEnable() {
		if (!setupChat()) {
		      log(Level.WARNING, "Warn - No Chat Plugin");
		 }
		this.getCommand("alcmene").setExecutor(new BuxCommandsExecutor(this));
		this.getCommand("galateyah").setExecutor(new BuxCommandsExecutor(this));
		this.getCommand("groll").setExecutor(new BuxCommandsExecutor(this));
		this.getCommand("hat").setExecutor(new BuxCommandsExecutor(this));
		this.getCommand("mumnut").setExecutor(new BuxCommandsExecutor(this));
		this.getCommand("rahman").setExecutor(new BuxCommandsExecutor(this));
		this.getCommand("raven").setExecutor(new BuxCommandsExecutor(this));
		this.getCommand("tnkl").setExecutor(new BuxCommandsExecutor(this));
		this.getCommand("who").setExecutor(new BuxCommandsExecutor(this));
	}
	
	public boolean setupChat() {
	    RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
	    BuxCommands.setChat(((Chat)rsp.getProvider()));
	    return BuxCommands.getChat() != null;
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
	
	public void onDisable() {
		System.out.println("BuxCommands shutting down.");
	}


}