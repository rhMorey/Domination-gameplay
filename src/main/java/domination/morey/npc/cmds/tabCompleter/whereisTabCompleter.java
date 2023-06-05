package domination.morey.npc.cmds.tabCompleter;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class whereisTabCompleter implements TabCompleter {

    @Override
    public @Nullable List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (command.getName().equalsIgnoreCase("whereis")) {
            if (args.length == 1) {
                List<String> suggestions = new ArrayList<>();
                suggestions.add("doran");
                suggestions.add("olga");
                suggestions.add("lorient");
                suggestions.add("alduan");
                suggestions.add("schesein");
                suggestions.add("elise");
                return suggestions;
            }
        }
        return null;
    }
}
