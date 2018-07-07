package ru.raiffeisen;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;

class StringParser {
    public static void main(String[] args) throws IOException {
        // reading text until "" is entered
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String input;
        input = in.nextLine();
        while (!"".equals(input)) {
            sb.append(input);
            sb.append(";");
            input = in.nextLine();
        }
        System.out.println("Entered text : " + sb.toString());

        // getting args number
        int n = args.length;
        // printing args list
        System.out.println("\nHere is the args list: ");
        for (int i = 0; i < n; i++) {
            System.out.println("args[" + i + "]  = " + args[i]);
        }

        // parsing text entered
        String line;
        String word;
        int matchedInText;
        int matchedInLine;

        for (int i = 0; i < n; i++) {
            System.out.println("\nLooking for args[" + i + "] : " + args[i]);
            Scanner parser = new Scanner(sb.toString());
            parser.useDelimiter(";");
            matchedInText = 0;
            while (parser.hasNext()) {
                line = parser.next();
                Scanner lineParser = new Scanner(line);
                lineParser.useDelimiter(" ");
                matchedInLine = 0;
                while (lineParser.hasNext()) {
                    // comparing to argument
                    word = lineParser.next();
                    if (word.toLowerCase().equals((args[i]).toLowerCase())) {
                        matchedInLine++;
                        matchedInText++;
                    }
                }
                if (matchedInLine >= 1) {
                    System.out.println("Found in line : " + line);
                }
            }
            if (matchedInText == 0) {
                System.out.println("No matches found for :" + args[i]);
            }
        }


    }
}

