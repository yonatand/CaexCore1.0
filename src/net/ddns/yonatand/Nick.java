package net.ddns.yonatand;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static net.ddns.yonatand.Color.*;
import static net.ddns.yonatand.Main.*;

public class Nick {

    public static boolean nickCom(CommandSender sender, Command cmd, String label, String[] args){

        if(args.length==0){
            sender.sendMessage(ymlConfig.chatName+"your nick is "+updateColor(formatColor((String)caexData.getPlayer((Player)sender,".nick"),"&o")+"&r"));
            return true;
        }

        ((Player)sender).setDisplayName(updateColor(formatColor(args[0],"&o")+"&r"));
        caexData.setPlayer((Player)sender,".nick",formatColor(args[0],"&o")+"&r");
        caexData.save();
        ((Player)sender).setPlayerListName(updateColor((String)caexData.getPlayer(((Player)sender),".nick")));
        return true;

    }

    public static void setNick(Player ply){
        ply.setDisplayName(updateColor(formatColor((String)caexData.getPlayer(ply,".nick"),"&o")+"&r"));
    }

}
