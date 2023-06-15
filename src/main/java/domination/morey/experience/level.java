package domination.morey.experience;

import domination.morey.main;
import net.md_5.bungee.api.ChatMessageType;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerExpChangeEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.logging.Logger;

import static domination.morey.main.plugin;

public class level implements Listener {

    level manage;

    public level() {
        manage = this;
    }

    @EventHandler
    public void onConnect(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Logger logger = plugin.getLogger();
        if (plugin.getConfig().get(main.xpPath(player)) == null || plugin.getConfig().get(main.manaPath(player)) == null) {
            plugin.getConfig().set(main.xpPath(player), 0);
            plugin.getConfig().set(main.manaPath(player), 0);
            logger.info("mana set to 0 for " + player.getName() + " / " + player.getUniqueId());
            logger.info("xp set to 0 for " + player.getName() + " / " + player.getUniqueId());
            plugin.saveConfig();
        }
    }

    @EventHandler
    public void leveling(PlayerExpChangeEvent event) {

        Player player = event.getPlayer();
        int xp = event.getAmount();
        int xptotal = player.getTotalExperience();
        String message = "§e+" + xp + " §eXP";
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, net.md_5.bungee.api.chat.TextComponent.fromLegacyText(message));
        plugin.getConfig().set(main.xpPath(player), xptotal);
        //plugin.getConfig().set("eco." + player.getUniqueId() + ".xp", main.getInstance().getConfig().getInt("eco." + player.getUniqueId() + ".xp") + xp);
        plugin.saveConfig();
    }


    public static void addXP(int amount, Player player) {
        plugin.getConfig().set(main.xpPath(player), plugin.getConfig().getInt(main.xpPath(player)) + amount);
        String message = "§e+" + amount + " §eXP";
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, net.md_5.bungee.api.chat.TextComponent.fromLegacyText(message));
        plugin.saveConfig();
    }

    public void removeXP(int amount, Player player) {
        plugin.getConfig().set(main.xpPath(player), plugin.getConfig().getInt(main.xpPath(player)) - amount);
        String message = "§c-" + amount + " §cXP";
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, net.md_5.bungee.api.chat.TextComponent.fromLegacyText(message));
        plugin.saveConfig();
    }

    public static int getMana(Player player) {
        return plugin.getConfig().getInt(main.manaPath(player));
    }

    public static void addMana(Player player, int amount) {
        plugin.getConfig().set(main.manaPath(player), amount);
        plugin.saveConfig();
    }
}
//
//plugin.getConfig().set("eco." + player.getUniqueId() + ".xp", main.getInstance().getConfig().getInt("eco." + player.getUniqueId() + ".xp") + random);
//                levelManager(player);
//                plugin.saveConfig();
//