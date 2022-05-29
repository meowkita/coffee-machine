package io.meowkita.coffeemachine;

public enum CoffeeType {

    ESPRESSO(250, 0, 16, 4),
    LATTE(350, 75, 20, 7),
    CAPPUCCINO(200, 100, 12, 6);

    private final int water;
    private final int milk;
    private final int coffee;
    private final int cost;

    CoffeeType(int water, int milk, int coffee, int cost) {
        this.water = water;
        this.milk = milk;
        this.coffee = coffee;
        this.cost = cost;
    }

    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getCoffee() {
        return coffee;
    }

    public int getCost() {
        return cost;
    }

}
