package com.javarush.task.task34.task3410.model;

import com.javarush.task.task34.task3410.controller.EventListener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Paths;

public class Model {
    public static final int FIELD_CELL_SIZE = 20;

    private GameObjects gameObjects;
    private int currentLevel = 1;
    private EventListener eventListener;
    private LevelLoader levelLoader;
//    private LevelLoader levelLoader = new LevelLoader(Paths.get("E:\\Programming\\IdeaProjects\\JavaRushTasks\\out\\production\\4.JavaCollections\\com\\javarush\\task\\task34\\task3410\\res"));

    public Model() {
        URL url = this.getClass().getResource("../res/levels.txt");
        String resources = null;
        if (url == null) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                System.out.println("Enter path to file with information about levels");
                resources = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            resources = url.getPath();
        }
        System.out.println(resources);
        levelLoader = new LevelLoader(Paths.get(resources));
    }

    public GameObjects getGameObjects() {
        return gameObjects;
    }

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }
    public void move(Direction direction) {
        Player player = gameObjects.getPlayer();
        if (checkWallCollision(player, direction)) return;
        if (checkBoxCollisionAndMoveIfAvailable(direction)) return;
        int dx = direction == Direction.LEFT ? -FIELD_CELL_SIZE : (direction == Direction.RIGHT ? FIELD_CELL_SIZE : 0);
        int dy = direction == Direction.UP ? -FIELD_CELL_SIZE : (direction == Direction.DOWN ? FIELD_CELL_SIZE : 0);
        player.move(dx, dy);
        checkCompletion();
    }

    public void restart() {
        restartLevel(currentLevel);
    }

    public void startNextLevel() {
        restartLevel(++currentLevel);
    }

    public boolean checkWallCollision(CollisionObject gameObject, Direction direction) {
        return gameObjects.getWalls().stream().anyMatch(w -> gameObject.isCollision(w, direction));
    }

    public boolean checkBoxCollisionAndMoveIfAvailable(Direction direction) {
        Player player = gameObjects.getPlayer();
        for (Box box : gameObjects.getBoxes()) {
            if (player.isCollision(box, direction)) {
                if (checkWallCollision(box, direction)) {
                    return true;
                } else {
                    if (gameObjects.getBoxes().stream().filter(b -> !b.equals(box)).anyMatch(b -> box.isCollision(b, direction))) {
                        return true;
                    } else {
                        int dx = direction == Direction.LEFT ? -FIELD_CELL_SIZE : (direction == Direction.RIGHT ? FIELD_CELL_SIZE : 0);
                        int dy = direction == Direction.UP ? -FIELD_CELL_SIZE : (direction == Direction.DOWN ? FIELD_CELL_SIZE : 0);
                        box.move(dx, dy);
                        return false;
                    }
                }
            }
        }
        return false;
    }

    public void checkCompletion() {
        int countInHome = 0;
        for (Home home : gameObjects.getHomes()) {
            for (Box box : gameObjects.getBoxes()) {
                if (box.x == home.x && box.y == home.y) countInHome++;
            }
        }
        if (countInHome == gameObjects.getHomes().size()) {
            eventListener.levelCompleted(currentLevel);
        }
    }

    public void restartLevel(int level) {
        gameObjects = levelLoader.getLevel(level);
    }
}
