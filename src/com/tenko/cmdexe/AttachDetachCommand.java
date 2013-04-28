package com.tenko.cmdexe;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import com.tenko.FCReborn;

public class AttachDetachCommand {

	public AttachDetachCommand(String cmd, CommandSender cs, String[] args){
		if(cmd.equalsIgnoreCase("attach")){
			ExecuteAttach(cs, args);
		} else if(cmd.equalsIgnoreCase("detach")){
			ExecuteDetach(cs, args);
		} else {
			//This should never be called, but let's just make sure the user knows if we somehow did get here.
			cs.sendMessage(ChatColor.BLUE + "[FCReborn] We're not sure how you got here.");
		}
	}

	/**
	 * Executes the attachment to a player.
	 * @param cs - The CommandSender.
	 * @param args - The player to attach to.
	 */
	public void ExecuteAttach(CommandSender cs, String[] args){
		try {
			//Is the player already in there?
			FCReborn plugin = FCReborn.getPlugin();
			if(plugin.getChatters().containsKey(cs.getName())){
				plugin.getChatters().remove(cs.getName());
			}

			if(Bukkit.getServer().getPlayer(args[0]) != null){
				String plyr = Bukkit.getServer().getPlayer(args[0]).getName();
				//Okay, whose silly enough to do this?
				if(plyr.equalsIgnoreCase(cs.getName())){
					cs.sendMessage(ChatColor.RED + "[FCReborn] You can't attach to yourself!");
					return;
				}
				plugin.getChatters().put(cs.getName(), Bukkit.getServer().getPlayer(args[0]).getName());	
				cs.sendMessage(ChatColor.GREEN + "[FCReborn] Successfully attached to " + plyr);
			} else {
				cs.sendMessage(ChatColor.RED + "[FCReborn] That player is offline!");
			}
		} catch (ArrayIndexOutOfBoundsException e){
			cs.sendMessage(ChatColor.RED + "[FCReborn] Invalid or no player specified!");
		}
	}
	
	/**
	 * Executes the detachment from a player.
	 * @param cs - The CommandSender.
	 * @param args - Not used.
	 */
	public void ExecuteDetach(CommandSender cs, String[] args){
		if(FCReborn.getPlugin().getChatters().containsKey(cs.getName())){
			cs.sendMessage(ChatColor.GREEN + "[FCReborn] Detached from " + FCReborn.getPlugin().getChatters().remove(cs.getName()));
		} else {
			cs.sendMessage(ChatColor.RED + "[FCReborn] You weren't attached to anyone to begin with!");
		}
	}

}
