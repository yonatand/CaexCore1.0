package net.ddns.yonatand;

import org.bukkit.ChatColor;

public class Color {

    public static String updateColor(String in){

        String colorF = in;

        colorF= colorF.replaceAll("&1",ChatColor.DARK_BLUE.toString());
        colorF= colorF.replaceAll("&2",ChatColor.DARK_GREEN.toString());
        colorF= colorF.replaceAll("&3",ChatColor.DARK_AQUA.toString());
        colorF= colorF.replaceAll("&4",ChatColor.DARK_RED.toString());
        colorF= colorF.replaceAll("&5",ChatColor.DARK_PURPLE.toString());
        colorF= colorF.replaceAll("&6",ChatColor.GOLD.toString());
        colorF= colorF.replaceAll("&7",ChatColor.GRAY.toString());
        colorF= colorF.replaceAll("&8",ChatColor.DARK_GRAY.toString());
        colorF= colorF.replaceAll("&9",ChatColor.BLUE.toString());
        colorF= colorF.replaceAll("&a",ChatColor.GREEN.toString());
        colorF= colorF.replaceAll("&b",ChatColor.AQUA.toString());
        colorF= colorF.replaceAll("&c",ChatColor.RED.toString());
        colorF= colorF.replaceAll("&d",ChatColor.LIGHT_PURPLE.toString());
        colorF= colorF.replaceAll("&e",ChatColor.YELLOW.toString());
        colorF= colorF.replaceAll("&f",ChatColor.WHITE.toString());
        colorF= colorF.replaceAll("&0",ChatColor.BLACK.toString());
        colorF= colorF.replaceAll("&l",ChatColor.BOLD.toString());
        colorF= colorF.replaceAll("&m",ChatColor.STRIKETHROUGH.toString());
        colorF= colorF.replaceAll("&n",ChatColor.UNDERLINE.toString());
        colorF= colorF.replaceAll("&o",ChatColor.ITALIC.toString());
        colorF= colorF.replaceAll("&r",ChatColor.RESET.toString());
        colorF= colorF.replaceAll("&k",ChatColor.MAGIC.toString());

        return colorF;
    }

    public static String formatColor(String in, String format){

        String colorF = in;

        colorF= colorF.replaceAll("&1","&1"+format);
        colorF= colorF.replaceAll("&2","&2"+format);
        colorF= colorF.replaceAll("&3","&3"+format);
        colorF= colorF.replaceAll("&4","&4"+format);
        colorF= colorF.replaceAll("&5","&5"+format);
        colorF= colorF.replaceAll("&6","&6"+format);
        colorF= colorF.replaceAll("&7","&7"+format);
        colorF= colorF.replaceAll("&8","&8"+format);
        colorF= colorF.replaceAll("&9","&9"+format);
        colorF= colorF.replaceAll("&a","&a"+format);
        colorF= colorF.replaceAll("&b","&b"+format);
        colorF= colorF.replaceAll("&c","&c"+format);
        colorF= colorF.replaceAll("&d","&d"+format);
        colorF= colorF.replaceAll("&e","&e"+format);
        colorF= colorF.replaceAll("&f","&f"+format);
        colorF= colorF.replaceAll("&0","&0"+format);
        colorF= colorF.replaceAll("&l","&l"+format);
        colorF= colorF.replaceAll("&m","&m"+format);
        colorF= colorF.replaceAll("&n","&n"+format);
        colorF= colorF.replaceAll("&o","&o"+format);
        colorF= colorF.replaceAll("&r","&r"+format);
        colorF= colorF.replaceAll("&k","&k"+format);

        return colorF;
    }

}
