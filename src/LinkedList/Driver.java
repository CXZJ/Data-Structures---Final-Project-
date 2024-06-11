package LinkedList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Driver {
    public static void main(String[] args) {
        // Create a list of Person objects
        MyLinkedList<Person> personList = new MyLinkedList<>();

        // Read data from a text file and populate the personList
        try (BufferedReader reader = new BufferedReader(new FileReader("src/Data/unique_name_dataset.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String name = parts[0].trim();
                    int number = Integer.parseInt(parts[1].trim());
                    personList.add(new Person(name, number));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading data from the file: " + e.getMessage());
        }

        // Display the list before sorting
        System.out.println("Before sorting:");
        System.out.println(personList);

        // Prompt user for sorting choice
        System.out.println("Choose sorting algorithm:");
        System.out.println("1. Heap Sort");
        System.out.println("2. Quick Sort");
        System.out.println("3. Selection Sort");

        int choice = getUserChoice();

        long startTime = System.currentTimeMillis();
        if (choice == 1) {
            // Perform heap sort
            HeapSort heapSort = new HeapSort();
            heapSort.sort(personList);
            System.out.println("\nSorting using Heap Sort...");
        } else if (choice == 2) {
            // Perform quicksort
            QuickSort quickSort = new QuickSort();
            quickSort.quickSort(personList, 0, personList.size() - 1);
            System.out.println("\nSorting using Quick Sort...");
        } else if (choice == 3) {
            // Perform selection sort
            SelectionSort selectionSort = new SelectionSort();
            selectionSort.selectionSort(personList);
            System.out.println("\nSorting using Selection Sort...");
        } else {
            System.out.println("Invalid choice!");
            return;
        }
        long endTime = System.currentTimeMillis();

        // Display the sorted list
        System.out.println("After sorting:");
        System.out.println(personList);

        // Display the time taken for sorting
        long elapsedTime = endTime - startTime;
        System.out.println("Time taken for sorting: " + elapsedTime + " milliseconds");
    }

    private static int getUserChoice() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int choice = -1;
        try {
            String input = reader.readLine();
            choice = Integer.parseInt(input.trim());
        } catch (IOException e) {
            System.err.println("Error reading user input: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Invalid input format. Please enter a number.");
        }
        return choice;
    }
}
