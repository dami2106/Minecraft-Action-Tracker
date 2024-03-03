package com.dami.actiontracker.event;

import javax.swing.text.JTextComponent;
import java.security.Key;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.BlockPos;
public class KeyInputHandler {
    public static final String KEY_CATEGORY_TUTORIAL = "tutorial";
    public static final String KEY_MOVE_NORTH = "move_north";
    public static final String KEY_MOVE_EAST = "move_east";
    public static final String KEY_MOVE_SOUTH = "move_south";
    public static final String KEY_MOVE_WEST = "move_west";
    public static final String KEY_MOVE_UP = "move_up";
    public static final String KEY_JUMP_UP_NORTH = "jump_up_north";
    public static final String KEY_JUMP_UP_EAST = "jump_up_east";
    public static final String KEY_JUMP_UP_SOUTH = "jump_up_south";
    public static final String KEY_JUMP_UP_WEST = "jump_up_west";

    public static KeyBinding move_north;
    public static KeyBinding move_east;
    public static KeyBinding move_south;
    public static KeyBinding move_west;
    public static KeyBinding move_up;
    public static KeyBinding jump_up_north;
    public static KeyBinding jump_up_east;
    public static KeyBinding jump_up_south;
    public static KeyBinding jump_up_west;




    public static void registerKeyInputs() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {

            if(move_north.wasPressed()) {
                // north
                MinecraftClient minecraftClient = MinecraftClient.getInstance();
                if (minecraftClient.player != null) {
                    // Get the current position of the player
                    BlockPos currentPlayerPos = minecraftClient.player.getBlockPos();
                    // Move the player one block north
                    BlockPos newPlayerPos = currentPlayerPos.north();
                    // Set the player's position to the new position
                    minecraftClient.player.updatePosition(newPlayerPos.getX(), newPlayerPos.getY(), newPlayerPos.getZ());
                }
            }else if(move_east.wasPressed()) {
                // east
                MinecraftClient minecraftClient = MinecraftClient.getInstance();
                if (minecraftClient.player != null) {
                    // Get the current position of the player
                    BlockPos currentPlayerPos = minecraftClient.player.getBlockPos();
                    // Move the player one block north
                    BlockPos newPlayerPos = currentPlayerPos.east();
                    // Set the player's position to the new position
                    minecraftClient.player.updatePosition(newPlayerPos.getX(), newPlayerPos.getY(), newPlayerPos.getZ());
                }
            }else if(move_south.wasPressed()) {
                // south
                MinecraftClient minecraftClient = MinecraftClient.getInstance();
                if (minecraftClient.player != null) {
                    // Get the current position of the player
                    BlockPos currentPlayerPos = minecraftClient.player.getBlockPos();
                    // Move the player one block north
                    BlockPos newPlayerPos = currentPlayerPos.south();
                    // Set the player's position to the new position
                    minecraftClient.player.updatePosition(newPlayerPos.getX(), newPlayerPos.getY(), newPlayerPos.getZ());
                }
            }else if(move_west.wasPressed()) {
                // west
                MinecraftClient minecraftClient = MinecraftClient.getInstance();
                if (minecraftClient.player != null) {
                    // Get the current position of the player
                    BlockPos currentPlayerPos = minecraftClient.player.getBlockPos();
                    // Move the player one block north
                    BlockPos newPlayerPos = currentPlayerPos.west();
                    // Set the player's position to the new position
                    minecraftClient.player.updatePosition(newPlayerPos.getX(), newPlayerPos.getY(), newPlayerPos.getZ());
                }
            }else if(move_up.wasPressed()) {
                // up
                MinecraftClient minecraftClient = MinecraftClient.getInstance();
                if (minecraftClient.player != null) {
                    // Get the current position of the player
                    BlockPos currentPlayerPos = minecraftClient.player.getBlockPos();
                    // Move the player one block north
                    BlockPos newPlayerPos = currentPlayerPos.up();
                    // Set the player's position to the new position
                    minecraftClient.player.updatePosition(newPlayerPos.getX(), newPlayerPos.getY(), newPlayerPos.getZ());
                }
            }
            else if(jump_up_north.wasPressed()) {
                // up
                MinecraftClient minecraftClient = MinecraftClient.getInstance();
                if (minecraftClient.player != null) {
                    // Get the current position of the player
                    BlockPos currentPlayerPos = minecraftClient.player.getBlockPos();
                    // Move the player one block north
                    BlockPos newPlayerPos = currentPlayerPos.up().north();
                    // Set the player's position to the new position
                    minecraftClient.player.updatePosition(newPlayerPos.getX(), newPlayerPos.getY(), newPlayerPos.getZ());
                }
            }
            else if(jump_up_east.wasPressed()) {
                // up
                MinecraftClient minecraftClient = MinecraftClient.getInstance();
                if (minecraftClient.player != null) {
                    // Get the current position of the player
                    BlockPos currentPlayerPos = minecraftClient.player.getBlockPos();
                    // Move the player one block north
                    BlockPos newPlayerPos = currentPlayerPos.up().east();
                    // Set the player's position to the new position
                    minecraftClient.player.updatePosition(newPlayerPos.getX(), newPlayerPos.getY(), newPlayerPos.getZ());
                }
            }
            else if(jump_up_south.wasPressed()) {
                // up
                MinecraftClient minecraftClient = MinecraftClient.getInstance();
                if (minecraftClient.player != null) {
                    // Get the current position of the player
                    BlockPos currentPlayerPos = minecraftClient.player.getBlockPos();
                    // Move the player one block north
                    BlockPos newPlayerPos = currentPlayerPos.up().south();

                    // Set the player's position to the new position
                    minecraftClient.player.updatePosition(newPlayerPos.getX(), newPlayerPos.getY(), newPlayerPos.getZ());
                }
            }
            else if(jump_up_west.wasPressed()) {
                // up
                MinecraftClient minecraftClient = MinecraftClient.getInstance();
                if (minecraftClient.player != null) {
                    // Get the current position of the player
                    BlockPos currentPlayerPos = minecraftClient.player.getBlockPos();
                    // Move the player one block north
                    BlockPos newPlayerPos = currentPlayerPos.up().west();
                    // Set the player's position to the new position
                    minecraftClient.player.updatePosition(newPlayerPos.getX(), newPlayerPos.getY(), newPlayerPos.getZ());
                }
            }
        });
    }

    //      I
    //     J L   MOVING DIRECTION   P IS UP
    //      K
    // jump up north east south weth
    //          8     6    1     4
    public static void register() {
        move_north = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_MOVE_NORTH,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_I,
                KEY_CATEGORY_TUTORIAL
        ));
        move_east = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_MOVE_EAST,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_L,
                KEY_CATEGORY_TUTORIAL
        ));
        move_south = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_MOVE_SOUTH,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_K,
                KEY_CATEGORY_TUTORIAL
        ));
        move_west = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_MOVE_WEST,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_J,
                KEY_CATEGORY_TUTORIAL
        ));
        move_up = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_MOVE_UP,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_P,
                KEY_CATEGORY_TUTORIAL
        ));
        jump_up_north = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_JUMP_UP_NORTH,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_8,
                KEY_CATEGORY_TUTORIAL
        ));

        jump_up_east = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_JUMP_UP_EAST,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_6, // Change the key here, e.g., GLFW.GLFW_KEY_Q for example
                KEY_CATEGORY_TUTORIAL`
        ));

        jump_up_south = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_JUMP_UP_SOUTH,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_2, // Change the key here
                KEY_CATEGORY_TUTORIAL
        ));

        jump_up_west = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_JUMP_UP_WEST,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_4, // Change the key here
                KEY_CATEGORY_TUTORIAL
        ));

        registerKeyInputs();
    }

}