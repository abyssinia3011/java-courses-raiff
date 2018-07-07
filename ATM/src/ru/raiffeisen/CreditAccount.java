package ru.raiffeisen;

public class CreditAccount extends Account {
    private double creditLimit;
    private boolean creditCard;
    private double MIN_LIMIT = -20000.00;


    public CreditAccount(String cba, String open, String currency, double balance, boolean active,
                         String description, double creditLimit, boolean creditCard) {
        super(cba, open, currency, balance, active, description);
        this.creditLimit = creditLimit;
        this.creditCard = creditCard;
    }


    @Override
    public String showAccountDetails() {
        return (super.showAccountDetails() +
                ", creditLimit=" + creditLimit +
                ", creditCard=" + creditCard +
                ", MIN_LIMIT=" + MIN_LIMIT);
    }


}
