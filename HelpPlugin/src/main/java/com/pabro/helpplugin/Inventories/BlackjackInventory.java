package com.pabro.helpplugin.Inventories;

import com.pabro.helpplugin.Managers.HeadsManager;
import com.pabro.helpplugin.Managers.PluginManager;
import net.kyori.adventure.text.Component;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentWrapper;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wither;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.Nullable;

import java.util.*;

import static com.pabro.helpplugin.Managers.PluginManager.itemStack;

public class BlackjackInventory implements Listener {

    private static Inventory invinvite = Bukkit.createInventory(null, 54, "blackjack invite menu");
    private static Inventory inv = Bukkit.createInventory(null, 45, "blackjack");
    private static List<ItemStack> playcards = new ArrayList<>(27);
    public static HashMap<UUID, Long> invitedplayers = new HashMap<>();
    public static HashMap<ItemStack, Player> onlineplayers = new HashMap<>();
    private static Economy economy = PluginManager.getEconomy();
    private static Random random = new Random();
    private static int amount = 0;
    private static int loopamount = 0;


    @EventHandler(ignoreCancelled = true)
    public void onPlayerArmorStandManipulate(PlayerArmorStandManipulateEvent event) {
        event.setCancelled(true);
        if (event.getRightClicked().getCustomName().equalsIgnoreCase("blackjack"))
            event.getPlayer().openInventory(BlackjackPlayers());
    }

    private static Inventory BlackjackPlayers() {
        invinvite.clear();
        Bukkit.getOnlinePlayers();
        for (Player player : Bukkit.getOnlinePlayers()) {
            invinvite.setItem(invinvite.firstEmpty(), HeadsManager.getPlayerHead(player));
            //onlineplayers.put(player.getUniqueId(), player);
            onlineplayers.put(HeadsManager.getPlayerHead(player), player);
        }
        return invinvite;
    }

    private static void invitems(Player player) {
        playcards.clear();
        playcards.add(PluginManager.itemStack(Material.LIME_STAINED_GLASS_PANE, " "));
        player.openInventory(BlackjackMenu());
    }

    private static Inventory BlackjackMenu() {
        Inventory inv = Bukkit.createInventory(null, 54, "blackjack menu");

        inv.setItem(0, itemStack(Material.PLAYER_HEAD, " ")); //player head
        inv.setItem(1, itemStack(Material.SHIELD, " ")); //stand
        inv.setItem(2, itemStack(Material.PAPER, " ")); //hit
        inv.setItem(3, itemStack(Material.BARRIER, " ")); //surrender
        inv.setItem(9, itemStack(Material.MAP, " ")); //card 1
        inv.setItem(10, itemStack(Material.MAP, " ")); //card 2
        inv.setItem(11, itemStack(Material.MAP, " ")); //card 3
        inv.setItem(12, itemStack(Material.MAP, " ")); //card 4
        inv.setItem(13, itemStack(Material.MAP, " ")); //card 5

        inv.setItem(18, itemStack(Material.PLAYER_HEAD, " ")); //player head
        inv.setItem(19, itemStack(Material.SHIELD, " ")); //stand
        inv.setItem(20, itemStack(Material.PAPER, " ")); //hit
        inv.setItem(21, itemStack(Material.BARRIER, " ")); //surrender
        inv.setItem(27, itemStack(Material.MAP, " ")); //card 1
        inv.setItem(28, itemStack(Material.MAP, " ")); //card 2
        inv.setItem(29, itemStack(Material.MAP, " ")); //card 3
        inv.setItem(30, itemStack(Material.MAP, " ")); //card 4
        inv.setItem(31, itemStack(Material.MAP, " ")); //card 5

        inv.setItem(36, itemStack(Material.PLAYER_HEAD, " ")); //player head
        inv.setItem(37, itemStack(Material.SHIELD, " ")); //stand
        inv.setItem(38, itemStack(Material.PAPER, " ")); //hit
        inv.setItem(39, itemStack(Material.BARRIER, " ")); //surrender
        inv.setItem(45, itemStack(Material.MAP, " ")); //card 1
        inv.setItem(46, itemStack(Material.MAP, " ")); //card 2
        inv.setItem(47, itemStack(Material.MAP, " ")); //card 3
        inv.setItem(48, itemStack(Material.MAP, " ")); //card 4
        inv.setItem(49, itemStack(Material.MAP, " ")); //card 5

        inv.setItem(8, itemStack(Material.WITHER_SKELETON_SKULL, " ")); //dealer
        inv.setItem(17, itemStack(Material.MAP, " ")); //card 1
        inv.setItem(26, itemStack(Material.MAP, " ")); //card 2
        inv.setItem(35, itemStack(Material.MAP, " ")); //card 3
        inv.setItem(44, itemStack(Material.MAP, " ")); //card 4
        inv.setItem(53, itemStack(Material.MAP, " ")); //leave

        return inv;
    }

