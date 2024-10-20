import java.util.Scanner;

public class Kruskal {
    int[] parent = new int[10]; // Array to store the parent of each vertex
    int n; // Number of vertices

    // Function to find the root of a vertex
    int find(int m) {
        if (parent[m] == 0) {
            return m; // m is the root
        } else {
            return find(parent[m]); // Recursively find the root
        }
    }

    // Function to unite two subsets
    void union(int i, int j) {
        parent[i] = j; // Make j the parent of i
    }

    // Function to implement Kruskal's algorithm
    void krkl(int[][] a, int n) {
        int sum = 0; // Cost of the minimum spanning tree
        int k = 0;   // Number of edges in the MST

        // Initialize the parent array
        for (int i = 0; i < 10; i++) {
            parent[i] = 0;
        }

        // Main logic to construct MST using Kruskal's algorithm
        while (k < n - 1) {
            int min = Integer.MAX_VALUE; // Start with the maximum value
            int u = -1, v = -1; // Vertices for the minimum edge

            // Find the minimum edge
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (a[i][j] < min && i != j) {
                        min = a[i][j];
                        u = i;
                        v = j;
                    }
                }
            }

            // Find roots of the vertices
            int rootU = find(u);
            int rootV = find(v);

            // If they are not in the same set, unite them
            if (rootU != rootV) {
                union(rootU, rootV);
                System.out.println("(" + u + "," + v + ") = " + min);
                sum += min; // Add to the total cost
                k++; // Increment the edge count
            }

            // Remove the edge by setting it to a large value
            a[u][v] = a[v][u] = Integer.MAX_VALUE;
        }

        System.out.println("The cost of minimum spanning tree = " + sum);
    }

    public static void main(String[] args) {
        int[][] a = new int[10][10]; // Adjacency matrix
        int i, j;

        System.out.println("Enter the number of vertices of the graph:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println("Enter the weighted matrix:");
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= n; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        Kruskal k = new Kruskal();
        k.n = n; // Set the number of vertices
        k.krkl(a, n); // Call Kruskal's algorithm
        sc.close();
    }
}
