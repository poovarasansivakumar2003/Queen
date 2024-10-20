import java.util.*;

class Graph {
    private int vertices; 
    private List<List<Integer>> adjacencyList;  
    
    public Graph(int vertices) { 
        this.vertices = vertices; 
        adjacencyList = new ArrayList<>(vertices); 
        for (int i = 0; i < vertices; ++i) { 
            adjacencyList.add(new ArrayList<>()); 
        } 
    } 
    
    // Add an edge to the graph
    public void addEdge(int v, int w) { 
        adjacencyList.get(v).add(w); 
    } 
    
    // Print all nodes reachable from the startNode
    public void printReachableNodes(int startNode) { 
        boolean[] visited = new boolean[vertices]; 
        LinkedList<Integer> queue = new LinkedList<>(); 
        
        // Mark the start node as visited and enqueue it
        visited[startNode] = true; 
        queue.add(startNode); 
        
        System.out.println("Nodes reachable from node " + startNode + ":"); 
        
        // BFS traversal
        while (!queue.isEmpty()) { 
            startNode = queue.poll(); 
            System.out.print(startNode + " "); 

            // Iterate through the adjacent nodes
            for (int nextNode : adjacencyList.get(startNode)) { 
                if (!visited[nextNode]) { 
                    visited[nextNode] = true; 
                    queue.add(nextNode); 
                } 
            } 
        } 
    } 
    
    public static void main(String[] args) { 
        Graph graph = new Graph(7); 
        
        // Adding edges to the graph
        graph.addEdge(0, 1); 
        graph.addEdge(0, 2); 
        graph.addEdge(1, 3); 
        graph.addEdge(1, 4); 
        graph.addEdge(2, 5); 
        graph.addEdge(2, 6); 
        
        int startNode = 0; 
        graph.printReachableNodes(startNode); 
    } 
}
