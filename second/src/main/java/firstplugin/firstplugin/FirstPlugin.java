package firstplugin.firstplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Random;


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

    @EventHandler
    public void playerInteractEvent(PlayerInteractEvent e){
        Player p = e.getPlayer();
        if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK &&
                p.getInventory().getItemInMainHand().getType() == Material.CARROT_ON_A_STICK){
            p.setVelocity(p.getLocation().getDirection().setY(1));




        }
    }
}
