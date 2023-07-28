package domination.morey.experience.leveling;

import domination.morey.main;
import net.md_5.bungee.api.ChatMessageType;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerExpChangeEvent;

import static domination.morey.experience.level.*;
import static domination.morey.main.*;

public class leveling implements Listener {

    public static double multiplier = 2.75;

    public void lvlUp(Player player) {
        String lvlup = "§7§m⎯⎯⎯⎯⎯⎯⎯⎯§r§7[ §cNiveau supérieur §7]§m⎯⎯⎯⎯⎯⎯⎯⎯\n" +
                " \n" +
                "§bVous êtes maintenant niveau §e" + (getLvl(player)) + "§b.\n" +
                "§7Consultez le livre de l'aventurier pour voir vos récompenses.\n" +
                " \n" +
                "§7§m⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯§r";
        player.sendMessage(lvlup);
        player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_DIDGERIDOO, 1, 1);
    }
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
                plugin.getConfig().set(levelPath(player), getLvl(player) + 1);
                xptotal = xptotal - (int) xpNeed;
                plugin.saveConfig();
                lvlUp(player);
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
