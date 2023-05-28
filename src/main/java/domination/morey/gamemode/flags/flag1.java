package domination.morey.gamemode.flags;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.world.World;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import com.sk89q.worldguard.protection.regions.RegionContainer;
import domination.morey.gamemode.capture;
import domination.morey.main;
import domination.morey.team.team;
import domination.morey.economy.money;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.scheduler.BukkitTask;

import java.util.Objects;
import java.util.logging.Logger;

public class flag1 implements Listener {

    private int contest = 0;
    private int i = 0;
    static capture capture = new capture();

    private int seconds;
    private BukkitTask timerTask;

    static money money = new money();
    @EventHandler
    public void captureFlag(PlayerInteractEvent event) {

        Player player = event.getPlayer();
        World w = BukkitAdapter.adapt(player.getWorld());
        RegionContainer container = WorldGuard.getInstance().getPlatform().getRegionContainer();
        RegionManager regions = container.get(w);
        assert regions != null;
        Location playerLocation = player.getLocation();

        // MODIFICATION
        ProtectedRegion flag1 = regions.getRegion("flag1");
        assert flag1 != null;
        // MODIFICATION

        if(event.getClickedBlock() == null) return;
        if (Objects.equals(event.getHand(), EquipmentSlot.OFF_HAND)) return;

        // MODIFICATION
        if(regions.getRegion("flag1") == null) return;
        if(Objects.requireNonNull(regions.getRegion("flag1")).contains(playerLocation.getBlockX(), playerLocation.getBlockY(), playerLocation.getBlockZ())) {
            // MODIFICATION

            if (team.purple.getEntries().contains(player.getName()) && event.getClickedBlock().getType().equals(Material.YELLOW_WOOL)) {
                contest++;
                capture.effect(contest, player);
                String message = "§e " + contest + " §7/ §a20";
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
                if (contest == 20) {
                    contest = 0;
                    i = 0;
                    capture.whatFlag(flag1, player, playerLocation, 70);
                }
            }
            if (team.purple.getEntries().contains(player.getName()) && event.getClickedBlock().getType().equals(Material.WHITE_WOOL)) {
                i++;
                capture.effect(i, player);
                String message = "§e " + i + " §7/ §a40";
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
                if (i == 40) {
                    i = 0;
                    contest = 0;
                    capture.whatFlag(flag1, player, playerLocation, 70);
                }
            }
            if (team.yellow.getEntries().contains(player.getName()) && event.getClickedBlock().getType().equals(Material.PURPLE_WOOL)) {
                contest++;
                capture.effect(contest, player);
                String message = "§e " + contest + " §7/ §a20";
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
                if (contest == 20) {
                    contest = 0;
                    i = 0;
                    capture.whatFlag(flag1, player, playerLocation, 70);
                }
            }
            if (team.yellow.getEntries().contains(player.getName()) && event.getClickedBlock().getType().equals(Material.WHITE_WOOL)) {
                i++;
                capture.effect(i, player);
                String message = "§e " + i + " §7/ §a40";
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
                if (i == 40) {
                    i = 0;
                    contest = 0;
                    capture.whatFlag(flag1, player, playerLocation, 70);
                }
            }
        }
    }

    public void points(String t) {

        Logger logger = Bukkit.getLogger();
        logger.info("test");
        timerTask = Bukkit.getServer().getScheduler().runTaskTimer(main.plugin, () -> {
            seconds++;
            // Faites quelque chose chaque seconde (par exemple, afficher le temps dans la console)
            logger.info("§6" + seconds + "§e secondes se sont écoulées");
            if (seconds == 10) {
                Bukkit.getServer().broadcastMessage("test");
            }
            if (seconds == 20) {
                Bukkit.getServer().broadcastMessage("test2");
            }
            if(seconds == 30) {
                getTeamPlayers(t);
                seconds = 0;
                Bukkit.getServer().broadcastMessage("fin");
            }
        }, 20L, 20L);
    }

    private void stopTimer() {
        if (timerTask != null) {
            timerTask.cancel();
            timerTask = null;
        }
    }

    public void getTeamPlayers(String t) {

        if(t.equals("purple")) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                if (team.purple.getEntries().contains(player.getName())) {
                    money.addMoney(2, player);
                }
            }
        }
        if(t.equals("yellow")) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                if (team.yellow.getEntries().contains(player.getName())) {
                    money.addMoney(2, player);
                }
            }
        }
    }
}
