package hw6;

public class Cat extends Animal {
    int maxrun = 200;
    int countCat = 0;
    public Cat(String name, String color, int age) {
        super(name, color, age);
        countCat++;
    }

    @Override
    public void run(int m) {
        if(m>=0) {
            if (m >= maxrun) {
                m = maxrun;
            }
            System.out.println(name + " пробежал " + m + " метров.");
        }else {
            System.out.println("кот не умеет бегать задом");
        }
    }
    @Override
    public void swim(int m) {
        System.out.println("кот не умеет плавать(");
    }

    public int getCountCat(){
        return countCat;
    }
}
