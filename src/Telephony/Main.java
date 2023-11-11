package Telephony;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        List<String> urls = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        Smartphone smartphone = new Smartphone(numbers, urls);

        smartphone.getNumbers().forEach(n -> {
            if (n.matches(".*[a-zA-Z]+.*")) {
                System.out.println("Invalid number!");
            } else {

                System.out.println(smartphone.call() + n);
            }
        });

        smartphone.getUrls().forEach(url -> {
            if (url.matches(".*[0-9]+.*")) {
                System.out.println("Invalid URL!");
            } else {
                System.out.println(smartphone.browse() + url + "!");

            }
        });
    }
}
