package com.javarush.task.task35.task3513;

import java.util.*;
import java.util.stream.Collectors;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    private Stack<Tile[][]> previousStates;
    private Stack<Integer> previousScores;
    private boolean isSaveNeeded = true;
    private int countAutoStep = 50;

    int score = 0;
    int maxTile = 0;

    public Model() {
        gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        previousStates = new Stack<>();
        previousScores = new Stack<>();
        resetGameTiles();
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    void resetGameTiles() {
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[0].length; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
    }

    private void addTile() {
        List<Tile> emptyTiles = getEmptyTiles();
        if (emptyTiles.isEmpty())
            return;

        int value = Math.random() < 0.9 ? 2 : 4;
        int index = (int)(Math.random() * emptyTiles.size());
        emptyTiles.get(index).value = value;
    }

    private List<Tile> getEmptyTiles() {
        return Arrays.stream(gameTiles).flatMap(Arrays::stream)
                .filter(Tile::isEmpty)
                .collect(Collectors.toList());
    }

    private boolean compressTiles(Tile[] tiles) {
        boolean isCompressed = false;
        //счетчик обхода элементов переданного массива
        int i = 0;
        //обходим элементы массива поко не обнаружим элемент с нулевым значение либо пока не дойдем до конца массива
        while (i < tiles.length && !tiles[i++].isEmpty());
        //индекс первого нулевого элемента
        int k = i-1;
        //обходим оставшиеся элементы массива в поиске не нулевых,
        //при обнаружении такового перезаписываем его значение в "левее стоящий" пустой элемент
        //и обнуляем значение найденого элемента
        for (int j = i; j < tiles.length; j++) {
            if (!tiles[j].isEmpty()) {
                tiles[k++].value = tiles[j].value;
                tiles[j].value = 0;
                isCompressed = true;
            }
        }
        return isCompressed;
    }

    private boolean mergeTiles(Tile[] tiles) {
        boolean isMerged = false;
        for (int i = 0; i < tiles.length - 1; i++) {
            //если сосодние элементы равны и имеют значение отличные от нуля делаем слияние
            if (tiles[i].value == tiles[i+1].value) {
                if (tiles[i].value != 0) {
                    //флаг факта слияния
                    isMerged = true;
                    int newValue = tiles[i].value * 2;
                    //обновляем новое максимальное значение ячейки
                    if (newValue > maxTile) {
                        maxTile = newValue;
                    }
                    //делаемприращение суммарного счета
                    score += newValue;
                    //изменение значений в ячейках
                    tiles[i].value = newValue;
                    tiles[i + 1].value = 0;
                }
                //делаем перескок через слившиеся ячейки
                i++;
            }
        }

        if (isMerged) {
            compressTiles(tiles);
        }
        return isMerged;
    }

    public boolean canMove() {
        if (getEmptyTiles().size() > 0) {
            return true;
        }
        int countRow = gameTiles.length;
        int countCol = gameTiles[0].length;
        for (int x = 0; x < countRow; x++) {
            for (int y = 0; y < countCol; y++) {
                Tile t = gameTiles[x][y];
                if ((x < countRow - 1 && t.value == gameTiles[x + 1][y].value)
                        || ((y < countCol - 1) && t.value == gameTiles[x][y + 1].value)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void left() {
        if (isSaveNeeded) {
            saveState(gameTiles);
        }
        boolean isChanged = false;
        for (int i = 0; i < gameTiles.length; i++) {
            Tile[] line = gameTiles[i];
            if (compressTiles(line) | mergeTiles(line)) {
                isChanged = true;
            }
        }
        if (isChanged) {
            addTile();
        }
        isSaveNeeded = true;
    }

    public void up() {
        saveState(gameTiles);
        rotate();
        rotate();
        rotate();
        left();
        rotate();
    }

    public void right() {
        saveState(gameTiles);
        rotate();
        rotate();
        left();
        rotate();
        rotate();
    }

    public void down() {
        saveState(gameTiles);
        rotate();
        left();
        rotate();
        rotate();
        rotate();
    }

    private void rotate() {
        int countRow = gameTiles.length;
        int countCol = gameTiles[0].length;
        Tile[][] tiles = new Tile[countCol][countRow];
        for (int i = 0; i < countRow; i++) {
            for (int j = 0; j < countCol; j++) {
                tiles[j][countRow-1-i] = gameTiles[i][j];
            }
        }
        gameTiles = tiles;
    }

    private void saveState(Tile[][] tiles) {
        int countRow = tiles.length;
        int countCol = tiles[0].length;
        Tile[][] top = new Tile[countRow][countCol];
        for (int i = 0; i < countRow; i++) {
            for (int j = 0; j < countCol; j++) {
                top[i][j] = new Tile(tiles[i][j].value);
            }
        }
        previousStates.push(top);
        previousScores.push(score);
        isSaveNeeded = false;
    }

    void rollback() {
        if (previousStates.size() > 0 && previousScores.size() > 0) {
            gameTiles = previousStates.pop();
            score = previousScores.pop();
        }
    }

    void randomMove() {
        int i = ((int)(Math.random()*100)) % 4;
        switch (i) {
            case 0: {
                left();
                break;
            }
            case 1: {
                up();
                break;
            }
            case 2: {
                right();
                break;
            }
            case 3: {
                down();
                break;
            }
        }
    }

    private boolean hasBoardChanged() {
        Tile[][] tiles = previousStates.peek();
        int countRow = tiles.length;
        int countCol = tiles[0].length;
        for (int i = 0; i < countRow; i++) {
            for (int j = 0; j < countCol; j++) {
                if (tiles[i][j].value != gameTiles[i][j].value) {
                    return true;
                }
            }
        }
        return false;
    }

    private MoveEfficiency getMoveEfficiency(Move move) {
        move.move();
        MoveEfficiency moveEfficiency;
        if (!hasBoardChanged()) {
            moveEfficiency = new MoveEfficiency(-1, 0, move);
        } else {
            moveEfficiency = new MoveEfficiency(getEmptyTiles().size(), score, move);
        }
        rollback();
        return moveEfficiency;
    }

    void autoMove() {
        PriorityQueue<MoveEfficiency> moveEfficiencies = new PriorityQueue<>(4, Collections.reverseOrder());
        moveEfficiencies.offer(getMoveEfficiency(this::left));
        moveEfficiencies.offer(getMoveEfficiency(this::up));
        moveEfficiencies.offer(getMoveEfficiency(this::right));
        moveEfficiencies.offer(getMoveEfficiency(this::down));
        moveEfficiencies.peek().getMove().move();
    }

    public void startAutoMove() {
        int i = 0;
        while (i++ < countAutoStep) {
            autoMove();
        }
    }
}
