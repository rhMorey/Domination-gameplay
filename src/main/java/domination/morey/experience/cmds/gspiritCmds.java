package domination.morey.experience.cmds;

import domination.morey.main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class gspiritCmds implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        Player player = (Player) sender;
        if(s.equalsIgnoreCase("gspirit")) {
            if(args.length == 0) {
                player.sendMessage(main.prefix + "Sélectionnez un montant d'§bâmes§c à donner.");
            }
            if(args.length == 1) {
                if(isNumber(args[0])) {
                    int amount = Integer.parseInt(args[0]);
                    player.setLevel(player.getLevel() + amount);
                    player.sendMessage(main.prefix + "§eVous avez reçu §b" + amount + " Âmes§e.");
                } else {
                    player.sendMessage(main.prefix + "Sélectionnez un montant d'§bâmes§c valide.");
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
