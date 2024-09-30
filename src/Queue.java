public class Queue<String> {
    private Node<String> first;
    private Node<String> last;
    private int size;

    private static class Node<String> {
        private String item;
        private Node<String> next;
    }

    public Queue() {
        first = null;
        last = null;
        size = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public void enqueue(String item) {
        Node<String> oldLast = last;
        last = new Node<>();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        size++;
    }

    public String dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue underflow");
        }
        String item = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        size--;
        return item;
    }
}