package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.positions.World;

import game.actors.NurseJoy;
import game.actors.Player;
import game.grounds.*;
import game.items.Pokefruit;
import game.pokemon.*;


/**
 * The main class to start the game.
 * Created by:
 *
 * @author Riordan D. Alfredo
 *
 * Modified by: Raunak Koirala
 */
public class Application {

    /**
     * This is the main execution and logic for the code that runs the world
     */
    public static void main(String[] args) {

        World world = new World(new Display());

        FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(),
                new Floor(), new Tree(),
                new Lava(), new Puddle(), new Crater(), new Hay(), new Waterfall());

        List<String> map = Arrays.asList(
                ".............................................^^^^^^^^^^^^^^",
                "...........,.,................................,.,..^^^^O^^^",
                ".....................................................^^^^^^",
                "........................................................^^^",
                "............................###.............,,...........^^",
                "............................#.#.............,T............^",
                "..,,,................,.....................................",
                "..,.,......~...............................................",
                "...~~~~~~~~................................................",
                "....~~~~~..................................................",
                "~~W.~~~.,............................,,,...................",
                "~~..~~.,.,...........................,T,...................",
                "~~~~~~~~~............................,.....................");
        GameMap gameMap = new GameMap(groundFactory, map);
        world.addGameMap(gameMap);


        FancyGroundFactory secondFactory = new FancyGroundFactory(new Dirt(),new Floor(),new Wall());

        List<String> pokemonCenter = Arrays.asList(
                "##################",
                "#________________#",
                "#______....._____#",
                "#________________#",
                "#________________#",
                "########_._#######");

        GameMap secondGameMap = new GameMap(secondFactory,pokemonCenter);

        world.addGameMap(secondGameMap);




        Player ash = new Player("Ash", '@', 1);
        world.addPlayer(ash, gameMap.at(29, 6));


        Actor nurseJoy = new NurseJoy("NurseJoy", '%', 100);
        secondGameMap.at(9, 2).addActor(nurseJoy);


        gameMap.at(29,5).setGround(new EntranceDoor(9, 5, secondGameMap));
        secondGameMap.at(9,5).setGround(new EntranceDoor(29,5,gameMap));


        Actor pikachu = new Pikachu();
        gameMap.at(33, 10).addActor(pikachu);




        world.run();

    }
}
