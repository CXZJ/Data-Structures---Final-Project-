import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import ArrayList.*;
import HashMaps.SelectionSortHashMaps;
import SortingAlgorithm.BinarySearch;

public class ArrayListManager {
    static void handleOperations(Scanner scanner, MyArrayList<Person> myArrayList) {
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

    private static void addData(Scanner scanner, MyArrayList<Person> myArrayList) {
        System.out.println("Enter key to add:");
        String name = scanner.nextLine();
        System.out.println("Enter value to add:");
        int number = Integer.parseInt(scanner.nextLine());
        Person person = new Person(name, number);
        int index = 0;
        boolean isDuplicate = false;

        for (int i = 0; i < myArrayList.size(); i++) {
            if (myArrayList.get(i).getName().equals(name)) {
                index = i;
                isDuplicate = true;
            }
        }

        long startTime = System.currentTimeMillis();

        if (isDuplicate) {myArrayList.set(index, person);}
        else {myArrayList.add(person);}

        long endTime = System.currentTimeMillis();
        System.out.println("Updated Array List: " + myArrayList);
        System.out.println("It took " + (endTime - startTime) / 1000.0 + " seconds");
    }

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

    private static void handleSelectionSort(Scanner scanner, MyArrayList<Person> myArrayList) {
        long startTime = System.currentTimeMillis();

        SelectionSortArrayList.selectionSort(myArrayList);

        long endTime = System.currentTimeMillis();
        System.out.println("It took " + (endTime - startTime) / 1000.0 + " seconds");
        System.out.println(myArrayList);

        searchInSortedArray(scanner, myArrayList);
    }

    private static void handleHeapSort(Scanner scanner, MyArrayList<Person> myArrayList) {
        long startTime = System.currentTimeMillis();

        HeapSortArrayList.sort(myArrayList);

        long endTime = System.currentTimeMillis();
        System.out.println("It took " + (endTime - startTime) / 1000.0 + " seconds");
        System.out.println(myArrayList);

        searchInSortedArray(scanner, myArrayList);
    }

    private static void handleQuickSort(Scanner scanner, MyArrayList<Person> myArrayList) {
        long startTime = System.currentTimeMillis();

        QuickSortArrayList.quickSort(myArrayList, 0, myArrayList.size() - 1);

        long endTime = System.currentTimeMillis();
        System.out.println("It took " + (endTime - startTime) / 1000.0 + " seconds");
        System.out.println(myArrayList);

        searchInSortedArray(scanner, myArrayList);
    }

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
