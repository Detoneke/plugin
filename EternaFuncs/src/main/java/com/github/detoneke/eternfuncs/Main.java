package com.github.detoneke.eternfuncs;

import com.github.detoneke.eternfuncs.comandos.Broadcast;
import com.github.detoneke.eternfuncs.utils.File;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public final class Main extends JavaPlugin {
    PluginDescriptionFile pluginyml = getDescription();
    public String version = pluginyml.getVersion();
    public String nombre = pluginyml.getName();
    public List<String> autor = pluginyml.getAuthors();

    private final File config = new File(this,  "config");

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',"&8[&eEF&8] &aEnabled&f EternFuncs &7[" + version + "]"));
        Bukkit.getConsoleSender().sendMessage("");
        registerCommands();
        getPluginConfig();
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',"&8[&eEF&8] &cDisabled&f EternFuncs &7[" + version + "]"));
        Bukkit.getConsoleSender().sendMessage("");
    }
    public void registerCommands(){
        this.getCommand("announce").setExecutor(new Broadcast());
    }

    public File getPluginConfig(){
        return config;
    }
}