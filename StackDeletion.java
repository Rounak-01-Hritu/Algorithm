import java.util.Scanner;

class Stack {
    final int MAX = 100;
    int[] arr = new int[MAX];
    int top;

    Stack() { top = -1; }

    boolean isFull() { return top == MAX - 1; }
    boolean isEmpty() { return top == -1; }

    void push(int x) {
        if (isFull()) {
            System.out.println("Stack Overflow! Cannot insert " + x);
            return;
        }
        arr[++top] = x;
        System.out.println(x + " inserted into stack.");
    }

    void pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! Nothing to delete.");
            return;
        }
        System.out.println(arr[top--] + " deleted from stack.");
    }

    void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.print("Stack elements: ");
        for (int i = top; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

public class StackDeletion {
    public static void main(String[] args) {
        Stack s = new Stack();
        Scanner sc = new Scanner(System.in);
        int choice, value;

        do {
            System.out.println("\n1. Push\n2. Pop\n3. Display\n4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    value = sc.nextInt();
                    s.push(value);
                    break;
                case 2:
                    s.pop();
                    break;
                case 3:
                    s.display();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 4);

        sc.close();
    }
}
