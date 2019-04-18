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

public class Tp {

    protected static boolean tp(CommandSender sender, Command cmd, String label, String[] args){
        if(!sender.hasPermission(bPerm+"tp")){ //perm check
            return false;
        }
        else if(!(sender instanceof Player)){ //is player check
            sender.sendMessage(ymlConfig.chatName+"this command will work only on players");
            return false;
        }
        else if(args.length==0){ //command syntax check
            sender.sendMessage(ymlConfig.chatName+"you need to write the username of a player to teleport to!");
            return false;
        }
        UUID ply2 = findOnlinePlayerUUID(args[0]); //find online player
        if(ply2==null){ //if failed
            sender.sendMessage(ymlConfig.chatName+"the player you are trying to teleport to is not online!");
            return false;
        }
        TeleEffect.teleEffect((Player) sender);
        ((Player) sender).teleport(getServer().getPlayer(ply2));
        TeleEffect.teleEffect((Player) sender);
        sender.sendMessage(ChatColor.YELLOW+"whoosh!");
        return true;
    }


}
