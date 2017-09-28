package Java_Practice.Practice_3_DataStructures;

import java.util.LinkedList;

/**
 * Created by Splayd on 10.01.2017.
 * Simple path to the file:
 * input = "/home/../var/./lib//file.txt"
 * expected = "var/lib/file.txt"
 */
public class SimplePath {
    public static void main(String[] args) {
        String path = "/home/../var/./lib//file.txt"; //Expected: "var/lib/file.txt"
        String path1 = "/var//lib"; //Expected: "/var/lib"
        String path2 = "//"; //Expected: "/"
        String path3 = "/../../../../../../../../../../"; //Expected: "/"
        SplitPath splitPath = new SplitPath();
        SplitPath splitPath2 = new SplitPath();
        System.out.println(splitPath.splitPath(path));
        System.out.println(splitPath.splitPath(path1));
        System.out.println(splitPath.splitPath(path2));
        System.out.println(splitPath.splitPath(path3));
        System.out.println(splitPath2.splitPath2(path));
        System.out.println(splitPath2.splitPath2(path1));
        System.out.println(splitPath2.splitPath2(path2));
        System.out.println(splitPath2.splitPath2(path3));
    }
}

class SplitPath {
    //Firs method
    public String splitPath(String path) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String elements : path.split("/")) {
            stringBuilder.append(elements);
            stringBuilder.append("/");
            if (elements.equals("..")) {
                stringBuilder = new StringBuilder();
            }
        }

        String simplePath = stringBuilder.toString();

        StringBuilder simpleBuilder = new StringBuilder();
        for (String elements : simplePath.split("/")) {
            if (elements.equals(".")) {
                continue;
            }
            simpleBuilder.append(elements);
            simpleBuilder.append("/");
        }

        String result = simpleBuilder.toString().replace("//", "/");
        result = result.substring(0, result.length() - 1);

        if (result.isEmpty()) {
            result = "/";
        }
        return result;
    }

    //Second method
    public String splitPath2(String input) {
        LinkedList<String> path = new LinkedList<>();
        StringBuilder wordBuffer = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char letter = input.charAt(i);

            if (letter == '/') {
                String word = wordBuffer.toString();

                if ("..".equals(word)) {
                    if (!path.isEmpty()) {
                        path.pop();
                    }
                } else if (".".equals(word) || word.length() == 0) {

                } else {
                    path.push(word);
                }

                wordBuffer = new StringBuilder();
            } else {
                wordBuffer.append(letter);
            }
        }

        String word = wordBuffer.toString();
        if (word.length() > 0 && !".".equals(word) && !"..".equals(word)) {
            path.push(word);
        }

        StringBuilder result = new StringBuilder();

        while (!path.isEmpty()) {
            String fileName = path.removeLast();
            result.append("/");
            result.append(fileName);
        }

        if (result.length() == 0) {
            result.append("/");
        }
        return result.toString();
    }
}
