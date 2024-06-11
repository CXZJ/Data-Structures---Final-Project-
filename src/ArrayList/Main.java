package ArrayList;

import ArrayList.MyArrayList;
import ArrayList.Person;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Person> arrayList = new MyArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("Data-Structures---Final-Project--main/src/Data/Data.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String name = parts[0];
                    int score = Integer.parseInt(parts[1]);
                    // Create a new Person object and add it to the list
                    arrayList.add(new Person(name, score));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading data from the file: " + e.getMessage());
        }

        System.out.println(arrayList.isEmpty());
//        System.out.println(arrayList.get(2));
//        System.out.println(arrayList.size());
//        System.out.println(arrayList.get(1));
        System.out.println(arrayList);
//        HeapSort heapsort = new HeapSort();
//        heapsort.sort(arrayList);
//        System.out.println(arrayList);
//        SelectionSort.selectionSort(arrayList);
//        System.out.println(arrayList);
        long startTime = System.nanoTime();
//        QuickSort.quickSort(arrayList, 0, arrayList.size() - 1);
//        HeapSort heapsort = new HeapSort();
//        heapsort.sort(arrayList);
        SelectionSort.selectionSort(arrayList);
        long endTime = System.nanoTime();
        long durationMilliseconds = (endTime - startTime) / 1_000_000;
        long durationMicroseconds = (endTime - startTime) / 1_000;

        System.out.println(arrayList);
        System.out.println("Sorting took: " + durationMilliseconds + " milliseconds");
        System.out.println("Sorting took: " + durationMicroseconds + " microseconds");
    }
}
