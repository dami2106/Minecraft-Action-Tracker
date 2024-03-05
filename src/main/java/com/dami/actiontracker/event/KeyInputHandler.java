package com.dami.actiontracker.event;

import javax.swing.text.JTextComponent;
import java.security.Key;
import java.sql.SQLOutput;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.BlockPos;
import java.lang.Math;

public class KeyInputHandler {
    public static final String KEYBIND_CONTROLLER = "MC Action Tracker";
    public static final String KEY_MOVE_DISCRETE = "Move Forward Discrete";
    public static final String KEY_JUMP_UP = "Jump Up Discrete";
    public static final String KEY_JUMP_DOWN = "Jump Down Discrete";

    public static KeyBinding move_discrete;
    public static KeyBinding jump_up;

    public static KeyBinding jump_down;




    public static void registerKeyInputs() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {

            if(move_discrete.wasPressed()) {
                // north
                MinecraftClient minecraftClient = MinecraftClient.getInstance();
                if (minecraftClient.player != null) {
                    // Get the current position of the player
                    BlockPos currentPlayerPos = minecraftClient.player.getBlockPos();

                    // Get the current yaw rotation of the player
                    float playerYaw = minecraftClient.player.getYaw();
                    playerYaw %= 360;

                    if (playerYaw < 0)
                        playerYaw += 360.0F;

                    BlockPos newPlayerPos ;

                    // Determine the direction the player is facing based on yaw angle
                    if (playerYaw < 45 || playerYaw >= 315) {
                        // Facing south
                        System.out.println("South");
                        newPlayerPos = currentPlayerPos.south();
                    } else if (playerYaw < 135) {
                        // Facing west
                        System.out.println("West");
                        newPlayerPos = currentPlayerPos.west();
                    } else if (playerYaw < 225) {
                        // Facing north
                        System.out.println("North");
                        newPlayerPos = currentPlayerPos.north();
                    } else {
                        // Facing east
                        System.out.println("East");
                        newPlayerPos = currentPlayerPos.east();
                    }
                    // Set the player's position to the new position
                    minecraftClient.player.updatePosition(newPlayerPos.getX()+0.5, newPlayerPos.getY(), newPlayerPos.getZ()+0.5);
                }
            }
            else if(jump_up.wasPressed()) {
                // up
                MinecraftClient minecraftClient = MinecraftClient.getInstance();
                if (minecraftClient.player != null) {
                    // Get the current position of the player
                    BlockPos currentPlayerPos = minecraftClient.player.getBlockPos();

                    // Get the current yaw rotation of the player
                    float playerYaw = minecraftClient.player.getYaw();
                    playerYaw = playerYaw % 360;
                    if (playerYaw < 0)
                        playerYaw += 360.0F;

                    // Calculate the offset based on the direction the player is facin
                    BlockPos newPlayerPos ;
                    // Determine the direction the player is facing based on yaw angle
                    if (playerYaw < 45 || playerYaw >= 315) {
                        // Facing south
                        newPlayerPos = currentPlayerPos.up().south();
                    } else if (playerYaw < 135) {
                        // Facing west
                        newPlayerPos = currentPlayerPos.up().west();
                    } else if (playerYaw < 225) {
                        // Facing north
                        newPlayerPos = currentPlayerPos.up().north();
                    } else {
                        // Facing east
                        newPlayerPos = currentPlayerPos.up().east();
                    }

                    // Set the player's position to the new position
                    minecraftClient.player.updatePosition(newPlayerPos.getX()+0.5, newPlayerPos.getY(), newPlayerPos.getZ()+0.5);
                }
            }
            else if(jump_down.wasPressed()) {
                // up
                MinecraftClient minecraftClient = MinecraftClient.getInstance();
                if (minecraftClient.player != null) {
                    // Get the current position of the player
                    BlockPos currentPlayerPos = minecraftClient.player.getBlockPos();

                    // Get the current yaw rotation of the player
                    float playerYaw = minecraftClient.player.getYaw();
                    playerYaw = playerYaw % 360;
                    if (playerYaw < 0)
                        playerYaw += 360.0F;

                    // Calculate the offset based on the direction the player is facin
                    BlockPos newPlayerPos ;
                    // Determine the direction the player is facing based on yaw angle
                    if (playerYaw < 45 || playerYaw >= 315) {
                        // Facing south
                        newPlayerPos = currentPlayerPos.down().south();
                    } else if (playerYaw < 135) {
                        // Facing west
                        newPlayerPos = currentPlayerPos.down().west();
                    } else if (playerYaw < 225) {
                        // Facing north
                        newPlayerPos = currentPlayerPos.down().north();
                    } else {
                        // Facing east
                        newPlayerPos = currentPlayerPos.down().east();
                    }

                    // Set the player's position to the new position
                    minecraftClient.player.updatePosition(newPlayerPos.getX()+0.5, newPlayerPos.getY(), newPlayerPos.getZ()+0.5);
                }
            }

        });
    }


    public static void register() {
        move_discrete = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_MOVE_DISCRETE,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_I,
                KEYBIND_CONTROLLER
        ));

        jump_up = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_JUMP_UP,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_O,
                KEYBIND_CONTROLLER
        ));

        jump_down = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_JUMP_DOWN,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_U,
                KEYBIND_CONTROLLER
        ));


        registerKeyInputs();
    }

}