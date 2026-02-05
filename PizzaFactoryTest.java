package codepractise;
class Pizza {
 int size;
 String toppings;
 String cheeseType;
 
 Pizza(int size, String toppings, String cheeseType)
 {
   this.size=size;
   this.toppings=toppings;
   this.cheeseType=cheeseType;
 }
 void makePizza()
 {
   System.out.println("pizza size"+ size +"with toppings"+toppings+"cheeseType"+cheeseType);
  }
}

class VegPizza extends Pizza{
  String specialIngredient = "panner";
  VegPizza(int size, String toppings, String cheeseType)
  {
    super(size, toppings, cheeseType);
    }
   @Override
    void makePizza()
   {
   System.out.println("pizza size"+ size +"with toppings"+toppings+
   "cheeseType"+cheeseType+ specialIngredient);
  }  
 }
 
 class NonvegPizaa extends Pizza{
  String specialIngredient = "chicken";
  
  NonvegPizaa(int size, String toppings, String cheeseType)
  {
    super(size, toppings, cheeseType);  
   }
  @Override
 void makePizza()
 {
   System.out.println("pizza size"+ size +"with toppings"+toppings+
   "cheeseType"+cheeseType + specialIngredient);
  }
  }
