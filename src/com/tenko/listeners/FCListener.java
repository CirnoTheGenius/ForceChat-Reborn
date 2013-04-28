package com.tenko.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import com.tenko.FCReborn;

public class FCListener implements Listener {
	
	@EventHandler
	public void Chat(AsyncPlayerChatEvent e){
		FCReborn plugin = FCReborn.getPlugin();
		
		if(plugin.getChatters().containsKey(e.getPlayer().getName())){
			Bukkit.getServer().getPlayer(plugin.getChatters().get(e.getPlayer().getName())).chat(e.getMessage());
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void Left(PlayerQuitEvent e){
		FCReborn plugin = FCReborn.getPlugin();

		if(plugin.getChatters().containsKey(e.getPlayer().getName())){
			plugin.getChatters().remove(e.getPlayer().getName());
		}
	}
}
