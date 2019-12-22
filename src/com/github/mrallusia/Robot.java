package com.github.mrallusia;

/**
 * Объект класса робот
 */

public class Robot implements RunnerType{

    private String model; // Модель
    private int MaxRunDistance;
    private int MaxJumpHeight;
    private boolean able = true; // параметр для проверки на преодоления полосы препятствий


    public Robot(String model, int MaxRunDistance, int MaxJumpHeight) {
        this.model = model;
        this.MaxRunDistance = MaxRunDistance; // Высота прыжка
        this.MaxJumpHeight = MaxJumpHeight; //Дистанция бега
    }

    //переопределяем методы интерфейсов

    @Override
    public String getName() {
        return model;
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
                    System.err.println(this.model + " умеет прыгать. Сошёл с дистанции");
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
                    System.err.println(this.model + " не смог пробежать " + ob.getParam() + " Сошёл с дистанции");
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
        System.out.println(this.model + " успешно пробежал");
    }

    public void jump() {
        System.out.println(this.model + " успешно перепрыгнул");
    }

}
