package HashMaps;

import java.util.Random;

public class QuickSort {
    public static void quickSortInt(int[] array, int start, int end){
        if(start >= end){ // this is so that the number wont compare itself over and over again
            return;
        }

        int pivotIndex = new Random().nextInt(end - start + 1) + start;
        int pivot = array[pivotIndex];

        int leftPointer = partitionInt(array, start, end, pivot);

        quickSortInt(array,start,leftPointer-1); //lower partition
        quickSortInt(array,leftPointer,end); //higher partition
    }
    private static int partitionInt(int[] array, int start, int end, int pivot) {
        int leftPointer = start;
        int rightPointer = end;
        while(leftPointer<=rightPointer){
            while(array[leftPointer] < pivot){//keeps incrementing if pivot is less
                leftPointer++;
            }
            while(array[rightPointer] > pivot){//keeps incrementing if pivot is bigger
                rightPointer--;
            }
            if (leftPointer <= rightPointer) { // Swap elements and move pointers
                swapInt(array, leftPointer, rightPointer);
                leftPointer++;
                rightPointer--;
            }
        }
        return leftPointer;
    }

    public static void swapInt(int[] array, int index1, int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
    // For Strings
    public static void quickSortString(String[] array, int start, int end){
        if(start >= end){
            return;
        }

        int pivotIndex = new Random().nextInt(end - start + 1) + start;
        String pivot = array[pivotIndex];

        int leftPointer = partitionString(array, start, end, pivot);

        quickSortString(array,start,leftPointer-1);
        quickSortString(array,leftPointer,end);
    }

    private static int partitionString(String[] array, int start, int end, String pivot) {
        int leftPointer = start;
        int rightPointer = end;
        while(leftPointer <= rightPointer){
            while(array[leftPointer].compareTo(pivot) < 0){
                leftPointer++;
            }
            while(array[rightPointer].compareTo(pivot) > 0){
                rightPointer--;
            }
            if (leftPointer <= rightPointer) {
                swapString(array, leftPointer, rightPointer);
                leftPointer++;
                rightPointer--;
            }
        }
        return leftPointer;
    }

    public static void swapString(String[] array, int index1, int index2){
        String temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}

