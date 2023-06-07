package domination.morey.team.whichclass;

import domination.morey.main;
import io.lumine.mythic.bukkit.utils.scoreboard.PacketScoreboardTeam;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class classeCmds implements CommandExecutor {

    private PacketScoreboardTeam packet;
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        if(s.equals("classe")) {
            Player player = (Player) sender;
            if(args.length == 0) {
                sender.sendMessage("§cVous devez spécifier une classe.");
                return false;
            }
            if(args.length == 1) {
                switch (args[0]) {
                    case "dps":
                        sender.sendMessage(main.prefix + "§aVous êtes §6DPS§a.");
                        setTabList(player, "§cDPS");
                        break;
                    case "healer":
                        sender.sendMessage(main.prefix + "§aVous êtes §6Healer§a.");
                        setTabList(player, "§aHealer");
                        break;
                    case "tank":
                        sender.sendMessage(main.prefix + "§aVous êtes §6Tank§a.");
                        setTabList(player, "§9Tank");
                        break;
                    case "autofill":
                        sender.sendMessage(main.prefix + "§aVous êtes §6Autofill§a.");
                        setTabList(player, "§7Fill");
                        break;
                }
            }
        }
        return false;
    }

    public void setTabList(Player player, String classe) {
        switch (classe) {
            case "dps":
                player.setPlayerListHeader("§cDPS");
                break;
            case "healer":
                player.setPlayerListName(classe + " " + player.getName());
                break;
            case "tank":
                player.setPlayerListName(classe + " " + player.getName());
                break;
        }
    }
}
