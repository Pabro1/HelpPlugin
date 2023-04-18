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

public class CoinflipCommand implements CommandExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender instanceof Player player) {
            Economy economy = PluginManager.getEconomy();
            Random dice = new Random();
            @Nullable Component errormessage = Component.text(ChatColor.RED + "Er is een fout opgetreden!");
            @Nullable Component errortransactie = Component.text(ChatColor.RED + "De transactie is mislukt!");
            @Nullable Component errorgeld = Component.text(ChatColor.RED + "Je hebt niet genoeg geld!");
            @Nullable Component errorcommand = Component.text(ChatColor.RED + "Gebruik: /coinflip (kop/munt) (inzetbedrag)");

            if (args.length == 0) {
                player.sendMessage(errorcommand);
                return false;
            }

            if (args.length == 2) {
                String coin = String.valueOf(args[0]);
                Double amount = Double.valueOf(args[1]);
                @Nullable Component coincomponent = Component.text(ChatColor.GRAY + "Gekozen kant: " + ChatColor.WHITE + coin);
                @Nullable Component amountcomponent = Component.text(ChatColor.GRAY + "Geld ingezet: " + ChatColor.WHITE + "$" + amount);

                if (economy.getBalance(player) < amount) {
                    player.sendMessage(errorgeld);
                    return false;
                } else {
                    if (dice.nextInt(2) == 1) {
                        if (coin.equalsIgnoreCase("munt")) {
                            EconomyResponse response = economy.depositPlayer(player, amount);

                            titles(player, "Je hebt munt gegooit", amount);

                            if (response.transactionSuccess()) {
                                return false;
                            } else {
                                player.sendMessage(errortransactie);}

                        } else if (coin.equalsIgnoreCase("Kop")) {
                            EconomyResponse response = economy.depositPlayer(player, amount);

                            titleskop(player, "Je hebt kop gegooit", amount);

                            if (response.transactionSuccess()) {
                            return false;
                            } else {
                                player.sendMessage(errortransactie); }

                        } else {
                                player.sendMessage(errormessage); }
                    } else {
                        if (coin.equalsIgnoreCase("munt")) {
                            EconomyResponse response = economy.withdrawPlayer(player, amount);

                            titleskoplose(player, "Je hebt kop gegooit", amount);

                            if (response.transactionSuccess()) {
                                return false;
                            } else {
                                player.sendMessage(errortransactie); }
                        } else if (coin.equalsIgnoreCase("kop")) {
                            EconomyResponse response = economy.withdrawPlayer(player, amount);

                            titleslose(player, "Je hebt munt gegooit", amount);

                            if (response.transactionSuccess()) {
                                return false;
                            } else {
                                player.sendMessage(errortransactie); }

                        } else {
                            player.sendMessage(errormessage); }

                    }
                }
            }
            else {
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
        Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> player.sendMessage(ChatColor.GOLD + "Je hebt " + ChatColor.WHITE + "munt" + ChatColor.GOLD + " gegooit!\n" + ChatColor.GREEN + "Je wint " + ChatColor.WHITE + "$" + amount * 2), 90);
    }

    public void titleslose(Player player, String text, double amount) {
        Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, ()-> player.sendTitle(ChatColor.GOLD + "3", null), 0);
        Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, ()-> player.sendTitle(ChatColor.GOLD + "2", null), 30);
        Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, ()-> player.sendTitle(ChatColor.GOLD + "1", null), 60);
        Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, ()-> player.sendTitle(ChatColor.GOLD.toString() + ChatColor.BOLD + text, null), 90);
        Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> player.sendMessage(ChatColor.GOLD + "Je hebt " + ChatColor.WHITE + "munt" + ChatColor.GOLD + " gegooit!\n" + ChatColor.RED + "Je verliest " + ChatColor.WHITE + "$" + amount), 90);
    }


    public void titleskop(Player player, String text, double amount) {
        Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> player.sendTitle(ChatColor.GOLD + "3", null), 0);
        Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> player.sendTitle(ChatColor.GOLD + "2", null), 30);
        Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> player.sendTitle(ChatColor.GOLD + "1", null), 60);
        Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> player.sendTitle(ChatColor.GOLD.toString() + ChatColor.BOLD + text, null), 90);
        Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> player.sendMessage(ChatColor.GOLD + "Je hebt " + ChatColor.WHITE + "kop" + ChatColor.GOLD + " gegooit!\n" + ChatColor.GREEN + "Je wint " + ChatColor.WHITE + "$" + amount * 2), 90);
    }

    public void titleskoplose(Player player, String text, double amount) {
        Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> player.sendTitle(ChatColor.GOLD + "3", null), 0);
        Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> player.sendTitle(ChatColor.GOLD + "2", null), 30);
        Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> player.sendTitle(ChatColor.GOLD + "1", null), 60);
        Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> player.sendTitle(ChatColor.GOLD.toString() + ChatColor.BOLD + text, null), 90);
        Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> player.sendMessage(ChatColor.GOLD + "Je hebt " + ChatColor.WHITE + "kop" + ChatColor.GOLD + " gegooit!\n" + ChatColor.RED + "Je verliest " + ChatColor.WHITE + "$" + amount), 90);
    }


    }

