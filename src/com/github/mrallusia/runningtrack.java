package com.github.mrallusia;

/**
 * Объект препятствия беговая дистанция
 */

public class runningtrack implements Obstacle{

    private int distance;

    public runningtrack(int distance) {
        this.distance = distance;
    }

    public int getParam() {
        return distance;
    }


}
