package domination.morey.team.whichclass;

import domination.morey.main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.logging.Logger;

import static domination.morey.main.plugin;

public class classeEvent implements Listener {

    @EventHandler
    public void onConnect(PlayerJoinEvent event) {

        Player player = event.getPlayer();
        Logger logger = plugin.getLogger();
        if (plugin.getConfig().get(main.classePath(player)) == null) {
            plugin.getConfig().set(main.classePath(player), "none");
            logger.info("classe set to none for " + player.getName() + " / " + player.getUniqueId());
            plugin.saveConfig();
        }

    }

}
