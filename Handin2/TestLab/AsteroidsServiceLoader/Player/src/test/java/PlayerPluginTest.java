import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

import dk.sdu.mmmi.cbse.playersystem.Player;
import dk.sdu.mmmi.cbse.playersystem.PlayerPlugin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerPluginTest {
    private PlayerPlugin playerPlugin;
    private Entity player;
    private World world;
    private GameData gameData;

    public PlayerPluginTest() {
    }

    @BeforeEach
    public void init() {
        playerPlugin = new PlayerPlugin();
        world = new World();
        gameData = new GameData();
    }

    @Test
    public void playerInstance() {
        //Adds a player into the game
        playerPlugin.start(gameData, world);

        //Test for player instance
        boolean playerInstance = false;

        //Foreach loop for the world entities, checks if an entity instance is a player
        for (Entity entity : world.getEntities()) {
            if (entity instanceof Player) {
                playerInstance = true;
            }
        }
        //Asserts if the playerInstance is true, ie. one of the entities in the game is a player.
        assertTrue(playerInstance);
        System.out.println("An instance of the player is: " + playerInstance);
    }


    @Test
    public void noPlayerInstance() {
        //A player ship is created and the player is added (only way i could make it work)
        player = playerPlugin.createPlayerShip(gameData);
        playerPlugin.start(gameData, world);


        //Test for player instance
        boolean playerInstance = true;

        //Removes the player from the game world.
        world.removeEntity(player);

        //Foreach loop for the world entities, checks if an entity instance is a player
        for (Entity entity : world.getEntities()) {
            if (entity.equals(player)) {
                playerInstance = true;
            } else {
                //If the instances aren't the entity type player, then the test player instance is false
                playerInstance = false;
            }
        }
        //Asserts if the playerInstance is false, ie. one of the entities in the game is not a player.
        assertEquals(false, playerInstance);
        System.out.println("An instance of the player is: " + playerInstance);
    }
}
