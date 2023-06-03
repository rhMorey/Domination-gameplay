package domination.morey.experience.cmds;

import domination.morey.main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static domination.morey.main.plugin;

public class statsCmds implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        Player player = (Player) sender;
        if(s.equals("stats")) {
            player.sendMessage("§7§m-----------§r§7[ §6" + player.getName() + " §7]§m-----------§r");
            player.sendMessage("§6Monnaie§7: §a" + plugin.getConfig().get("eco." + player.getUniqueId() + ".money") + "§a Fragment d'émeraude §7(FE)");
            player.sendMessage("§eExperience§7: §e" + plugin.getConfig().get(main.xpPath(player)) + "§e XP");
            player.sendMessage("§bÂmes§7: §b" + player.getLevel());
            player.sendMessage("§9Mana§7: §9" + plugin.getConfig().get(main.manaPath(player)));
        }
        return false;
    }
}
