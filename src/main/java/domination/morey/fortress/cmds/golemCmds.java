package domination.morey.fortress.cmds;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class golemCmds implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        Player player = (Player) sender;
        if(command.getName().equalsIgnoreCase("golem")) {
            Entity golem = player.getWorld().spawn(player.getLocation(), org.bukkit.entity.IronGolem.class);
            golem.setCustomName("golem1");
            golem.setGlowing(true);
            if(golem.isDead()) {
                Bukkit.broadcastMessage("golem is dead");
            } else {
                Bukkit.broadcastMessage("golem is alive");
            }
        }
        return false;
    }
}
