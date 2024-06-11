import HashMaps.HeapSort;
import HashMaps.MyHashmaps;
import HashMaps.QuickSort;
import HashMaps.SelectionSort;
import SortingAlgorithm.LinearSearch;
import SortingAlgorithm.BinarySearch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MyHashmaps<String, Integer> myHashmaps = new MyHashmaps<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Hashmap");
            System.out.println("2. ArrayList");
            System.out.println("3. LinkedList");
            int mainChoice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            switch (mainChoice) {
                case 1:
                    handleHashmapOperations(scanner, myHashmaps);
                    break;
                case 2:
                    // Handle ArrayList operations here
                    break;
                case 3:
                    // Handle LinkedList operations here
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void handleHashmapOperations(Scanner scanner, MyHashmaps<String, Integer> myHashmaps) {
        while (true) {
            System.out.println("1. Load data from file");
            System.out.println("2. Add");
            System.out.println("3. Remove");
            System.out.println("4. Exit");
            System.out.println("5. Sort");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            switch (choice) {
                case 1:
                    loadDataFromFile(scanner, myHashmaps);
                    break;
                case 2:
                    addDataToHashmap(scanner, myHashmaps);
                    break;
                case 3:
                    removeDataFromHashmap(scanner, myHashmaps);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                case 5:
                    sortHashmap(scanner, myHashmaps);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void loadDataFromFile(Scanner scanner, MyHashmaps<String, Integer> myHashmaps) {
        System.out.println("Enter the file name:");
        String fileName = scanner.nextLine();
        long startTime = System.currentTimeMillis();

        try (BufferedReader reader = new BufferedReader(new FileReader("src/Data/" + fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String name = parts[0].trim();
                    int number = Integer.parseInt(parts[1].trim());
                    myHashmaps.put(name, number);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading data from the file: " + e.getMessage());
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Data loaded from " + fileName);
        System.out.println("It took " + (endTime - startTime) / 1000.0 + " seconds");
    }

    private static void addDataToHashmap(Scanner scanner, MyHashmaps<String, Integer> myHashmaps) {
        long startTime = System.currentTimeMillis();

        System.out.println("Enter key to add:");
        String key = scanner.nextLine();
        System.out.println("Enter value to add:");
        int value = Integer.parseInt(scanner.nextLine());
        myHashmaps.put(key, value);

        long endTime = System.currentTimeMillis();
        System.out.println("Updated Hashmap: " + myHashmaps);
        System.out.println("It took " + (endTime - startTime) / 1000.0 + " seconds");
    }

    private static void removeDataFromHashmap(Scanner scanner, MyHashmaps<String, Integer> myHashmaps) {
        long startTime = System.currentTimeMillis();

        System.out.println("Enter key to remove:");
        String key = scanner.nextLine();
        myHashmaps.remove(key);

        long endTime = System.currentTimeMillis();
        System.out.println("Updated Hashmap: " + myHashmaps);
        System.out.println("It took " + (endTime - startTime) / 1000.0 + " seconds");
    }

    private static void sortHashmap(Scanner scanner, MyHashmaps<String, Integer> myHashmaps) {
        System.out.println("1. Selection Sort");
        System.out.println("2. Heap Sort");
        System.out.println("3. Quick Sort");
        int sortChoice = scanner.nextInt();
        scanner.nextLine();  // Consume the newline

        switch (sortChoice) {
            case 1:
                handleSelectionSort(scanner, myHashmaps);
                break;
            case 2:
                handleHeapSort(scanner, myHashmaps);
                break;
            case 3:
                handleQuickSort(scanner, myHashmaps);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void handleSelectionSort(Scanner scanner, MyHashmaps<String, Integer> myHashmaps) {
        long startTime = System.currentTimeMillis();

        int[] intArray = Arrays.stream(myHashmaps.values()).mapToInt(Integer::parseInt).toArray();
        SelectionSort.selectionSortInt(intArray);

        long endTime = System.currentTimeMillis();
        System.out.println("It took " + (endTime - startTime) / 1000.0 + " seconds");
        System.out.println(Arrays.toString(myHashmaps.displayScore(intArray)));

        searchInSortedArray(scanner, myHashmaps, SelectionSort::selectionSortString);
    }

    private static void handleHeapSort(Scanner scanner, MyHashmaps<String, Integer> myHashmaps) {
        long startTime = System.currentTimeMillis();

        int[] intArray = Arrays.stream(myHashmaps.values()).mapToInt(Integer::parseInt).toArray();
        HeapSort.heapSortInt(intArray);

        long endTime = System.currentTimeMillis();
        System.out.println("It took " + (endTime - startTime) / 1000.0 + " seconds");
        System.out.println(Arrays.toString(myHashmaps.displayScore(intArray)));

        searchInSortedArray(scanner, myHashmaps, HeapSort::heapSortString);
    }

    private static void handleQuickSort(Scanner scanner, MyHashmaps<String, Integer> myHashmaps) {
        long startTime = System.currentTimeMillis();

        int[] intArray = Arrays.stream(myHashmaps.values()).mapToInt(Integer::parseInt).toArray();
        QuickSort.quickSortInt(intArray, 0, intArray.length - 1);

        long endTime = System.currentTimeMillis();
        System.out.println("It took " + (endTime - startTime) / 1000.0 + " seconds");
        System.out.println(Arrays.toString(myHashmaps.displayScore(intArray)));

        searchInSortedArray(scanner, myHashmaps, (array) -> QuickSort.quickSortString(array, 0, array.length - 1));
    }

    private static void searchInSortedArray(Scanner scanner, MyHashmaps<String, Integer> myHashmaps, SortingFunction sortingFunction) {
        System.out.println("Enter the username you want to find:");
        String targetName = scanner.nextLine();

        String[] stringArray = myHashmaps.keySet();
        sortingFunction.sort(stringArray);

        System.out.println("1. Linear Search");
        System.out.println("2. Binary Search");
        int searchChoice = scanner.nextInt();
        scanner.nextLine();  // Consume the newline

        switch (searchChoice) {
            case 1:
                performLinearSearch(myHashmaps, stringArray, targetName);
                break;
            case 2:
                performBinarySearch(myHashmaps, stringArray, targetName);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void performLinearSearch(MyHashmaps<String, Integer> myHashmaps, String[] stringArray, String targetName) {
        long startTime = System.currentTimeMillis();

        int index = LinearSearch.linearSearchString(stringArray, stringArray.length, targetName);
        if (index == -1) {
            System.out.println("Not found");
        } else {
            System.out.println("This person's score is " + myHashmaps.get(targetName));
        }

        long endTime = System.currentTimeMillis();
        System.out.println("It took " + (endTime - startTime) / 1000.0 + " seconds");
    }

    private static void performBinarySearch(MyHashmaps<String, Integer> myHashmaps, String[] stringArray, String targetName) {
        long startTime = System.currentTimeMillis();

        int index = BinarySearch.binarySearch(stringArray, targetName);
        if (index == -1) {
            System.out.println("Not found");
        } else {
            System.out.println("This person's score is " + myHashmaps.get(targetName));
        }

        long endTime = System.currentTimeMillis();
        System.out.println("It took " + (endTime - startTime) / 1000.0 + " seconds");
    }

    @FunctionalInterface
    interface SortingFunction {
        void sort(String[] array);
    }
}
