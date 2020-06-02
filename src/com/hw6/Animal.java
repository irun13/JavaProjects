package hw6;

public class Animal {
    String name;
    String color;
    int age;

    public Animal(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    public void run(int m) {
        System.out.println(name + " пробежал " + m + " метров.");
    }

    public void swim(int m) {
        System.out.println(name + " проплыл " + m + " метров.");
    }
}
