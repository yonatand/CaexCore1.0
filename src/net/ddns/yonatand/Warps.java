package net.ddns.yonatand;

import net.ddns.yonatand.classes.SimpleLocation;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.MemorySection;
import org.bukkit.entity.Player;

import java.util.Arrays;

import static net.ddns.yonatand.Main.bPerm;
import static net.ddns.yonatand.Main.caexData;
import static net.ddns.yonatand.Main.ymlConfig;
import static org.bukkit.Bukkit.getServer;


public class Warps {


    public static boolean addwarpCom(CommandSender sender, Command cmd, String label, String[] args){

        if(!(sender instanceof Player)){

            sender.sendMessage(ymlConfig.chatName+"addwarp works only on players!");
            return false;

        }

        if(!sender.hasPermission(bPerm+"addwarp")){
            return false;
        }

        else if(args.length==0){
            sender.sendMessage(ymlConfig.chatName+"you need to write a name for the warp");
            return false;
        }

        if(addwarp(new SimpleLocation(args[0],((Player)sender).getLocation()))){
            sender.sendMessage(ymlConfig.chatName+"created a warp successful");
            return true;
        }else{
            sender.sendMessage(ymlConfig.chatName+"oof (contact yonatand [Atomic Cookie])");
        }
        return false;


    }

    public static boolean deletewarpCom(CommandSender sender, Command cmd, String label, String[] args){

        if(!sender.hasPermission(bPerm+"deletewarp")){
            return false;
        }

        else if(args.length==0){
            sender.sendMessage(ymlConfig.chatName+"you need to write a name for the warp");
            return false;
        }

        return diswarp(args[0]);

    }

    public static boolean warpCom(CommandSender sender, Command cmd, String label, String[] args){

        if(args.length==0) {
            if(getwarpnames().equals("")) {
                sender.sendMessage(ymlConfig.chatName + "there are no warps on this server.");
            }else{
                sender.sendMessage(ChatColor.YELLOW + getwarpnames());
            }
            return false;
        }

        if(!(sender instanceof Player)){

            sender.sendMessage(ymlConfig.chatName+"warp works only on players!");
            return false;

        }

        SimpleLocation warp = getWarp(args[0]);
        if(warp==null){
            sender.sendMessage(ymlConfig.chatName+"this warp does not exists.");
            sender.sendMessage(getwarpnames());
            return false;
        }

        if(!sender.hasPermission(bPerm+"warp."+args[0])){
            sender.sendMessage(ymlConfig.chatName+"you don't have permissions to go there!");
            return false;
        }
        TeleEffect.teleEffect((Player) sender);
        ((Player) sender).teleport(getWarp(args[0]).getLoc());
        sender.sendMessage(ChatColor.YELLOW+"whoosh!");
        TeleEffect.teleEffect((Player) sender);

        return true;

    }



    public static boolean addwarp(SimpleLocation warp){

        if(warpReal(warp.getName())){
            return false;
        }

        try {

            caexData.setWarp(warp.getName() + ".world", warp.getWorld());
            caexData.setWarp(warp.getName() + ".x", Double.toString(warp.getX()));
            caexData.setWarp(warp.getName() + ".y", Double.toString(warp.getY()));
            caexData.setWarp(warp.getName() + ".z", Double.toString(warp.getZ()));
            caexData.save();

            return true;

        }catch(Exception e){

            return false;

        }
    }


    public static boolean diswarp(String name){

        if(!warpReal(name)){
            return false;
        }

        try {

            caexData.delwarp(name);
            caexData.save();

            return true;

        }catch(Exception e){

            return false;

        }

    }

    public static String getwarpnames(){

        String ans = caexData.warpList();
        if(ans.equals(""))
            return "";
        StringBuilder ans2 = new StringBuilder(ans);

        ans2.deleteCharAt(ans.length()-1);
        ans2.deleteCharAt(0);

        ans=ans2.toString();
        ans=ans.replaceAll("\\s+","");

        String[] arr = ans.split(",");

        ans="";
        //ans=Arrays.toString(arr);
        for(String var : arr){
                ans+=var+", ";
        }

        ans2 = new StringBuilder(ans);

        ans2.deleteCharAt(ans.length()-1);
        ans2.deleteCharAt(ans.length()-2);

        ans=ans2.toString();

        return ans;

    }

    public static SimpleLocation getWarp(String in){

        if(!warpReal(in)){
            return null;
        }

        String name="";

        if(getwarpnames().equals(""))
            return null;
        String list = getwarpnames();
        list=list.replaceAll("\\s+","");

        String[] arr = list.split(",");

        for(String var : arr){
            if(var.equals(in))
                name=var;
        }


        return new SimpleLocation(name,(String)caexData.getWarp(name+".world"),Double.valueOf((String)caexData.getWarp(name+".x")),Double.valueOf((String)caexData.getWarp(name+".y")),Double.valueOf((String)caexData.getWarp(name+".z")));

    }

    public static boolean warpReal(String name){

        if(name.length()==0)
            return false;
        if(getwarpnames().equals(""))
            return false;
        String list = getwarpnames();
        list=list.replaceAll("\\s+","");

        String[] arr = list.split(",");

        for(String var : arr){
            if(var.equals(name))
                return true;
        }

        return false;
    }


}
