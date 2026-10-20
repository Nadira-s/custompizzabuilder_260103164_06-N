interface Pizza {
    double getPrice();
    String getDescription();
}

final class PlainPizza implements Pizza {
    @Override
    public double getPrice() {
        return 5.0;
    }

    @Override
    public String getDescription() {
        return "Plain Dough & Sauce";
    }
}

abstract class PizzaTopping implements Pizza {
    private final Pizza pizza;
    private final double price;
    private final String description;

    PizzaTopping(Pizza pizza, double price, String description) {
        this.pizza = pizza;
        this.price = price;
        this.description = description;
    }

    @Override
    public double getPrice() {
        return pizza.getPrice() + price;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", " + description;
    }
}

final class Cheese extends PizzaTopping {
    Cheese(Pizza pizza) {
        super(pizza, 2.0, "Cheese");
    }
}

final class Olives extends PizzaTopping {
    Olives(Pizza pizza) {
        super(pizza, 1.0, "Olives");
    }
}

final class Pineapple extends PizzaTopping {
    Pineapple(Pizza pizza) {
        super(pizza, 1.5, "Pineapple");
    }
}

public class PizzaDemo {
    public static void main(String[] args) {
        Pizza pizza = new Cheese(new Olives(new Pineapple(new PlainPizza())));

        System.out.println("Description: " + pizza.getDescription());
        System.out.printf("Total cost: $%.2f%n", pizza.getPrice());
    }
}
