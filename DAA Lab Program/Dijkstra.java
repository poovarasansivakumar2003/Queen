import java.util.Scanner;

public class Dijkstra {
    int[] d = new int[10];      // Array to hold the shortest distance from the source
    int[] p = new int[10];      // Array to hold the predecessor of each vertex
    int[] visited = new int[10]; // Array to mark visited vertices

    public void dijk(int[][] a, int s, int n) {
        // Initialize distances and predecessors
        for (int i = 0; i < n; i++) {
            d[i] = Integer.MAX_VALUE; // Set initial distances to infinity
            p[i] = -1;                 // Set initial predecessors to -1
            visited[i] = 0;           // Mark all vertices as unvisited
        }

        d[s] = 0; // Distance from source to itself is 0

        for (int count = 0; count < n - 1; count++) {
            int u = -1;
            int min = Integer.MAX_VALUE;

            // Find the unvisited vertex with the smallest distance
            for (int j = 0; j < n; j++) {
                if (visited[j] == 0 && d[j] < min) {
                    min = d[j];
                    u = j;
                }
            }

            if (u == -1) break; // If there are no reachable vertices

            visited[u] = 1; // Mark the vertex as visited

            // Update the distance for each neighboring vertex
            for (int v = 0; v < n; v++) {
                if (a[u][v] != 0 && visited[v] == 0) { // Check for edges and unvisited vertices
                    if (d[u] + a[u][v] < d[v]) {
                        d[v] = d[u] + a[u][v]; // Update distance
                        p[v] = u; // Update predecessor
                    }
                }
            }
        }
    }

    void path(int v, int s) {
        if (p[v] != -1) {
            path(p[v], s);
        }
        if (v != s) {
            System.out.print("->" + v);
        }
    }

    void display(int s, int n) {
        for (int i = 0; i < n; i++) {
            if (i != s) {
                System.out.print(s + " ");
                path(i, s);
                System.out.print(" = " + d[i]);
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        int[][] a = new int[10][10]; // Adjacency matrix
        int i, j, n, s;

        System.out.println("Enter the number of vertices:");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        System.out.println("Enter the weighted adjacency matrix:");
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter the source vertex:");
        s = sc.nextInt();

        Dijkstra tr = new Dijkstra();
        tr.dijk(a, s, n);

        System.out.println("The shortest path from source " + s + " to remaining vertices are:");
        tr.display(s, n);

        sc.close();
    }
}
