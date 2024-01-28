package com.dami.actiontracker;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.loader.impl.lib.sat4j.core.Vec;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ActionResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Formatting;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import net.minecraft.world.World;
import net.minecraft.world.BlockView;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import com.dami.actiontracker.command.ReturnHomeCommand;

public class ActionTracker implements ModInitializer {
    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final String MOD_ID = "ActionTracker";
    public static final Logger LOGGER = LoggerFactory.getLogger("actiontracker");

    public static final Vec3d NORTH = new Vec3d(0, 0, -1.0);
    public static final Vec3d EAST = new Vec3d(1.0, 0, 0);
    public static final Vec3d SOUTH = new Vec3d(0, 0, 1.0);
    public static final Vec3d WEST = new Vec3d(-1.0, 0, 0);


    public Vec3d oldPlayerPos = new Vec3d(-999, -999, -999);
    public Vec3d oldBlockPos = new Vec3d(-999, -999, -999);

    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        System.out.println("Logger Init");
        ServerTickEvents.START_SERVER_TICK.register(this::onServerTick);

        AttackBlockCallback.EVENT.register((player, world, hand, pos, direction) -> {
            if (player instanceof ServerPlayerEntity) {
                onPlayerBreakBlock((ServerPlayerEntity) player, pos, world);
//                return ActionResult.success(true);  // Return true to indicate the block was successfully attacked
            }
            return ActionResult.PASS;  // Return false if the block was not successfully attacked
        });


//        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
//            if (player instanceof ServerPlayerEntity) {
//                BlockPos pos = hitResult.getBlockPos();
//
//                onBlockPlaced((ServerPlayerEntity) player, pos, world);
//            }
//            return ActionResult.PASS;
//        });

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		CommandRegistrationCallback.EVENT.register(ReturnHomeCommand::register);

		System.out.println("Logger Init");
		ServerTickEvents.START_SERVER_TICK.register(this::onServerTick);

		AttackBlockCallback.EVENT.register((player, world, hand, pos, direction) -> {
			if (player instanceof ServerPlayerEntity) {
				onPlayerBreakBlock((ServerPlayerEntity) player, pos, world);
				return ActionResult.success(true);  // Return true to indicate the block was successfully attacked
			}
			return ActionResult.success(false);  // Return false if the block was not successfully attacked
		});
        PlayerInteractBlockCallback.EVENT.register((player, world, hand, pos, direction) -> {


        });
    }

    private void onBlockPlaced(ServerPlayerEntity player, BlockPos pos, World world) {
        // Get the coordinates of the placed block
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();

        Vec3d blockPos = new Vec3d(x, y, z);
        Vec3d playerPos = getPlayerVec(player);
        String blockName = getBlockName(world, x, y, z);

        System.out.println("place," + blockName + "," + blockPos.toString() + ",player," + playerPos.toString());
    }

    public String getBlockName(World world, int x, int y, int z) {
        BlockPos blockPos = new BlockPos(x, y, z);
        BlockState blockState = world.getBlockState(blockPos);
        Block block = blockState.getBlock();

        String blockString = block.toString();
        String blockData = blockString.split(":")[1];
        return blockData.substring(0, blockData.length() - 1);
    }

    private void onPlayerBreakBlock(ServerPlayerEntity player, BlockPos pos, World world) {
        // Get the coordinates of the broken block
        int x = (int) pos.getX();
        int y = (int) pos.getY();
        int z = (int) pos.getZ();

        Vec3d blockPos = new Vec3d(x, y, z);
        Vec3d playerPos = getPlayerVec(player);

        String blockName = getBlockName(world, x, y, z);
        if (!blockName.equals("air")) {
            System.out.println("break," + blockName + "," + blockPos.toString() + ",player," + playerPos.toString());
//            world.breakBlock(pos, true, player);
        }

    }

    private Vec3d getPlayerVec(ServerPlayerEntity player) {
        int x = (int) player.getX();
        int y = (int) player.getY();
        int z = (int) player.getZ();

        return new Vec3d(x, y, z);
    }

    private Vec3d getDiffVector(Vec3d newVec, Vec3d oldVec) {
        Vec3d resultant = newVec.subtract(oldVec);
        resultant = resultant.normalize();
        return resultant;
    }

    private String getPlayerDirection(Vec3d playerPos) {
        String dir = "";

        Vec3d resultant = getDiffVector(playerPos, oldPlayerPos);

        if (resultant.equals(NORTH)) {
            dir = "NORTH";
        } else if (resultant.equals(EAST)) {
            dir = "EAST";
        } else if (resultant.equals(SOUTH)) {
            dir = "SOUTH";
        } else if (resultant.equals(WEST)) {
            dir = "WEST";
        }

        oldPlayerPos = playerPos;

        return dir;
    }

    private void onServerTick(MinecraftServer server) {
        // Iterate over all loaded worlds

        server.getWorlds().forEach(world -> {
            if (world != null) {
                // Iterate over all players in the world
                ((ServerWorld) world).getPlayers().forEach(player -> {
                    // Print player's position every 20 ticks (1 second)
                    if (server.getTicks() % 5 == 0) {
                        int x = (int) player.getX();
                        int y = (int) player.getY();
                        int z = (int) player.getZ();

                        Vec3d playerPos = new Vec3d(x, y, z);
                        String pd = getPlayerDirection(playerPos);
                        if (!playerPos.equals(oldPlayerPos)) {
                            System.out.println("MOVE: " + pd);
                        }
                    }
                });
            }
        });
    }
}