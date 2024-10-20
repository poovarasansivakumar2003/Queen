class HeapSort {

    // Function to heapify a subtree rooted at index i
    static void heapify(int a[], int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // left child
        int right = 2 * i + 2; // right child
        
        // If left child is larger than root
        if (left < n && a[left] > a[largest]) {
            largest = left;
        }
        
        // If right child is larger than largest so far
        if (right < n && a[right] > a[largest]) {
            largest = right;
        }
        
        // If largest is not root
        if (largest != i) {
            // swap a[i] with a[largest]
            int temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;
            
            // Recursively heapify the affected subtree
            heapify(a, n, largest);
        }
    }

    // Function to implement heap sort
    static void heapSort(int a[], int n) {
        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(a, n, i);
        }
        
        // One by one extract an element from heap
        for (int i = n - 1; i >= 0; i--) {
            // Move current root to end
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;

            // call max heapify on the reduced heap
            heapify(a, i, 0);
        }
    }

    // Function to print the array elements
    static void printArr(int a[], int n) {
        for (int i = 0; i < n; ++i) {
            System.out.print(a[i] + " ");
        }
        System.out.println(); // New line after printing the array
    }

    public static void main(String args[]) {
        int a[] = {45, 7, 20, 40, 25, 23, -2};
        int n = a.length;
        System.out.print("Before sorting array elements are:\n");
        printArr(a, n);
        heapSort(a, n);
        System.out.print("After sorting array elements are:\n");
        printArr(a, n);
    }
}
