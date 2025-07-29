import java.util.*;

class Item {
    int value, weight;
    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}

public class FractionalKnapsack {

    static double fractionalKnapsack(int W, Item[] items, int n) {
        Arrays.sort(items, (a, b) -> 
            Double.compare((double)b.value / b.weight, (double)a.value / a.weight));

        double finalValue = 0.0;

        for (int i = 0; i < n; i++) {
            if (items[i].weight <= W) {
                W -= items[i].weight;
                finalValue += items[i].value;
            } else {
                finalValue += items[i].value * ((double)W / items[i].weight);
                break;
            }
        }
        return finalValue;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();
        Item[] items = new Item[n];

        System.out.print("Enter values of items: ");
        int[] values = new int[n];
        for (int i = 0; i < n; i++) values[i] = sc.nextInt();

        System.out.print("Enter weights of items: ");
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) weights[i] = sc.nextInt();

        for (int i = 0; i < n; i++)
            items[i] = new Item(values[i], weights[i]);

        System.out.print("Enter capacity of knapsack: ");
        int W = sc.nextInt();

        double maxValue = fractionalKnapsack(W, items, n);
        System.out.println("Maximum value in Knapsack = " + maxValue);

        sc.close();
    }
}
