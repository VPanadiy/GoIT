package Java_Practice.Practice_3_DataStructures;

import java.util.ArrayList;

public class Application {

    public static double parse(String rpnString) {
        ArrayList<String> arrayListOfInputExpression = new ArrayList<>();
        ArrayList<Double> arrayListOfInputIntExpression = new ArrayList<>();

        for (String elements : rpnString.split(" ")) {
            arrayListOfInputExpression.add(elements);
        }

        for (int i = 0; i < arrayListOfInputExpression.size(); i++) {
            if (!"+".equals(arrayListOfInputExpression.get(i)) &&
                    !"-".equals(arrayListOfInputExpression.get(i)) &&
                    !"*".equals(arrayListOfInputExpression.get(i)) &&
                    !"/".equals(arrayListOfInputExpression.get(i))
                    ) {
                try {
                    arrayListOfInputIntExpression.add(Double.parseDouble(arrayListOfInputExpression.get(i)));
                } catch (Exception e) {
                    throw new RPNParserException();
                }
            } else {
                if ("+".equals(arrayListOfInputExpression.get(i))) {
                    try {
                        arrayListOfInputIntExpression.set(arrayListOfInputIntExpression.size() - 1, arrayListOfInputIntExpression.get(arrayListOfInputIntExpression.size() - 2) + arrayListOfInputIntExpression.get(arrayListOfInputIntExpression.size() - 1));
                        arrayListOfInputIntExpression.remove(arrayListOfInputIntExpression.size() - 2);
                    } catch (Exception e) {
                        throw new RPNParserException();
                    }
                } else if ("-".equals(arrayListOfInputExpression.get(i))) {
                    try {
                        arrayListOfInputIntExpression.set(arrayListOfInputIntExpression.size() - 1, arrayListOfInputIntExpression.get(arrayListOfInputIntExpression.size() - 2) - arrayListOfInputIntExpression.get(arrayListOfInputIntExpression.size() - 1));
                        arrayListOfInputIntExpression.remove(arrayListOfInputIntExpression.size() - 2);
                    } catch (Exception e) {
                        throw new RPNParserException();
                    }
                } else if ("*".equals(arrayListOfInputExpression.get(i))) {
                    try {
                        arrayListOfInputIntExpression.set(arrayListOfInputIntExpression.size() - 1, arrayListOfInputIntExpression.get(arrayListOfInputIntExpression.size() - 2) * arrayListOfInputIntExpression.get(arrayListOfInputIntExpression.size() - 1));
                        arrayListOfInputIntExpression.remove(arrayListOfInputIntExpression.size() - 2);
                    } catch (Exception e) {
                        throw new RPNParserException();
                    }
                } else if ("/".equals(arrayListOfInputExpression.get(i))) {
                    if (arrayListOfInputIntExpression.get(arrayListOfInputIntExpression.size() - 1) == 0) {
                        throw new ArithmeticException();
                    } else {
                        try {
                            arrayListOfInputIntExpression.set(arrayListOfInputIntExpression.size() - 1, arrayListOfInputIntExpression.get(arrayListOfInputIntExpression.size() - 2) / arrayListOfInputIntExpression.get(arrayListOfInputIntExpression.size() - 1));
                            arrayListOfInputIntExpression.remove(arrayListOfInputIntExpression.size() - 2);
                        } catch (Exception e) {
                            throw new RPNParserException();
                        }
                    }
                }
            }
        }
        return arrayListOfInputIntExpression.get(0);
    }

    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println(parse(args[i]));
        }
    }

}

