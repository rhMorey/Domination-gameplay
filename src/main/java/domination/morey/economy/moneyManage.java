package domination.morey.economy;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import static domination.morey.main.plugin;

public class moneyManage implements Listener {

    moneyManage manage;

    public moneyManage() {
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

    public int getMoney(Player player) {
        int money = plugin.getConfig().getInt("eco." + player.getUniqueId() + ".money");
        return money;
    }
}
