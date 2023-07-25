package domination.morey.experience.leveling;

import domination.morey.main;
import net.md_5.bungee.api.ChatMessageType;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerExpChangeEvent;

import static domination.morey.experience.level.*;
import static domination.morey.main.*;

public class leveling implements Listener {

    public static double multiplier = 2.75;
    @EventHandler
    public void onPlayerGainXP(PlayerExpChangeEvent event) {
        Player player = event.getPlayer();
        int xp = event.getAmount();
        double xpNeed = 500 * multiplier * getLvl(player);
        int xptotal = player.getTotalExperience();
        if(getLvl(player) != 60) {
            if (getXP(player) >= xpNeed) {
                addXP(getXP(player) - getXP(player), player);
                plugin.getConfig().set(xpPath(player), xptotal - (int) xpNeed);
                player.sendMessage("§bNiv sup §e" + (getLvl(player) + 1) + "§b.");
                plugin.getConfig().set(levelPath(player), getLvl(player) + 1);
                xptotal = xptotal - (int) xpNeed;
                plugin.saveConfig();
                if(getLvl(player) == 60) {
                    player.sendMessage("§bVous avez atteint le niveau maximum.");
                }
            } else {
                plugin.getConfig().set(main.xpPath(player), xptotal + xp);
                String message = "§e+" + xp + " §eXP";
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, net.md_5.bungee.api.chat.TextComponent.fromLegacyText(message));
                plugin.saveConfig();
            }
        } else {
            plugin.getConfig().set(main.xpPath(player), xptotal + xp);
            String message = "§e+" + xp + " §eXP";
            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, net.md_5.bungee.api.chat.TextComponent.fromLegacyText(message));
            plugin.saveConfig();
        }
    }
}
