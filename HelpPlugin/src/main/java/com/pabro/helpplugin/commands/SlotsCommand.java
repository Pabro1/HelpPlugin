package com.pabro.helpplugin.commands;

import com.pabro.helpplugin.Inventories.SlotsInventory;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SlotsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender instanceof Player player) {
            player.openInventory(SlotsInventory.GeldSlotInventory());
        }

        return false;
    }
}


