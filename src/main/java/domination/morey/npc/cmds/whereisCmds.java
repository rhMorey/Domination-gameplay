package domination.morey.npc.cmds;

import domination.morey.main;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class whereisCmds implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        Player player = (Player) sender;
        if(s.equals("whereis")) {

            TextComponent message = new TextComponent("§7[§8§nVoir la carte§r§7]");
            message.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "http://164.132.202.29:8124"));

            if(args.length == 0) {
                player.sendMessage(main.prefix + "§cVeuillez indiquer un nom de PNJ.");
            }
            if(args.length == 1) {
                switch (args[0]) {
                    case ("doran"):
                        player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL, 1, 1);
                        player.sendMessage("§eDoran se trouve à l'entrée de Versain, à l'ouest de la carte.");
                        player.spigot().sendMessage(message);
                        break;
                }
            }
        }

        return false;
    }
}
