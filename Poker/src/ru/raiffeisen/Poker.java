package ru.raiffeisen;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import static java.lang.System.arraycopy;
import static java.lang.System.clearProperty;
import static java.lang.System.setOut;

public class Poker {

    static void printArray(String[] arr) {
        int len;
        len = arr.length;
        for (int i = 0; i < len; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n");
        return;
    }

    static String[] mixedCardBranch(String[] arr) {
        Random rnd = new Random();
        for (int i = arr.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            String a = arr[index];
            arr[index] = arr[i];
            arr[i] = a;
        }
        return arr;
    }

    static int getPlayersNumber() {
        Scanner sc = new Scanner(System.in);
        String input = "";
        boolean entered = false;
        while (!entered) {
            input = sc.nextLine();
            if (input.matches("^-?\\d{1}$") || (input.matches("^-?\\d{2}$"))) {
                if ((Integer.valueOf(input)) >= 2 && (Integer.valueOf(input)) <= 10) {
                    entered = true;
                }
            }
            System.out.println("Wrong number. Please, try again.");
        }
        return Integer.valueOf(input);
    }

    static void dealingCards(int num, String[] cards) {

        String[][] dealsFiveEach = new String[num][5];
        int offset = 0;
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < 5; j++) {
                dealsFiveEach[i][j] = cards[j + offset];
                System.out.print(dealsFiveEach[i][j] + " ");
            }
            System.out.println("\n");
            offset += 5;
        }
    }


    public static void main(String[] args) {

        // card suits
        String[] hearts = {"h2", "h3", "h4", "h5", "h6", "h7", "h8", "h9", "h10", "hJ", "hQ", "hK", "hA"};
        String[] diamonds = {"d2", "d3", "d4", "d5", "d6", "d7", "d8", "d9", "d10", "dJ", "dQ", "dK", "dA"};
        String[] clubs = {"c2", "c3", "c4", "c5", "c6", "c7", "c8", "c9", "c10", "cJ", "cQ", "cK", "cA"};
        String[] spades = {"s2", "s3", "s4", "s5", "s6", "s7", "s8", "s9", "s10", "sJ", "sQ", "sK", "sA"};

        // total cards array
        String[] cards = new String[52];
        arraycopy(hearts, 0, cards, 0, 13);
        arraycopy(diamonds, 0, cards, 13, 13);
        arraycopy(clubs, 0, cards, 26, 13);
        arraycopy(spades, 0, cards, 39, 13);

        // mixing cards
        String[] mixedCards = mixedCardBranch(cards);
        System.out.println("Mixed cards branch");
        printArray(mixedCards);

        System.out.println("Please, enter number of players (2-10)");
        int players = getPlayersNumber();

        System.out.println("=== Dealing cards ===");
        dealingCards(players, mixedCards);

    }
}
