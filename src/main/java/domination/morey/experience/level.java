package domination.morey.experience;

import domination.morey.main;
import net.md_5.bungee.api.ChatMessageType;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Objects;
import java.util.Random;

import static domination.morey.main.plugin;

public class level implements Listener {

    @EventHandler
    public void onConnect(PlayerJoinEvent event) {
        if (plugin.getConfig().get("eco." + event.getPlayer().getUniqueId() + ".xp") == null || plugin.getConfig().get("eco." + event.getPlayer().getUniqueId() + ".level") == null) {
            plugin.getConfig().set("eco." + event.getPlayer().getUniqueId() + ".xp", 0);
            plugin.getConfig().set("eco." + event.getPlayer().getUniqueId() + ".level", 0);
            plugin.saveConfig();
        }
    }

    public void levelManager(Player player) {

        if (plugin.getConfig().getInt("eco." + player.getUniqueId() + ".xp") >= 100) {
            plugin.getConfig().set("eco." + player.getUniqueId() + ".level", plugin.getConfig().getInt("eco." + player.getUniqueId() + ".level") + 1);
        }
    }

    @EventHandler
    public void leveling(EntityDeathEvent event) {

        Entity dead = event.getEntity();
        if(event.getEntity().getKiller() != null) {
            Player player = event.getEntity().getKiller();
            if (dead.getLastDamageCause() instanceof EntityDamageByEntityEvent) {
                int random = (int) (Math.random() * 5);
                String message = "§e+" + random + " §eXP";
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, net.md_5.bungee.api.chat.TextComponent.fromLegacyText(message));
                plugin.getConfig().set("eco." + player.getUniqueId() + ".xp", main.getInstance().getConfig().getInt("eco." + player.getUniqueId() + ".xp") + random);
                levelManager(player);
                plugin.saveConfig();

            }
        }
    }

    //
    // Faire une système pour addMoney et removeMoney
    //
}
//
//plugin.getConfig().set("eco." + player.getUniqueId() + ".xp", main.getInstance().getConfig().getInt("eco." + player.getUniqueId() + ".xp") + random);
//                levelManager(player);
//                plugin.saveConfig();
//