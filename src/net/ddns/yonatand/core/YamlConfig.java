package net.ddns.yonatand.core;

import static net.ddns.yonatand.core.Main.caexData;

public class YamlConfig {

    public static String chatName="<CaexCore> ";

    protected static void update(){

        if(caexData.configExists("chatName")){
            if(((String)caexData.getConfig("chatName")).equals("")){
                caexData.setConfig("chatName",chatName);
            }
            else{
                String name = (String)caexData.getConfig("chatName");
                if(name.charAt(name.length()-1)==' ')
                    chatName=Color.updateColor(name);
                else
                    chatName=Color.updateColor(name)+" ";
            }
        }
        else{
            caexData.setConfig("chatName",chatName);
        }

        caexData.save();
    }

}
