package com.pabro.helpplugin.commands.TabCompletions;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DiceTabcompletion implements TabCompleter {
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (args.length == 1) {
            List<String> tabcomplete = new ArrayList<>();
            tabcomplete.add("1");
            tabcomplete.add("2");
            tabcomplete.add("3");
            tabcomplete.add("4");
            tabcomplete.add("5");
            tabcomplete.add("6");

            return tabcomplete;
        } else if (args.length >= 2) {
            List<String> tabcomplete = new ArrayList<>();
            tabcomplete.add("");

            return tabcomplete;
        }

        return null;
    }
}
