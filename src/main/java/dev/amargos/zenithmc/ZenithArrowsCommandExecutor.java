package dev.amargos.zenithmc;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ZenithArrowsCommandExecutor implements CommandExecutor {
    final ZenithArrows plugin;

    public ZenithArrowsCommandExecutor(ZenithArrows plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            String msg = "&8[&cZenithArrows&8]: &7A bow boosting plugin";
            msg += "\n&7Version: &f" + plugin.getDescription().getVersion();
            msg += "\n&7Authors: &f" + String.join("&7, &f", plugin.getDescription().getAuthors());
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
            return true;
        } else if (args[0].equalsIgnoreCase("reload")) {
            if (!sender.hasPermission("zenithbowkb.admin")) {
                sender.sendMessage("");
                return true;
            }
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&cZenithArrows&8]: &7Reloading..."));
            plugin.reloadConfig();
            sender.sendMessage(
                    ChatColor.translateAlternateColorCodes('&', "&8[&cZenithArrows&8]: &7Reload Complete!"));
            return true;
        } else {
            String msg = "&8[&cZenithArrows&8]: &7Unknown command.";
            sender.sendMessage(msg);
            return false;
        }
    }
}
