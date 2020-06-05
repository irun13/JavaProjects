package hw7;

public class Cat {
    private String name;
    int appetite = 10;

    public Cat(String name) {
        this.name = name;
    }

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public String getName() {

        return name;
    }

    public void eat(Plate plate) {
        System.out.println(name + " eat...");
        plate.decreaseFood(appetite);
    }

}

