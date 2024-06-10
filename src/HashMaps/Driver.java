package HashMaps;

import SortingAlgorithm.BinarySearch;
import SortingAlgorithm.LinearSearch;

import java.io.*;
import java.util.*;

public class Driver {
    public static void main(String[] args) {

        // Create a HashMap to store the name-number pairs
        MyHashmaps<String, Integer> nameToNumberMap = new MyHashmaps<>();

        long start = System.currentTimeMillis();
        // Read data from a txt file
        try (BufferedReader reader = new BufferedReader(new FileReader("src/Data/unique_name_dataset.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                // Storing the data inside a hashmap
                if (parts.length == 2) {
                    String name = parts[0].trim();
                    int number = Integer.parseInt(parts[1].trim());
                    nameToNumberMap.put(name, number);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading data from the file: " + e.getMessage());
        }
        // before sorting
        System.out.println(Arrays.toString(nameToNumberMap.keySet()));

        // converting the string to an int
        String[] stringArray = nameToNumberMap.keySet();
        int[] intArray = Arrays.stream(nameToNumberMap.Values())
                .mapToInt(Integer::parseInt)
                .toArray();

        // sorting the score in integer
//        quickSort.quickSortInt(intArray,0, intArray.length-1);
//        HeapSort.heapSortInt(intArray);
//        SelectionSort.selectionSortInt(intArray);
        long end = System.currentTimeMillis();

        // sorting the score in strings

//        quickSort.quickSortString(stringArray, 0, (stringArray.length)-1 );
        HeapSort.heapSortString(stringArray);
//        SelectionSort.selectionSortString(stringArray);

        // Search algorithm

        if(BinarySearch.binarySearch(stringArray, "Natalie_0")==-1){
            System.out.println("not found");
        }else{
            System.out.println("found");
        }

        if(LinearSearch.linearSearchString(stringArray, stringArray.length, "Natalie_0")==-1){
            System.out.println("not found");
        }else{
            System.out.println("found");
        }

        // result after sorting
//        System.out.println(Arrays.toString(intArray));
        System.out.println(Arrays.toString(stringArray));
        // Retrieve the corresponding names from the map
//        System.out.println(Arrays.toString(nameToNumberMap.displayScore(intArray)));
//        System.out.println((end-start)/1000.);

    }
}

