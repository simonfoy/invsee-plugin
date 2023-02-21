package me.simonfoy.invsee;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

public class InvSeeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "This command can only be used by players!");
            return false;
        }

        Player player = (Player) sender;
        if (!player.hasPermission("invsee.command")) {
            player.sendMessage(ChatColor.RED + "You don't have permission to use this command!");
            return false;
        }

        if (args.length != 1) {
            player.sendMessage(ChatColor.RED + "Usage: /invsee <player>");
            return false;
        }

        Player target = Bukkit.getPlayer(args[0]);
        if (target == null) {
            player.sendMessage(ChatColor.RED + "Player " + args[0] + " not found!");
            return false;
        }

        Inventory targetInv = target.getInventory();
        player.openInventory(targetInv);
        player.sendMessage(ChatColor.GREEN + "You are now viewing " + target.getName() + "'s inventory!");
        return true;
    }
}