package com.tenko.cmdexe;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import com.tenko.FCReborn;

//No, this isn't the opposite of CommandExe...
public class ExeCommand implements CommandExe {

	public ExeCommand(CommandSender cs, String[] args){
		Execute(cs, args);
	}

	@Override
	public void Execute(CommandSender cs, String[] args){
		try {
			if(!FCReborn.getPlugin().getChatters().containsKey(cs.getName())){
				cs.sendMessage(ChatColor.RED + "[FCReborn] You aren't attached to anyone!");
				return;
			}

			StringBuilder cmd = new StringBuilder();

			for(String s: args){
				cmd.append(s);
				cmd.append(" ");
			}

			Bukkit.getServer().dispatchCommand(
					Bukkit.getServer().getPlayer(FCReborn.getPlugin().getChatters().get(cs.getName())),
					cmd.toString()
					);
			cs.sendMessage(ChatColor.GREEN + "[FCReborn] Successfully forced command execution!");
		} catch (ArrayIndexOutOfBoundsException e){
			cs.sendMessage(ChatColor.RED + "[FCReborn] Invalid or no player specified!");
		}
	}
}

