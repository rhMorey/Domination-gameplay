package domination.morey.economy;

import domination.morey.gamemode.capture;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import static domination.morey.main.plugin;

public class money implements Listener {

    money manage;

    public money() {
        manage = this;
    }

    @EventHandler
    public void onConnect(PlayerJoinEvent event) {
        if(plugin.getConfig().get("eco." + event.getPlayer().getUniqueId() + ".money") == null) {
            plugin.getConfig().set("eco." + event.getPlayer().getUniqueId() + ".money", 0);
            plugin.saveConfig();
        }
    }

    public void addMoney(int amount, Player player) {
        plugin.getConfig().set("eco." + player.getUniqueId() + ".money", plugin.getConfig().getInt("eco." + player.getUniqueId() + ".money") + amount);
        player.sendMessage("§a+" + amount + "§a Fragment d'émeraude");
        plugin.saveConfig();
    }

    public void removeMoney(int amount, Player player) {
        plugin.getConfig().set("eco." + player.getUniqueId() + ".money", plugin.getConfig().getInt("eco." + player.getUniqueId() + ".money") - amount);
        player.sendMessage("§c-" + amount + "§a Fragment d'émeraude");
        plugin.saveConfig();
    }
}
