package domination.morey.experience.cmds;

import domination.morey.main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static domination.morey.experience.leveling.leveling.multiplier;
import static domination.morey.experience.level.getLvl;
import static domination.morey.experience.level.getXP;
import static domination.morey.main.plugin;

public class statsCmds implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        Player player = (Player) sender;
        if(s.equals("stats")) {
            if (getLvl(player) != 60) {
                double xpNeed = 500 * multiplier * getLvl(player);
                player.sendMessage("§7§m⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯§r§7[ §6" + player.getName() + " §7]§m⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯§r");
                player.sendMessage("§6Monnaie§7: §a" + plugin.getConfig().get("eco." + player.getUniqueId() + ".money") + "§a Fragment d'émeraude §7(FE)");
                player.sendMessage("§bÂmes§7: §b" + player.getLevel());
                player.sendMessage("§9Mana§7: §9" + plugin.getConfig().get(main.manaPath(player)));
                player.sendMessage("§7§m⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯§r§7[ §cNiveau§7 §c" + getLvl(player) + " §7(§e" + getXP(player) + "§f/§c" + xpNeed + "§7) §7]§m⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯§r");
            } else {
                player.sendMessage("§7§m⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯§r§7[ §6" + player.getName() + " §7]§m⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯§r");
                player.sendMessage("§6Monnaie§7: §a" + plugin.getConfig().get("eco." + player.getUniqueId() + ".money") + "§a Fragment d'émeraude §7(FE)");
                player.sendMessage("§bÂmes§7: §b" + player.getLevel());
                player.sendMessage("§9Mana§7: §9" + plugin.getConfig().get(main.manaPath(player)));
                player.sendMessage("§7§m⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯§r§7[ §cNiveau§7 §c" + getLvl(player) + " §7(§e" + getXP(player) + "§f/§c∞§7) §7]§m⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯§r");
            }
        }
        return false;
    }
}
