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

    public static ItemStack result = new ItemStack(main.Item(Material.PHANTOM_MEMBRANE, "§fSolidification d'armure", "§7Cet objet doit être ajouté à votre armure afin de la solidifier.",
            " ",
            "§7L'armure doit être §9rare§7 ou plus."));

    public static ShapedRecipe onCraft() {

        NamespacedKey nsKey = new NamespacedKey(plugin, "iron_solidification");
        ShapedRecipe recipe = new ShapedRecipe(nsKey, result);
        recipe.shape("CAC", "ABA", "CAC");

        recipe.setIngredient('B', Material.NAUTILUS_SHELL);
        recipe.setIngredient('C', Material.LEATHER);
        recipe.setIngredient('A', Material.IRON_INGOT);
        return recipe;
    }
}
