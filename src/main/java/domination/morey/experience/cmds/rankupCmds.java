package domination.morey.experience.cmds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static domination.morey.main.plugin;
import static org.apache.commons.lang.math.NumberUtils.isNumber;

public class rankupCmds implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        Player player = (Player) sender;
        if(s.equals("rankup")) {
            if(args.length == 0) {
                player.sendMessage("§cSélectionnez un montant d'xp à accorder à votre niveau.");
            } else if(args.length == 1) {
                if(isNumber(args[0])) {
                    int amount = Integer.parseInt(args[0]);
                    if(player.getLevel() < amount) {
                        player.sendMessage("§cVous n'avez pas assez de niveau(x).");
                        return false;
                    }
                    player.setLevel(player.getLevel() - amount);
                    plugin.getConfig().set("eco." + player.getUniqueId() + ".level", plugin.getConfig().getInt("eco." + player.getUniqueId() + ".level") + amount);
                    player.sendMessage("§eVous avez reçu " + amount + "§e niveau(x).");
                } else {
                    player.sendMessage("§cSélectionnez un montant d'xp valide.");
                }
            }
        }
        return false;
    }
}
