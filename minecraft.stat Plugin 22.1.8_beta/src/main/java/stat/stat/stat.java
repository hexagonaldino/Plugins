package stat.stat;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;


class stat extends JavaPlugin implements Listener
    
{
    public static double HP = 0;
    public static double MP = 0;
    public static double SP = 0;
    public static double ATK = 0;
    public static double DEF = 0;
    public static double EXP = 0;
    public static double LUK = 0;
    public static double AGI = 0;
    public static double LP = 0;

    @Override
    public void onEnable()
    {
        getLogger().info(
                getDescription().getName() + " this has been run  Version : "
                        + getDescription().getVersion());
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd,
                             String commandLabel, String[] args)
    {
        if (commandLabel.equalsIgnoreCase("stat"))
        {
            ((Player) sender).sendMessage(ChatColor.GREEN + "your HP stat is "
                    + ChatColor.RED + (int) HP + ChatColor.GREEN + " MP is "
                    + ChatColor.RED + (int) MP + ChatColor.GREEN + " SP is "
                    + ChatColor.RED + (int) SP + ChatColor.GREEN + " ATK is "
                    + ChatColor.RED + (int) ATK + ChatColor.GREEN + " DEF is "
                    + ChatColor.RED + (int) DEF + ChatColor.GREEN + " EXP is "
                    + ChatColor.RED + (int) EXP + ChatColor.GREEN + " LUK is "
                    + ChatColor.RED + (int) LUK + ChatColor.GREEN + " AGI is "
                    + ChatColor.RED + (int) AGI + ChatColor.AQUA + " You have  "
                    + ChatColor.GRAY + (int) LP + ChatColor.GREEN + "point left");
        }

        return false;
    }

}
