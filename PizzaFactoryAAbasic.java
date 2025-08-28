package codepractise;
    import java.util.HashMap;
	import java.util.Map;

	enum Role {
	    CUSTOMER, CHEF, ADMIN
	}
	
	class User {
	    String username;
	    String password;
	    Role role;

	    User(String username, String password, Role role) {
	        this.username = username;
	        this.password = password;
	        this.role = role;
	    }
	}

	
	class AuthService {
	    private static Map<String, User> userMap = new HashMap<>();

	    static {
	       
	        userMap.put("swayam", new User("swayam", "ssd123", Role.CUSTOMER));
	        userMap.put("barasinga", new User("barasinga", "bsa123", Role.CHEF));
	        userMap.put("ashwin", new User("ashwin", "ash123", Role.ADMIN));
	    }


	    public static User authenticate(String username, String password) {
	        User u = userMap.get(username);   
	        if (u != null && u.password.equals(password)) {
	            return u;
	        }
	        throw new SecurityException("Invalid username or password");
	    }

	   
	    public static void authorize(User user, Role requiredRole) {
	        if (user.role != requiredRole) {
	            throw new SecurityException("Access denied! Required role: " + requiredRole);
	        }
	    }
	}

	
	class PizzaOrderingSystem {
	    public static void orderPizza(User user) {
	        
	        AuthService.authorize(user, Role.CUSTOMER);
	        System.out.println(user.username + " placed an order ✅");
	    }

	    public static void bakePizza(User user) {
	       
	        AuthService.authorize(user, Role.CHEF);
	        System.out.println(user.username + " is baking the pizza 👨‍🍳");
	    }

	    public static void manageSystem(User user) {
	     
	        AuthService.authorize(user, Role.ADMIN);
	        System.out.println(user.username + " is managing the system ⚙️");
	    }
	}

	
	public class PizzaFactoryAAbasic {
	    public static void main(String[] args) {
	        try {
	            // Customer login
	            User customer = AuthService.authenticate("alice", "pass123");
	            PizzaOrderingSystem.orderPizza(customer);

	            // Chef login
	            User chef = AuthService.authenticate("bob", "chef123");
	            PizzaOrderingSystem.bakePizza(chef);

	            // Admin login
	            User admin = AuthService.authenticate("admin", "admin123");
	            PizzaOrderingSystem.manageSystem(admin);

	          
	            User wrong = AuthService.authenticate("alice", "wrongpass");

	        } catch (SecurityException e) {
	            System.out.println("❌ " + e.getMessage());
	        }
	    }
	}


