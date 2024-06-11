package LinkedList;

public class SelectionSort {
    public void selectionSort(MyLinkedList<Person> list) {
        int n = list.size();

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (list.get(j).getName().compareTo(list.get(minIndex).getName()) < 0) {
                    minIndex = j;
                }
            }
            list.swap(i, minIndex);
        }
    }
}
