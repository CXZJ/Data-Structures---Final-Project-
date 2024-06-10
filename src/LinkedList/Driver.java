package LinkedList;

public class Driver {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        // Assign values to nodes
        linkedList.head = new LinkedList.Node(1);
        LinkedList.Node second = new LinkedList.Node(2);
        LinkedList.Node third = new LinkedList.Node(3);

        // Connect nodes
        linkedList.head.next = second;
        second.next = third;

        // Printing node values
        LinkedList.Node current = linkedList.head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
    }
}
