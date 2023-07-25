package domination.morey;

import domination.morey.experience.level;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import static domination.morey.main.plugin;

public class intro implements Listener {

    intro manage;

    public intro() {
        manage = this;
    }

    @EventHandler
    public static void forceLaunch(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();
        if(event.getMessage().equals("/intro")) {
            event.setCancelled(true);
            if (player.isOp()) {
                launch(player);
            }
        }
    }

    @EventHandler
    public static void creynois(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();
        if(event.getMessage().equals("/creynois")) {
            event.setCancelled(true);
            player.sendMessage("§eLes §3Creynois§e sont trouvables dans toutes les capitales, ce sont des sortes de marchand-mage, nous ne connaissons pas leur intention mais ils sont très utiles lorsqu'il s'agit de commerce ou de puissance.\n" +
                    "§eIls utilisent les §bâmes §eet l'§dAméthyste§e.\n");
        }
    }

    public static void launch(Player player) {
        String message = "§cRegardez votre chat !";
        player.sendTitle("Bienvenue" + player.getName(), message, 10, 70, 20);
        player.playSound(player.getLocation(), "minecraft:entity.player.levelup", 1, 1);
        chatVoid(player);
        player.sendMessage("§eSalut §6" + player.getName() + "§f, nous allons te faire un cours tutoriel sur le serveur :)");
        player.sendMessage("§7Alors lis bien ton chat, bon jeu :)");
        chatVoid(player);
        Bukkit.getScheduler().runTaskLater(main.plugin, () -> {
            Location loc1 = new Location(player.getWorld(), -925, 73, 112, 131, 25);
            player.teleport(loc1);
            chatVoid(player);
            player.sendMessage("§eVoici des marchands§f, ils sont dans pleins de villes, vous pourrez acheter ou vendre des objets diverses avec eux.");
            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_COW_BELL, 1, 1);
            chatVoid(player);
            Bukkit.getScheduler().runTaskLater(main.plugin, () -> {
                Location loc2 = new Location(player.getWorld(), 981, 93, -1012, 160, 16);
                player.teleport(loc2);
                chatVoid(player);
                player.sendMessage("§bIci c'est Dinhâm§f, une ville prospère rempli de commerçant venant de tout l'île.");
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL, 1, 1);
                chatVoid(player);
                Bukkit.getScheduler().runTaskLater(main.plugin, () -> {
                    Location loc3 = new Location(player.getWorld(), 91, 87, -497, -162, -5);
                    player.teleport(loc3);
                    chatVoid(player);
                    player.sendMessage("§fDepuis quelques temps, la §2corruption §ffait son apparition sur l'île, ils grangrènnent petit à petit les villes.");
                    player.playSound(player.getLocation(), Sound.AMBIENT_CAVE, 1, 1);
                    chatVoid(player);
                    Bukkit.getScheduler().runTaskLater(main.plugin, () -> {
                        Location loc4 = new Location(player.getWorld(), 406, 142, -1693, -156, 8);
                        player.teleport(loc4);
                        chatVoid(player);
                        player.sendMessage("§fFaites vous remarquer, triomphez de vos combats, et aidez un empire à §ecombattre la §2corruption§f.");
                        chatVoid(player);
                        Bukkit.getScheduler().runTaskLater(main.plugin, () -> {
                            Location loc5 = new Location(player.getWorld(), -673.5, 200, 208.563);
                            player.teleport(loc5);
                            chatVoid(player);
                            player.sendMessage("§fMais pour l'instant, §echoississez votre équipe§f.");
                            player.sendMessage("§8Changeable plus tard");
                            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
                            chatVoid(player);

                            player.sendMessage("[§f§l§m⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯§r]\n" +
                                    "§eVous devez arrêter cette corruption à tout pris !\n" +
                                    "§eUnissez-vous avec des joueurs, terrassez les ennemies de l'île\n" +
                                    "§eEt devenez le plus puissant en fabriquant, en achetant ou en vendant du stuff\n" +
                                    " \n" +
                                    "§eVous pouvez §6miner§e des §6ressources §equi vous permettront de §6fabriquer§e des §6objets§e.\n" +
                                    "§eVous pouvez également faire appel aux §3Creynois§e pour vous aider §8(/creynois)§e.\n");

                        }, 200L); // 300L = 15 secondes
                    }, 200L); // 300L = 15 secondes
                }, 200L); // 300L = 15 secondes
            }, 200L); // 300L = 15 secondes
        }, 200L); // 300L = 15 secondes
    }

    public static void chatVoid(Player player) {
        player.sendMessage(" ");
        player.sendMessage(" ");
        player.sendMessage(" ");
        player.sendMessage(" ");
    }
}
