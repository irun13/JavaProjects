package hw6;
import java.util.Random;

public class Dog extends Animal {
    static Random random = new Random();

    int countDog = 5;
    int maxrun = 500;
    int maxswim = 10;
    public Dog(String name, String color, int age) {
        super(name, color, age);
        countDog++;
    }

    @Override
    public void run(int m) {
        if(m>=0) {
            if (m >= maxrun) {
                m = maxrun;
            }
            System.out.println(name + " пробежал " + m + " метров.");
        }else {
            System.out.println("собака не умеет бегать задом");
        }
    }
    @Override
    public void swim(int m) {
        if(m>=0) {
            if (m >= maxswim + random.nextInt(500) ) {  // разброс у песика может быть 500 метров
                m = maxswim;
            }
            System.out.println(name + " проплыл " + m + " метров.");
        }else {
            System.out.println("собака не умеет плавать задом");
        }
    }
    public int getCountDog(){
        return countDog;
    }
}
