package net.ddns.yonatand;

import org.bukkit.ChatColor;
import org.bukkit.scoreboard.Scoreboard;
import static org.bukkit.Bukkit.getServer;

public class Group {

    Scoreboard score = getServer().getScoreboardManager().getMainScoreboard();

    public boolean addTeam(String teamName){
        try{

            if(teamExists(teamName)){
                return false;
            }

            score.registerNewTeam(teamName);
            return true;

        }catch(Exception e){
            return false;
        }
    }

    public boolean colorTeam(String teamName, String color, String prefix){
        try{

            score.getTeam(teamName).setColor(ChatColor.valueOf(Color.updateColor(color)));
            score.getTeam(teamName).setPrefix(Color.updateColor(prefix));
            return true;

        }catch(Exception e){
            return false;
        }
    }

    public boolean teamExists(String name){
        return (score.getTeam(name)==null?false:true);
    }

}
