package domination.morey;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class affichage implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        Player player = (Player) sender;
        if(s.equals("aff")) {

            Bukkit.broadcastMessage("§7§m-----------------------------");
            Bukkit.broadcastMessage("§a§ki §6L'équipe §aKiwi §6a gagné ! §a§ki");
            Bukkit.broadcastMessage(" ");
            Bukkit.broadcastMessage("§aScore d'équipe§7: §<score>");
            Bukkit.broadcastMessage("§6MVP: §a<player>");
            Bukkit.broadcastMessage(" ");
            Bukkit.broadcastMessage("§7§m-----------------------------");

        }
        return false;
    }
}
