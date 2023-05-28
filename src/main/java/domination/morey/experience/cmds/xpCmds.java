package domination.morey.experience.cmds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static domination.morey.main.plugin;

public class xpCmds implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        Player player = (Player) sender;
        if(s.equalsIgnoreCase("xp")) {
            player.sendMessage("§eExperience§7: §e" + plugin.getConfig().get("eco." + player.getUniqueId() + ".xp") + "§e XP");
        }
        return false;
    }
}
