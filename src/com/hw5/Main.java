package hw5;

import java.sql.SQLOutput;

public class Main {
    /** Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст;
     * Конструктор класса должен заполнять эти поля при создании объекта;
     * Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;
     * Создать массив из 5 сотрудников
     Пример:
     Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
     persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30); // потом для каждой ячейки массива задаем объект
     persArray[1] = new Person(...);
     ...
     persArray[4] = new Person(...);
     * С помощью цикла вывести информацию только о сотрудниках старше 40 лет;*/

    public static void main(String[] args) {
        //Employee employee1 = new Employee ("Ирина","Аналитик", "Volkova.irka@yandex.ru", "8787878", 123, 12);
        //employee1.info();
        Employee[] employeeArr = new Employee[5];
        employeeArr[0] = new Employee ("Дарт Сидиус","Император Палпатин", "DartSidius@yandex.ru", "6 666 66666666", 123, 100500);
        employeeArr[1] = new Employee ("Граф Дуку","ситх", "GrafDuKu@yandex.ru", "8787878", 90000, 45);
        employeeArr[2] = new Employee ("Падме Амидала"," королева планеты Набу́", "PadmeAmidalaNaberrie@yandex.ru", "777", 1230000, 16);
        employeeArr[3] = new Employee ("C-3P0","робот", "C-3P0@yandex.ru", "-", 0, 100500);
        employeeArr[4] = new Employee ("Оби-Ван Кеноби","рыцарь-джедай", "Obi-WanKenobi@yandex.ru", "7 777 7777777", 0, 32);

        for (int i = 0; i < employeeArr.length ; i++) {
            if (employeeArr[i].getAge() > 40){
                System.out.println("Сотрудник " + employeeArr[i].getName());
                employeeArr[i].info();
                System.out.println("****************************");
            }

        }
    }
}
