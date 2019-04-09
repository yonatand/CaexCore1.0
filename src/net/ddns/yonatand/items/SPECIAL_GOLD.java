package net.ddns.yonatand.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class SPECIAL_GOLD implements Listener {


    public static ItemStack sGold(){

        ItemStack item = new ItemStack(Material.GOLD_INGOT,1);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(ChatColor.GOLD+"Special Gold");
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(ChatColor.LIGHT_PURPLE+"Used for payments in Elixia");
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(meta);



        return item;

    }


    public static void giveGold(Player player, int am){

        ItemStack item = sGold();
        item.setAmount(am);

        player.getInventory().addItem(item);

    }



}
