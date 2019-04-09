package net.ddns.yonatand.files;

import net.ddns.yonatand.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class AbstractFile {

    protected Main main;
    private File file;
    protected static FileConfiguration config;

    public AbstractFile(Main main, String filename){
        this.main=main;
        this.file=new File(main.getDataFolder(), filename);
        if(!file.exists()){
            try{
                file.createNewFile();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        this.config=YamlConfiguration.loadConfiguration(file);
    }

    public void save(){
        try{
            this.config.save(this.file);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
