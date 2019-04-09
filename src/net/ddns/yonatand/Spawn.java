package net.ddns.yonatand;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static net.ddns.yonatand.Main.bPerm;
import static net.ddns.yonatand.Main.caexData;
import static net.ddns.yonatand.Main.ymlConfig;
import static org.bukkit.Bukkit.getServer;

public class Spawn {

    protected static boolean setspawn(CommandSender sender, Command cmd, String label, String[] args){

        if(!sender.hasPermission(bPerm+"setspawn")) { //perm check
            return false;
        }

        caexData.setSpawn(((Player)sender).getLocation());
        sender.sendMessage(ymlConfig.chatName+"The location of spawn is now "+((Player)sender).getLocation().toString());
        caexData.save();
        return true;

    }

    protected static boolean spawn(CommandSender sender, Command cmd, String label, String[] args){

        if(!sender.hasPermission(bPerm+"spawn")) { //perm check
            return false;
        }
        try {
            String sploc = caexData.getSpawn();
            String[] splocParts = sploc.split(",");
            TeleEffect.teleEffect((Player) sender);
            ((Player) sender).teleport(new Location(getServer().getWorld(splocParts[0]), Double.valueOf(splocParts[1]), Double.valueOf(splocParts[2]), Double.valueOf(splocParts[3])));
            TeleEffect.teleEffect((Player) sender);
            sender.sendMessage(ymlConfig.chatName+"teleported you to spawn");
        }catch(Exception e){
            sender.sendMessage(ymlConfig.chatName+"there was a problem locating spawn");
            return false;
        }
        return true;

    }

}
