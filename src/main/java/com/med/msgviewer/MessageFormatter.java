package com.med.msgviewer;

import java.util.Scanner;

public class MessageFormatter {
    public static String formatter(String fileContent) {

        //The split is done based on newline (which is defined differently in each OS)
        //regex takes that into consideration to ensure cross-platform compatibility
        //fields takes a string and returns an array of messages
        String [] fields = fileContent.split("(\\r\\n\\s|\\r\\s|\\n\\s)");

        String formattedFileContent = "";
        for (String field : fields) {
            //System.out.println(field);

            Scanner scanner = new Scanner( field ).useDelimiter("\\n");
            String TIME_STAMP = scanner.next().replace("Time:", "");
            String NICK_NAME = scanner.next().replace("Name:", "");
            String CONTENT = scanner.next().replace("Message:", "");

            formattedFileContent += "[" + TIME_STAMP + "]" + NICK_NAME + ":" + CONTENT + "\n";
        }


        return formattedFileContent;
    }

}
