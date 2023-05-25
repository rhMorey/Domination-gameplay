package domination.morey.team;

import domination.morey.main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.scoreboard.Team;

import java.util.Objects;

public class team implements Listener {

    public static Team purple = Bukkit.getServer().getScoreboardManager().getMainScoreboard().getTeam("purple");
    public static Team yellow = Bukkit.getServer().getScoreboardManager().getMainScoreboard().getTeam("yellow");

    // Création des teams
    public void createTeam() {
        if(purple == null) {
            purple = Bukkit.getServer().getScoreboardManager().getMainScoreboard().registerNewTeam("purple");
            purple.setDisplayName("Purple");
            purple.setColor(org.bukkit.ChatColor.DARK_PURPLE);
        }
        if(yellow == null) {
            yellow = Bukkit.getServer().getScoreboardManager().getMainScoreboard().registerNewTeam("yellow");
            yellow.setDisplayName("Yellow");
            yellow.setColor(org.bukkit.ChatColor.YELLOW);
        }
    }

    // Détection si le joueur se connecte -> création des teams + téléportation au spawn
    @EventHandler
    public void onConnect(PlayerJoinEvent event) {
        createTeam();
        Player player = event.getPlayer();
        if(!purple.getEntries().contains(player.getName()) && !yellow.getEntries().contains(player.getName())) {

            Location spawn = new Location(Bukkit.getWorld("world"), -950, 64, 208);
            player.teleport(spawn);
            player.sendMessage(main.prefix + "§eVeuillez choisir une équipe.");
        }
    }

    // Clique sur le bloc qui correspond à l'équipe -> téléportation vers champs de bataille
    @EventHandler
    public void onClickTeam(PlayerInteractEvent event) {

        Player player = event.getPlayer();
        if(event.getClickedBlock() == null) return;
        // Pour éviter que le joueur clique avec les deux mains
        if (Objects.equals(event.getHand(), EquipmentSlot.OFF_HAND)) return;
        //
        if(event.getClickedBlock().getType() == Material.PURPLE_GLAZED_TERRACOTTA) {
            purple.addEntry(event.getPlayer().getName());
            //player.teleport( BATTLEFIELD )
            player.sendMessage("§aVous êtes maintenant dans l'équipe §5Violet§a.");
        }
        if(event.getClickedBlock().getType() == Material.YELLOW_GLAZED_TERRACOTTA) {
            yellow.addEntry(event.getPlayer().getName());
            //player.teleport( BATTLEFIELD )
            player.sendMessage("§aVous êtes maintenant dans l'équipe §eJaune§a.");
        }

    }
}
