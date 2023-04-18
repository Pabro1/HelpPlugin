package com.pabro.helpplugin.Managers;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import com.pabro.helpplugin.HelpPlugin;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.RegisteredServiceProvider;

import java.lang.reflect.Field;
import java.util.UUID;

import static org.bukkit.Bukkit.getServer;

public class PluginManager {

    public static Economy getEconomy() {
        return econ;
    }
    private static Economy econ = null;
    public static HelpPlugin plugin;

    public static ItemStack itemStack(Material material, String displayname) {
        ItemStack itemStack = new ItemStack(material);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(displayname);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public static ItemStack getheads(ItemStack itemstack, String displayname) {
        ItemStack itemStack = new ItemStack(itemstack);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(displayname);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public static ItemStack getHead(String name) {
        for (HeadsManager head : HeadsManager.values()) {
            if (head.getName().equalsIgnoreCase(name)) {
                return head.getItemStack();
            }
        }
        return null;
    }
    public static ItemStack createSkull(String url, String name)  {
        ItemStack head = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (short)3);
        if (url.isEmpty()) {
            return head;
        }
        SkullMeta headMeta = (SkullMeta) head.getItemMeta();
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        profile.getProperties().put("textures", new Property("textures", url));

        try {
            Field profilefield = headMeta.getClass().getDeclaredField("profile");
            profilefield.setAccessible(true);
            profilefield.set(headMeta, profile);
        } catch (NoSuchFieldException|IllegalArgumentException|IllegalAccessException error) {
            error.printStackTrace();
        }

        head.setItemMeta(headMeta);

        return head;
    }

    public static boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }


}
