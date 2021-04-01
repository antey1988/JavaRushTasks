package com.javarush.task.task34.task3410.model;

public abstract class CollisionObject extends GameObject {
    public CollisionObject(int x, int y) {
        super(x, y);
    }

    public boolean isCollision(GameObject gameObject, Direction direction) {
        switch (direction) {
            case LEFT:
                return ((x - Model.FIELD_CELL_SIZE == gameObject.x) && y == gameObject.y);
            case RIGHT:
                return ((x + Model.FIELD_CELL_SIZE == gameObject.x) && y == gameObject.y);
            case UP:
                return (x == gameObject.x && (y - Model.FIELD_CELL_SIZE == gameObject.y));
            case DOWN:
                return (x == gameObject.x && (y + Model.FIELD_CELL_SIZE == gameObject.y));
        }
        return false;
    }
}
