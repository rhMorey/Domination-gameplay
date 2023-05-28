package domination.morey.gamemode;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.world.World;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import com.sk89q.worldguard.protection.regions.RegionContainer;
import domination.morey.team.team;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class gameplay implements Listener {


    @EventHandler
    public void onEnterWrongCampPurple(PlayerMoveEvent event) {

        Player player = event.getPlayer();
        World w = BukkitAdapter.adapt(player.getWorld());
        RegionContainer container = WorldGuard.getInstance().getPlatform().getRegionContainer();
        RegionManager regions = container.get(w);
        assert regions != null;
        ProtectedRegion purple = regions.getRegion("violet");

        if(team.purple.getEntries().contains(player.getName())) {

            assert purple != null;
            if(purple.contains(player.getLocation().getBlockX(), player.getLocation().getBlockY(), player.getLocation().getBlockZ())) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 30, 1));
                player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 30, 0));
            }
        }
        if(team.yellow.getEntries().contains(player.getName())) {

            assert purple != null;
            if(purple.contains(player.getLocation().getBlockX(), player.getLocation().getBlockY(), player.getLocation().getBlockZ())) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 30, 1));
                player.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 30, 0));
            }
        }
    }

    @EventHandler
    public void onEnterWrongCampYellow(PlayerMoveEvent event) {

        Player player = event.getPlayer();
        World w = BukkitAdapter.adapt(player.getWorld());
        RegionContainer container = WorldGuard.getInstance().getPlatform().getRegionContainer();
        RegionManager regions = container.get(w);
        assert regions != null;
        ProtectedRegion yellow = regions.getRegion("yellow");

        if(team.yellow.getEntries().contains(player.getName())) {

            assert yellow != null;
            if(yellow.contains(player.getLocation().getBlockX(), player.getLocation().getBlockY(), player.getLocation().getBlockZ())) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 30, 1));
                player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 30, 0));
            }
        }
        if(team.purple.getEntries().contains(player.getName())) {

            assert yellow != null;
            if(yellow.contains(player.getLocation().getBlockX(), player.getLocation().getBlockY(), player.getLocation().getBlockZ())) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 30, 1));
                player.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 30, 0));
            }
        }
    }
}
