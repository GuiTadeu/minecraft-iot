package br.com.mineqtt;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class LeverClick implements Listener {

    boolean isOn = false;

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event){
        if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK)
                && event.getClickedBlock().getType().equals(Material.LEVER)){
            isOn = !isOn;
            ClientMQTT.publish(isOn ? "on" : "off");
        }
    }
}
