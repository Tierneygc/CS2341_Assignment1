import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import java.io.*;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
    ClassLoader classloader = Thread.currentThread().getContextClassLoader();
    InputStream is = classloader.getResourceAsStream(filePath);
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

        }
        else if (logEntry.contains("WARN")) {
            warnCount++;
            if (logEntry.contains("Memory")) {
                memoryWarnings++;
            }
        }
        else {
            infoCount++;
        }
    }


    public static void main(String[] args) {

        LogProcessor logprocessor = new LogProcessor();

        logprocessor.processLogFile("src/log-data.csv");

        System.out.println("Error Count: " + logprocessor.errorCount);
        System.out.println("Warn Count: " + logprocessor.warnCount);
        System.out.println("Memory Warning Count: " + logprocessor.memoryWarnings);
        System.out.println("Info Count: " + logprocessor.infoCount);

//        logprocessor.errorStack.insertionSort();
        int i = 1;
        while (i <= 100 && !logprocessor.errorStack.isEmpty()){
            System.out.println(logprocessor.errorStack.pop());
            i++;
        }

    }


}
