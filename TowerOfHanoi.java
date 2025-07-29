import java.util.Scanner;

public class TowerOfHanoi {
    static void towerOfHanoi(int n, char fromRod, char toRod, char auxRod) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + fromRod + " to " + toRod);
            return;
        }
        towerOfHanoi(n - 1, fromRod, auxRod, toRod);
        System.out.println("Move disk " + n + " from " + fromRod + " to " + toRod);
        towerOfHanoi(n - 1, auxRod, toRod, fromRod);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of disks: ");
        int n = sc.nextInt();
        System.out.println("Steps to solve Tower of Hanoi:");
        towerOfHanoi(n, 'A', 'C', 'B');
        System.out.println("Total moves = " + ((int)Math.pow(2, n) - 1));
        sc.close();
    }
}
