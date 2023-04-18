package com.pabro.helpplugin.Inventories;

import com.pabro.helpplugin.Managers.HeadsManager;
import com.pabro.helpplugin.HelpPlugin;
import com.pabro.helpplugin.Managers.PluginManager;
import net.kyori.adventure.text.Component;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.pabro.helpplugin.Managers.PluginManager.itemStack;

public class SlotsInventory implements Listener {
    private static List<ItemStack> slotsitems = new ArrayList<>(27);
    private static List<ItemStack> coloritems = new ArrayList<>(7);
    private static Inventory invslotmachine = Bukkit.createInventory(null, 45, "Slot Machine");
    private static Inventory invjackpot = Bukkit.createInventory(null, 45, "Jackpot");
    private static Inventory invthreeequals = Bukkit.createInventory(null, 45, "Three Equals");
    private static Inventory invtwoequals = Bukkit.createInventory(null, 45, "Two Equals");
    private static Inventory invzeroequals = Bukkit.createInventory(null, 45, "Zero Equals");
    private static Economy economy = PluginManager.getEconomy();
    private static Random random = new Random();
    private static int amount;

    private static void invitems(Player player) {
        coloritems.clear();
        coloritems.add(itemStack(Material.LIME_STAINED_GLASS_PANE, " "));
        coloritems.add(itemStack(Material.YELLOW_STAINED_GLASS_PANE, " "));
        coloritems.add(itemStack(Material.BLUE_STAINED_GLASS_PANE, " "));
        coloritems.add(itemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE, " "));
        coloritems.add(itemStack(Material.PINK_STAINED_GLASS_PANE, " "));
        coloritems.add(itemStack(Material.RED_STAINED_GLASS_PANE, " "));
        coloritems.add(itemStack(Material.ORANGE_STAINED_GLASS_PANE, " "));
        coloritems.add(itemStack(Material.MAGENTA_STAINED_GLASS_PANE, " "));

        slotsitems.clear();
        slotsitems.add(new ItemStack(Material.TROPICAL_FISH));
        slotsitems.add(new ItemStack(Material.PUFFERFISH));
        slotsitems.add(new ItemStack(Material.ROTTEN_FLESH));
        slotsitems.add(new ItemStack(Material.POISONOUS_POTATO));
        slotsitems.add(new ItemStack(Material.BAKED_POTATO));
        slotsitems.add(new ItemStack(Material.MELON_SLICE));
        slotsitems.add(new ItemStack(Material.CARROT));
        slotsitems.add(new ItemStack(Material.APPLE));
        slotsitems.add(new ItemStack(Material.PUMPKIN_PIE));
        slotsitems.add(new ItemStack(Material.COOKIE));
        slotsitems.add(new ItemStack(Material.BREAD));
        slotsitems.add(new ItemStack(Material.MELON_SLICE));
        slotsitems.add(new ItemStack(Material.GLOW_BERRIES));
        slotsitems.add(new ItemStack(Material.CHORUS_FRUIT));
        slotsitems.add(new ItemStack(Material.SWEET_BERRIES));
        slotsitems.add(new ItemStack(Material.BEETROOT));
        slotsitems.add(new ItemStack(Material.KELP));
        slotsitems.add(new ItemStack(Material.COOKED_MUTTON));
        slotsitems.add(new ItemStack(Material.COOKED_BEEF));
        slotsitems.add(new ItemStack(Material.COOKED_RABBIT));
        slotsitems.add(new ItemStack(Material.COOKED_CHICKEN));
        slotsitems.add(new ItemStack(Material.DRIED_KELP));
        slotsitems.add(new ItemStack(Material.BEETROOT_SOUP));
        slotsitems.add(new ItemStack(Material.SLIME_BALL));
        slotsitems.add(new ItemStack(Material.MAGMA_CREAM));
        slotsitems.add(new ItemStack(Material.HONEYCOMB));
        slotsitems.add(new ItemStack(Material.EGG));
        slotsitems.add(new ItemStack(Material.BLAZE_POWDER));
        slotsitems.add(new ItemStack(Material.SPIDER_EYE));

