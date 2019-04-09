package net.ddns.yonatand.events;

import net.ddns.yonatand.PlayerData;
import net.ddns.yonatand.items.SPECIAL_GOLD;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import static net.ddns.yonatand.Main.ymlConfig;

public class BasicEvents implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        SPECIAL_GOLD gold = new SPECIAL_GOLD();
        Player ply = event.getPlayer();

        if(!PlayerData.playerExists(ply)){

            gold.giveGold(ply,10);
            ply.sendMessage(ymlConfig.chatName+"Welcome, "+ply.getName()+", to the Elixia world!");
            ply.sendMessage(ymlConfig.chatName+"You got 10 Special Gold ingots as starting money.");
            ply.sendMessage(ymlConfig.chatName+"Enjoy your stay!");

            PlayerData.addPlayer(event.getPlayer());

        }else{

            ply.sendMessage(ymlConfig.chatName+"Welcome back "+ply.getName()+"!");

        }

        ply.sendTitle(ChatColor.BOLD+"Welcome, "+ChatColor.DARK_AQUA+ply.getName()+ChatColor.RESET+""+ChatColor.BOLD+"!",ChatColor.BOLD+""+ChatColor.AQUA+"Welcome to Caex-MC!",10,70,20);

    }

}