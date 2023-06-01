package domination.morey.dungeons;

import domination.morey.main;
import io.lumine.mythic.api.mobs.MythicMob;
import io.lumine.mythic.bukkit.BukkitAdapter;
import io.lumine.mythic.bukkit.MythicBukkit;
import io.lumine.mythic.core.mobs.ActiveMob;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class customMobs implements Listener {

    @EventHandler
    public void spawnBoss(PlayerInteractEvent event) {

        Player player = event.getPlayer();
        MythicMob mob = MythicBukkit.inst().getMobManager().getMythicMob("SkeletalKnight").orElse(null);
        Location spawnLocation = player.getLocation();
        if (event.getAction().isRightClick() && player.getInventory().getItemInMainHand().getType().equals(Material.FEATHER)) {
            if (mob != null) {
                // spawns mob
                ActiveMob knight = mob.spawn(BukkitAdapter.adapt(spawnLocation), 1);

                // get mob as bukkit entity
                Entity entity = knight.getEntity().getBukkitEntity();
            } else {
                player.sendMessage(main.prefix + "§cLe mob n'existe pas");
            }
        }
    }
}
