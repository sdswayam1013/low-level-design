package codepractise;
abstract class Pizza1 {
    int size;
    String toppings;
    String cheeseType;

    Pizza1(int size, String toppings, String cheeseType) {
        this.size = size;
        this.toppings = toppings;
        this.cheeseType = cheeseType;
    }

    abstract void makePizza();
}

class VegPizza1 extends Pizza1 {
    String specialIngredient = "Paneer";

    VegPizza1(int size, String toppings, String cheeseType) {
        super(size, toppings, cheeseType);
    }

    @Override
    void makePizza() {
        System.out.println("Veg Pizza → Size: " + size +
                           ", Toppings: " + toppings +
                           ", Special: " + specialIngredient +
                           ", Cheese: " + cheeseType);
    }
}

class NonVegPizza1 extends Pizza1 {
    String specialIngredient = "Chicken";

    NonVegPizza1(int size, String toppings, String cheeseType) {
        super(size, toppings, cheeseType);
    }

    @Override
    void makePizza() {
        System.out.println("Non-Veg Pizza → Size: " + size +
                           ", Toppings: " + toppings +
                           ", Special: " + specialIngredient +
                           ", Cheese: " + cheeseType);
    }
}

class PizzaFactoryP {
    public static Pizza1 makePizza(String type, int size, String toppings, String cheeseType) {
        if (type.equalsIgnoreCase("veg")) {
            return new VegPizza1(size, toppings, cheeseType);
        } else if (type.equalsIgnoreCase("nonveg")) {
            return new NonVegPizza1(size, toppings, cheeseType);
        } 
        
        throw new IllegalArgumentException("Unknown pizza type: " + type);
    }
}
