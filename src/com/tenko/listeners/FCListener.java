package com.tenko.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.tenko.FCReborn;

public class FCListener implements Listener {
	
	private final FCReborn plugin = FCReborn.getPlugin();
	
	@EventHandler
	public void Chat(AsyncPlayerChatEvent e){
		if(this.plugin.getChatters().containsKey(e.getPlayer())){
			Bukkit.getServer().getPlayer(this.plugin.getChatters().get(e.getPlayer())).chat(e.getMessage());
			e.setCancelled(true);
		}
	}
}
