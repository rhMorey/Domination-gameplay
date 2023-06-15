package domination.morey.customItems.ingredients;

import domination.morey.main;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import static domination.morey.main.plugin;

public class FerEnergie implements Listener {

    FerEnergie ferEnergie = new FerEnergie();

    public FerEnergie getFerEnergie() {
        return ferEnergie;
    }

    public static ItemStack result = new ItemStack(main.Item(Material.IRON_INGOT, "§fFer compressé",
            "§7Le Fer compressé est bien plus résistant que le fer."));

    public static ShapedRecipe onCraft() {

        NamespacedKey nsKey = new NamespacedKey(plugin, "reinforced_iron");
        ShapedRecipe recipe = new ShapedRecipe(nsKey, result);
        recipe.shape("ABA", "BCB", "ABA");

        recipe.setIngredient('A', Material.AIR);
        recipe.setIngredient('B', Material.IRON_INGOT);
        recipe.setIngredient('C', Material.BLAZE_POWDER);
        return recipe;
    }

}
