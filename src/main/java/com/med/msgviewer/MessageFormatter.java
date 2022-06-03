package com.med.msgviewer;

import java.util.Arrays;

public class MessageFormatter {
    public static String formatter(String fileContent) {

        System.out.println(fileContent);

        //The split is done based on newline (which is defined differently in each OS)
        //regex takes that into consideration to ensure cross-platform compatibility
        String [] fields = fileContent.split("(\\r\\n|\\r|\\n)");
        // fields = "4231", "Java Programming", "1000.00"

        System.out.print(Arrays.toString(fields));
        return fileContent;
    }
}
