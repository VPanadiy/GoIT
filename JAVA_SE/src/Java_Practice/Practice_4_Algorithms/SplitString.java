package Java_Practice.Practice_4_Algorithms;

import java.util.LinkedList;

/**
 * Created by Splayd on 15.01.2017.
 * Split string that depend on width, split word if his size more then width;
 */
public class SplitString {
    public static void main(String[] args) {
        Split split = new Split();
        String input = "All of the information, content, services and software displayed on, transmitted through, or used in connection with the Service, including, for example, news articles, opinions, reviews, text, photographs, images, illustrations, audio clips, video, html, source and object code, software, data, and the like (collectively, the \"Content\"), as well as its selection and arrangement, is owned by East Valley Tribune and its affiliates, licensors or suppliers (excluding any \"User Content,\" as defined below, which may be owned by others). The Service is protected by copyright, trademark and other intellectual property laws of the United States of America and applicable international intellectual property laws.";
        int width = 50;
        System.out.println(split.splitInput(input, width));
    }

}

class Split {
    public String splitInput(String input, int width) {
        LinkedList<Character> charList = new LinkedList<>();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            charList.add(input.charAt(i));
        }

        boolean isFound = false;
        for (int i = 0; i < charList.size(); i++) {
            if (i % width == 0 && i != 0) {
                if (' ' == charList.get(i)) {
                    builder.append('\n');
                    for (int j = 0; j <= width; j++) {
                        charList.remove(0);
                    }
                    i = 0;
                    builder.append(charList.get(i));
                } else {
                    for (int j = i; j > 0; j--) {
                        if (isFound == false) {
                            if (' ' == charList.get(j)) {
                                isFound = true;
                                i = 0;
                                int temp = j;
                                for (; j < width; j++) {
                                    int length = builder.length();
                                    builder.deleteCharAt(length - 1);
                                }
                                builder.append('\n');
                                for (int m = 0; m <= temp; m++) {
                                    charList.remove(0);
                                }
                                builder.append(charList.get(i));
                            }
                        }
                    }

                    if (isFound == false) {
                        int length = builder.length();
                        builder.deleteCharAt(length - 1);
                        builder.append('-');
                        builder.append('\n');
                        for (int j = 0; j < width - 1; j++) {
                            charList.remove(0);
                        }
                        i = 0;
                        builder.append(charList.get(i));
                    } else {
                        isFound = false;
                    }
                }
            } else {
                builder.append(charList.get(i));
            }
        }
        return builder.toString();
    }
}
