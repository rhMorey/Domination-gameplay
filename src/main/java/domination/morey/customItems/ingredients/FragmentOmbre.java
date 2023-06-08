package domination.morey.customItems.ingredients;

import domination.morey.main;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import static domination.morey.main.plugin;

public class FragmentOmbre implements Listener {

    FragmentOmbre fragmentOmbre = new FragmentOmbre();

    public FragmentOmbre getFragmentOmbre() {
        return fragmentOmbre;
    }

    public static ItemStack result = new ItemStack(main.Item(Material.ECHO_SHARD, "§3Fragment d'ombre",
            "§7ᛏᚺᛁᛊ ᛟᛒᛃᛖᚲᛏ ᚺᛟᛚᛞᛊ ᚨᚾ ᛟᚢᛖᚱᚹᚺᛖᛚᛗᛁᛜ ᛈᛟᚹᛖᚱ", // Cet objet détient une puissance débordante
            " ",
            "§3§lRunique§7: §5ᛊᚺᚨᛞᛟᚹ"));

    public static ShapedRecipe onCraft() {

        NamespacedKey nsKey = new NamespacedKey(plugin, "shadow_fragment");
        ShapedRecipe recipe = new ShapedRecipe(nsKey, result);
        recipe.shape("EEE", "BAC", "EDE");

        recipe.setIngredient('A', Material.DIAMOND);
        recipe.setIngredient('B', Material.GLOW_INK_SAC);
        recipe.setIngredient('C', Material.BLACK_DYE);
        recipe.setIngredient('D', Material.DRIED_KELP);
        recipe.setIngredient('E', Material.AIR);
        return recipe;
    }

}
