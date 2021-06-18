package modernjavainaction.chap01;

import java.util.List;

import static modernjavainaction.chap01.FilteringApples.inventory;

interface AppleFormatter {
    String accept(FilteringApples.Apple apple);
}

class AppleFancyFormatter implements AppleFormatter {
    public String accept(FilteringApples.Apple apple) {
        String characteristic = apple.getWeight() > 150 ? "heavy" : "light";
        return "A " + characteristic + " " + apple.getColor();
    }
}

class AppleSimpleFormatter implements AppleFormatter {
    public String accept(FilteringApples.Apple apple) {
        return "An apple of " + apple.getWeight() + "g";
    }
}


public class PrettyPrintAppleExample {
    public static void prettyPrintApple(List<FilteringApples.Apple> inventory, AppleFormatter formatter) {
        for (FilteringApples.Apple apple : inventory) {
            String output = formatter.accept(apple);
            System.out.println(output);
        }
    }

    public static void main(String[] args) {
        prettyPrintApple(inventory, new AppleFancyFormatter());
        /*
         * A light green
         * A heavy green
         * A light red
         */

        prettyPrintApple(inventory, new AppleSimpleFormatter());
        /*
         * An apple of 80g
         * An apple of 155g
         * An apple of 120g
         */
    }

}
