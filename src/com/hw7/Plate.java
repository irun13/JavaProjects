package hw7;

public class Plate {
    private int food;

    public Plate(int food) {

        this.food = food;
    }

    public int getFood() {

        return food;
    }

    public void decreaseFood(int amount, Cat cat) {
        if (amount> food){
            System.out.println("Котик " + cat.getName() + " остался голодным! МяУ!");
        } else {
            food -= amount;
            System.out.println("Котик " + cat.getName()+ " покушал)))");
        }
    }

    public void info() {
        System.out.println("Plate: " + food);
    }
}

