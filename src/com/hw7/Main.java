package hw7;

import hw5.Employee;

import java.sql.SQLOutput;

public class Main {
    /*
    1. Расширить задачу про котов и тарелки с едой
2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды (например, в миске 10 еды, а кот пытается покушать 15-20)
3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту удалось покушать (хватило еды), сытость = true
4. Считаем, что если коту мало еды в тарелке, то он ее просто не трогает, то есть не может быть наполовину сыт (это сделано для упрощения логики программы)
5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести информацию о сытости котов в консоль
6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку
    */
    public static void main(String[] args) {
        Cat[] catArr = new Cat[5];
        catArr[0] = new Cat("Bars");
        catArr[1] = new Cat("Irun", 50);
        catArr[2] = new Cat("BigIrun", 72);
        catArr[3] = new Cat("SmolIrun", 2);
        catArr[4] = new Cat("BigIvan", 172);

        Plate plate = new Plate(50);

        for (int i = 0; i < catArr.length; i++) {
            catArr[i].eat(plate);
            System.out.println("Котик " + catArr[i].getName() + " сыт? " + catArr[i].getHunger() + ". В тарелке осталось " + plate.getFood());
        }

        plate.info();
        plate.addFood(150);
        plate.info();

    }
}

