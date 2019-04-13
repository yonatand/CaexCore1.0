package net.ddns.yonatand.core.classes;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class SimpleLocation {

    private String name;
    private String world;
    private double x;
    private double y;
    private double z;

    public SimpleLocation(String name, Location loc){
        this.name=name;
        this.world=loc.getWorld().getName();
        this.x=loc.getX();
        this.y=loc.getY();
        this.z=loc.getZ();
    }

    public SimpleLocation(String name, String worldName, double x, double y, double z){
        this.name=name;
        this.world=worldName;
        this.x=x;
        this.y=y;
        this.z=z;
    }

    @Override
    public String toString() {
        return name+","+world+","+x+","+y+","+z;
    }

    public String getName() {
        return name;
    }

    public String getWorld() {
        return world;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public Location getLoc(){
        return new Location(Bukkit.getWorld(this.world),this.x,this.y,this.z);
    }
}
