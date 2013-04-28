package com.tenko;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.plugin.java.JavaPlugin;

import com.tenko.listeners.FCListener;

public class FCReborn extends JavaPlugin {
	
	//Use the force, Luke!
	private Map<String, String> chatters = new HashMap<String, String>();	
	private final FCListener fc = new FCListener();
	private static FCReborn thePlugin;
	
	@Override
	public void onEnable(){
		thePlugin = this;
		getServer().getPluginManager().registerEvents(this.fc, this);
	}
	
	
	public Map<String, String> getChatters(){
		return this.chatters;
	}
	
	public static FCReborn getPlugin(){
		return thePlugin;
	}
}