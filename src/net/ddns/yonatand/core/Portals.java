package net.ddns.yonatand.core;

import net.ddns.yonatand.core.classes.SimpleLocation;
import org.bukkit.Axis;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Rotation;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Orientable;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getServer;

public class Portals {

    public static boolean addPortalCom(CommandSender sender, Command cmd, String label, String[] args){

        addPortal((Player)sender);
        return true;

    }

    public static boolean removePortalCom(CommandSender sender, Command cmd, String label, String[] args){
        return false;
    }


    private static void addPortal(Player ply){
        boolean side = playerOr(ply);

        Location blockLoc = ply.getTargetBlockExact(5).getLocation();

        Block b1 = getServer().getWorld(ply.getLocation().getWorld().getName()).getBlockAt(blockLoc.add(0,2,0));

        Orientable o1 = ((Orientable)Material.NETHER_PORTAL.createBlockData());
        if(side)
            o1.setAxis(Axis.Z);
        else
            o1.setAxis(Axis.X);
        b1.setType(Material.NETHER_PORTAL);
        b1.setBlockData((BlockData)o1);

        Block b2 =getServer().getWorld(ply.getLocation().getWorld().getName()).getBlockAt(blockLoc.add(0,-1,0));

        Orientable o2 = ((Orientable)Material.NETHER_PORTAL.createBlockData());
        if(side)
            o2.setAxis(Axis.Z);
        else
            o2.setAxis(Axis.X);
        b2.setType(Material.NETHER_PORTAL);
        b2.setBlockData((BlockData)o1);

    }

    private static boolean playerOr(Player ply){

        double yaw = ply.getLocation().getYaw();

        if((yaw>315 && yaw<45) || (yaw<225 && yaw>135)) {
            ply.sendMessage(Double.toString(yaw));
            return false;
        }
        else
            return true;

    }

}
