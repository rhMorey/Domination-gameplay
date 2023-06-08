package domination.morey.team.whichclass;

import domination.morey.main;
import domination.morey.team.team;
import io.lumine.mythic.bukkit.utils.scoreboard.PacketScoreboardTeam;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.jetbrains.annotations.NotNull;

import java.util.logging.Logger;

import static domination.morey.main.plugin;

public class classeCmds implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        if(s.equals("classe")) {
            Logger logger = plugin.getLogger();
            Player player = (Player) sender;
            if(args.length == 0) {
                sender.sendMessage("§cVous devez spécifier une classe.");
                return false;
            }
            if(args.length == 1) {
                switch (args[0]) {
                    case "dps":
                        sender.sendMessage(main.prefix + "§aVous êtes §6DPS§a.");
                        plugin.getConfig().set("eco." + player.getUniqueId() + ".classe", "dps");
                        logger.info("classe set to dps for " + player.getName() + " / " + player.getUniqueId());
                        plugin.saveConfig();
                        break;
                    case "healer":
                        sender.sendMessage(main.prefix + "§aVous êtes §6Healer§a.");
                        plugin.getConfig().set("eco." + player.getUniqueId() + ".classe", "healer");
                        logger.info("classe set to healer for " + player.getName() + " / " + player.getUniqueId());
                        plugin.saveConfig();
                        break;
                    case "tank":
                        sender.sendMessage(main.prefix + "§aVous êtes §6Tank§a.");
                        plugin.getConfig().set("eco." + player.getUniqueId() + ".classe", "tank");
                        logger.info("classe set to tank for " + player.getName() + " / " + player.getUniqueId());
                        plugin.saveConfig();
                        break;
                    case "autofill":
                        sender.sendMessage(main.prefix + "§aVous êtes §6Autofill§a.");
                        plugin.getConfig().set("eco." + player.getUniqueId() + ".classe", "autofill");
                        logger.info("classe set to autofill for " + player.getName() + " / " + player.getUniqueId());
                        plugin.saveConfig();
                        break;
                    default:
                        sender.sendMessage(main.prefix + "§cVous devez spécifier une classe.");
                        break;
                }
            }
        }
        return false;
    }
}
