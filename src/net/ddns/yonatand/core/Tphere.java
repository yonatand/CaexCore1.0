package net.ddns.yonatand.core;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

import static net.ddns.yonatand.core.FindOnlinePlayerUUID.findOnlinePlayerUUID;
import static net.ddns.yonatand.core.Main.bPerm;
import static net.ddns.yonatand.core.Main.ymlConfig;
import static org.bukkit.Bukkit.getServer;

public class Tphere {

    protected static boolean tphere(CommandSender sender, Command cmd, String label, String[] args){
        if(!sender.hasPermission(bPerm+"Tphere")){ //perm check
            return false;
        }
        else if(!(sender instanceof Player)){ //is player check
            sender.sendMessage(ymlConfig.chatName+"this command will work only on players");
            return false;
        }
        else if(args.length==0){ //command syntax check
            sender.sendMessage(ymlConfig.chatName+"you need to write the username of a player to teleport to you!");
            return false;
        }
        UUID ply2 = findOnlinePlayerUUID(args[0]); //find online player
        if(ply2==null){ //if failed
            sender.sendMessage(ymlConfig.chatName+"the player you are trying to teleport is not online!");
            return false;
        }
        TeleEffect.teleEffect(getServer().getPlayer(ply2));
        getServer().getPlayer(ply2).teleport(((Player) sender));
        TeleEffect.teleEffect(getServer().getPlayer(ply2));
        sender.sendMessage(ChatColor.YELLOW+"whoosh!");
        return true;
    }

}
