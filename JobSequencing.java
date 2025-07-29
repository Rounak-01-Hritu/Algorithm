import java.util.*;

class Job {
    char id;
    int deadline, profit;

    Job(char id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class JobSequencing {

    static void jobSequencing(Job[] arr, int n) {
        Arrays.sort(arr, (a, b) -> b.profit - a.profit);

        int maxDeadline = 0;
        for (Job job : arr)
            maxDeadline = Math.max(maxDeadline, job.deadline);

        char[] jobOrder = new char[maxDeadline + 1];
        Arrays.fill(jobOrder, '-');
        int totalProfit = 0;

        for (int i = 0; i < n; i++) {
            for (int j = arr[i].deadline; j > 0; j--) {
                if (jobOrder[j] == '-') {
                    jobOrder[j] = arr[i].id;
                    totalProfit += arr[i].profit;
                    break;
                }
            }
        }

        System.out.print("Selected jobs: ");
        for (int i = 1; i <= maxDeadline; i++) {
            if (jobOrder[i] != '-') System.out.print(jobOrder[i] + " ");
        }
        System.out.println("\nTotal Profit: " + totalProfit);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of jobs: ");
        int n = sc.nextInt();
        Job[] arr = new Job[n];

        System.out.println("Enter job details (id deadline profit):");
        for (int i = 0; i < n; i++) {
            char id = sc.next().charAt(0);
            int deadline = sc.nextInt();
            int profit = sc.nextInt();
            arr[i] = new Job(id, deadline, profit);
        }

        jobSequencing(arr, n);
        sc.close();
    }
}
