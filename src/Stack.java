public class Stack<Item> {
    private Node<Item> top;
    private int size;

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
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

    public void push(Item item) {
        Node<Item> oldTop = top;
        top = new Node<>();
        top.item = item;
        top.next = oldTop;
        size++;
    }

    public Item pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack underflow");
        }
        Item item = top.item;
        top = top.next;
        size--;
        return item;
    }
}