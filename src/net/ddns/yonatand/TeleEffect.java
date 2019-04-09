package net.ddns.yonatand;

import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getServer;

public class TeleEffect {

    public static boolean teleEffect(CommandSender sender, Command cmd, String label, String[] args){
        return teleEffect((Player)sender);
    }

    public static boolean teleEffect(Player player){
        Player ply = player;
        for(Player temp : getServer().getOnlinePlayers()){
            temp.spawnParticle(Particle.END_ROD,ply.getLocation(),50,0,0,0,1);
            //getServer().getWorld(ply.getLocation().getWorld().getName()).strikeLightningEffect(ply.getLocation());
            temp.playSound(ply.getLocation(), Sound.BLOCK_BEACON_POWER_SELECT,3.0F,0.5F);
        }
        return true;
    }

}
