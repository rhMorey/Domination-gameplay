package domination.morey.economy.cmds;

import domination.morey.main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static domination.morey.main.plugin;

public class gmoneyCmds implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        Player player = (Player) sender;
        if(s.equalsIgnoreCase("gmoney")) {
            if(args.length == 0) {
                player.sendMessage(main.prefix + "Sélectionnez un montant à donner.");
            }
            if(args.length == 1) {
                if(isNumber(args[0])) {
                    int amount = Integer.parseInt(args[0]);
                    plugin.getConfig().set("eco." + player.getUniqueId() + ".money", plugin.getConfig().getInt("eco." + player.getUniqueId() + ".money") + amount);
                    plugin.saveConfig();
                    player.sendMessage(main.prefix + "Vous avez reçu §a" + amount + "§a Fragment d'émeraude");
                } else {
                    player.sendMessage(main.prefix + "Sélectionnez un montant valide.");
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
