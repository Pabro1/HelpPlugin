package com.pabro.helpplugin.commands;

import com.pabro.helpplugin.Managers.ArmorstandManager;
import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ArmorstandCommand implements CommandExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender instanceof Player player) {
            @Nullable Component errormessage = Component.text(ChatColor.RED + "Er is een fout opgetreden!");

            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("blackjack")) {
                    ArmorstandManager.BlackjackArmorstand(player);

                } else {
                    player.sendMessage(errormessage);
                }
            } else {
                player.sendMessage(errormessage);
            }
        }

        return false;
    }
}
