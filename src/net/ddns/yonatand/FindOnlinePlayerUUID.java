package net.ddns.yonatand;

import org.bukkit.entity.Player;
import java.util.UUID;
import static org.bukkit.Bukkit.getServer;

public class FindOnlinePlayerUUID {

    protected static UUID findOnlinePlayerUUID(String ply){
        Player[] plyList = getServer().getOnlinePlayers().toArray(new Player[0]);

        for(Player temp : plyList){
            if(temp.getName().toLowerCase().startsWith(ply.toLowerCase())){
                return temp.getUniqueId();
            }
        }
        return null;
    }

}