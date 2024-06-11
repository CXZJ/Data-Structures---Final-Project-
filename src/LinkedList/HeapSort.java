package LinkedList;

public class HeapSort {

    public void sort(MyLinkedList<Person> list) {
        int N = list.size();

        // Build heap (rearrange array)
        for (int i = N / 2 - 1; i >= 0; i--)
            heapify(list, N, i);

        // One by one extract an element from heap
        for (int i = N - 1; i > 0; i--) {
            // Move current root to end
            Person temp = list.get(0);
            list.set(0, list.get(i));
            list.set(i, temp);

            // Call max heapify on the reduced heap
            heapify(list, i, 0);
        }
    }

    // To heapify a subtree rooted with node i which is
    // an index in list[]. n is size of heap
    void heapify(MyLinkedList<Person> list, int N, int i) {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < N && list.get(l).getName().compareTo(list.get(largest).getName()) > 0)
            largest = l;

        // If right child is larger than largest so far
        if (r < N && list.get(r).getName().compareTo(list.get(largest).getName()) > 0)
            largest = r;

        // If largest is not root
        if (largest != i) {
            Person swap = list.get(i);
            list.set(i, list.get(largest));
            list.set(largest, swap);

            // Recursively heapify the affected sub-tree
            heapify(list, N, largest);
        }
    }
}
