package atm.state;

public interface ATMState {
    void insertCard();
    void enterPin(int pin);
    void withdrawCash(int amount);
    void ejectCard();
}
