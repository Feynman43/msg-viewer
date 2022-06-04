package com.med.msgviewer;

import java.util.Scanner;

public class MessageFormatter {
    public static String[][] formatter(String fileContent) {

        //The split is done based on newline (which is defined differently in each OS)
        //regex takes that into consideration to ensure cross-platform compatibility
        //fields takes a string and returns an array of messages
        String [] fields = fileContent.split("(\\r\\n\\s|\\r\\s|\\n\\s)");

        String formattedFileContent = "";
        String [][] messages = new String[fields.length][3];

        for (int i = 0; i < fields.length; i++) {
            System.out.println(fields[i]);

            Scanner scanner = new Scanner( fields[i] ).useDelimiter("\\n");
            String TIME_STAMP = scanner.next().replace("Time:", "");
            messages[i][0] = TIME_STAMP;
            String NICK_NAME = scanner.next().replace("Name:", "");
            messages[i][1] = NICK_NAME;
            String CONTENT = scanner.next().replace("Message:", "");
            messages[i][2] = CONTENT;

            formattedFileContent += "[" + TIME_STAMP + "]" + NICK_NAME + ":" + CONTENT + "\n";
        }

        return messages;

/*        try{

        } catch (Exception e) {
            e.printStackTrace();
        //return formattedFileContent;*/
        }
    }
