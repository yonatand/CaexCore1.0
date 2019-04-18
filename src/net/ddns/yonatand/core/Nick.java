package net.ddns.yonatand.core;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;

import static net.ddns.yonatand.core.Color.*;
import static net.ddns.yonatand.core.Main.*;

public class Nick {

    public static boolean nickCom(CommandSender sender, Command cmd, String label, String[] args){

        if(args.length==0){
            sender.sendMessage(ymlConfig.chatName+"your nick is "+updateColor(formatColor((String)caexData.getPlayer((Player)sender,".nick"),"&o")+"&r"));
            return true;
        }

        Team team = Group.getPlayerGroup((Player)sender);
        if(team!=null) {
            ((Player)sender).setDisplayName(team.getPrefix()+team.getColor()+ChatColor.ITALIC+args[0]+ChatColor.RESET);
        }else{
            ((Player)sender).setDisplayName(ChatColor.ITALIC+args[0]+ChatColor.RESET);
        }

        caexData.setPlayer((Player)sender,".nick",args[0]);
        caexData.save();
        return true;

    }

    public static boolean resetNick(CommandSender sender, Command cmd, String label, String[] args){

        caexData.setPlayer((Player)sender,".nick","");
        caexData.save();
        Team team = Group.getPlayerGroup((Player)sender);
        if(team!=null) {
            setOnlyTeamPrefix((Player) sender,team );
        }else{
            ((Player)sender).setDisplayName(sender.getName());
        }
        return true;
    }

    public static void setNick(Player ply){
        Team team = Group.getPlayerGroup(ply);
        if(team!=null) {
            if(((String)caexData.getPlayer(ply,".nick")).equals(""))
                setOnlyTeamPrefix(ply,team);
            else
                ply.setDisplayName(team.getPrefix()+team.getColor()+ChatColor.ITALIC+(String)caexData.getPlayer(ply,".nick")+ChatColor.RESET);
        }else{
            if(((String)caexData.getPlayer(ply,".nick")).equals(""))
                ply.setDisplayName(ply.getName()+ChatColor.RESET);
            else
                ply.setDisplayName(ChatColor.ITALIC+(String)caexData.getPlayer(ply,".nick")+ChatColor.RESET);
        }
    }

    public static void setOnlyTeamPrefix(Player ply, Team team){

        ply.setDisplayName(team.getPrefix()+team.getColor()+ply.getName()+ChatColor.RESET);

    }

}
