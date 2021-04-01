package com.javarush.task.task34.task3410.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

public class LevelLoader {
    private Path levels;

    public LevelLoader(Path levels) {
        this.levels = levels;
    }

    public GameObjects getLevel(int level) {

        Set<Wall> walls = new HashSet<>();
        Set<Box> boxes = new HashSet<>();
        Set<Home> homes = new HashSet<>();
        Player player = null;

        int needLevel = level % 60 == 0 ? 60 : level % 60;
        final int skipLine = 6;
        try (FileReader fis = new FileReader(levels.toFile());
             BufferedReader br = new BufferedReader(fis)) {
            String line;
//            ищем нужный уровень
            while (!br.readLine().equals("Maze: " + needLevel)) {
            }
//            пропускаем служеные строки
            int i = 0;
            while (i < skipLine) {
                i++;
                br.readLine();
            }
//            считываем информацию об элементах уровня
            int y = Model.FIELD_CELL_SIZE/2;
            while (!(line = br.readLine()).equals(""))       {
                int x = Model.FIELD_CELL_SIZE/2;
                for (int j = 0; j < line.length(); j++) {
                    switch (line.charAt(j)) {
                        case 'X': {
                            walls.add(new Wall(x, y));
                            break;
                        }
                        case '*': {
                            boxes.add(new Box(x, y));
                            break;
                        }
                        case '.': {
                            homes.add(new Home(x, y));
                            break;
                        }
                        case '&': {
                            homes.add(new Home(x, y));
                            boxes.add(new Box(x, y));
                            break;
                        }
                        case '@': {
                            player = new Player(x, y);
                        }
                    }
                    x += Model.FIELD_CELL_SIZE;
                }
                y += Model.FIELD_CELL_SIZE;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new GameObjects(walls,boxes,homes,player);
    }
}
