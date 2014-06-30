package com.core.thewolfbadger.preventors;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: MayoDwarf
 * Date: 6/8/14
 * Time: 2:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main extends JavaPlugin implements Listener {
    private FileConfiguration config;
    @Override
    public void onEnable() {
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        this.getServer().getPluginManager().registerEvents(this, this);
    }
    @Override
    public void onDisable() {}
    @EventHandler
    public void onDrop(PlayerDropItemEvent evt) {
        Player p = evt.getPlayer();
        Material m = evt.getItemDrop().getItemStack().getType();
        if(getConfig().contains("Lists.PreventDropsOf")) {
        List<String> materials = (List<String>) getConfig().getList("Lists.PreventDropsOf");
        for(String mat : materials) {
            if(mat.equals(m.toString())) {
                evt.setCancelled(true);
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("Messages.PreventDropMessage")));
                break;
                }
            }
        }
    }
    @EventHandler
    public void onPickup(PlayerPickupItemEvent evt) {
        Player p = evt.getPlayer();
        Material m = evt.getItem().getItemStack().getType();
        if(getConfig().contains("Lists.PreventPickupsOf")) {
            List<String> materials = (List<String>) getConfig().getList("Lists.PreventPickupsOf");
            for(String mat : materials) {
                if(mat.equals(m.toString())) {
                    evt.setCancelled(true);
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("Messages.PreventPickupsMessage")));
                    evt.getItem().remove();
                    break;
                }
            }
        }
    }
}
