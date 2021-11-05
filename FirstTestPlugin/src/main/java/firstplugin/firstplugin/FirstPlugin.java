package firstplugin.firstplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;


public final class FirstPlugin extends JavaPlugin implements Listener, CommandExecutor {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getCommand("menu").setExecutor(this);

    }


    @EventHandler

    public void PlayerJoin(PlayerJoinEvent join){

        join.setJoinMessage(ChatColor.GRAY+"[+]  "+ChatColor.AQUA+join.getPlayer().getName());
    }




    @EventHandler
    public void PlayerQuit(PlayerQuitEvent quit){
        quit.setQuitMessage(ChatColor.GRAY+"[-]  "+ChatColor.RED+quit.getPlayer().getName());
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        Inventory i = Bukkit.createInventory(null, 54, "menu");
        if(args.length == 0){
            p.openInventory(i);
        }
        return false;
    }
}
