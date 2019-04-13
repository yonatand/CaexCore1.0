package net.ddns.yonatand.core;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static net.ddns.yonatand.core.FindOnlinePlayerUUID.findOnlinePlayerUUID;
import static net.ddns.yonatand.core.Main.bPerm;
import static net.ddns.yonatand.core.Main.ymlConfig;
import static org.bukkit.Bukkit.getServer;

public class Gm {

    protected static boolean gm(CommandSender sender, Command cmd, String label, String[] args){

        if(args.length==0){ //syntax check
            sender.sendMessage(ymlConfig.chatName+"the command was not used correctly");
            return false;
        }

        else if(!(sender instanceof Player)){ //is player check
            sender.sendMessage(ymlConfig.chatName+"this command will work only on players");
            return false;
        }


        Player ply2;

        if(args.length==1) { //syntax self Gm check
            ply2=((Player) sender);
        }
        else{
            ply2=getServer().getPlayer(findOnlinePlayerUUID(args[1]));
        }

        if(args[0].equals("1") || args[0].equalsIgnoreCase("creative")){ //if sets self to creative

            if(sender.hasPermission(bPerm+"Gm.creative")){ //has perm check

                ply2.setGameMode(GameMode.CREATIVE); //change gamemode
                sender.sendMessage(ymlConfig.chatName+"changed "+ply2.getName()+"'s gamemode to creative");
                return true;

            }

        }
         else if(args[0].equals("0") || args[0].equalsIgnoreCase("survival")){ //if sets self to survival

            if(sender.hasPermission(bPerm+"Gm.survival")){ //has perm check

                ply2.setGameMode(GameMode.SURVIVAL); //change gamemode
                sender.sendMessage(ymlConfig.chatName+"changed "+ply2.getName()+"'s gamemode to survival");
                return true;

            }

         }
         else if(args[0].equals("2") || args[0].equalsIgnoreCase("adventure")){ //if sets self to adventure

            if(sender.hasPermission(bPerm+"Gm.adventure")){ //has perm check

                ply2.setGameMode(GameMode.ADVENTURE); //change gamemode
                sender.sendMessage(ymlConfig.chatName+"changed "+ply2.getName()+"'s gamemode to adventure");
                return true;

            }

         }
         else if(args[0].equals("3") || args[0].equalsIgnoreCase("spectator")){ //if sets self to spectator

            if(sender.hasPermission(bPerm+"Gm.spectator")){ //has perm check

                ply2.setGameMode(GameMode.SPECTATOR); //change gamemode
                sender.sendMessage(ymlConfig.chatName+"changed "+ply2.getName()+"'s gamemode to spectator");
                return true;

            }

         }



        return false;

    }

}
