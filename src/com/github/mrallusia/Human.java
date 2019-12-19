package com.github.mrallusia;

/**
 * Объект класса человек
 */

public class Human implements RunnerType{

    private String name;
    private int MaxRunDistance;
    private int MaxJumpHeight;
    private boolean able = true; // параметр для проверки на преодоления полосы препятствий

    public Human(String name, int MaxRunDistance, int MaxJumpHeight) {
        this.name = name;
        this.MaxRunDistance = MaxRunDistance; // Высота прыжка
        this.MaxJumpHeight = MaxJumpHeight; //Дистанция бега
    }

    //переопределяем методы интерфейсов

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getMaxDist() {
        return MaxRunDistance;
    }

    @Override
    public int getMaxHeight() {
        return MaxJumpHeight;
    }

    @Override
    public void doIt(Obstacle ob) {

        if  (able) {
            if (ob instanceof wall) {

                if (ob.getParam() > 0 && ob.getParam() <= MaxJumpHeight) {
                    jump();
                }
                else if (ob.getParam() > MaxJumpHeight) {
                    System.err.println(this.name + " не прыгнет на " + ob.getParam() + " Сошёл с дистанции");
                    this.able = false;
                }
                else {
                    System.err.println("Не стена, а скорее яма!");
                }

            }
            else if (ob instanceof runningtrack) {
                if (ob.getParam() > 0 && ob.getParam() <= MaxRunDistance) {
                    run();
                }
                else if (ob.getParam() > MaxRunDistance) {
                    System.err.println(this.name + " не смог пробежать " + ob.getParam() + " Сошёл с дистанции");
                    this.able = false;
                }
                else {
                    System.err.println("Некуда бежать!");
                }

            }
        }

    }

    //методы бега и прыга
    public void run() {
        System.out.println(this.name + " успешно пробежал");
    }

    public void jump() {
        System.out.println(this.name + " успешно перепрыгнул");
    }

}
