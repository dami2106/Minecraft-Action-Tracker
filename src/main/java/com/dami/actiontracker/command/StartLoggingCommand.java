package com.dami.actiontracker.command;

import com.llamalad7.mixinextras.lib.apache.commons.ObjectUtils;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

import com.dami.actiontracker.logging.LoggingManager;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

import static com.mojang.brigadier.arguments.StringArgumentType.getString;
import static com.mojang.brigadier.arguments.StringArgumentType.word;



public class StartLoggingCommand {

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher, boolean dedicated) {
        dispatcher.register(CommandManager.literal("actiontracker")
                .then(CommandManager.literal("start")
                        .then(CommandManager.argument("logtext", word())
                                .executes(context -> run(context, getString(context, "logtext")))
                        ).executes(context -> run(context, null))
                )
        );
    }
    private static int run(CommandContext<ServerCommandSource> context, @Nullable String log_text) throws CommandSyntaxException {

        if (!LoggingManager.LOGGING) {
            LoggingManager.LOGGING = true;

            //TODO Set file name here
            String file_name;
            if (log_text != null){
                file_name = log_text + ".txt";
            }else{
                file_name = "log_action.txt";
            }
            context.getSource().sendFeedback(() -> Text.literal("Started logging to : " + file_name), false);
            LoggingManager.createFile(file_name);

        } else {
            context.getSource().sendFeedback(() -> Text.literal("Already logging."), false);
        }


        return 1;
    }
}
