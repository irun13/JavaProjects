package hw7;

public class Cat {
    private String name;
    int appetite = 10;
    boolean hunger;

    public Cat(String name) {
        this.name = name;
        this.hunger = false;
    }

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.hunger = false;
    }

    public String getName() {
        return name;
    }
    public Boolean getHunger() {
        return hunger;
    }

    public void eat(Plate plate) {
        System.out.println(name + " eat...");
        plate.decreaseFood(appetite, this);
    }

}

