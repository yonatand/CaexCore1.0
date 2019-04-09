package net.ddns.yonatand.files;

import net.ddns.yonatand.Main;
import net.ddns.yonatand.Warps;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class CaexData extends AbstractFile {

    public CaexData(Main main){
        super(main, "caexdata.yml");
    }

    public String getSpawn(){
        return (String)this.config.get("spawn_location");
    }

    public void setSpawn(Location loc){
        this.config.set("spawn_location",loc.getWorld().getName()+","+loc.getX()+","+loc.getY()+","+loc.getZ());
    }


    public Object getWarp(String at){
        return this.config.get("warps."+at);
    }

    public void setWarp(String at, String warp){
        this.config.set("warps."+at,warp);
    }

    public String warpList(){
        try {
            return String.valueOf(this.config.getConfigurationSection("warps").getKeys(false));
        }catch(Exception e){
            return "";
        }
    }

    public void delwarp(String warp){
        config.getConfigurationSection("warps").set(warp,null);
    }

    public Object getPlayer(Player ply, String at){
        return this.config.get("players."+ply.getUniqueId().toString()+at);
    }

    public void setPlayer(Player ply, String at, String data){
        this.config.set("players."+ply.getUniqueId().toString()+at,data);
    }

    public String getHomesList(Player ply){
        try {
            return String.valueOf(this.config.getConfigurationSection("players."+ply.getUniqueId().toString()+".homes").getKeys(false));
        }catch(Exception e){
            return "";
        }
    }

    public void delhome(Player ply, String name){
        config.getConfigurationSection("players."+ply.getUniqueId().toString()+".homes").set(name,null);
    }

    public boolean playerExists(Player ply){
        return this.config.isSet("players."+ply.getUniqueId().toString());
    }

    public void setConfig(String at, String data){
        this.config.set("config."+at,data);
    }

    public Object getConfig(String at){
        return this.config.get("config."+at);
    }

    public boolean configExists(String at){
        return this.config.isSet("config."+at);
    }


}
