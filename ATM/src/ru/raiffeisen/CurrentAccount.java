package ru.raiffeisen;

public class CurrentAccount extends Account {


    public CurrentAccount(String cba, String open, String currency, double balance, boolean active, String description) {
        super(cba, open, currency, balance, active, description);
     }


//    public boolean replenishAccount(float amount, Account accountBonus) {
//
//        if (!super.replenishAccount(amount)) {
//            return false;
//        } else if (amount >= LIMIT) {
//            System.out.print("BONUS ===> ");
//            accountBonus.replenishAccount(BONUS);
//        }
//        return true;
//    }


    @Override
    public String showAccountDetails() {
        return (super.showAccountDetails());

    }
}
