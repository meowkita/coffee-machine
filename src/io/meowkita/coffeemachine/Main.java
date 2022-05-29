package io.meowkita.coffeemachine;

import java.util.Scanner;

public class Main {

    private final static Scanner scanner = new Scanner(System.in);
    private static final CoffeeMachine coffeeMachine = new CoffeeMachine();

    public static void main(String[] args) {
        String action;
        do {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            action = scanner.nextLine();
            System.out.println();

            switch (action) {
                case "buy":
                    buy();
                    break;
                case "fill":
                    fill();
                    break;
                case "take":
                    take();
                    break;
                case "remaining":
                    coffeeMachine.remaining();
                    break;
                case "exit":
                    break;
            }

            System.out.println();
        } while (!action.equals("exit"));
    }

    private static void buy() {
        String message = """
                What do you want to buy?
                \t1 - espresso
                \t2 - latte
                \t3 - cappuccino
                """;

        System.out.println(message);
        String selectedOption = scanner.nextLine();

        CoffeeType coffeeType;
        switch (selectedOption) {
            case "1" -> coffeeType = CoffeeType.ESPRESSO;
            case "2" -> coffeeType = CoffeeType.LATTE;
            case "3" -> coffeeType = CoffeeType.CAPPUCCINO;
            default -> {
                System.out.println("Not found this type of coffee");
                return;
            }
        }

        coffeeMachine.buy(coffeeType);
    }

    private static void fill() {
        System.out.println("Write how many ml of water you want to add:");
        int water = scanner.nextInt();

        System.out.println("Write how many ml of milk you want to add:");
        int milk = scanner.nextInt();

        System.out.println("Write how many grams of coffee you want to add:");
        int coffee = scanner.nextInt();

        System.out.println("Write how many disposable cups you want to add:");
        int cups = scanner.nextInt();

        coffeeMachine.fill(water, milk, coffee, cups);
    }

    private static void take() {
        int takenMoney = coffeeMachine.take();
        System.out.printf("I gave you $%d\n", takenMoney);
    }

}
