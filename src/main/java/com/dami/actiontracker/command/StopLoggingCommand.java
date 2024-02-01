package com.dami.actiontracker.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import com.dami.actiontracker.command.StartLoggingCommand;

import com.dami.actiontracker.logging.LoggingManager;
public class StopLoggingCommand {

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher, boolean dedicated) {
        dispatcher.register(CommandManager.literal("actiontracker")
                .then(CommandManager.literal("stop").executes(StopLoggingCommand::run)));
    }

    private static int run(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {

        if (LoggingManager.LOGGING) {
            LoggingManager.LOGGING = false;
            context.getSource().sendFeedback(() -> Text.literal("Stopped logging. Saving File."), false);

            //TODO Save file here

        } else {
            context.getSource().sendFeedback(() -> Text.literal("Not currently logging. Nothing to stop."), false);
        }



        return 1;
    }
}
