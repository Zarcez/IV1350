package Sem.View;

import java.time.LocalDateTime;

/**
 * The class that writes out the error message
 */
public class ErrorMessageHandler {

    /**
     * Builds the error message that is sent to the user
     * @param msg the message that is printed
     */
    void ShowErrorMessage(String msg){
        StringBuilder errorMsgBuilder = new StringBuilder();
        LocalDateTime errorTime = LocalDateTime.now();
        errorMsgBuilder.append(errorTime);
        errorMsgBuilder.append("  ERROR  ");
        errorMsgBuilder.append(msg);
        System.out.println(errorMsgBuilder);
    }

}
