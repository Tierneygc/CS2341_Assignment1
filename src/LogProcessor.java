

import java.io.*;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;


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

        } else if (logEntry.contains("WARN")) {
            warnCount++;
            if (logEntry.contains("Memory")) {
                memoryWarnings++;
        }
    } else {
infoCount++;
    }
}


    public static void main(String[] args) {

        LogProcessor logprocessor = new LogProcessor();
        logprocessor.processLogFile("log-data.csv");
        logprocessor.errorStack.insertionSort();

    }


}
