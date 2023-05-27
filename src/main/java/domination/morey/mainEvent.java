package domination.morey;

import domination.morey.economy.money;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class mainEvent implements Listener {

    static domination.morey.economy.money money = new money();

    @EventHandler
    public void onDie(PlayerDeathEvent event) {

        Player player = event.getPlayer();
        player.sendMessage("§cVous êtes mort");
        int random = (int) (Math.random() * 20);
        money.removeMoney(random, player);
        if(player.getKiller() != null) {
            Player killer = player.getKiller();
            killer.sendMessage("§aVous avez tué §c" + player.getName());
            money.addMoney(random, killer);
        }
    }

    @EventHandler
    public void deathMessage(PlayerDeathEvent event) {

        event.deathMessage(null);
    }
}