    public static Inventory BlackjackInzetMenu() {
        Inventory inv = Bukkit.createInventory(null, 45, "blackjack inzet menu");

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

    @EventHandler(ignoreCancelled = true)
    private void onInventoryClick(InventoryClickEvent event) {
        @Nullable Component errormessage = Component.text(ChatColor.RED + "Er is een fout opgetreden!");
        @Nullable Component errorgeld = Component.text(ChatColor.RED + "Je hebt niet genoeg geld!");
        Player player = (Player) event.getWhoClicked();
        Long newvalue = System.currentTimeMillis() + 10 * 1000;

        TextComponent text1 = new TextComponent(ChatColor.WHITE + player.getName() + ChatColor.LIGHT_PURPLE + " has send you an invite to play blackjack! \n");
        TextComponent textclickable1 = new TextComponent("§a§lACCEPT");
        TextComponent text2 = new TextComponent("§7§l | ");
        TextComponent textclickable2 = new TextComponent("§c§lDENY");
        textclickable1.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/blackjack"));
        textclickable2.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/spawn"));
        text1.addExtra(textclickable1);
        text1.addExtra(text2);
        text1.addExtra(textclickable2);

        if (event.getView().getTitle().equalsIgnoreCase("blackjack invite menu")) {
            try {
                int slot = event.getSlot();
                Player headofplayer = onlineplayers.get(invinvite.getItem(slot));

                if (String.valueOf(invinvite.getItem(slot)).equalsIgnoreCase(String.valueOf(HeadsManager.getPlayerHead(headofplayer)))) {
                    if (invitedplayers.containsKey(headofplayer.getUniqueId())) {
                        if (invitedplayers.get(headofplayer.getUniqueId()) > System.currentTimeMillis()) {
                            Long timeleftinmillis = (invitedplayers.get(headofplayer.getUniqueId()) - System.currentTimeMillis()) / 1000;
                            String timeleft = timeleftinmillis.toString();
                            player.sendMessage(ChatColor.LIGHT_PURPLE + "You can send " + ChatColor.WHITE + headofplayer.getName() + ChatColor.LIGHT_PURPLE + " a new invite in " + timeleft + " seconds.");
                            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_PLACE, 0.5f, 0.5f);
                        } else {
                            headofplayer.sendMessage(text1);
                            invitedplayers.put(headofplayer.getUniqueId(), System.currentTimeMillis() + (10 * 1000));
                            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 0.8f, 0.8f);
                        }
                    } else {
                        headofplayer.sendMessage(text1);
                        invitedplayers.put(headofplayer.getUniqueId(), System.currentTimeMillis() + (10 * 1000));
                        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 0.8f, 0.8f);
                    }
                } else {}
            } catch (ArrayIndexOutOfBoundsException error) {}
        }

        if (event.getView().getTitle().equalsIgnoreCase("blackjack inzet menu")) {
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
            player.openInventory(BlackjackInzetMenu());

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
                    invitems((Player) event.getWhoClicked());
                }
            }
        }

        if (event.getView().getTitle().equalsIgnoreCase("blackjack inzet menu") || (event.getView().getTitle().equalsIgnoreCase("blackjack menu")) || (event.getView().getTitle().equalsIgnoreCase("blackjack invite menu"))) {
            event.setCancelled(true);
        }
    }

    private static ItemStack itemStack(Material material, String displayname) {
        ItemStack itemStack = new ItemStack(material);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(displayname);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

}