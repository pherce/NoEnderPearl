package me.pherce.NoEnderPearl;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class NoEnderPearl extends JavaPlugin implements Listener {
	
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }
    
    public void onDisable() {
        System.out.println("NoEnderPearl disabled");
    }
	
	@EventHandler
	public void interact (PlayerTeleportEvent e){
		Player player = e.getPlayer();
		if(e.getPlayer().getItemInHand().getType() == Material.ENDER_PEARL && player.hasPermission("enderpearl.grant")){
		e.setCancelled(false);
		}else{
			e.setCancelled(true);
			player.sendMessage(ChatColor.RED.toString()+"No ender pearls here, fuckface!");
		}
	}
}
