package codepractise;

public class PizzaFactoryPatternTest {
	
	    public static void main(String[] args) {
	        // Client code just asks the factory, doesn’t care about exact classes
	        Pizza1 p1 = PizzaFactoryP.makePizza("veg", 12, "cheeseburst", "oregano");
	        Pizza1 p2 = PizzaFactoryP.makePizza("nonveg", 14, "Olives", "chillyflakes");

	        p1.makePizza();
	        p2.makePizza();
	    }
	}

}

