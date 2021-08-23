package machine;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] inputs = {400, 540, 120, 9, 550}; // water[0], milk[1], beans[2], cups[3] & money[4]

        boolean stopIt = false;
        while (!stopIt) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String opt1 = scanner.next();
            coffeeMachineActions.status status = coffeeMachineActions.status.CHOOSING;
            switch (opt1) {
                case "buy" :
                    status = coffeeMachineActions.status.BUY;
                    inputs = coffeeMachineActions.buyCoffee(inputs);
                    System.out.println();
                    break;
                case "fill" :
                    status = coffeeMachineActions.status.FILL;
                    inputs = coffeeMachineActions.fillInputs(inputs);
                    System.out.println();
                    break;
                case "take" :
                    status = coffeeMachineActions.status.TAKE;
                    inputs = coffeeMachineActions.takeMoney(inputs);
                    System.out.println();
                    break;
                case "remaining" :
                    status = coffeeMachineActions.status.REMAINING;
                    coffeeMachineActions.printInputs(inputs);
                    System.out.println();
                    break;
                case "exit" :
                    stopIt = true;
                    break;
                default :
                    System.out.println();
                    break;
            }
        }
    }

}
class coffeeMachineActions {

    enum status {
        CHOOSING, BUY, FILL, TAKE, REMAINING
    }

    public static void printInputs(int[] inputs) {
        System.out.println("\nThe coffee machine has:");
        System.out.printf("%d ml of water%n", inputs[0]);
        System.out.printf("%d ml of milk%n", inputs[1]);
        System.out.printf("%d g of coffee beans%n", inputs[2]);
        System.out.printf("%d disposable cups%n", inputs[3]);
        System.out.printf("$%d of money%n", inputs[4]);
    }

    public static int[] buyCoffee(int[] inputs) {
        // water[0], milk[1], beans[2], cups[3] & money[4]
        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        Scanner scanner = new Scanner(System.in);
        String optBuy = scanner.next();
        if (Objects.equals(optBuy, "1") && inputs[0] >= 250 && inputs[2] >= 16 && inputs[3] > 0) {
            System.out.println("I have enough resources, making you a coffee!");
            inputs[0] -= 250;
            inputs[2] -= 16;
            inputs[3]--;
            inputs[4] += 4;
        } else if (Objects.equals(optBuy, "1") && (inputs[0] < 250 || inputs[2] < 16 || inputs[3] == 0)) {
            System.out.println("Sorry, not enough water!");
        } else if (Objects.equals(optBuy, "2") && inputs[0] >= 350 && inputs[1] >= 75 && inputs[2] >= 20 && inputs[3] > 0) {
            System.out.println("I have enough resources, making you a coffee!");
            inputs[0] -= 350;
            inputs[1] -= 75;
            inputs[2] -= 20;
            inputs[3]--;
            inputs[4] += 7;
        } else if (Objects.equals(optBuy, "2") && (inputs[0] < 350 || inputs[1] < 75 || inputs[2] < 20 || inputs[3] == 0)) {
            System.out.println("Sorry, not enough water!");
        } else if (Objects.equals(optBuy, "3") && inputs[0] >= 200 && inputs[1] >= 100 && inputs[2] >= 12 && inputs[3] > 0) {
            System.out.println("I have enough resources, making you a coffee!");
            inputs[0] -= 200;
            inputs[1] -= 100;
            inputs[2] -= 12;
            inputs[3]--;
            inputs[4] += 6;
        } else if (Objects.equals(optBuy, "3") && (inputs[0] < 200 || inputs[1] < 100 || inputs[2] < 12 || inputs[3] == 0)) {
            System.out.println("Sorry, not enough water!");
        }
        return inputs;
    }

    public static int[] fillInputs(int[] inputs) {
        // water[0], milk[1], beans[2], cups[3] & money[4]
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWrite how many ml of water you want to add: ");
        inputs[0] += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        inputs[1] += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        inputs[2] += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add: ");
        inputs[3] += scanner.nextInt();
        return inputs;
    }

    public static int[] takeMoney(int[] inputs) {
        // water[0], milk[1], beans[2], cups[3] & money[4]
        System.out.printf("%nI gave you $%d%n", inputs[4]);
        inputs[4] = 0;
        return inputs;
    }
}
