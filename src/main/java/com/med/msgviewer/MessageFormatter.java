package com.med.msgviewer;

import java.util.Arrays;
import java.util.Scanner;

public class MessageFormatter {
    public static String formatter(String fileContent) {

        //The split is done based on newline (which is defined differently in each OS)
        //regex takes that into consideration to ensure cross-platform compatibility
        //fields takes a string and returns an array of messages
        String [] fields = fileContent.split("(\\r\\n\\s|\\r\\s|\\n\\s)");

        for (String field : fields) {
            //System.out.println(field);

            Scanner scanner = new Scanner( field ).useDelimiter("\\n");
            String TIME_STAMP = scanner.next(); // 4231
            String NICK_NAME = scanner.next(); // "Java Programming"
            String CONTENT = scanner.next();  // 1000.00

            System.out.println("[" + TIME_STAMP + "]" + NICK_NAME + ":" + CONTENT);
        }


        //System.out.print(Arrays.toString(fields));
        return fileContent;
    }
}
