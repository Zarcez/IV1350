package Sem.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * This class creates the log file used to store the error
 */
public class LogHandler {
    private PrintWriter logFile;
    private String LOG_FILE_NAME = "log.txt";

    public LogHandler() throws IOException {
        logFile = new PrintWriter(new FileWriter(LOG_FILE_NAME),true);
    }

    /**
     * Builds the string for the log
     * @param exception The exception that is logged
     */
    public void logException(Exception exception){
        StringBuilder logMsgBuilder = new StringBuilder();
        logMsgBuilder.append(getTime());
        logMsgBuilder.append(" Exception was thrown: ");
        logMsgBuilder.append(exception.getMessage());
        logFile.println(logMsgBuilder);
        exception.printStackTrace(logFile);
    }

    private String getTime(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        return now.format(formatter);    }

}
