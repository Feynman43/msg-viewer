package com.med.msgviewer;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.*;

public class MessageFormatter {
    public static String[][] formatter(String fileContent) {

        //The split is done based on newline (which is defined differently in each OS)
        //regex takes that into consideration to ensure cross-platform compatibility
        //fields takes a string and returns an array of messages
        String[] fields = fileContent.split("(\\r\\n\\s|\\r\\s|\\n\\s)");

        String[][] messages = new String[fields.length][3];

        for (int i = 0; i < fields.length; i++) {
            System.out.println(fields[i]);

            Scanner scanner = new Scanner(fields[i]).useDelimiter("\\n");
            String TIME_STAMP = scanner.next().replace("Time:", "");
            messages[i][0] = TIME_STAMP;
            String NICK_NAME = scanner.next().replace("Name:", "");
            messages[i][1] = NICK_NAME;
            String CONTENT = scanner.next().replace("Message:", "");
            messages[i][2] = CONTENT;
        }

        return messages;
    }

    public static Collection<? extends Node> emojiHandlerHappy(Text msgContent) {

        Collection<Node> list = null;
        if (msgContent.getText().contains(":)")) {

            Image image = new Image(String.valueOf(MessageFormatter.class.getResource("smile_happy.gif")));
            ImageView imageView = new ImageView(image);
            //ImageView imageView = new ImageView("https://emojipedia-us.s3.dualstack.us-west-1.amazonaws.com/thumbs/160/apple/33/smiling-face-with-smiling-eyes_1f60a.png");
            // Remove :) and :( from text
            msgContent.setText(msgContent.getText().replace(":)","\n"));
            System.out.println(msgContent);
            String [] messageText = msgContent.getText().split("\\n");
            list = new ArrayList<Node>();
            System.out.println(Arrays.toString(messageText));
            //for (String msgChunk: messageText)
            for (int i = 0; i < messageText.length; i++) {

                Text msgChunk = new Text(messageText[i]);
                msgChunk.setFill(Color.BLACK);
                list.add(msgChunk);


                if (i == messageText.length - 1) {
                    break;
                } else {
                    list.add(imageView);
                }

            }
        }

        System.out.println(list);
        return list;
    }

    public static Collection<? extends Node> emojiHandlerSad(Text msgContent) {

        Collection<Node> list = null;
        if (msgContent.getText().contains(":(")) {

            Image image = new Image(String.valueOf(MessageFormatter.class.getResource("smile_sad.gif")));
            ImageView imageView = new ImageView(image);
            //ImageView imageView = new ImageView("https://emojipedia-us.s3.dualstack.us-west-1.amazonaws.com/thumbs/160/apple/33/smiling-face-with-smiling-eyes_1f60a.png");
            // Remove :) and :( from text
            msgContent.setText(msgContent.getText().replace(":(","\n"));
            System.out.println(msgContent);
            String [] messageText = msgContent.getText().split("\\n");
            list = new ArrayList<Node>();
            System.out.println(Arrays.toString(messageText));
            //for (String msgChunk: messageText)
            for (int i = 0; i < messageText.length; i++) {

                Text msgChunk = new Text(messageText[i]);
                msgChunk.setFill(Color.BLACK);

                list.add(msgChunk);


                if (i == messageText.length - 1) {
                    break;
                } else {
                    list.add(imageView);
                }

            }
        }

        System.out.println(list);
        return list;
    }
}
