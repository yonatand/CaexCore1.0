package net.ddns.yonatand.core;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import static org.bukkit.Bukkit.getServer;

public class Group {

    public static Scoreboard score = getServer().getScoreboardManager().getMainScoreboard();

    public static boolean addTeam(String teamName){
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

    public static boolean prefixTeam(String teamName, String prefix){
        try{

            score.getTeam(teamName).setPrefix(Color.updateColor(prefix));
            return true;

        }catch(Exception e){
            return false;
        }
    }

    public static boolean addPlayerToTeam(Player ply, String teamName){
        try{

            score.getTeam(teamName).addEntry(ply.getName());
            return true;

        }catch(Exception e){
            return false;
        }
    }

    public static Team getPlayerGroup(Player ply){

        Team[] teams = score.getTeams().toArray(new Team[0]);

        for(Team temp : teams){

            if(temp.hasEntry(ply.getName()))
                return temp;

        }
        return null;
    }

    public static boolean teamExists(String name){
        return (score.getTeam(name)==null?false:true);
    }

    public static boolean colorTeam(String teamName, String color){
        try{

            score.getTeam(teamName).setColor(ChatColor.getByChar(Color.updateColor(color)));
            return true;

        }catch(Exception e){
            return false;
        }
    }

    public static boolean removePlayerGroup(Player ply){
        try {
            Team[] teams = score.getTeams().toArray(new Team[0]);

            for (Team temp : teams) {

                if (temp.hasEntry(ply.getName()))
                    temp.removeEntry(ply.getName());

            }
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public static Team getGroup(String name){
        return score.getTeam(name);
    }


}
