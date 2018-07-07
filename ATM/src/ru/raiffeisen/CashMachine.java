package ru.raiffeisen;

import java.util.Scanner;

public class CashMachine {


    public static String chooseOperation() {
        // reading user
        boolean chosen = false;
        Scanner in = new Scanner(System.in);
        String input = "";
        System.out.println
                ("Choose operation: 1 - replenish account; 2 - withdraw from account; " +
                        "3 - get account balance; 4 - transfer to another account");
        while (!chosen) {
            input = in.nextLine();
            System.out.print("Chosen operation ");
            switch (input) {
                case "1":
                    System.out.println("1 - replenish account");
                    chosen = true;
                    break;
                case "2":
                    System.out.println("2 - withdraw from account");
                    chosen = true;
                    break;
                case "3":
                    System.out.println("3 - get account balance");
                    chosen = true;
                    break;
                case "4":
                    System.out.println("4 - transfer to another account");
                    chosen = true;
                    break;
                default:
                    System.out.println("not supported. Please, try again");
                    chosen = false;
                    break;
            }

        }
        return input;
    }


    public static String chooseAccount() {
        boolean chosen = false;
        Scanner in = new Scanner(System.in);
        String input = "";
        String massAccounts[] = {"1", "2", "3", "4", "5"};
        while (!chosen) {
            input = in.nextLine();
            for (String s : massAccounts) {
                if (String.valueOf(input).equals(s)) {
                    chosen = true;
                }
            }
            if (!chosen) {
                System.out.println("Account does not exist. Please, try again");
            } else System.out.println("Chosen account : " + input);

        }
        return input;
    }



    public static double enterAmount() {
        Scanner in = new Scanner(System.in);
        String input = "";
        boolean entered = false;
        while(!entered) {
            input = in.nextLine();
            if (input.matches("^\\d+(\\.\\d+)?")) {
                entered = true;
            }
        }
        return Double.valueOf(input);
    }

    public static String enterAnswer() {
        Scanner in = new Scanner(System.in);
        String answer;
        answer = in.nextLine();
        return answer;
    }


    public static void main(String[] args) {

        final double BONUS = 2000.00;
        final double MAX_LIMIT = 1000000.00;

        Account[] accounts = new Account[5];
        CreditAccount acc1 = new CreditAccount("40817810900002546850", "2015-02-25", "RUR",
                27195.68, true, "Credit account *6850", 80000.00, true);
        DebitAccount acc2 = new DebitAccount("40817810900009241733", "2015-10-16", "RUR",
                390008.11, false, "Debit account *1733", true);
        CurrentAccount acc3 = new CurrentAccount("40817810900005201436", "2015-07-17", "RUR",
                55010.35, true, "Current account *1436");
        CurrentAccount acc4 = new CurrentAccount("40817810900005481091", "2017-01-15", "RUR",
                14000.00, true, "Current account *1091");
        DebitAccount acc5 = new DebitAccount("40817810900001048872", "2018-03-30", "RUR",
                49450.86, true, "Debit account *8872", true);

        accounts[0] = acc1;
        accounts[1] = acc2;
        accounts[2] = acc3;
        accounts[3] = acc4;
        accounts[4] = acc5;

        System.out.println(accounts[0].showAccountDetails());
        System.out.println(accounts[1].showAccountDetails());
        System.out.println(accounts[2].showAccountDetails());
        System.out.println(accounts[3].showAccountDetails());
        System.out.println(accounts[4].showAccountDetails());

        boolean exit = false;
        while (!exit) {
            System.out.println("Please, choose an account");
            String account = chooseAccount();
            if ((accounts[Integer.parseInt(account) - 1] instanceof DebitAccount) &&
                    (acc1.getBalance() < 0)) {
                System.out.println("Credit account balance is negative. No operation is possible");
            } else {
                System.out.println("Please, choose operation");
                String operation = chooseOperation();
                double sum = 0;
                switch (operation) {
                    case "1":
                        //1 - replenish account
                        System.out.println("Please, enter sum");
                        sum = enterAmount();
                        accounts[Integer.parseInt(account) - 1].replenish(sum);
                        accounts[Integer.parseInt(account) - 1].showAccountBalance();
                        if ((accounts[Integer.parseInt(account) - 1] instanceof CurrentAccount) &&
                                (sum > MAX_LIMIT)) {
                            System.out.println("BONUS ===> Debit account replenishment");
                            acc5.replenish(BONUS);
                            acc5.showAccountBalance();
                        }
                        break;
                    case "2":
                        //2 - withdraw from account
                        System.out.println("Please, enter sum");
                        sum = enterAmount();
                        accounts[Integer.parseInt(account) - 1].withdraw(sum);
                        accounts[Integer.parseInt(account) - 1].showAccountBalance();
                        break;
                    case "3":
                        //3 - get account balance
                        accounts[Integer.parseInt(account) - 1].showAccountBalance();
                        break;
                    case "4":
                        //4 - transfer between accounts
                        System.out.println("Please, choose a destination account");
                        String accountTo = chooseAccount();
                        System.out.println("Please, enter sum");
                        sum = enterAmount();
                        accounts[Integer.parseInt(account) - 1].
                                transferToAccount(accounts[Integer.parseInt(accountTo) - 1], sum);
                        accounts[Integer.parseInt(account) - 1].showAccountBalance();
                        accounts[Integer.parseInt(accountTo) - 1].showAccountBalance();
                        break;

                }
            }

            System.out.println("Would you like to continue? y/n");
            String answer = enterAnswer();
            if (answer.equals("n")) {
                exit = true;
            }
        }
    }
}




