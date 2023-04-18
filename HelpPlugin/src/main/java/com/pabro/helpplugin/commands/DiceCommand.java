package com.pabro.helpplugin.commands;

import com.pabro.helpplugin.HelpPlugin;
import com.pabro.helpplugin.Managers.PluginManager;
import net.kyori.adventure.text.Component;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class DiceCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender instanceof Player player) {
            Economy economy = PluginManager.getEconomy();
            Random random = new Random();
            Integer result = Integer.valueOf(random.nextInt(6) + 1);
            @Nullable Component errortransactie = Component.text(ChatColor.RED + "De transactie is mislukt!");
            @Nullable Component errormessage = Component.text(ChatColor.RED + "Er is een fout opgetreden!");
            @Nullable Component errorcommand = Component.text(ChatColor.RED + "Gebruik: /dobbelsteen (1-6) (inzetbedrag)");
            @Nullable Component errorgeld = Component.text(ChatColor.RED + "Je hebt niet genoeg geld!");

            if (args.length == 2) {
                Double amount = Double.valueOf(args[1]);
                Integer dice = Integer.valueOf(args[0]);

                if (economy.getBalance(player) < amount) {
                    player.sendMessage(errorgeld);
                    return false;
                } else {
                if (dice.doubleValue() >= 1 && dice <= 6) {
                    if (dice == result) {
                        EconomyResponse response = economy.depositPlayer(player, amount * 6);
                        titles(player, "Je hebt " + result + " gegooit!", amount);
                        titles1(player, String.valueOf(result), amount);


                        if (response.transactionSuccess()) {
                            return false;
                        } else {
                            player.sendMessage(errortransactie);
                        }

                    } else {
                        EconomyResponse response = economy.withdrawPlayer(player, amount);
                        titles(player, "Je hebt " + result + " gegooit!", amount);
                        titles2(player, String.valueOf(result), amount);

                        if (response.transactionSuccess()) {
                            return false;
                        } else {
                            player.sendMessage(errortransactie);
                        }
                    }
                } else {
                    player.sendMessage(errormessage);
                } }
            } else {
                player.sendMessage(errormessage);
            }

        }

        return false;
    }

    public void titles(Player player, String text, double amount) {
        Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, ()-> player.sendTitle(ChatColor.GOLD + "3", null), 0);
        Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, ()-> player.sendTitle(ChatColor.GOLD + "2", null), 30);
        Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, ()-> player.sendTitle(ChatColor.GOLD + "1", null), 60);
        Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, ()-> player.sendTitle(ChatColor.GOLD.toString() + ChatColor.BOLD + text, null), 90);
    }
    public void titles1(Player player, String text, double amount) {
        Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> player.sendMessage(ChatColor.GOLD + "Je hebt " + ChatColor.WHITE + text + ChatColor.GOLD + " gegooit!\n" + ChatColor.GREEN + "Je wint " + ChatColor.WHITE + "$" + amount * 4), 90);
    }
    public void titles2(Player player, String text, double amount) {
        Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> player.sendMessage(ChatColor.GOLD + "Je hebt " + ChatColor.WHITE + text + ChatColor.GOLD + " gegooit!\n" + ChatColor.RED + "Je verliest " + ChatColor.WHITE + "$" + amount), 90);
    }
    public void titleslose(Player player, String text, double amount) {
        Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, ()-> player.sendTitle(ChatColor.GOLD + "3", null), 0);
        Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, ()-> player.sendTitle(ChatColor.GOLD + "2", null), 30);
        Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, ()-> player.sendTitle(ChatColor.GOLD + "1", null), 60);
        Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, ()-> player.sendTitle(ChatColor.GOLD.toString() + ChatColor.BOLD + text, null), 90);
    }

}
