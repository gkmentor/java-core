package org.hagiakinh.core.datetime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        do {
            System.out.print("Enter date: ");
            String input = scanner.nextLine();
            try {
                date = simpleDateFormat.parse(input);
            } catch (ParseException e) {
                System.out.println("Input date wrong format");
            }
        } while (date == null);

        System.out.println(simpleDateFormat.format(date));
    }
}
