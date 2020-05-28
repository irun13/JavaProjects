package hw5;

public class Employee {
/* Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст;
 * Конструктор класса должен заполнять эти поля при создании объекта;
 * Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;*/

    private String name;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    // конструктор
    public Employee(String name, String position, String email, String phone, int salary, int age){
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;

    }
    public void info() {
        System.out.println("namе " + name);
        System.out.println("position " + position);
        System.out.println("email " + email);
        System.out.println("phone " + phone);
        System.out.println("salary " + salary);
        System.out.println("age " + age);
    }

    public int getAge() {
        return age;
    }
    public String getName() {
        return name;
    }

}
