package codepractise;


//Abstract Class using Template Method Pattern
abstract class Pizza3 {
 int size;
 String toppings;
 String cheeseType;

 Pizza3(int size, String toppings, String cheeseType) {
     this.size = size;
     this.toppings = toppings;
     this.cheeseType = cheeseType;
 }


 public final void makePizza() {
     prepareDough();
     addToppings();     
     addCheese();     
     bake();
     cut();
     pack();
     System.out.println("✅ Pizza is ready!\n");
 }

 
 private void prepareDough() {
     System.out.println("Preparing dough for size " + size + " pizza...");
 }

 
 protected abstract void addToppings();
 protected abstract void addCheese();

 
 private void bake() {
     System.out.println("Baking at 220°C for 15 minutes...");
 }

 private void cut() {
     System.out.println("Cutting pizza into 8 slices...");
 }

 private void pack() {
     System.out.println("Packing pizza in a box...");
 }
}


class VegPizza3 extends Pizza3 {
 String specialIngredient = "Paneer";

 VegPizza3(int size, String toppings, String cheeseType) {
     super(size, toppings, cheeseType);
 }

 @Override
 protected void addToppings() {
     System.out.println("Adding veg toppings: " + toppings + ", Special: " + specialIngredient);
 }

 @Override
 protected void addCheese() {
     System.out.println("Adding cheese: " + cheeseType);
 }
}


class NonVegPizza3 extends Pizza3 {
 String specialIngredient = "Chicken";

 NonVegPizza3(int size, String toppings, String cheeseType) {
     super(size, toppings, cheeseType);
 }

 @Override
 protected void addToppings() {
     System.out.println("Adding non-veg toppings: " + toppings + ", Special: " + specialIngredient);
 }

 @Override
 protected void addCheese() {
     System.out.println("Adding cheese: " + cheeseType);
 }
}


class PizzaFactoryP3 {
 public static Pizza1 makePizza(String type, int size, String toppings, String cheeseType) {
     if (type == null) {
         throw new IllegalArgumentException("Pizza type cannot be null");
     }

     switch (type) {
         case "veg":
             return new VegPizza1(size, toppings, cheeseType);

         case "nonveg":
             return new NonVegPizza1(size, toppings, cheeseType);

         default:
             throw new IllegalArgumentException("pizza not valid: " + type);
     }
 }
}
public class PizzaFactoryTemplateMethod {
 public static void main(String[] args) {
     Pizza1 p1 = PizzaFactoryP3.makePizza("veg", 12, "Onion", "Cheeseburst");
     p1.makePizza();

     Pizza1 p2 = PizzaFactoryP3.makePizza("nonveg", 14, "Pepper", "chillyflakes");
     p2.makePizza();
 }
}
