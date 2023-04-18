package com.pabro.helpplugin.Managers;

import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class ArmorstandManager {

    public static void BlackjackArmorstand(Player player) {
        ArmorStand armorStand = (ArmorStand) player.getWorld().spawnEntity(player.getLocation(), EntityType.ARMOR_STAND);
        armorStand.setCustomNameVisible(true);
        armorStand.setCustomName("blackjack");
    }

}
