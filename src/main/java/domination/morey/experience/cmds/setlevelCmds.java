package domination.morey.experience.cmds;

import domination.morey.main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static domination.morey.main.plugin;

public class setlevelCmds implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        Player player = (Player) sender;
        if(s.equalsIgnoreCase("setlevel")) {
            if(args.length == 0) {
                player.sendMessage(main.prefix + "Sélectionnez le niveau à prendre.");
            }
            if(args.length == 1) {
                if(isNumber(args[0])) {
                    int amount = Integer.parseInt(args[0]);
                    plugin.getConfig().set(main.levelPath(player), amount);
                    plugin.saveConfig();
                    player.sendMessage(main.prefix + "§eVous êtes maintenant niveau §c" + amount + "§e.");
                } else {
                    player.sendMessage(main.prefix + "Sélectionnez un niveau valide.");
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
