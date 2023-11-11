package FoodShortage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Buyer> buyers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            Buyer buyer;

            if (tokens.length == 3) {
                buyer = new Rebel(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                buyers.add(buyer);
            } else {
                buyer = new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2], tokens[3]);
                buyers.add(buyer);
            }
        }

        String input = scanner.nextLine();

        while(!"End".equals(input)) {
            for (Buyer buyer:
                    buyers) {
                if (buyer.getName().equals(input)){
                    buyer.buyFood();
                }
            }

            input = scanner.nextLine();
        }

        int totalFood = 0;

        for (Buyer buyer :
                buyers) {
            totalFood += buyer.getFood();
        }

        System.out.println(totalFood);
    }
}
