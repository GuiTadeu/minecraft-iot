package br.com.mineqtt;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable(){
        this.getServer().getPluginManager().registerEvents(new LeverClick(), this);
    }

}
