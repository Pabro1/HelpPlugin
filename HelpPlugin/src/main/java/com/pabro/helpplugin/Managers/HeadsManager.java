package com.pabro.helpplugin.Managers;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.checkerframework.common.aliasing.qual.Unique;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public enum HeadsManager {

    ARROWLEFT ("NTQyZmRlOGI4MmU4YzFiOGMyMmIyMjY3OTk4M2ZlMzVjYjc2YTc5Nzc4NDI5YmRhZGFiYzM5N2ZkMTUwNjEifX19", "arrowleft"),
    ARROWRIGHT ("NDA2MjYyYWYxZDVmNDE0YzU5NzA1NWMyMmUzOWNjZTE0OGU1ZWRiZWM0NTU1OWEyZDZiODhjOGQ2N2I5MmVhNiJ9fX0=", "arrowright"),
    LIMEGLASS ("NTBmNGVmN2Q2YzVkOGRhMzYxODI3NTIyM2JkY2ExNDdjOWNmYWFjNzdkMzdlOGFlODFkNzU3YTU5MzY3NmFjMiJ9fX0=", "limeglass"),
    REDGLASS ("YjI1NGUyNDI2ZDJhY2M4NGM1YzY1ODg2OWE4NmQ3YTFjYzlhNGY2MDQ4NjZhYWU0NjdiNWI0OTY2NTQwNGY1ZCJ9fX0=", "redglass");


    private ItemStack item;
    private String idtag;
    private String prefix = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUv";
    HeadsManager(String texture, String id) {
        item = PluginManager.createSkull(prefix + texture, id);
        idtag = id;
    }


    public ItemStack getItemStack() {
        return item;
    }

    public String getName() {
        return idtag;
    }


    public static List<ItemStack> getPlayerHeads(){
        return Bukkit.getOnlinePlayers().stream().map(p -> getPlayerHead(p)).toList();
    }
    /*public static Player getHeadPlayer(Player player) {
        ItemStack item = new ItemStack(Material.PLAYER_HEAD, 1);
        SkullMeta skull = (SkullMeta) item.getItemMeta();

        skull.setDisplayName(ChatColor.WHITE + player.getName());
        skull.setOwningPlayer(player);
        item.setItemMeta(skull);
        Player skullplayer = (Player) skull.getOwningPlayer();
        return skullplayer;
    }*/
    public static ItemStack getPlayerHead(Player player) {
        ItemStack item = new ItemStack(Material.PLAYER_HEAD, 1);
        SkullMeta skull = (SkullMeta) item.getItemMeta();

        skull.setDisplayName(ChatColor.WHITE + player.getName());
        skull.setOwningPlayer(player);
        item.setItemMeta(skull);
        UUID UUIDofhead = Objects.requireNonNull(skull.getOwningPlayer()).getUniqueId();
        return item;
    }

}
