package org.hagiakinh.core.io.input_parsing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();


        StringTokenizer tokenizer = new StringTokenizer("this is a test");
        while(tokenizer.hasMoreTokens()) {
            System.out.println(tokenizer.nextToken());
        }

        int number = Integer.parseInt("123");
        double decimal = Double.parseDouble("12.34");

        Scanner scanner = new Scanner(System.in);
        number = scanner.nextInt();
        decimal = scanner.nextDouble();
    }
}


