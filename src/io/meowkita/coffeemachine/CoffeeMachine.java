package io.meowkita.coffeemachine;

public class CoffeeMachine {

    private int water = 400;
    private int milk = 540;
    private int coffee = 120;
    private int cups = 9;
    private int money = 550;

    /**
     * Instantiates coffee machine with predefined amount of resources
     */
    public CoffeeMachine() {
    }

    /**
     * Instantiates coffee machine with given amount of resources
     * @param water Water on start
     * @param milk Milk on start
     * @param coffee Coffee on start
     * @param cups Cups on start
     * @param money Money on start
     */
    public CoffeeMachine(int water, int milk, int coffee, int cups, int money) {
        this.water = water;
        this.milk = milk;
        this.coffee = coffee;
        this.cups = cups;
        this.money = money;
    }

    /**
     * Makes a coffee using the specified type. Consumes machine resources such a water, milk, etc.
     *
     * @param type A coffee type to get consume info from
     */
    public void buy(CoffeeType type) {
        int waterNeeded = type.getWater();
        int milkNeeded = type.getMilk();
        int coffeeNeeded = type.getCoffee();
        int cost = type.getCost();

        makeCoffee(waterNeeded, milkNeeded, coffeeNeeded, cost);
    }

    /**
     * Replenishes the coffee machine by a given amount of each type of resource
     *
     * @param water  Amount of water to add
     * @param milk   Amount of milk to add
     * @param coffee Amount of coffee to add
     * @param cups   Amount of cups to add
     */
    public void fill(int water, int milk, int coffee, int cups) {
        this.water += water;
        this.milk += milk;
        this.coffee += coffee;
        this.cups += cups;
    }

    /**
     * Takes all money from the coffee machine and sets it to zero
     *
     * @return Amount of money withdrawn
     */
    public int take() {
        int takenMoney = money;
        money = 0;
        return takenMoney;
    }

    /**
     * Prints remaining supplies
     */
    public void remaining() {
        String message = String.format(
                """
                        The coffee machine has:
                        %d ml of water
                        %d ml of milk
                        %d g of coffee beans
                        %d disposable cups
                        $%d of money""",
                water,
                milk,
                coffee,
                cups,
                money
        );
        System.out.println(message);
    }

    /**
     * Makes a cup of coffee with consume of given resources
     *
     * @param water  Water to consume
     * @param milk   Milk to consume
     * @param coffee Coffee to consume
     * @param money  Money to add
     */
    private void makeCoffee(int water, int milk, int coffee, int money) {
        if (this.water - water < 0) {
            System.out.println("Sorry, not enough water!");
            return;
        }

        if (this.milk - milk < 0) {
            System.out.println("Sorry, not enough milk!");
            return;
        }

        if (this.coffee - coffee < 0) {
            System.out.println("Sorry, not enough coffee!");
            return;
        }

        if (this.cups < 0) {
            System.out.println("Sorry, not enough disposable cups!");
            return;
        }

        this.water -= water;
        this.milk -= milk;
        this.coffee -= coffee;
        this.cups -= 1;
        this.money += money;

        System.out.println("I have enough resources, making you a coffee!");
    }

}
