package atm;

import model.AtmContext;

public class AtmApplication {

    public static void main(String[] args) {

        ATMContext atm = new ATMContext();

        atm.insertCard();
        atm.enterPin(1234);
        atm.withdrawCash(3700);
    }
}
