package codepractise;
import java.util.*;
import org.mindrot.jbcrypt.BCrypt;


// ---------------- ENUMS ----------------
enum Role4 {
    CUSTOMER, CHEF, ADMIN
}

enum VegSpecial {
    ALOO_TIKKI, MIX_VEG_TIKKI
}

enum NonVegSpecial {
    CHICKEN_TIKKA, CHICKEN_PERI_PERI
}

// ---------------- USER CLASS ----------------
class User4 {
    String username;
    String passwordHash; // Store only hash
    Role role;
	public Object password;

    public User4(String username, String plainPassword, Role role) {
        this.username = username;
        this.passwordHash = hashPassword(plainPassword); // hash at registration
        this.role = role;
    }

    private String hashPassword(String plainPassword) {
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt());
    }

    public boolean checkPassword(String plainPassword) {
        return BCrypt.checkpw(plainPassword, passwordHash);
    }
}

// ---------------- USER STORE ----------------
class UserStore {
    private static Map<String, User> userMap = new HashMap<>();

    static {
        // Secure signup with hashed passwords
        userMap.put(new User("swayam", "swa123", Role.CUSTOMER));
        userMap.put(new User("barasinga", "brs123", Role.CHEF));
        userMap.put(new User("mukesh", "mkh123", Role.ADMIN));
    }

    public static void addUser(User user) {
        userMap.put(user.username, user);
    }

    public static User authenticate(String username, String password) {
        User user = userMap.get(username);
       if (user != null && user.password.equals(password)) {
            return user;
        }
        throw new SecurityException("Invalid username or password");
    }
}

// ---------------- TEMPLATE METHOD ----------------
abstract class Pizza1 {
    int size;
    String cheeseType;

    Pizza1(int size, String cheeseType) {
        this.size = size;
        this.cheeseType = cheeseType;
    }

    // Template method
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

// ---------------- VEG PIZZA ----------------
class VegPizza1 extends Pizza1 {
    VegSpecial special;

    VegPizza1(int size, String cheeseType, VegSpecial special) {
        super(size, cheeseType);
        this.special = special;
    }

    @Override
    protected void addToppings() {
        System.out.println("Adding Veg Special: " + special);
    }

    @Override
    protected void addCheese() {
        System.out.println("Adding cheese: " + cheeseType);
    }
}

// ---------------- NON-VEG PIZZA ----------------
class NonVegPizza1 extends Pizza1 {
    NonVegSpecial special;

    NonVegPizza1(int size, String cheeseType, NonVegSpecial special) {
        super(size, cheeseType);
        this.special = special;
    }

    @Override
    protected void addToppings() {
        System.out.println("Adding Non-Veg Special: " + special);
    }

    @Override
    protected void addCheese() {
        System.out.println("Adding cheese: " + cheeseType);
    }
}

// ---------------- FACTORY ----------------
class PizzaFactoryP {
    public static Pizza1 makeVegPizza(int size, String cheeseType, VegSpecial special) {
        return new VegPizza1(size, cheeseType, special);
    }

    public static Pizza1 makeNonVegPizza(int size, String cheeseType, NonVegSpecial special) {
        return new NonVegPizza1(size, cheeseType, special);
    }
}

// ---------------- MAIN TEST ----------------
public class PizzaFactoryAAHashedPswd {
    public static void main(String[] args) {
        try {
            // Authenticate user
            User loggedIn = UserStore.authenticate("swayam", "swa123");
            System.out.println("✅ Logged in as " + loggedIn.username + " (" + loggedIn.role + ")");

            // Authorization: only CUSTOMER can order pizza
            if (loggedIn.role == Role.CUSTOMER) {
                Pizza1 p1 = PizzaFactoryP.makeVegPizza(12, "Mozzarella", VegSpecial.ALOO_TIKKI);
                p1.makePizza();

                Pizza1 p2 = PizzaFactoryP.makeNonVegPizza(14, "Cheddar", NonVegSpecial.CHICKEN_TIKKA);
                p2.makePizza();
            } else {
                System.out.println("❌ You are not allowed to order pizza.");
            }

        } catch (SecurityException e) {
            System.out.println("❌ Login failed: " + e.getMessage());
        }
    }
}
