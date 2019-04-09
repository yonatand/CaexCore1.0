package net.ddns.yonatand;

import net.ddns.yonatand.classes.SimpleLocation;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.MemorySection;
import org.bukkit.entity.Player;

import static net.ddns.yonatand.Main.*;

public class Home {

        public static boolean getHomesCom(CommandSender sender, Command cmd, String label, String[] args){
            sender.sendMessage(ymlConfig.chatName+"your homes are:");
            String homes=caexData.getHomesList((Player)sender);
            if(homes.equals("")){
                sender.sendMessage("you have no homes.");
                return true;
            }
            sender.sendMessage(homes);
            return true;
        }


        public static boolean addHomeCom(CommandSender sender, Command cmd, String label, String[] args){

            if(!sender.hasPermission(bPerm+"addhome")) {
                return true;
            }

            if(!(homesArr((Player)sender).length<3)){
                sender.sendMessage(ymlConfig.chatName+"you can't have more then 3 homes!");
                return true;
            }

            if(args.length==0){
                sender.sendMessage(ymlConfig.chatName+"you need to add a name to the home!");
                return false;
            }


            if (homeEx((Player)sender,args[0])) {
                sender.sendMessage(ymlConfig.chatName+"this home already exists!");
                return false;
            }

            return addhome((Player)sender, new SimpleLocation(args[0],((Player)sender).getLocation()));

        }


        public static boolean deleteHomeCom(CommandSender sender, Command cmd, String label, String[] args){

            if(!sender.hasPermission(bPerm+"delhome")) {
                return true;
            }

            if(args.length==0){
                sender.sendMessage(ymlConfig.chatName+"you need to add a name to the home you want to delete!");
                return false;
            }

            if(homesArr((Player)sender).length==0){
                sender.sendMessage(ymlConfig.chatName+"you have no homes to delete!");
                return false;
            }

            if(delhome((Player)sender,args[0])){
                sender.sendMessage(ymlConfig.chatName+"deleted home "+args[0]);
                return true;
            }else{
                sender.sendMessage(ymlConfig.chatName+"something went wrong!");
                return false;
            }

        }


        public static boolean homeCom(CommandSender sender, Command cmd, String label, String[] args){

            SimpleLocation home;

            if(!sender.hasPermission(bPerm+"home")) {
                return true;
            }

            if(homesArr((Player)sender).length==0){
                sender.sendMessage(ymlConfig.chatName+"you don't have any homes!");
                sender.sendMessage(ymlConfig.chatName+"please use /addhome [name] to add a home.");
            }


            if(args.length==0 && homesArr((Player)sender).length==1) {
                telehome((Player)sender,homesArr((Player) sender)[0]);
                sender.sendMessage(ChatColor.YELLOW+"woosh!");
                return true;
            }

            if(args.length==0){
                sender.sendMessage(ymlConfig.chatName+"please enter a home name.");
                return false;
            }

            if(homeEx((Player)sender,args[0])){
                telehome((Player)sender,args[0]);
                sender.sendMessage(ChatColor.YELLOW+"woosh!");
                return true;
            }
            else{
                sender.sendMessage(ymlConfig.chatName+"this home doesn't exists.");
                return false;
            }

        }


        private static boolean telehome(Player ply, String name){
            try {
                TeleEffect.teleEffect(ply);
                ply.teleport(getHome(ply, name).getLoc());
                TeleEffect.teleEffect(ply);
                return true;
            }catch(Exception e){
                return false;
            }

        }



        private static boolean addhome(Player ply, SimpleLocation loc){
            try{

                caexData.setPlayer(ply,".homes."+loc.getName()+".world",loc.getWorld());
                caexData.setPlayer(ply,".homes."+loc.getName()+".x",Double.toString(loc.getX()));
                caexData.setPlayer(ply,".homes."+loc.getName()+".y",Double.toString(loc.getY()));
                caexData.setPlayer(ply,".homes."+loc.getName()+".z",Double.toString(loc.getZ()));

                caexData.save();

                return true;

            }catch(Exception e){
                return false;
            }
        }

        private static boolean delhome(Player ply, String name){
            try{

                caexData.delhome(ply,name);
                caexData.save();
                return true;

            }catch(Exception e){
                return false;
            }
        }


        public static String[] homesArr(Player ply){

            if(caexData.getHomesList(ply).equals(""))
                return new String[0];
            String list = caexData.getHomesList(ply);
            list=list.replaceAll("\\s+","");

            StringBuilder list2 = new StringBuilder(list);

            list2.deleteCharAt(list2.length()-1);
            list2.deleteCharAt(0);

            list=list2.toString();

            String[] arr = list.split(",");
            return arr;

        }

        public static boolean homeEx(Player ply, String name){

            String[] homes = homesArr(ply);

            for(String var : homes){
                if(var.equals(name))
                    return true;
            }

            return false;

        }

        public static SimpleLocation getHome(Player ply, String name){

            String[] homes = homesArr(ply);

            String home="";

            for(String var : homes){
                if(var.equals(name))
                    home=var;
            }

            if(home.equals(""))
                return null;

            return new SimpleLocation(home,(String)caexData.getPlayer(ply,".homes."+home+".world"),Double.valueOf((String)caexData.getPlayer(ply,".homes."+home+".x")),Double.valueOf((String)caexData.getPlayer(ply,".homes."+home+".y")),Double.valueOf((String)caexData.getPlayer(ply,".homes."+home+".z")));


        }

}
