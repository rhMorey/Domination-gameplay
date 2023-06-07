package domination.morey.customItems.items;

import domination.morey.customItems.ingredients.FragmentOmbre;
import domination.morey.main;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import static domination.morey.main.plugin;

public class LanterneOmbre implements Listener {

    LanterneOmbre lanterneOmbre = new LanterneOmbre();

    public LanterneOmbre getLanterneOmbre() {
        return lanterneOmbre;
    }

    public static ItemStack result = new ItemStack(main.Item(Material.SOUL_LANTERN, "§3Lanterne d'ombre", "§7ᛏᚺᛁᛊ ᛚᚨᚾᛏᛖᚱᚾ ᛈᚱᛟᛏᛖᚲᛏᛊ ᛁᛟᚢ ᚠᚱᛟᛗ ᛊᛟᚢᛚ ᚠᛟᚷ", // Cette lanterne vous protège de la brume d'âme
            " ",
            "§3§lRunique§7: §5ᛊᚺᚨᛞᛟᚹ"));

    public static ShapedRecipe onCraft() {

        NamespacedKey nsKey = new NamespacedKey(plugin, "shadow_lantern");
        ShapedRecipe recipe = new ShapedRecipe(nsKey, result);
        recipe.shape("CBC", "BAB", "CBC");

        recipe.setIngredient('A', Material.LANTERN);
        recipe.setIngredient('B', FragmentOmbre.result);
        recipe.setIngredient('C', Material.AIR);
        return recipe;
    }
}