        loop(invslotmachine, player);
    }

    public static void loop(Inventory inventory, Player player) {
        player.openInventory(invslotmachine);

        @Nullable Component errortransactie = Component.text(ChatColor.RED + "De transactie is mislukt!");

        Random random1 = new Random();
        Random random2 = new Random();
        Random random3 = new Random();
        Random random4 = new Random();
        int randomint1 = random1.nextInt(5);
        int randomint2 = random2.nextInt(5);
        int randomint3 = random3.nextInt(5);
        int randomint4 = random4.nextInt(27);
        int delay = 0;
        int i = 0;

        for (i = 0; i <= 50; i++) {
            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invslotmachine.clear(), delay);
            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 0.8f, 1f), delay);

            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invslotmachine.setItem(0, coloritems.get(random.nextInt(coloritems.size()))), delay);
            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invslotmachine.setItem(1, coloritems.get(random.nextInt(coloritems.size()))), delay);
            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invslotmachine.setItem(2, coloritems.get(random.nextInt(coloritems.size()))), delay);
            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invslotmachine.setItem(3, coloritems.get(random.nextInt(coloritems.size()))), delay);
            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invslotmachine.setItem(4, coloritems.get(random.nextInt(coloritems.size()))), delay);
            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invslotmachine.setItem(5, coloritems.get(random.nextInt(coloritems.size()))), delay);
            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invslotmachine.setItem(6, coloritems.get(random.nextInt(coloritems.size()))), delay);
            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invslotmachine.setItem(7, coloritems.get(random.nextInt(coloritems.size()))), delay);
            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invslotmachine.setItem(8, coloritems.get(random.nextInt(coloritems.size()))), delay);
            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invslotmachine.setItem(9, coloritems.get(random.nextInt(coloritems.size()))), delay);
            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invslotmachine.setItem(17, coloritems.get(random.nextInt(coloritems.size()))), delay);
            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invslotmachine.setItem(18, coloritems.get(random.nextInt(coloritems.size()))), delay);
            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invslotmachine.setItem(26, coloritems.get(random.nextInt(coloritems.size()))), delay);
            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invslotmachine.setItem(27, coloritems.get(random.nextInt(coloritems.size()))), delay);
            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invslotmachine.setItem(35, coloritems.get(random.nextInt(coloritems.size()))), delay);
            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invslotmachine.setItem(36, coloritems.get(random.nextInt(coloritems.size()))), delay);
            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invslotmachine.setItem(37, coloritems.get(random.nextInt(coloritems.size()))), delay);
            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invslotmachine.setItem(38, coloritems.get(random.nextInt(coloritems.size()))), delay);
            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invslotmachine.setItem(39, coloritems.get(random.nextInt(coloritems.size()))), delay);
            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invslotmachine.setItem(40, coloritems.get(random.nextInt(coloritems.size()))), delay);
            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invslotmachine.setItem(41, coloritems.get(random.nextInt(coloritems.size()))), delay);
            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invslotmachine.setItem(42, coloritems.get(random.nextInt(coloritems.size()))), delay);
            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invslotmachine.setItem(43, coloritems.get(random.nextInt(coloritems.size()))), delay);
            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invslotmachine.setItem(44, coloritems.get(random.nextInt(coloritems.size()))), delay);

            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invslotmachine.setItem(21, slotsitems.get(random.nextInt(slotsitems.size()))), delay);
            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invslotmachine.setItem(22, slotsitems.get(random.nextInt(slotsitems.size()))), delay);
            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invslotmachine.setItem(23, slotsitems.get(random.nextInt(slotsitems.size()))), delay);
            delay = delay + 2;
            if (i > 40 && i < 48) {
                delay = delay + 2;
            } else if (i >= 48) {
                delay = delay + 5;
                if (i == 50) {
                    Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 0.8f, 1f), delay);
                    int randomslot = random.nextInt(100) + 1;
                    if (randomslot <= 2) {
                        Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invjackpot.setItem(0, itemStack(Material.YELLOW_STAINED_GLASS_PANE, " ")), delay);
                        Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invjackpot.setItem(1, itemStack(Material.YELLOW_STAINED_GLASS_PANE, " ")), delay);
                        Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invjackpot.setItem(2, itemStack(Material.YELLOW_STAINED_GLASS_PANE, " ")), delay);
                        Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invjackpot.setItem(3, itemStack(Material.YELLOW_STAINED_GLASS_PANE, " ")), delay);
                        Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invjackpot.setItem(4, itemStack(Material.YELLOW_STAINED_GLASS_PANE, " ")), delay);
                        Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invjackpot.setItem(5, itemStack(Material.YELLOW_STAINED_GLASS_PANE, " ")), delay);
                        Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invjackpot.setItem(6, itemStack(Material.YELLOW_STAINED_GLASS_PANE, " ")), delay);
                        Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invjackpot.setItem(7, itemStack(Material.YELLOW_STAINED_GLASS_PANE, " ")), delay);
                        Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invjackpot.setItem(8, itemStack(Material.YELLOW_STAINED_GLASS_PANE, " ")), delay);
                        Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invjackpot.setItem(9, itemStack(Material.YELLOW_STAINED_GLASS_PANE, " ")), delay);
                        Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invjackpot.setItem(17, itemStack(Material.YELLOW_STAINED_GLASS_PANE, " ")), delay);
                        Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invjackpot.setItem(18, itemStack(Material.YELLOW_STAINED_GLASS_PANE, " ")), delay);
                        Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invjackpot.setItem(26, itemStack(Material.YELLOW_STAINED_GLASS_PANE, " ")), delay);
                        Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invjackpot.setItem(27, itemStack(Material.YELLOW_STAINED_GLASS_PANE, " ")), delay);
                        Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invjackpot.setItem(35, itemStack(Material.YELLOW_STAINED_GLASS_PANE, " ")), delay);
                        Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invjackpot.setItem(36, itemStack(Material.YELLOW_STAINED_GLASS_PANE, " ")), delay);
                        Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invjackpot.setItem(37, itemStack(Material.YELLOW_STAINED_GLASS_PANE, " ")), delay);
                        Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invjackpot.setItem(38, itemStack(Material.YELLOW_STAINED_GLASS_PANE, " ")), delay);
                        Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invjackpot.setItem(39, PluginManager.getheads(HeadsManager.ARROWLEFT.getItemStack(),ChatColor.GOLD + "Menu sluiten")), delay);
                        Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invjackpot.setItem(40, itemStack(Material.NETHER_STAR, " ")), delay);
                        Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invjackpot.setItem(41, PluginManager.getheads(HeadsManager.ARROWRIGHT.getItemStack(),ChatColor.GOLD + "Ga verder")), delay);
                        Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invjackpot.setItem(42, itemStack(Material.YELLOW_STAINED_GLASS_PANE, " ")), delay);
                        Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invjackpot.setItem(43, itemStack(Material.YELLOW_STAINED_GLASS_PANE, " ")), delay);
                        Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invjackpot.setItem(44, itemStack(Material.YELLOW_STAINED_GLASS_PANE, " ")), delay);

                        Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invjackpot.setItem(21, itemStack(Material.ENCHANTED_GOLDEN_APPLE, null)), delay);
                        Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invjackpot.setItem(22, itemStack(Material.ENCHANTED_GOLDEN_APPLE, null)), delay);
                        Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invjackpot.setItem(23, itemStack(Material.ENCHANTED_GOLDEN_APPLE, null)), delay);
                        Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> player.openInventory(invjackpot), delay);

                        @Nullable Component component = Component.text(ChatColor.GOLD.toString() + ChatColor.BOLD + player.getName() + " heeft de jackpot gewonnen op een slotmachine!");
                        Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> Bukkit.broadcast(component), delay);

                        Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> player.sendTitle(ChatColor.GOLD.toString() + ChatColor.BOLD + "Jackpot", null), delay);
                        Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> player.sendMessage(ChatColor.GREEN + "Je hebt " + ChatColor.WHITE + amount * 10 + ChatColor.GREEN + " gewonnen!"), delay);
                        EconomyResponse response = (EconomyResponse) Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> economy.depositPlayer(player, amount * 9), delay);
                        if (response.transactionSuccess()) {
                            return;
                        } else {
                            player.sendMessage(errortransactie);
                        }
                    } else {
                        if (randomint1 == randomint2 && randomint2 == randomint3) {
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invthreeequals.setItem(0, itemStack(Material.GREEN_STAINED_GLASS_PANE, " ")), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invthreeequals.setItem(1, itemStack(Material.GREEN_STAINED_GLASS_PANE, " ")), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invthreeequals.setItem(2, itemStack(Material.GREEN_STAINED_GLASS_PANE, " ")), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invthreeequals.setItem(3, itemStack(Material.GREEN_STAINED_GLASS_PANE, " ")), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invthreeequals.setItem(4, itemStack(Material.GREEN_STAINED_GLASS_PANE, " ")), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invthreeequals.setItem(5, itemStack(Material.GREEN_STAINED_GLASS_PANE, " ")), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invthreeequals.setItem(6, itemStack(Material.GREEN_STAINED_GLASS_PANE, " ")), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invthreeequals.setItem(7, itemStack(Material.GREEN_STAINED_GLASS_PANE, " ")), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invthreeequals.setItem(8, itemStack(Material.GREEN_STAINED_GLASS_PANE, " ")), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invthreeequals.setItem(9, itemStack(Material.GREEN_STAINED_GLASS_PANE, " ")), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invthreeequals.setItem(17, itemStack(Material.GREEN_STAINED_GLASS_PANE, " ")), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invthreeequals.setItem(18, itemStack(Material.GREEN_STAINED_GLASS_PANE, " ")), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invthreeequals.setItem(26, itemStack(Material.GREEN_STAINED_GLASS_PANE, " ")), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invthreeequals.setItem(27, itemStack(Material.GREEN_STAINED_GLASS_PANE, " ")), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invthreeequals.setItem(35, itemStack(Material.GREEN_STAINED_GLASS_PANE, " ")), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invthreeequals.setItem(36, itemStack(Material.GREEN_STAINED_GLASS_PANE, " ")), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invthreeequals.setItem(37, itemStack(Material.GREEN_STAINED_GLASS_PANE, " ")), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invthreeequals.setItem(38, itemStack(Material.GREEN_STAINED_GLASS_PANE, " ")), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invthreeequals.setItem(39, PluginManager.getheads(HeadsManager.ARROWLEFT.getItemStack(),ChatColor.GOLD + "Menu sluiten")), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invthreeequals.setItem(40, itemStack(Material.NETHER_STAR, " ")), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invthreeequals.setItem(41, PluginManager.getheads(HeadsManager.ARROWRIGHT.getItemStack(),ChatColor.GOLD + "Ga verder")), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invthreeequals.setItem(42, itemStack(Material.GREEN_STAINED_GLASS_PANE, " ")), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invthreeequals.setItem(43, itemStack(Material.GREEN_STAINED_GLASS_PANE, " ")), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invthreeequals.setItem(44, itemStack(Material.GREEN_STAINED_GLASS_PANE, " ")), delay);

                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invthreeequals.setItem(21, slotsitems.get(randomint4)), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invthreeequals.setItem(22, slotsitems.get(randomint4)), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invthreeequals.setItem(23, slotsitems.get(randomint4)), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> player.openInventory(invthreeequals), delay);

                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> player.sendTitle(ChatColor.GREEN.toString() + ChatColor.BOLD + "Je hebt gewonnen", null), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> player.sendMessage(ChatColor.GREEN + "Je hebt " + ChatColor.WHITE + amount * 2 + ChatColor.GREEN + " gewonnen!"), delay);
                            EconomyResponse response = (EconomyResponse) Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> economy.depositPlayer(player, amount), delay);
                            if (response.transactionSuccess()) {
                                return;
                            } else {
                                player.sendMessage(errortransactie);
                            }
                        } else if (randomint1 == randomint2 || randomint2 == randomint3 || randomint1 == randomint3) {
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invtwoequals.setItem(0, itemStack(Material.GREEN_STAINED_GLASS_PANE, " ")), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invtwoequals.setItem(1, itemStack(Material.GREEN_STAINED_GLASS_PANE, " ")), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invtwoequals.setItem(2, itemStack(Material.GREEN_STAINED_GLASS_PANE, " ")), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invtwoequals.setItem(3, itemStack(Material.GREEN_STAINED_GLASS_PANE, " ")), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invtwoequals.setItem(4, itemStack(Material.GREEN_STAINED_GLASS_PANE, " ")), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invtwoequals.setItem(5, itemStack(Material.GREEN_STAINED_GLASS_PANE, " ")), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invtwoequals.setItem(6, itemStack(Material.GREEN_STAINED_GLASS_PANE, " ")), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invtwoequals.setItem(7, itemStack(Material.GREEN_STAINED_GLASS_PANE, " ")), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invtwoequals.setItem(8, itemStack(Material.GREEN_STAINED_GLASS_PANE, " ")), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invtwoequals.setItem(9, itemStack(Material.GREEN_STAINED_GLASS_PANE, " ")), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invtwoequals.setItem(17, itemStack(Material.GREEN_STAINED_GLASS_PANE, " ")), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invtwoequals.setItem(18, itemStack(Material.GREEN_STAINED_GLASS_PANE, " ")), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invtwoequals.setItem(26, itemStack(Material.GREEN_STAINED_GLASS_PANE, " ")), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invtwoequals.setItem(27, itemStack(Material.GREEN_STAINED_GLASS_PANE, " ")), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invtwoequals.setItem(35, itemStack(Material.GREEN_STAINED_GLASS_PANE, " ")), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invtwoequals.setItem(36, itemStack(Material.GREEN_STAINED_GLASS_PANE, " ")), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invtwoequals.setItem(37, itemStack(Material.GREEN_STAINED_GLASS_PANE, " ")), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invtwoequals.setItem(38, itemStack(Material.GREEN_STAINED_GLASS_PANE, " ")), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invtwoequals.setItem(39, PluginManager.getheads(HeadsManager.ARROWLEFT.getItemStack(),ChatColor.GOLD + "Menu sluiten")), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invtwoequals.setItem(40, itemStack(Material.NETHER_STAR, " ")), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invtwoequals.setItem(41, PluginManager.getheads(HeadsManager.ARROWRIGHT.getItemStack(),ChatColor.GOLD + "Ga verder")), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invtwoequals.setItem(42, itemStack(Material.GREEN_STAINED_GLASS_PANE, " ")), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invtwoequals.setItem(43, itemStack(Material.GREEN_STAINED_GLASS_PANE, " ")), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invtwoequals.setItem(44, itemStack(Material.GREEN_STAINED_GLASS_PANE, " ")), delay);

                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invtwoequals.setItem(21, slotsitems.get(randomint4)), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invtwoequals.setItem(22, slotsitems.get(randomint4)), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invtwoequals.setItem(23, slotsitems.get(randomint4 + 1)), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> player.openInventory(invtwoequals), delay);

                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> player.sendTitle(ChatColor.GREEN.toString() + ChatColor.BOLD + "Je hebt gewonnen", null), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> player.sendMessage(ChatColor.GREEN + "Je hebt " + ChatColor.WHITE + amount * 1.5 + ChatColor.GREEN + " gewonnen!"), delay);
                            EconomyResponse response = (EconomyResponse) Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> economy.depositPlayer(player, amount * 0.5), delay);
                            if (response.transactionSuccess()) {
                                return;
                            } else {
                                player.sendMessage(errortransactie);
                            }
                        } else {
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invzeroequals.setItem(0, itemStack(Material.RED_STAINED_GLASS_PANE, " ")), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invzeroequals.setItem(1, itemStack(Material.RED_STAINED_GLASS_PANE, " ")), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invzeroequals.setItem(2, itemStack(Material.RED_STAINED_GLASS_PANE, " ")), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invzeroequals.setItem(3, itemStack(Material.RED_STAINED_GLASS_PANE, " ")), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invzeroequals.setItem(4, itemStack(Material.RED_STAINED_GLASS_PANE, " ")), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invzeroequals.setItem(5, itemStack(Material.RED_STAINED_GLASS_PANE, " ")), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invzeroequals.setItem(6, itemStack(Material.RED_STAINED_GLASS_PANE, " ")), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invzeroequals.setItem(7, itemStack(Material.RED_STAINED_GLASS_PANE, " ")), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invzeroequals.setItem(8, itemStack(Material.RED_STAINED_GLASS_PANE, " ")), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invzeroequals.setItem(9, itemStack(Material.RED_STAINED_GLASS_PANE, " ")), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invzeroequals.setItem(17, itemStack(Material.RED_STAINED_GLASS_PANE, " ")), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invzeroequals.setItem(18, itemStack(Material.RED_STAINED_GLASS_PANE, " ")), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invzeroequals.setItem(26, itemStack(Material.RED_STAINED_GLASS_PANE, " ")), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invzeroequals.setItem(27, itemStack(Material.RED_STAINED_GLASS_PANE, " ")), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invzeroequals.setItem(35, itemStack(Material.RED_STAINED_GLASS_PANE, " ")), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invzeroequals.setItem(36, itemStack(Material.RED_STAINED_GLASS_PANE, " ")), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invzeroequals.setItem(37, itemStack(Material.RED_STAINED_GLASS_PANE, " ")), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invzeroequals.setItem(38, itemStack(Material.RED_STAINED_GLASS_PANE, " ")), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invzeroequals.setItem(39, PluginManager.getheads(HeadsManager.ARROWLEFT.getItemStack(),ChatColor.GOLD + "Menu sluiten")), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invzeroequals.setItem(40, itemStack(Material.NETHER_STAR, " ")), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invzeroequals.setItem(41, PluginManager.getheads(HeadsManager.ARROWRIGHT.getItemStack(),ChatColor.GOLD + "Ga verder")), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invzeroequals.setItem(42, itemStack(Material.RED_STAINED_GLASS_PANE, " ")), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invzeroequals.setItem(43, itemStack(Material.RED_STAINED_GLASS_PANE, " ")), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invzeroequals.setItem(44, itemStack(Material.RED_STAINED_GLASS_PANE, " ")), delay);

                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invzeroequals.setItem(21, slotsitems.get(randomint4)), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invzeroequals.setItem(22, slotsitems.get(randomint4 + 1)), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> invzeroequals.setItem(23, slotsitems.get(randomint4 + 2)), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> player.openInventory(invzeroequals), delay);

                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> player.sendTitle(ChatColor.RED.toString() + ChatColor.BOLD + "Je hebt verloren", null), delay);
                            Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> player.sendMessage(ChatColor.RED + "Je hebt " + ChatColor.WHITE + amount + ChatColor.RED + " verloren!"), delay);
                            EconomyResponse response = (EconomyResponse) Bukkit.getScheduler().runTaskLater(HelpPlugin.plugin, () -> economy.withdrawPlayer(player, amount), delay);
                            if (response.transactionSuccess()) {
                                return;
                            } else {
                                player.sendMessage(errortransactie);
                            }
                        }
                    }
                }
            }
        }
    }

    public static Inventory GeldSlotInventory() {
        Inventory inv = Bukkit.createInventory(null, 45, "Betting Menu");

        inv.setItem(0, itemStack(Material.WHITE_STAINED_GLASS_PANE, " "));
        inv.setItem(1, itemStack(Material.WHITE_STAINED_GLASS_PANE, " "));
        inv.setItem(2, itemStack(Material.WHITE_STAINED_GLASS_PANE, " "));
        inv.setItem(3, itemStack(Material.WHITE_STAINED_GLASS_PANE, " "));
        inv.setItem(4, itemStack(Material.WHITE_STAINED_GLASS_PANE, " "));
        inv.setItem(5, itemStack(Material.WHITE_STAINED_GLASS_PANE, " "));
        inv.setItem(6, itemStack(Material.WHITE_STAINED_GLASS_PANE, " "));
        inv.setItem(7, itemStack(Material.WHITE_STAINED_GLASS_PANE, " "));
        inv.setItem(8, itemStack(Material.WHITE_STAINED_GLASS_PANE, " "));
        inv.setItem(9, itemStack(Material.WHITE_STAINED_GLASS_PANE, " "));
        inv.setItem(11, PluginManager.getheads(HeadsManager.LIMEGLASS.getItemStack(), ChatColor.GREEN + "+ $10"));
        inv.setItem(13, PluginManager.getheads(HeadsManager.LIMEGLASS.getItemStack(), ChatColor.GREEN + "+ $100"));
        inv.setItem(15, PluginManager.getheads(HeadsManager.LIMEGLASS.getItemStack(), ChatColor.GREEN + "+ $1000"));
        inv.setItem(17, itemStack(Material.WHITE_STAINED_GLASS_PANE, " "));
        inv.setItem(18, itemStack(Material.WHITE_STAINED_GLASS_PANE, " "));
        inv.setItem(26, itemStack(Material.WHITE_STAINED_GLASS_PANE, " "));
        inv.setItem(27, itemStack(Material.WHITE_STAINED_GLASS_PANE, " "));
        inv.setItem(29, PluginManager.getheads(HeadsManager.REDGLASS.getItemStack(), ChatColor.RED + "- $10"));
        inv.setItem(31, PluginManager.getheads(HeadsManager.REDGLASS.getItemStack(), ChatColor.RED + "- $100"));
        inv.setItem(33, PluginManager.getheads(HeadsManager.REDGLASS.getItemStack(), ChatColor.RED + "- $1000"));
        inv.setItem(35, itemStack(Material.WHITE_STAINED_GLASS_PANE, " "));
        inv.setItem(36, itemStack(Material.WHITE_STAINED_GLASS_PANE, " "));
        inv.setItem(37, itemStack(Material.WHITE_STAINED_GLASS_PANE, " "));
        inv.setItem(38, itemStack(Material.WHITE_STAINED_GLASS_PANE, " "));
        inv.setItem(39, PluginManager.getheads(HeadsManager.ARROWLEFT.getItemStack(), ChatColor.GOLD + "Menu sluiten"));
        inv.setItem(41, PluginManager.getheads(HeadsManager.ARROWRIGHT.getItemStack(), ChatColor.GOLD + "Ga verder"));
        inv.setItem(42, itemStack(Material.WHITE_STAINED_GLASS_PANE, " "));
        inv.setItem(43, itemStack(Material.WHITE_STAINED_GLASS_PANE, " "));
        inv.setItem(44, itemStack(Material.WHITE_STAINED_GLASS_PANE, " "));

        if (amount > 0) {
            inv.setItem(40, itemStack(Material.LIME_DYE, ChatColor.GOLD + "Inzet: " + ChatColor.WHITE + "$" + String.valueOf(amount)));
        } else {
            inv.setItem(40, itemStack(Material.GRAY_DYE, ChatColor.GOLD + "Inzet: " + ChatColor.WHITE + "$" + String.valueOf(amount)));
        }

        return inv;
    }

    /*@EventHandler(ignoreCancelled = true)
    private void onInventoryClose(InventoryCloseEvent event) {
        Player player = (Player) event.getPlayer();
        if (event.getView().getTitle().equalsIgnoreCase("Slot Machine")) {
            player.openInventory(invslotmachine);
        }
        if (event.getView().getTitle().equalsIgnoreCase("Jackpot")) {
            player.openInventory(invjackpot);
        }
        if (event.getView().getTitle().equalsIgnoreCase("Three Equals")) {
            player.openInventory(invthreeequals);
        }
        if (event.getView().getTitle().equalsIgnoreCase("Two Equals")) {
            player.openInventory(invtwoequals);
        }
        if (event.getView().getTitle().equalsIgnoreCase("Zero Equals")) {
            player.openInventory(invzeroequals);
        }
    }*/

    @EventHandler(ignoreCancelled = true)
    private void onInventoryClick(InventoryClickEvent event) {
        @Nullable Component errormessage = Component.text(ChatColor.RED + "Er is een fout opgetreden!");
        @Nullable Component errorgeld = Component.text(ChatColor.RED + "Je hebt niet genoeg geld!");
        Player player = (Player) event.getWhoClicked();

        if (event.getView().getTitle().equalsIgnoreCase("Jackpot") || event.getView().getTitle().equalsIgnoreCase("Three Equals") ||
                event.getView().getTitle().equalsIgnoreCase("Two Equals") || event.getView().getTitle().equalsIgnoreCase("Zero Equals")) {
            if (event.getSlot() == 39) {
                event.getWhoClicked().closeInventory();
                player.playSound(player.getLocation(), Sound.BLOCK_STONE_BUTTON_CLICK_ON, 1f, 1f);
            }
            if (event.getSlot() == 41) {
                player.openInventory(SlotsInventory.GeldSlotInventory());
                player.playSound(player.getLocation(), Sound.BLOCK_STONE_BUTTON_CLICK_ON, 1f, 1f);
            }
        }

        if (event.getView().getTitle().equalsIgnoreCase("Betting Menu")) {
            if (event.getSlot() == 11) {
                amount = amount + 10;
                player.playSound(player.getLocation(), Sound.BLOCK_STONE_BUTTON_CLICK_ON, 1f, 1f);
            }
            if (event.getSlot() == 13) {
                amount = amount + 100;
                player.playSound(player.getLocation(), Sound.BLOCK_STONE_BUTTON_CLICK_ON, 1f, 1f);
            }
            if (event.getSlot() == 15) {
                amount = amount + 1000;
                player.playSound(player.getLocation(), Sound.BLOCK_STONE_BUTTON_CLICK_ON, 1f, 1f);
            }
            if (event.getSlot() == 29) {
                amount = amount - 10;
                player.playSound(player.getLocation(), Sound.BLOCK_WOODEN_BUTTON_CLICK_ON, 1f, 1f);
            }
            if (event.getSlot() == 31) {
                amount = amount - 100;
                player.playSound(player.getLocation(), Sound.BLOCK_WOODEN_BUTTON_CLICK_ON, 1f, 1f);
            }
            if (event.getSlot() == 33) {
                amount = amount - 1000;
                player.playSound(player.getLocation(), Sound.BLOCK_WOODEN_BUTTON_CLICK_ON, 1f, 1f);
            }
            player.openInventory(GeldSlotInventory());

            if (event.getSlot() == 39) {
                event.getWhoClicked().closeInventory();
                player.playSound(player.getLocation(), Sound.BLOCK_STONE_BUTTON_CLICK_ON, 1f, 1f);
            }
            if (event.getSlot() == 41) {
                if (amount <= 0) {
                    event.getWhoClicked().sendMessage(errormessage);
                    player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.5f, 1f);
                } else if (economy.getBalance(event.getWhoClicked().getName()) < amount) {
                    player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.5f, 1f);
                    event.getWhoClicked().sendMessage(errorgeld);
                } else {
                    invitems(player);
                }
            }
        }

        if (event.getView().getTitle().equalsIgnoreCase("Betting Menu") || (event.getView().getTitle().equalsIgnoreCase("Slot Machine")) || (event.getView().getTitle().equalsIgnoreCase("Jackpot") ||
                event.getView().getTitle().equalsIgnoreCase("Three Equals") || event.getView().getTitle().equalsIgnoreCase("Two Equals") || event.getView().getTitle().equalsIgnoreCase("Zero Equals"))) {
            event.setCancelled(true);
        }
    }
}
