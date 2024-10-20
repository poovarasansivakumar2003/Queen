import java.util.Scanner;

public class prims {
    public static void main(String[] args) {
        int[][] w = new int[10][10]; // Adjacency matrix for the weighted graph
        int n, i, j, s, k = 0, min, sum = 0, u = 0, v = 0, flag = 0;
        int[] sol = new int[10]; // Array to track included vertices

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices:");
        n = sc.nextInt();

        // Initialize solution array
        for (i = 1; i <= n; i++) {
            sol[i] = 0;
        }

        System.out.println("Enter the weighted graph (adjacency matrix):");
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= n; j++) {
                w[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter the source vertex (1 to " + n + "):");
        s = sc.nextInt();
        sol[s] = 1; // Mark the source vertex as included
        k = 1; // Count of edges included in the MST

        // Prim's algorithm implementation
        while (k <= n - 1) {
            min = Integer.MAX_VALUE; // Set initial min to max value

            for (i = 1; i <= n; i++) {
                for (j = 1; j <= n; j++) {
                    // If i is included and j is not, and edge weight is less than min
                    if (sol[i] == 1 && sol[j] == 0 && i != j && min > w[i][j]) {
                        min = w[i][j];
                        u = i;
                        v = j;
                    }
                }
            }

            // If no edge found, the graph is not connected
            if (min == Integer.MAX_VALUE) {
                flag = 1;
                break;
            }

            sol[v] = 1; // Include vertex v in the MST
            sum += min; // Update the total cost
            k++; // Increment edge count
            System.out.println(u + " -> " + v + " = " + min); // Print the edge
        }

        // Check if a spanning tree was found
        if (flag == 1) {
            System.out.println("No spanning tree (the graph might be disconnected).");
        } else {
            System.out.println("The cost of the minimum spanning tree is " + sum);
        }

        sc.close();
    }
}
