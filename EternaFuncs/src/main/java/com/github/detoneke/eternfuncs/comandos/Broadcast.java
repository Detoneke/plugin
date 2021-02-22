package com.github.detoneke.eternfuncs.comandos;

import com.github.detoneke.eternfuncs.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Broadcast implements CommandExecutor {

    private Main plugin;

    public Broadcast(Main plugin){
        this.plugin = plugin;
    }

    public Broadcast() {

    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("announce")){
            if (args.length == 0){
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&8[&e&lEF&8] &fCorrect usage: &a/announce <message>"));
            }else if (args.length >= 1){
                String mensaje = "";
                for (String part : args){
                    if (mensaje != "") mensaje += " ";
                    mensaje += part;
                }
                String prefix = plugin.getPluginConfig().getString("announce-prefix");
                Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&',prefix+" "+ mensaje));
            }
        }
        return true;
    }
}
