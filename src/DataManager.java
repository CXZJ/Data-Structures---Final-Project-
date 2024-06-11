import ArrayList.MyArrayList;
import ArrayList.Person;
import HashMaps.MyHashmaps;
import LinkedList.MyLinkedList;
import LinkedList.Person2;

import java.util.Scanner;

public class DataManager {
    MyHashmaps<String, Integer> myHashmaps = new MyHashmaps<>();
    MyArrayList<Person> myArrayList = new MyArrayList<>();
    MyLinkedList<Person2> myLinkedList = new MyLinkedList<>();

    public void handleHashmapOperations(Scanner scanner) {
        HashmapManager.handleOperations(scanner, myHashmaps);
    }

    public void handleArrayListOperations(Scanner scanner) {
        ArrayListManager.handleOperations(scanner, myArrayList);
    }

    public void handleLinkedListOperations(Scanner scanner) {
        LinkedListManager.handleOperations(scanner, myLinkedList);
    }
}
