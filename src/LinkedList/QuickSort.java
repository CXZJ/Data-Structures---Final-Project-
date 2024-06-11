package LinkedList;

public class QuickSort {

    public void quickSort(MyLinkedList<Person> list, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivotIndex = (start + end) / 2; // Choose pivot element
        Person pivot = list.get(pivotIndex);

        int leftPointer = start;
        int rightPointer = end;

        while (leftPointer <= rightPointer) {
            while (list.get(leftPointer).getName().compareTo(pivot.getName()) < 0) {
                leftPointer++;
            }
            while (list.get(rightPointer).getName().compareTo(pivot.getName()) > 0) {
                rightPointer--;
            }
            if (leftPointer <= rightPointer) {
                list.swap(leftPointer, rightPointer);
                leftPointer++;
                rightPointer--;
            }
        }

        quickSort(list, start, rightPointer);
        quickSort(list, leftPointer, end);
    }
}
