package com.dami.actiontracker.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

import com.dami.actiontracker.logging.LoggingManager;

public class StartLoggingCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher, boolean dedicated) {
        dispatcher.register(CommandManager.literal("actiontracker")
                .then(CommandManager.literal("start").executes(StartLoggingCommand::run)));
    }

    private static int run(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {

        if (!LoggingManager.LOGGING) {
            LoggingManager.LOGGING = true;

            //TODO Set file name here
            //FILENAME = "";

            context.getSource().sendFeedback(() -> Text.literal("Started logging to : " + LoggingManager.FILENAME), false);
            LoggingManager.createFile();

        } else {
            context.getSource().sendFeedback(() -> Text.literal("Already logging."), false);
        }


        return 1;
    }
}
