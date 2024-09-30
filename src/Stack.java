import static java.lang.Integer.parseInt;


public class Stack<T> {
    private Node<T> top;
    private int size;

    private static class Node<T> {
        private T item;
        private Node<T> next;
    }

    public Stack() {
        top = null;
        size = 0;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return size;
    }

    public void push(T item) {
        Node<T> oldTop = top;
        top = new Node<>();
        top.item = item;
        top.next = oldTop;
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack underflow");
        }
        T item = top.item;
        top = top.next;
        size--;
        return item;
    }


    public Node sortedInsert(Node newnode,
                                    Node sorted) {

        // Special case for the head end
        if (sorted == null){
            newnode.next = sorted;
            sorted = newnode;
        }

        else {
            Node curr = sorted;
            System.out.println("curr" + curr.item);
            String text1 = (String) curr.item.toString();
            System.out.println("text1" + text1);
            text1 = text1.substring(18, 20);
            System.out.println("substring" + text1);
            int secs1 = parseInt(text1);
            System.out.println("int" + secs1);

            String text2 = (String) newnode.item.toString();
            text2 = text2.substring(18, 20);
            int secs2 = parseInt(text2);
            if (secs1 >= secs2) {
                newnode.next = sorted;
                sorted = newnode;
            } else {


                // Locate the node before the
                // point of insertion
                while (curr.next != null &&
                        secs1 < secs2) {
                    curr = curr.next;
                }
                newnode.next = curr.next;
                curr.next = newnode;

            }
        }

        return sorted;
    }

    public Node insertionSort() {

        // Initialize sorted linked list
        Node sorted = null;
        Node curr = top;

        // Traverse the given linked list and
        // insert every node to sorted
        while (curr != null) {

            // Store next for next iteration
            Node next = curr.next;

            // Insert current in sorted linked list
            sorted = sortedInsert(curr, sorted);

            // Update current
            curr = next;
        }
        return sorted;
    }

}