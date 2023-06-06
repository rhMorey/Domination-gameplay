package domination.morey.customItems.ingredients;

import domination.morey.main;
import domination.morey.npc.pnj.vendor.Alduan;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import static domination.morey.main.plugin;

public class CoeurMerSulfurized implements Listener {

    CoeurMerSulfurized coeurMerSulfurized = new CoeurMerSulfurized();

    public CoeurMerSulfurized getCoeurMerSulfurized() {
        return coeurMerSulfurized;
    }

    public static ShapedRecipe onCraft() {

        ItemStack item = new ItemStack(main.Item(Material.HEART_OF_THE_SEA, "§5Cœur de la Mer sulfurisé",
                " ",
                "§6§lP: §eCe coeur vous donne Résistance III et Absorption IV",
                "§6§lActif: §eVous donne Résistance IV, Absorption V, Régénération III pendant 35 secondes"));
        NamespacedKey nsKey = new NamespacedKey(plugin, "coeur_de_la_mer_sulfurisé");
        ShapedRecipe recipe = new ShapedRecipe(nsKey, item);
        recipe.shape("CAC", "ABA", "CAC");

        recipe.setIngredient('B', Alduan.item5.getType());
        recipe.setIngredient('C', Material.LEATHER);
        recipe.setIngredient('A', Material.AIR);
        return recipe;
    }
}
