package SortingAlgorithm;

public class BinarySearch {

    // Returns index of x if it is present in arr[].
    public static int binarySearch(String[] arr, String target)
    {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if target is present at mid
            int comparison = arr[mid].compareTo(target);
            if (comparison == 0) {
                return mid;
            }

            // If target is greater, ignore left half
            if (comparison < 0) {
                low = mid + 1;
            } else {
                // If target is smaller, ignore right half
                high = mid - 1;
            }
        }

        // If we reach here, then element was
        // not present
        return -1;
    }



    // HashMaps.Driver code
    public static void main(String args[])
    {
//        BinarySearch ob = new BinarySearch();
//        int arr[] = { 2, 3, 4, 10, 40 };
//        int n = arr.length;
//        int x = 10;
//        int result = ob.binarySearch(arr, x);
//        if (result == -1)
//            System.out.println(
//                    "Element is not present in array");
//        else
//            System.out.println("Element is present at "
//                    + "index " + result);
    }
}
