package ru.raiffeisen;

public abstract class Account {
    protected String cba;
    protected String open;
    protected String currency;
    protected double balance;
    protected boolean active;
    protected String description;

    protected final double DRAW_LIMIT = 30000.00;


    protected double getBalance() {
        return balance;
    }

    protected boolean isActive() {
        return active;
    }


    protected void setBalance(double balance) {
        this.balance = balance;
    }

    protected void setActive(boolean active) {
        this.active = active;
    }


    public Account(String cba, String open, String currency, double balance, boolean active, String description) {
        this.cba = cba;
        this.open = open;
        this.currency = currency;
        this.balance = balance;
        this.active = active;
        this.description = description;
    }


    public boolean replenish(double amount) {
        if (!isActive()) {
            System.out.println("Operation is not possible. Account is blocked");
            return false;
        }
        if (amount <= 0) {
            System.out.println("Operation is not possible. Please enter sum");
            return false;
        }

        this.balance += amount;
        System.out.printf("Replenish " + this.description + " with %.2f " +
                this.currency + ". Operation successful \n", amount);
        return true;
    }

    public boolean withdraw(double amount) {
        if (!isActive()) {
            System.out.println("Operation is not possible. Account is blocked");
            return false;
        } else
        if (amount <= 0) {
            System.out.println("Operation is not possible. Please enter sum");
            return false;
        } else

        if (amount > DRAW_LIMIT) {
            System.out.println("Operation is not possible. Draw limit is over");
            return false;
        } else

        if (amount > this.getBalance()) {
            System.out.println("Operation is not possible. Insufficient funds");
            return false;
        }else {

            this.balance -= amount;

            System.out.printf
                    ("Withdraw %.2f " + this.currency + " from " + this.description + ". Operation successful\n", amount);
            return true;
        }
    }

    public boolean transferToAccount(Account accountTo, double amount) {
//        if ((accountTo.replenish(amount))&&(this.withdraw(amount))) {
        if (this.withdraw(amount)&&accountTo.replenish(amount)) {
            return true;
        } else return false;
    }


    public String showAccountDetails() {
        return "AccountDetails: " +
                "description='" + description + '\'' +
                ", cba='" + cba + '\'' +
                ", open='" + open + '\'' +
                ", currency='" + currency + '\'' +
                ", balance=" + balance +
                ", active=" + active +
                ", DRAW_LIMIT=" + DRAW_LIMIT;
    }

    public void showAccountBalance() {
        System.out.printf(this.description + " Current balance =  %.2f " + this.currency + "\n", this.balance);
    }


}


