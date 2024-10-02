import static java.lang.Integer.parseInt;

import java.text.ParseException;
import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.text.SimpleDateFormat;

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


//    public Node sortedInsert(Node newnode,
//                                    Node sorted) {
//
//
//        if (sorted == null){
//            newnode.next = sorted;
//            sorted = newnode;
//        }
//
//        else {
//            Node curr = sorted;
//            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            String text1 = (String) curr.item.toString();
//            text1 = text1.substring(1, 20);
//            System.out.println("tos"+ text1);
//            try {
//                // Try parsing the date
//                Date formatterSorted = dateFormat.parse(text1);
//                System.out.println("Parsed Date: " );
//            } catch (ParseException e) {
//                System.out.println("Parse exception: " + e.getMessage());
//            }
//            //Date formatterSorted = dateFormat.parse(text1);
//            String text2 = (String) newnode.item.toString();
//            text2 = text2.substring(1, 20);
//           //Date formatterNew = dateFormat.parse(text2);
//            try {
//                // Try parsing the date
//                Date formatterNew = dateFormat.parse(text2);
//                System.out.println("Parsed Date: " + formatterNew);
//            } catch (ParseException e) {
//                System.out.println("Parse exception: " + e.getMessage());
//            }
//
////            System.out.println("curr" + curr.item);
////
////            System.out.println("text1" + text1);
////            text1 = text1.substring(18, 20);
////            System.out.println("substring" + text1);
////            int secs1 = parseInt(text1);
////            System.out.println("int" + secs1);
////
////            String text2 = (String) newnode.item.toString();
////            text2 = text2.substring(18, 20);
////            int secs2 = parseInt(text2);
//            if (formatterSorted.compareTo(formatterNew)) {
//                newnode.next = sorted;
//                sorted = newnode;
//            } else {
//
//
//
//                while (curr.next != null &&
//                        secs1 < secs2) {
//                    curr = curr.next;
//                }
//                newnode.next = curr.next;
//                curr.next = newnode;
//
//            }
//        }
//
//        return sorted;
//    }
//
//    public Node insertionSort() {
//
//
//        Node sorted = null;
//        Node curr = top;
//
//
//
//        while (curr != null) {
//
//
//            Node next = curr.next;
//
//
//            sorted = sortedInsert(curr, sorted);
//
//
//            curr = next;
//        }
//        return sorted;
//    }

}