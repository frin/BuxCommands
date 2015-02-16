package net.buxville.rahman.buxcommands.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

;

public class Hat {
	public static void HatCommand(Player p) {
		ItemStack itemInHand = p.getItemInHand();
		if (itemInHand == null) {
			p.sendMessage(ChatColor.RED
					+ "No item in hand. You can't put your hand on your head in Minecraft?");
			return;
		}

		if (!itemInHand.getType().isBlock()) {
			p.sendMessage(ChatColor.RED
					+ "You cannot use this as a hat. What is wrong with you? Why would you even try that?");
			return;
		}

		ItemStack currentHat = p.getInventory().getHelmet();
		if ((currentHat != null) && (currentHat.getType() != Material.AIR)) {
			p.sendMessage(ChatColor.RED
					+ "You already have a hat. Please store it somewhere safe or tnkl will eat it!");
			return;
		}

		p.getInventory().removeItem(
				new ItemStack[] { new ItemStack(itemInHand.getType(), 1,
						itemInHand.getDurability()) });
		p.getInventory().setHelmet(
				new ItemStack(itemInHand.getType(), 1, itemInHand
						.getDurability()));
		p.sendMessage(ChatColor.GREEN + "Hat set.");
		return;
	}
}
