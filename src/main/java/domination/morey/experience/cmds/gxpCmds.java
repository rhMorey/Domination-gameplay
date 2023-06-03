package domination.morey.experience.cmds;

import domination.morey.main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static domination.morey.main.plugin;

public class gxpCmds implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        Player player = (Player) sender;
        if(s.equalsIgnoreCase("gxp")) {
            if(args.length == 0) {
                player.sendMessage(main.prefix + "Sélectionnez un montant d'xp à donner.");
            }
            if(args.length == 1) {
                if(isNumber(args[0])) {
                    int amount = Integer.parseInt(args[0]);
                    plugin.getConfig().set(main.xpPath(player), plugin.getConfig().getInt(main.xpPath(player)) + amount);
                    player.setTotalExperience(plugin.getConfig().getInt(main.xpPath(player)));
                    plugin.saveConfig();
                    player.sendMessage(main.prefix + "§eVous avez reçu " + amount + "§e XP");
                } else {
                    player.sendMessage(main.prefix + "Sélectionnez un montant d'xp valide.");
                }
            }
        }
        return false;
    }

    private boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
