package com.pabro.helpplugin.commands;

import com.pabro.helpplugin.Inventories.BlackjackInventory;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class BlackjackCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender instanceof Player player) {
            player.openInventory(BlackjackInventory.BlackjackInzetMenu());

            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("test")) {
                    player.sendMessage("test complete");
                }
            }

        }

        return false;
    }
}
