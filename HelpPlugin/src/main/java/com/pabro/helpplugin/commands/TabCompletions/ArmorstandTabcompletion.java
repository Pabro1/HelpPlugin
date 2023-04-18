package com.pabro.helpplugin.commands.TabCompletions;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ArmorstandTabcompletion implements TabCompleter {
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (args.length == 1) {
            List<String> tabcomplete = new ArrayList<>();
            tabcomplete.add("blackjack");

            return tabcomplete;
        } else if (args.length >= 2) {
            List<String> tabcomplete = new ArrayList<>();
            tabcomplete.add("");

            return tabcomplete;
        }

        return null;
    }
}
