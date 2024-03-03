package com.dami.actiontracker;

import com.dami.actiontracker.event.KeyInputHandler;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;

public class ActionTrackerClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        KeyInputHandler.register();

    }
}
