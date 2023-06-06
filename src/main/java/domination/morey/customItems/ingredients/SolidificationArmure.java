package domination.morey.customItems.ingredients;

import domination.morey.main;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import static domination.morey.main.plugin;

public class SolidificationArmure implements Listener {

    SolidificationArmure solidificationArmure = new SolidificationArmure();

    public SolidificationArmure getSolidificationArmure() {
        return solidificationArmure;
    }

    public static ShapedRecipe onCraft() {

        ItemStack item = new ItemStack(main.Item(Material.PHANTOM_MEMBRANE, "§fSolidification d'armure", "§7Cet objet est à ajouter à votre armure pour la solidifier"));
        NamespacedKey nsKey = new NamespacedKey(plugin, "solid_armor");
        ShapedRecipe recipe = new ShapedRecipe(nsKey, item);
        recipe.shape("CAC", "ABA", "CAC");

        recipe.setIngredient('B', Material.IRON_INGOT);
        recipe.setIngredient('C', Material.LEATHER);
        recipe.setIngredient('A', Material.AIR);
        return recipe;
    }
}
