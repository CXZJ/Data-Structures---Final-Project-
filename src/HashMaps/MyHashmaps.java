package HashMaps;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyHashmaps<K,V> {
    // return the all of the keys only in list of strings
    public String[] keySet() {
        ArrayList<String> keys = new ArrayList<>();

        for (int i = 0; i < SIZE; i++) {
            Entry<K,V> entry = table[i];
            while (entry != null) {
                keys.add(entry.getKey().toString());
                entry = entry.next;
            }
        }
        return keys.toArray(new String[0]);
    }
    // return the all of the values only in list of strings
    public String[] Values() {
        ArrayList<String> values = new ArrayList<>();

        for (int i = 0; i < SIZE; i++) {
            Entry<K,V> entry = table[i];
            while (entry != null) {
                values.add(entry.getValue().toString());
                entry = entry.next;
            }
        }
        return values.toArray(new String[0]);
    }
    // return the all of the values only
    public Set<Entry<K,V>> entrySet() {
        Set<Entry<K,V>> entries = new HashSet<>();

        for (int i = 0; i < SIZE; i++) {
            Entry<K,V> entry = table[i];
            while (entry != null) {
                entries.add(entry);
                entry = entry.next;
            }
        }
        return entries;
    }
    // display the score
    public String[] displayScore(int[] sortedScores){
        List<String> sortedNames = new ArrayList<>();
        for (int score : sortedScores) {
            for (Entry<K, V> entry : entrySet()) {
                if (entry.getValue().equals(score)) {
                    sortedNames.add(entry.getKey().toString());
                    break; // Found the name, move to the next score
                }
            }
        }
        String[] displaytheScores = new String[sortedNames.size()];
        for (int i = 0; i < sortedNames.size(); i++) {
            displaytheScores[i] = sortedNames.get(i) + ": " + sortedScores[i];
        }
        return displaytheScores;
    }



    public class Entry<K,V>{
        private V value;
        private K key;
        private Entry<K,V> next;
        public Entry(K key, V value){
            this.key = key;
            this.value = value;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
        public K getKey() {
            return key;
        }


        @Override
        public String toString() {
            Entry<K,V> temp = this;
            StringBuilder sb = new StringBuilder();
            while (temp != null) {
                sb.append(temp.key + " -> " + temp.value + ",");
                temp = temp.next;
            }
            return sb.toString();
        }
    }
    //field or HashMaps.MyHashmaps
    private final int SIZE = 5; // creates the size for array

    private Entry<K,V> table[]; // field

    public MyHashmaps(){
        table = new Entry[SIZE];
    }

    private int getHash(K key) { // Ensure non-negative index
        int hash = key.hashCode() % SIZE;
        return hash < 0 ? -hash : hash;
    }

    public void put(K key, V value){ // this is for the putting method
        int hash = getHash(key); // this is using a hashcode function to get the key in hash form
        // afterward its divided with the size of the array to be stored
        Entry<K, V> e = table[hash];

        if (e == null){
            table[hash]= new Entry<>(key,value); // enter value if empty
        }
        else{
            while (e.next != null){ // update value if put in the same place
                if(e.getKey() == key){ // if key exist
                    e.setValue(value);
                    return;
                }
                e = e.next;
            }
            if(e.getKey() == key){
                e.setValue(value);
                return;
            }

            e.next = new Entry<K, V>(key,value); //if key doesnt exist
        }
    }
    public V get(K key){
        int hash = getHash(key);
        Entry<K, V> e = table[hash];

        if (e == null){
            return null;
        }
        while (e != null){
            if(e.getKey().equals(key)){
                return e.getValue();
            }
            e = e.next;
        }
        return null;
    }

    public Entry<K,V> remove(K key){
        int hash = getHash(key);
        Entry<K, V> e = table[hash];

        if (e == null){
            return null;
        }
        if (e.getKey() == key){
            table[hash] = e.next;
            e.next = null;
            return e;
        }

        Entry<K,V> prev = e;
        e = e.next;

        while (e != null){
            if(e.getKey() == key){
                prev.next = e.next;
                e.next = null;
                return e;
            }
        }
        return null;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {
            if (table[i] != null) {
                sb.append(i + " " + table[i] + "\n");
            } else {
                sb.append(i + " " + "null" + "\n");
            }
        }

        return sb.toString();
    }
}


