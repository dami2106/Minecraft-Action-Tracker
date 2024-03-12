# Minecraft Action Tracker
 A Fabric mod for Minecraft to log discrete actions of the minecraft player. 

## Usage 
The mod works entirely within Minecraft. There are 2 commands needed to control the logger. Please see installation details below for instructions on installing a Fabric mod. Controls for discretely moving the player are also presented below 

### Start Logging:
To start the logger, within Minecraft, run the following command:
```
/actiontracker start <file_name.txt>
```
Note that the `<file_name.txt>` argument is optional, it allows you to specify a custom name for the log file. 
The default name is **log_action.txt**. This output file can be found in your Minecraft 
installation directory. 

### Stop Logging:
To stop the logger, and save changes to the file, run the following from within Minecraft:
```
/actiontracker stop
```

### Discrete Movement Keys:
 - **I** :  Move forward by 1 block
 - **O** : Jump Up and Move forward 1 block 
 - **U** : Jump Down and Move forward 1 block

These key bindings can be changed anytime in the Minecraft keybind menu:
<img width="974" alt="Screenshot 2024-03-12 at 17 18 01" src="https://github.com/dami2106/Minecraft-Action-Tracker/assets/102320150/6fe4453b-7a59-44d4-a5da-228b9f99807d">


## Installation 
Download the latest .jar file from the GitHub. Once this .jar has been downloaded, please follow the following tutorial to install the mod to Minecraft. 
Note the mod was built for Minecraft version 1.20.4 and has not been tested on any earlier or later versions.  
  
Please see [here](https://fabricmc.net/wiki/player:tutorials:adding_mods) for installing mods made for Fabric. 

Please also note that the Fabric API is also needed alongside the Action Tracker Mod. This can be downloaded from [here](https://www.curseforge.com/minecraft/mc-mods/fabric-api). 

## Logging Abilities 
Currently, the logger is able to detect: 
 - A block broken by the player, along with the coordinates and block type 
 - A block placed by the player, along with the coordinates and block type 
 - Players position when breaking or placing a block 
 - Players discrete movement, when moving in either North, East, South, or West.
 - Player Jumping Up a block in a cardinal direction
 - Player Jumping Down a block in a cardinal direction

### Example Output Format:
```
move,east
break,east,cobblestone
move,west
place,east,cobblestone
jumpup,east
```  

## Limitations 
 - Only a single player can be logged at a time on a single-player world (multiplayer has not been tested).
 - Only 1 logger can be run at a time.
 - Pickup up and Dropping items is not logged 


