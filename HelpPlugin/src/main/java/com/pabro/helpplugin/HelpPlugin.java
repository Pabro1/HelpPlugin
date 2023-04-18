package com.pabro.helpplugin;

import com.pabro.helpplugin.Inventories.BlackjackInventory;
import com.pabro.helpplugin.Inventories.SlotsInventory;
import com.pabro.helpplugin.commands.TabCompletions.ArmorstandTabcompletion;
import com.pabro.helpplugin.commands.TabCompletions.BlackjackTabcompletion;
import com.pabro.helpplugin.commands.TabCompletions.CoinflipTabcompletion;
import com.pabro.helpplugin.commands.TabCompletions.DiceTabcompletion;
import com.pabro.helpplugin.commands.*;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import static com.pabro.helpplugin.Managers.PluginManager.setupEconomy;

public final class HelpPlugin extends JavaPlugin {
    private static Economy econ = null;
    public static HelpPlugin plugin;

    @Override
    public void onEnable() {
        plugin = this;
        if (!setupEconomy() ) {
            System.out.println("Geen economy plugin gevonden, Vault uitschakelen.");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "De plugin is ingeschakelt");
        getServer().getPluginManager().registerEvents(new SlotsInventory(), this);
        getServer().getPluginManager().registerEvents(new BlackjackInventory(), this);

        getCommand("armorstand").setTabCompleter(new ArmorstandTabcompletion());
        getCommand("blackjack").setTabCompleter(new BlackjackTabcompletion());
        getCommand("dobbelsteen").setTabCompleter(new DiceTabcompletion());
        getCommand("coinflip").setTabCompleter(new CoinflipTabcompletion());

        getCommand("armorstand").setExecutor(new ArmorstandCommand());
        getCommand("blackjack").setExecutor(new BlackjackCommand());
        getCommand("dobbelsteen").setExecutor(new DiceCommand());
        getCommand("coinflip").setExecutor(new CoinflipCommand());
        getCommand("slots").setExecutor(new SlotsCommand());
    }

    @Override
    public void onDisable() {
    }
}
