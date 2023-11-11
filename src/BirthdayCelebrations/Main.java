package BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Birthable> birthables = new ArrayList<>();

        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");
            Birthable birthable = null;

            if (tokens.length == 5) {
                birthable = new Citizen(tokens[1], Integer.parseInt(tokens[2]), tokens[3], tokens[4]);
                birthables.add(birthable);
            } else {
                String type = tokens[0];
                if ("Pet".equals(type)) {
                    birthable = new Pet(tokens[1], tokens[2]);
                    birthables.add(birthable);
                }
            }



            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        List<String> birthdays = new ArrayList<>();

        for (Birthable birth :
                birthables) {
            if (birth.getBirthDate().endsWith(input)) {
                birthdays.add(birth.getBirthDate());
            }
        }

        if (birthdays.isEmpty()) {
            System.out.println("<no output>");
        } else {
            for (String date :
                    birthdays) {
                System.out.println(date);
            }
        }
    }
}
