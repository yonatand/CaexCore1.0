package net.ddns.yonatand;

import net.ddns.yonatand.events.BasicEvents;
import net.ddns.yonatand.files.CaexData;
import net.ddns.yonatand.items.SPECIAL_GOLD;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.UUID;

import static net.ddns.yonatand.FindOnlinePlayerUUID.findOnlinePlayerUUID;

public class Main extends JavaPlugin {

    protected static String bPerm="CaexCore.";

    public static CaexData caexData;

    public static YamlConfig ymlConfig = new YamlConfig();

    BasicEvents basicEvents = new BasicEvents();

    @Override
    public void onEnable(){
        if(!getDataFolder().exists())
            getDataFolder().mkdirs();

        this.caexData = new CaexData(this);

        this.ymlConfig.update();

        this.getServer().getPluginManager().registerEvents(basicEvents,this);
        getLogger().info("CaexCore was enabled!");
    }

    @Override
    public void onDisable(){
        caexData.save();
        getLogger().info("CaexCore was disabled =(");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("Tp")) {

            return Tp.tp(sender,cmd,label,args);

        }

        else if(cmd.getName().equalsIgnoreCase("Tphere")){

            return Tphere.tphere(sender,cmd,label,args);

        }

        else if(cmd.getName().equalsIgnoreCase("Gm")){

            return Gm.gm(sender,cmd,label,args);

        }

        else if(cmd.getName().equalsIgnoreCase("setspawn")){

            return Spawn.setspawn(sender,cmd,label,args);

        }

        else if(cmd.getName().equalsIgnoreCase("spawn")){

            return Spawn.spawn(sender,cmd,label,args);

        }

        else if(cmd.getName().equalsIgnoreCase("addwarp")){

            return Warps.addwarpCom(sender,cmd,label,args);

        }

        else if(cmd.getName().equalsIgnoreCase("deletewarp")){

            return Warps.deletewarpCom(sender,cmd,label,args);

        }

        else if(cmd.getName().equalsIgnoreCase("warp")){

            return Warps.warpCom(sender,cmd,label,args);

        }

        else if(cmd.getName().equalsIgnoreCase("tele")){

            return TeleEffect.teleEffect(sender,cmd,label,args);

        }

        else if(cmd.getName().equalsIgnoreCase("giveGold")){

            if(!sender.hasPermission(bPerm+"giveGold"))
                return false;

            try {
                Player ply = (Player) sender;
                int amm = 0;

                if (args.length == 1) {
                    amm = Integer.valueOf(args[0]);
                } else if (args.length > 1) {
                    UUID ply2 = findOnlinePlayerUUID(args[1]);
                    if (ply2 == null) { //if failed
                        sender.sendMessage(ymlConfig.chatName+"the player you are trying to give spacial gold to is not online!");
                        return false;
                    }
                    ply = getServer().getPlayer(ply2);
                    amm = Integer.valueOf(args[0]);
                } else if (args.length == 0) {
                    amm = 1;
                }
                SPECIAL_GOLD gold = new SPECIAL_GOLD();
                gold.giveGold(ply, amm);
                return true;
            }catch(Exception e){
                return false;
            }
        }

        else if(cmd.getName().equalsIgnoreCase("homes")){

            return Home.getHomesCom(sender,cmd,label,args);

        }

        else if(cmd.getName().equalsIgnoreCase("addhome")){

            return Home.addHomeCom(sender,cmd,label,args);

        }

        else if(cmd.getName().equalsIgnoreCase("deletehome")){

            return Home.deleteHomeCom(sender,cmd,label,args);

        }

        else if(cmd.getName().equalsIgnoreCase("home")){

            return Home.homeCom(sender,cmd,label,args);

        }

        return false;
    }



}
