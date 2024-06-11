import ArrayList.*;
import LinkedList.*;
import HashMaps.*;
import SortingAlgorithm.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MyHashmaps<String, Integer> myHashmaps = new MyHashmaps<>();
        MyArrayList<Person> myArrayList = new MyArrayList<>();
        MyLinkedList<Person2> myLinkedList = new LinkedList.MyLinkedList<>();
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
                    handleArrayListOperations(scanner, myArrayList);
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

    private static void handleArrayListOperations(Scanner scanner, MyArrayList<Person> myArrayList) {
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
                    loadDataFromFile(scanner, myArrayList);
                    break;
                case 2:
                    addData(scanner, myArrayList);
                    break;
                case 3:
                    removeData(scanner, myArrayList);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                case 5:
                    sort(scanner, myArrayList);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void handleLinkedListOperations(Scanner scanner, MyLinkedList<Person2> myLinkedList) {
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
                    loadDataFromFile(scanner, myLinkedList);
                    break;
                case 2:
                    addData(scanner, myLinkedList);
                    break;
                case 3:
                    removeData(scanner, myLinkedList);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                case 5:
                    sort(scanner, myLinkedList);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Load data for HashMaps
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

    // Load data for LinkedList
    private static void loadDataFromFile(Scanner scanner, MyLinkedList<Person2> myLinkedList) {
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
                    myLinkedList.add(new Person2(name, number));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading data from the file: " + e.getMessage());
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Data loaded from " + fileName);
        System.out.println("It took " + (endTime - startTime) / 1000.0 + " seconds");
    }

    // Load data for ArrayList
    private static void loadDataFromFile(Scanner scanner, MyArrayList<Person> myArrayList) {
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
                    myArrayList.add(new Person(name, number));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading data from the file: " + e.getMessage());
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Data loaded from " + fileName);
        System.out.println("It took " + (endTime - startTime) / 1000.0 + " seconds");
    }

    // Adding data to HashMaps
    private static void addData(Scanner scanner, MyHashmaps<String, Integer> myHashmaps) {
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

    // Adding data to LinkedList
    private static void addData(Scanner scanner, MyLinkedList<Person2> myLinkedList) {
        long startTime = System.currentTimeMillis();

        System.out.println("Enter key to add:");
        String name = scanner.nextLine();
        System.out.println("Enter value to add:");
        int number = Integer.parseInt(scanner.nextLine());
        myLinkedList.add(new Person2(name, number));

        long endTime = System.currentTimeMillis();
        System.out.println("Updated Array List: " + myLinkedList);
        System.out.println("It took " + (endTime - startTime) / 1000.0 + " seconds");
    }

    // Adding data to ArrayList
    private static void addData(Scanner scanner, MyArrayList<Person> myArrayList) {
        long startTime = System.currentTimeMillis();

        System.out.println("Enter key to add:");
        String name = scanner.nextLine();
        System.out.println("Enter value to add:");
        int number = Integer.parseInt(scanner.nextLine());
        myArrayList.add(new Person(name, number));

        long endTime = System.currentTimeMillis();
        System.out.println("Updated Array List: " + myArrayList);
        System.out.println("It took " + (endTime - startTime) / 1000.0 + " seconds");
    }

    // Removing data from Hashmap
    private static void removeData(Scanner scanner, MyHashmaps<String, Integer> myHashmaps) {
        long startTime = System.currentTimeMillis();

        System.out.println("Enter key to remove:");
        String key = scanner.nextLine();
        myHashmaps.remove(key);

        long endTime = System.currentTimeMillis();
        System.out.println("Updated Hashmap: " + myHashmaps);
        System.out.println("It took " + (endTime - startTime) / 1000.0 + " seconds");
    }

    // Removing data from MyArrayList
    private static void removeData(Scanner scanner, MyArrayList<Person> myArrayList) {
        System.out.println("Enter key to remove:");
        String key = scanner.nextLine();
        int index = 0;

        for (int i = 0; i < myArrayList.size(); i++) {
            if (myArrayList.get(i).getName().equals(key)) {
                index = i;
            }
        }

        long startTime = System.currentTimeMillis();

        myArrayList.remove(index);

        long endTime = System.currentTimeMillis();
        System.out.println("Updated Hashmap: " + myArrayList);
        System.out.println("It took " + (endTime - startTime) / 1000.0 + " seconds");
    }

    // Removing data from MyLinkedList
    private static void removeData(Scanner scanner, MyLinkedList<Person2> myLinkedList) {
        System.out.println("Enter key to remove:");
        String key = scanner.nextLine();
        int index = 0;

        for (int i = 0; i < myLinkedList.size(); i++) {
            if (myLinkedList.get(i).getName().equals(key)) {
                index = i;
            }
        }

        long startTime = System.currentTimeMillis();

        myLinkedList.remove(index);

        long endTime = System.currentTimeMillis();
        System.out.println("Updated Hashmap: " + myLinkedList);
        System.out.println("It took " + (endTime - startTime) / 1000.0 + " seconds");
    }

    // Pulling out the option for sorting for Hashmaps
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

    // Pulling out the option for sorting for MyLinkedList
    private static void sort(Scanner scanner, MyLinkedList<Person2> myLinkedList) {
        System.out.println("1. Selection Sort");
        System.out.println("2. Heap Sort");
        System.out.println("3. Quick Sort");
        int sortChoice = scanner.nextInt();
        scanner.nextLine();  // Consume the newline

        switch (sortChoice) {
            case 1:
                handleSelectionSort(scanner, myLinkedList);
                break;
            case 2:
                handleHeapSort(scanner, myLinkedList);
                break;
            case 3:
                handleQuickSort(scanner, myLinkedList);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    // Pulling out the option for sorting for MyArrayList
    private static void sort(Scanner scanner, MyArrayList<Person> myArrayList) {
        System.out.println("1. Selection Sort");
        System.out.println("2. Heap Sort");
        System.out.println("3. Quick Sort");
        int sortChoice = scanner.nextInt();
        scanner.nextLine();  // Consume the newline

        switch (sortChoice) {
            case 1:
                handleSelectionSort(scanner, myArrayList);
                break;
            case 2:
                handleHeapSort(scanner, myArrayList);
                break;
            case 3:
                handleQuickSort(scanner, myArrayList);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    // Handles the selection sort for HashMaps
    private static void handleSelectionSort(Scanner scanner, MyHashmaps<String, Integer> myHashmaps) {
        long startTime = System.currentTimeMillis();

        int[] intArray = Arrays.stream(myHashmaps.values()).mapToInt(Integer::parseInt).toArray();
        SelectionSortHashMaps.selectionSortInt(intArray);

        long endTime = System.currentTimeMillis();
        System.out.println("It took " + (endTime - startTime) / 1000.0 + " seconds");
        System.out.println(Arrays.toString(myHashmaps.displayScore(intArray)));

        searchInSortedArray(scanner, myHashmaps);
    }

    // Handles the selection sort for MyLinkedList
    private static void handleSelectionSort(Scanner scanner, MyLinkedList<Person2> myLinkedList) {
        long startTime = System.currentTimeMillis();

        SelectionSortLinkedList.selectionSort(myLinkedList);

        long endTime = System.currentTimeMillis();
        System.out.println("It took " + (endTime - startTime) / 1000.0 + " seconds");
        System.out.println(myLinkedList);

        searchInSortedArray(scanner, myLinkedList);
    }

    // Handles the selection sort for MyArrayList
    private static void handleSelectionSort(Scanner scanner, MyArrayList<Person> myArrayList) {
        long startTime = System.currentTimeMillis();

        SelectionSortArrayList.selectionSort(myArrayList);

        long endTime = System.currentTimeMillis();
        System.out.println("It took " + (endTime - startTime) / 1000.0 + " seconds");
        System.out.println(myArrayList);

        searchInSortedArray(scanner, myArrayList);
    }

    // Handles the heap sort for MyHashMaps
    private static void handleHeapSort(Scanner scanner, MyHashmaps<String, Integer> myHashmaps) {
        long startTime = System.currentTimeMillis();

        int[] intArray = Arrays.stream(myHashmaps.values()).mapToInt(Integer::parseInt).toArray();
        HeapSortHashMaps.heapSortInt(intArray);

        long endTime = System.currentTimeMillis();
        System.out.println("It took " + (endTime - startTime) / 1000.0 + " seconds");
        System.out.println(Arrays.toString(myHashmaps.displayScore(intArray)));

        searchInSortedArray(scanner, myHashmaps);
    }

    // Handles the heap sort for MyLinkedList
    private static void handleHeapSort(Scanner scanner, MyLinkedList<Person2> myLinkedList) {
        long startTime = System.currentTimeMillis();

        HeapSortLinkedList.sort(myLinkedList);

        long endTime = System.currentTimeMillis();
        System.out.println("It took " + (endTime - startTime) / 1000.0 + " seconds");
        System.out.println(myLinkedList);

        searchInSortedArray(scanner, myLinkedList);
    }

    // Handles the heap sort for MyArrayList
    private static void handleHeapSort(Scanner scanner, MyArrayList<Person> myArrayList) {
        long startTime = System.currentTimeMillis();

        HeapSortArrayList.sort(myArrayList);

        long endTime = System.currentTimeMillis();
        System.out.println("It took " + (endTime - startTime) / 1000.0 + " seconds");
        System.out.println(myArrayList);

        searchInSortedArray(scanner, myArrayList);
    }

    // Handles the quick sort for MyHashMaps
    private static void handleQuickSort(Scanner scanner, MyHashmaps<String, Integer> myHashmaps) {
        long startTime = System.currentTimeMillis();

        int[] intArray = Arrays.stream(myHashmaps.values()).mapToInt(Integer::parseInt).toArray();
        QuickSortHashMaps.quickSortInt(intArray, 0, intArray.length - 1);

        long endTime = System.currentTimeMillis();
        System.out.println("It took " + (endTime - startTime) / 1000.0 + " seconds");
        System.out.println(Arrays.toString(myHashmaps.displayScore(intArray)));

        searchInSortedArray(scanner, myHashmaps);
    }

    // Handles the quick sort for MyLinkedList
    private static void handleQuickSort(Scanner scanner, MyLinkedList<Person2> myLinkedList) {
        long startTime = System.currentTimeMillis();

        QuickSortLinkedList.quickSort(myLinkedList, 0, myLinkedList.size() - 1);

        long endTime = System.currentTimeMillis();
        System.out.println("It took " + (endTime - startTime) / 1000.0 + " seconds");
        System.out.println(myLinkedList);

        searchInSortedArray(scanner, myLinkedList);
    }

    // Handles the quick sort for MyArrayList
    private static void handleQuickSort(Scanner scanner, MyArrayList<Person> myArrayList) {
        long startTime = System.currentTimeMillis();

        QuickSortArrayList.quickSort(myArrayList, 0, myArrayList.size() - 1);

        long endTime = System.currentTimeMillis();
        System.out.println("It took " + (endTime - startTime) / 1000.0 + " seconds");
        System.out.println(myArrayList);

        searchInSortedArray(scanner, myArrayList);
    }

    // Pulling out the option for searching for MyHashmaps
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

    // Pulling out the option for searching for MyArrayList
    private static void searchInSortedArray(Scanner scanner, MyArrayList<Person> myArrayList) {
        System.out.println("Enter the username you want to find:");
        String targetName = scanner.nextLine();

        String[] stringArray = new String[myArrayList.size()];
        for (int i = 0; i < myArrayList.size(); i++) {
            stringArray[i] = myArrayList.get(i).getName();
        }
        SelectionSortHashMaps.selectionSortString(stringArray);


        System.out.println("1. Linear Search");
        System.out.println("2. Binary Search");
        int searchChoice = scanner.nextInt();
        scanner.nextLine();  // Consume the newline

        switch (searchChoice) {
            case 1:
                performLinearSearch(myArrayList, targetName);
                break;
            case 2:
                performBinarySearch(myArrayList, stringArray, targetName);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    // Pulling out the option for searching for MyLinkedList
    private static void searchInSortedArray(Scanner scanner, MyLinkedList<Person2> myLinkedList) {
        System.out.println("Enter the username you want to find:");
        String targetName = scanner.nextLine();

        String[] stringArray = new String[myLinkedList.size()];
        for (int i = 0; i < myLinkedList.size(); i++) {
            stringArray[i] = myLinkedList.get(i).getName();
        }
        SelectionSortHashMaps.selectionSortString(stringArray);

        System.out.println("1. Linear Search");
        System.out.println("2. Binary Search");
        int searchChoice = scanner.nextInt();
        scanner.nextLine();  // Consume the newline

        switch (searchChoice) {
            case 1:
                performLinearSearch(myLinkedList, targetName);
                break;
            case 2:
                performBinarySearch(myLinkedList, stringArray, targetName);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    // Handles the Linear Search for MyHashMaps
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

    // Handles the Linear Search for MyLinkedList
    private static void performLinearSearch(MyLinkedList<Person2> myLinkedList, String targetName) {
        long startTime = System.currentTimeMillis();
        boolean test = false;
        int score = 0;


        for (int i = 0; i < myLinkedList.size(); i++) {
            if (myLinkedList.get(i).getName().equals(targetName)) {
                test = true;
                score = myLinkedList.get(i).getNumber();
            }
        }

        if (test) {
            System.out.println("This person's score is " + score);
        } else {
            System.out.println("Not found");
        }

        long endTime = System.currentTimeMillis();
        System.out.println("It took " + (endTime - startTime) / 1000.0 + " seconds");
    }

    // Handles the Linear Search for MyArrayList
    private static void performLinearSearch(MyArrayList<Person> myArrayList, String targetName) {
        long startTime = System.currentTimeMillis();
        boolean test = false;
        int score = 0;


        for (int i = 0; i < myArrayList.size(); i++) {
            if (myArrayList.get(i).getName().equals(targetName)) {
                test = true;
                score = myArrayList.get(i).getNumber();
            }
        }

        if (test) {
            System.out.println("This person's score is " + score);
        } else {
            System.out.println("Not found");
        }

        long endTime = System.currentTimeMillis();
        System.out.println("It took " + (endTime - startTime) / 1000.0 + " seconds");
    }

    // Handles the Binary Search for MyHashMaps
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

    // Handles the Binary Search for MyHashMaps
    private static void performBinarySearch(MyLinkedList<Person2> myLinkedList, String[] stringArray, String targetName) {
        long startTime = System.currentTimeMillis();

        int index = BinarySearch.binarySearch(stringArray, targetName);
        if (index == -1) {
            System.out.println("Not found");
        } else {
            System.out.println("This person's score is " + myLinkedList.get(index).getNumber());
        }

        long endTime = System.currentTimeMillis();
        System.out.println("It took " + (endTime - startTime) / 1000.0 + " seconds");
    }

    // Handles the Binary Search for MyHashMaps
    private static void performBinarySearch(MyArrayList<Person> myArrayList, String[] stringArray, String targetName) {
        long startTime = System.currentTimeMillis();
        System.out.println(myArrayList);
        int index = BinarySearch.binarySearch(stringArray, targetName);
        if (index == -1) {
            System.out.println("Not found");
        } else {
            System.out.println("This person's score is " + myArrayList.get(index).getNumber());
        }

        long endTime = System.currentTimeMillis();
        System.out.println("It took " + (endTime - startTime) / 1000.0 + " seconds");
    }
}
