import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import HashMaps.*;
import SortingAlgorithm.BinarySearch;
import SortingAlgorithm.LinearSearch;

public class HashmapManager {
    static void handleOperations(Scanner scanner, MyHashmaps<String, Integer> myHashmaps) {
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
                    addData(scanner, myHashmaps);
                    break;
                case 3:
                    removeData(scanner, myHashmaps);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                case 5:
                    sort(scanner, myHashmaps);
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

    private static void addData(Scanner scanner, MyHashmaps<String, Integer> myHashmaps) {
        System.out.println("Enter key to add:");
        String key = scanner.nextLine();
        System.out.println("Enter value to add:");
        int value = Integer.parseInt(scanner.nextLine());

        long startTime = System.currentTimeMillis();

        myHashmaps.put(key, value);

        long endTime = System.currentTimeMillis();
        System.out.println("Updated Hashmap: " + myHashmaps);
        System.out.println("It took " + (endTime - startTime) / 1000.0 + " seconds");
    }

    private static void removeData(Scanner scanner, MyHashmaps<String, Integer> myHashmaps) {
        long startTime = System.currentTimeMillis();

        System.out.println("Enter key to remove:");
        String key = scanner.nextLine();
        myHashmaps.remove(key);

        long endTime = System.currentTimeMillis();
        System.out.println("Updated Hashmap: " + myHashmaps);
        System.out.println("It took " + (endTime - startTime) / 1000.0 + " seconds");
    }

    private static void sort(Scanner scanner, MyHashmaps<String, Integer> myHashmaps) {
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
        SelectionSortHashMaps.selectionSortInt(intArray);

        long endTime = System.currentTimeMillis();
        System.out.println("It took " + (endTime - startTime) / 1000.0 + " seconds");
        System.out.println(Arrays.toString(myHashmaps.displayScore(intArray)));

        searchInSortedArray(scanner, myHashmaps);
    }

    private static void handleHeapSort(Scanner scanner, MyHashmaps<String, Integer> myHashmaps) {
        long startTime = System.currentTimeMillis();

        int[] intArray = Arrays.stream(myHashmaps.values()).mapToInt(Integer::parseInt).toArray();
        HeapSortHashMaps.heapSortInt(intArray);

        long endTime = System.currentTimeMillis();
        System.out.println("It took " + (endTime - startTime) / 1000.0 + " seconds");
        System.out.println(Arrays.toString(myHashmaps.displayScore(intArray)));

        searchInSortedArray(scanner, myHashmaps);
    }

    private static void handleQuickSort(Scanner scanner, MyHashmaps<String, Integer> myHashmaps) {
        long startTime = System.currentTimeMillis();

        int[] intArray = Arrays.stream(myHashmaps.values()).mapToInt(Integer::parseInt).toArray();
        QuickSortHashMaps.quickSortInt(intArray, 0, intArray.length - 1);

        long endTime = System.currentTimeMillis();
        System.out.println("It took " + (endTime - startTime) / 1000.0 + " seconds");
        System.out.println(Arrays.toString(myHashmaps.displayScore(intArray)));

        searchInSortedArray(scanner, myHashmaps);
    }

    private static void searchInSortedArray(Scanner scanner, MyHashmaps<String, Integer> myHashmaps) {
        System.out.println("Enter the username you want to find:");
        String targetName = scanner.nextLine();

        String[] stringArray = myHashmaps.keySet();
        SelectionSortHashMaps.selectionSortString(stringArray);


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
}
