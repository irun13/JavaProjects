package hw7;

public class Plate {
    private int food;
    private int moreFood; //  то что добавляем в тарелку

    public Plate(int food) {

        this.food = food;
    }

    public int getFood() {

        return food;
    }

    public void decreaseFood(int amount, Cat cat) {
        if (amount> food){
           // System.out.println("Котик " + cat.getName() + " остался голодным! МяУ!");
        } else {
            food -= amount;
            cat.hunger = true;
            //System.out.println("Котик " + cat.getName()+ " покушал)))");
        }
    }

    public void addFood(int moreFood) {
        this.food +=moreFood;
    }


    public void info() {
        System.out.println("Plate: " + food);
    }
}

