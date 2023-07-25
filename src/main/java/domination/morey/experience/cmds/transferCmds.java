package domination.morey.experience.cmds;

import domination.morey.main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static domination.morey.main.plugin;
import static org.apache.commons.lang.math.NumberUtils.isNumber;

public class transferCmds implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        Player player = (Player) sender;
        if(s.equals("transfer")) {
            if(args.length == 0) {
                player.sendMessage("§cSélectionnez un montant d'§bÂmes§c à accorder à votre §9Mana§c.");
            } else if(args.length == 1) {
                if(isNumber(args[0])) {
                    int amount = Integer.parseInt(args[0]);
                    if(player.getLevel() < amount) {
                        player.sendMessage("§cVous n'avez pas assez d'§bÂmes§c.");
                        return false;
                    }
                    player.setLevel(player.getLevel() - amount);
                    plugin.getConfig().set(main.manaPath(player), plugin.getConfig().getInt(main.manaPath(player)) + amount);
                    player.sendMessage("§eVous avez transférer §b" + amount + " Âme(s) §een §9Mana§e.");
                } else {
                    player.sendMessage("§cSélectionnez un montant d'§bÂmes§c valide.");
                }
            }
        }
        return false;
    }
}
