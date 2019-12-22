package com.github.mrallusia;

/**
 * Интерфейс для участников забега
 */

public interface RunnerType {
    String getName();
    int getMaxDist();
    int getMaxHeight();

    void doIt(Obstacle obs);
}
