package ru.raiffeisen;

public class DebitAccount extends Account {
    private boolean debitCard;

    public DebitAccount(String cba, String open, String currency, double balance, boolean active,
                        String description, boolean debitCard) {
        super(cba, open, currency, balance, active, description);
        this.debitCard = debitCard;
    }


    @Override
    public String showAccountDetails() {
        return (super.showAccountDetails() +
                ", debitCard=" + debitCard);
    }
}
