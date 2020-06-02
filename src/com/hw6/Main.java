package hw6;

public class Main {
        /*1. Создать классы Собака и Кот с наследованием от класса Животное.
2. Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия. Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
4. * Добавить подсчет созданных котов, собак и животных.
5. * Добавить животным разброс в ограничениях. То есть у одной собаки ограничение на бег может быть 400 м., у другой 600 м.*/

    public static void main(String[] args) {
        Cat cat = new Cat("Barsik", "red", 2);
        cat.run(250);
        cat.swim(150);

        Dog dog = new Dog("Bobik0", "blue", 2);
        dog.run(555);
        dog.swim(150);

        Dog dog1 = new Dog("Bobik1", "blue", 2);
        dog.run(2);
        dog.swim(-150);

        System.out.println(dog1.getCountDog());
    }
}
