package net.ddns.yonatand.core;

import org.bukkit.entity.Player;
import static net.ddns.yonatand.core.Main.caexData;

public class PlayerData {

    public static boolean addPlayer(Player ply){

        if(caexData.playerExists(ply))
            return false;

        caexData.setPlayer(ply,".homes", "");
        caexData.setPlayer(ply,".nick", "");
        caexData.save();

        return true;
    }

    public static boolean playerExists(Player ply){
        return caexData.playerExists(ply);
    }





}
