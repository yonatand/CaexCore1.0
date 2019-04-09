package net.ddns.yonatand;

import org.bukkit.entity.Player;
import static net.ddns.yonatand.Main.caexData;

public class PlayerData {

    public static boolean addPlayer(Player ply){

        if(caexData.playerExists(ply))
            return false;

        caexData.setPlayer(ply,".homes", "");
        caexData.save();

        return true;
    }

    public static boolean playerExists(Player ply){
        return caexData.playerExists(ply);
    }





}
