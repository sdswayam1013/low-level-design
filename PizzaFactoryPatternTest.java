package codepractise;

public class PizzaFactoryPatternTest {
	
	    public static void main(String[] args) {
	        // Client code just asks the factory, doesn’t care about exact classes
	        Pizza1 p1 = PizzaFactory.makePizza("veg", 12, "Capsicum & Onion", "Mozzarella");
	        Pizza1 p2 = PizzaFactory.makePizza("nonveg", 14, "Jalapeno & Olives", "Cheddar");

	        p1.makePizza();
	        p2.makePizza();
	    }
	}

}
