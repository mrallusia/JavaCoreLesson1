import com.github.mrallusia.*;

/**
 * made bu Pavel 18.12.2019
 */

public class MainClass {

    public static void main(String[] args) {

        //создал бегащих и задал им параметры
        Human human1 = new Human("Albert Semionovich", 300, 1);
        Cat cat1 = new Cat("Cheshirskiy", 600, 2);
        Robot robot1 = new Robot("Робоцип", 2500, 0);

        //массив объектов
        RunnerType[] runnres = {human1, cat1, robot1};
        Obstacle[] obstacles = {new wall(1), new runningtrack(150), new wall(2), new wall(1), new runningtrack(600)};

        //циклы взаимодействий с препятствиями
        for (RunnerType r : runnres) {
            System.out.println(r.getName() + " Начал забег с препятсивиями");
            for (Obstacle track : obstacles) {
                r.doIt(track); // просим объект преодолеть препятствие
            }
            System.out.println(r.getName() + " Закончил забег с препятсивиями");
        }

    }

}
