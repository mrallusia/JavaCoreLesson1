package com.github.mrallusia;

/**
 * Объект препятствия стена
 */

public class wall implements Obstacle{

    private int height;

    public wall(int height) {
        this.height = height;
    }

    public int getParam() {
        return height;
    }
}
