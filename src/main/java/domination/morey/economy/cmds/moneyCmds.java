package domination.morey.economy.cmds;

import domination.morey.main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static domination.morey.main.plugin;

public class moneyCmds implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        Player player = (Player) sender;
        if(s.equalsIgnoreCase("money")) {
            player.sendMessage("§6Monnaie§7: §a" + plugin.getConfig().get("eco." + player.getUniqueId() + ".money") + "§a Fragment d'émeraude §7(FE)");
        }
        return false;
    }
}
