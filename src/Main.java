import java.io.*;
import java.util.ArrayList;

public class LogProcessor {
    private Queue<String> logQueue;
    private Stack<String> errorStack;
    private int infoCount;
    private int warnCount;
    private int errorCount;
    private int memoryWarnings;
    private ArrayList<String> recentErrors;

    public LogProcessor() {
        logQueue = new Queue<>();
        errorStack = new Stack<>();
        infoCount = 0;
        warnCount = 0;
        errorCount = 0;
        memoryWarnings = 0;
        recentErrors = new ArrayList<>();
    }

public void processLogFile(String filePath) {
    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
        String line;
        while ((line = br.readLine()) != null) {
            logQueue.enqueue(line);
        }

        while (!logQueue.isEmpty()) {
            String logEntry = logQueue.dequeue();
            processLogEntry(logEntry);
        }
    } catch (IOException e) {
        System.err.println("Error reading log file: " + e.getMessage());
    }
}

    private void processLogEntry(String logEntry) {
        if (logEntry.contains("ERROR")) {
            errorCount++;
            errorStack.push(logEntry);

        } else if (logEntry.contains("WARN") {
            warnCount++;
            if (logEntry.contains("Memory")) {
                memoryWarnings++;
        }
    } else {
infoCount++;
    }
}

    public static void sort(Comparable[] a)
    {
        int N = a.length;
        int h = 1;
        while (h < N/3) h = 3*h + 1; // 1, 4, 13, 40, 121, 364, ...
        while (h >= 1)
        { // h-sort the array.
            for (int i = h; i < N; i++)
            {
                for (int j = i; j >= h && less(a[j], a[j-h]); j -= h)
                    exch(a, j, j-h);
            }
            h = h/3;
        }
    }
    private static boolean less(Comparable v, Comparable w)
    { return v.compareTo(w) < 0; }
    private static void exch(Comparable[] a, int i, int j)
    {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }


public class Main {




    public static void main(String[] args) {



    }
