package codepractise;

public class PizzaFactory{
public static void main(String[] args)
{
Pizza p1= new VegPizza(12,"capsicum","crushed cheese");
Pizza p2= new NonvegPizaa(14,"chicken toppings","melted cheese");
p1.makePizza();
p2.makePizza();
}
}