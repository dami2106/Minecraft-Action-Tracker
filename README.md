# Minecraft Action Tracker
 A Fabric mod for Minecraft to log discrete actions of the minecraft player. 

## Usage 
The mod works entirely within Minecraft. There are 2 commands needed to control the logger. Please see installation details below for instructions on installing a Fabric mod. 

### Start Logging:
To start the logger, within Minecraft, run the following command:
```
/actiontracker start <file_name.txt>
```
Note that the `<file_name.txt>` argument is optional, it allows you to specify a custom name for the log file. 
The default name is **log_action.txt**. This output file can be found in your Minecraft 
installation logs directory, or in your mod's log directory. 

### Stop Logging:
To stop the logger, and save changes to the file, run the following from within Minecraft:
```
/actiontracker stop
```

## Installation 
Download the latest .jar file from the GitHub. Once this .jar has been downloaded, please follow the following tutorial to install the mod to Minecraft. 
Note the mod was built for Minecraft version 1.20.4 and has not been tested on any earlier or later versions.  
  
Please see [here](https://fabricmc.net/wiki/player:tutorials:adding_mods) for installing mods made for Fabric. 

## Logging Abilities 
Currently, the logger is able to detect: 
 - A block broken by the player, along with the coordinates and block type 
 - A block placed by the player, along with the coordinates and block type 
 - Players position when breaking or placing a block 
 - Players discrete movement, when moving in either North, East, South, or West. Logged on a per block movement scale. 

### Example Output Format:
```
place,cobblestone,(-201.0, -60.0, 104.0),player,(-199.0, -60.0, 104.0)
move,old,(-200.0, -59.0, 104.0),new,(-199.0, -59.0, 104.0)
move,old,(-200.0, -59.0, 104.0),new,(-201.0, -59.0, 104.0)
place,cobblestone,(-201.0, -59.0, 104.0),player,(-200.0, -57.0, 104.0)
break,cobblestone,(-201.0, -60.0, 104.0),player,(-199.0, -60.0, 104.0)
```  

## Limitations 
Currently, the mod is not able to track diagonal jumping. 
We are only able to track plain movement of the player in standard NESW directions.  

Additionally, only a single player can be logged at a time on a single-player world (multiplayer has not been tested).  

Only 1 logger can be run at a time. 


