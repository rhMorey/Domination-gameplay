package domination.morey.experience.cmds.tabCompleter;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class transferTabCompleter implements TabCompleter {

    @Override
    public @Nullable List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (command.getName().equalsIgnoreCase("transfer")) {
            if (args.length == 1) {
                List<String> suggestions = new ArrayList<>();
                suggestions.add("1");
                suggestions.add("3");
                suggestions.add("5");
                suggestions.add("10");
                return suggestions;
            }
        }
        return null;
    }

}
