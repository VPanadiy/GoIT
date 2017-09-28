package Java_Practice.Practice_3_DataStructures;

import java.util.ArrayList;

/**
 * Created by Splayd on 12.01.2017.
 * Example of Polish invert entry
 * Example: 12 5 + = 17;
 * 1 3 + 5 7 + * = 4 * 12 = 48;
 * 2 4 + 3 1 2 + * * = 6 3 3 * * = 6 * 9 = 54;
 * 1 2 + 1 2 3 + * 1 2 + * * = 3 1 5 * 3 * * = 3 5 3 * * = 3 15 * = 45;
 */
public class Polish_inverted_entry {
    public static void main(String[] args) {
        Inverted_entry inverted_entry = new Inverted_entry();
        String input = "12 5 +";
        String input2 = "1 3 + 5 7 + * ";
        String input3 = "2 4 + 3 1 2 + * *";
        String input4 = "1 2 + 1 2 3 + * 1 2 + * *";
        System.out.println(inverted_entry.invert(input));
        System.out.println(inverted_entry.invert(input2));
        System.out.println(inverted_entry.invert(input3));
        System.out.println(inverted_entry.invert(input4));
    }
}

class Inverted_entry {
    public int invert(String input) {
        ArrayList<String> arrayListOfInputExpression = new ArrayList<>();
        ArrayList<Integer> arrayListOfInputIntExpression = new ArrayList<>();

        for (String elements : input.split(" ")) {
            arrayListOfInputExpression.add(elements);
        }

        for (int i = 0; i < arrayListOfInputExpression.size(); i++) {
            if (!"+".equals(arrayListOfInputExpression.get(i)) &&
                    !"-".equals(arrayListOfInputExpression.get(i)) &&
                    !"*".equals(arrayListOfInputExpression.get(i)) &&
                    !"/".equals(arrayListOfInputExpression.get(i))
                    ) {
                arrayListOfInputIntExpression.add(Integer.parseInt(arrayListOfInputExpression.get(i)));
            } else {
                if ("+".equals(arrayListOfInputExpression.get(i))) {
                    arrayListOfInputIntExpression.set(arrayListOfInputIntExpression.size() - 1, arrayListOfInputIntExpression.get(arrayListOfInputIntExpression.size() - 2) + arrayListOfInputIntExpression.get(arrayListOfInputIntExpression.size() - 1));
                    arrayListOfInputIntExpression.remove(arrayListOfInputIntExpression.size() - 2);
                } else if ("-".equals(arrayListOfInputExpression.get(i))) {
                    arrayListOfInputIntExpression.set(arrayListOfInputIntExpression.size() - 1, arrayListOfInputIntExpression.get(arrayListOfInputIntExpression.size() - 2) - arrayListOfInputIntExpression.get(arrayListOfInputIntExpression.size() - 1));
                    arrayListOfInputIntExpression.remove(arrayListOfInputIntExpression.size() - 2);
                } else if ("*".equals(arrayListOfInputExpression.get(i))) {
                    arrayListOfInputIntExpression.set(arrayListOfInputIntExpression.size() - 1, arrayListOfInputIntExpression.get(arrayListOfInputIntExpression.size() - 2) * arrayListOfInputIntExpression.get(arrayListOfInputIntExpression.size() - 1));
                    arrayListOfInputIntExpression.remove(arrayListOfInputIntExpression.size() - 2);
                } else if ("/".equals(arrayListOfInputExpression.get(i))) {
                    arrayListOfInputIntExpression.set(arrayListOfInputIntExpression.size() - 1, arrayListOfInputIntExpression.get(arrayListOfInputIntExpression.size() - 2) / arrayListOfInputIntExpression.get(arrayListOfInputIntExpression.size() - 1));
                    arrayListOfInputIntExpression.remove(arrayListOfInputIntExpression.size() - 2);
                }
            }
        }
        return arrayListOfInputIntExpression.get(0);
    }
}
