package com.pabro.helpplugin.Managers;

import com.pabro.helpplugin.HelpPlugin;
import com.pabro.helpplugin.commands.SlotsCommand;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.Random;

import static com.pabro.helpplugin.Inventories.SlotsInventory.*;

public class InventoryManager {
    
    static Random random = new Random();
    
    /*public static Inventory invslotmachineitems(Player player) {
        invslotmachine.clear();
        player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 0.8f, 1f);

        invslotmachine.setItem(0, coloritems.get(random.nextInt(coloritems.size())));
        invslotmachine.setItem(1, coloritems.get(random.nextInt(coloritems.size())));
        invslotmachine.setItem(2, coloritems.get(random.nextInt(coloritems.size())));
        invslotmachine.setItem(3, coloritems.get(random.nextInt(coloritems.size())));
        invslotmachine.setItem(4, coloritems.get(random.nextInt(coloritems.size())));
        invslotmachine.setItem(5, coloritems.get(random.nextInt(coloritems.size())));
        invslotmachine.setItem(6, coloritems.get(random.nextInt(coloritems.size())));
        invslotmachine.setItem(7, coloritems.get(random.nextInt(coloritems.size())));
        invslotmachine.setItem(8, coloritems.get(random.nextInt(coloritems.size())));
        invslotmachine.setItem(9, coloritems.get(random.nextInt(coloritems.size())));
        invslotmachine.setItem(17, coloritems.get(random.nextInt(coloritems.size())));
        invslotmachine.setItem(18, coloritems.get(random.nextInt(coloritems.size())));
        invslotmachine.setItem(26, coloritems.get(random.nextInt(coloritems.size())));
        invslotmachine.setItem(27, coloritems.get(random.nextInt(coloritems.size())));
        invslotmachine.setItem(35, coloritems.get(random.nextInt(coloritems.size())));
        invslotmachine.setItem(36, coloritems.get(random.nextInt(coloritems.size())));
        invslotmachine.setItem(37, coloritems.get(random.nextInt(coloritems.size())));
        invslotmachine.setItem(38, coloritems.get(random.nextInt(coloritems.size())));
        invslotmachine.setItem(39, coloritems.get(random.nextInt(coloritems.size())));
        invslotmachine.setItem(40, coloritems.get(random.nextInt(coloritems.size())));
        invslotmachine.setItem(41, coloritems.get(random.nextInt(coloritems.size())));
        invslotmachine.setItem(42, coloritems.get(random.nextInt(coloritems.size())));
        invslotmachine.setItem(43, coloritems.get(random.nextInt(coloritems.size())));
        invslotmachine.setItem(44, coloritems.get(random.nextInt(coloritems.size())));

        invslotmachine.setItem(21, slotsitems.get(random.nextInt(slotsitems.size())));
        invslotmachine.setItem(22, slotsitems.get(random.nextInt(slotsitems.size())));
        invslotmachine.setItem(23, slotsitems.get(random.nextInt(slotsitems.size())));

        return invslotmachineitems(player);
    }*/



}
