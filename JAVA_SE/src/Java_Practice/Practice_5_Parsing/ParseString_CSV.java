package Java_Practice.Practice_5_Parsing;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Splayd on 14.01.2017.
 * Parsing CSV_String. ',' - separator
 */
public class ParseString_CSV {
    public static void main(String[] args) {

        CSV_String csv_string = new CSV_String();
        String input1 = "1997,Ford,E350,\"ac, 20.0, moon\",3000.00";
        String input2 = "1999,Chevy,\"Venture \"\"Extended Edition\"\"\",\"\",4900.50";
        String input3 = "1996,Jeep,Grand Cherokee,\"MUST SELL! air, moon roof, loaded\",4799.05";

        List<List<List<String>>> table = new ArrayList<>();
        table.add(csv_string.parse_CSV(input1));
        table.add(csv_string.parse_CSV(input2));
        table.add(csv_string.parse_CSV(input3));

        table.forEach(System.out::println);
    }
}

class CSV_String {
    public List<List<String>> parse_CSV(String input) {

        StringBuilder stringBuilder = new StringBuilder();
        List<List<String>> result = new ArrayList<>();
        List<String> list = new ArrayList<>();
        List<Character> inputChars = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            inputChars.add(input.charAt(i));
        }

        boolean isSingle = false;
        boolean isDouble = false;
        boolean next = false;

        for (int i = 0; i < inputChars.size(); i++) {
            if (!next) {
                if (!isDouble) {
                    if (!isSingle) {
                        if (',' == inputChars.get(i)) {
                            list.add(stringBuilder.toString());
                            stringBuilder = new StringBuilder();
                        } else if ('\"' == inputChars.get(i)) {
                            isSingle = true;
                        } else {
                            stringBuilder.append(inputChars.get(i));
                        }
                    } else {
                        if ('\"' == inputChars.get(i) && '\"' == inputChars.get(i + 1)) {
                            isDouble = true;
                        } else if ('\"' == inputChars.get(i) && ',' == inputChars.get(i + 1)) {
                            list.add(stringBuilder.toString());
                            stringBuilder = new StringBuilder();
                            isSingle = false;
                            next = true;
                        } else {
                            stringBuilder.append(inputChars.get(i));
                        }
                    }
                } else {
                    isDouble = false;
                    stringBuilder.append(inputChars.get(i));
                }
            } else {
                next = false;
            }
        }
        list.add(stringBuilder.toString());

        simpleDigit(list);

        result.add(list);
        return result;
    }

    private void simpleDigit(List<String> list) {

        Parse parse = new Parse();

        for (int i = 0; i < list.size(); i++) {

            boolean isNull = false;
            String temp = list.get(i);

            if (temp.equals("")) {
                isNull = true;
            }

            if (!isNull) {
                boolean isDigit = true;
                for (int j = 0; j < temp.length(); j++) {
                    if ('0' != (temp.charAt(j)) &&
                            '1' != (temp.charAt(j)) &&
                            '2' != (temp.charAt(j)) &&
                            '3' != (temp.charAt(j)) &&
                            '4' != (temp.charAt(j)) &&
                            '5' != (temp.charAt(j)) &&
                            '6' != (temp.charAt(j)) &&
                            '7' != (temp.charAt(j)) &&
                            '8' != (temp.charAt(j)) &&
                            '9' != (temp.charAt(j)) &&
                            '.' != (temp.charAt(j))) {
                        isDigit = false;
                    }
                }

                if (isDigit) {
                    double digit = Double.parseDouble(temp);
                    int digitBeforeZero = (int) digit; //целая часть
                    double digitAfterZero = digit - digitBeforeZero; //дробная часть
                    if (digitAfterZero == 0) {
                        list.set(i, String.valueOf(digitBeforeZero));
                    } else {
                        String simple = String.valueOf(digitAfterZero);
                        double tempParse = parse.parseString(simple);
                        list.set(i, String.valueOf(digitBeforeZero + tempParse));
                    }
                }
            }
        }
    }
}

class Parse {
    public Double parseString(String input) {
        ArrayList<Character> charArray = new ArrayList<>();
        ArrayList<Integer> digitArray = new ArrayList<>();

        if (input.equals("")) {
            input = "0";
        }

        for (int i = 0; i < input.length(); i++) {
            charArray.add(input.charAt(i));
        }

        double sign = 0;
        if ('-' == (charArray.get(0))) {
            sign = -1;
            charArray.remove(0);
        } else if ('+' == (charArray.get(0))) {
            sign = 1;
            charArray.remove(0);
        } else {
            sign = 1;
        }

        double e = 10;
        double eSign = 1;
        boolean isE = false;
        boolean isDot = false;
        double sumDigitBeforeDot = 0;
        double sumDigitAfterDot = 0;
        for (int i = 0; i < charArray.size(); i++) {
            if ('0' == (charArray.get(i)) ||
                    '1' == (charArray.get(i)) ||
                    '2' == (charArray.get(i)) ||
                    '3' == (charArray.get(i)) ||
                    '4' == (charArray.get(i)) ||
                    '5' == (charArray.get(i)) ||
                    '6' == (charArray.get(i)) ||
                    '7' == (charArray.get(i)) ||
                    '8' == (charArray.get(i)) ||
                    '9' == (charArray.get(i))
                    ) {
                digit(charArray, digitArray, i);
            } else if ('.' == (charArray.get(i))) {
                if (charArray.size() == 1) {
                    return 0.00;
                }
                isDot = true;
                for (Integer aDigitArray : digitArray) {
                    if (aDigitArray == 0) {
                        if (sumDigitBeforeDot != 0) {
                            sumDigitBeforeDot *= (Math.pow(10, 1));
                        }
                    } else {
                        sumDigitBeforeDot *= (Math.pow(10, 1));
                        sumDigitBeforeDot += aDigitArray;
                    }
                }
                while (digitArray.size() != 0) {
                    digitArray.remove(0);
                }
            } else if ('-' == (charArray.get(i))) {
                eSign = -1;
            } else if ('e' == (charArray.get(i))) {
                sumDigitAfterDot = getSumDigitAfterDot(digitArray, isDot, isE, eSign, sumDigitAfterDot);
                isE = true;
                while (digitArray.size() != 0) {
                    digitArray.remove(0);
                }
            } else {
                return 0.0;
            }
        }

        double sumDigitE = 0;
        if (!isE) {
            sumDigitAfterDot = getSumDigitAfterDot(digitArray, isDot, isE, eSign, sumDigitAfterDot);
        } else {
            sumDigitE = getSumDigitAfterDot(digitArray, isDot, isE, eSign, sumDigitAfterDot);
        }

        double result = 0.0;
        if (!isE) {
            result = (sumDigitBeforeDot + sumDigitAfterDot) * sign;
        } else {
            result = (sumDigitBeforeDot + sumDigitAfterDot) * sign * Math.pow(e, sumDigitE);
            result = Math.round(result * 100_000_000_000_000_000.0) / 100_000_000_000_000_000.0;
        }

        if (result == -0.0) {
            result = 0.0;
        }

        return result;
    }

    private double getSumDigitAfterDot(ArrayList<Integer> digitArray, boolean isDot, boolean isE, double eSign, double sumDigitAfterDot) {
        sumDigitAfterDot = 0;
        if (!isE) {
            if (!isDot) {
                for (int j = 0; j < digitArray.size(); j++) {
                    sumDigitAfterDot += (digitArray.get(j) * (Math.pow(10, digitArray.size() - 1 - j)));
                }
            } else {
                for (int j = 0; j < digitArray.size(); j++) {
                    sumDigitAfterDot += (digitArray.get(j) * (Math.pow(10, digitArray.size() - 1 - j)) / (Math.pow(10, digitArray.size())));
                }
            }
        } else {
            for (int j = 0; j < digitArray.size(); j++) {
                sumDigitAfterDot += (digitArray.get(j) * (((Math.pow(10, digitArray.size() - 1 - j))) * eSign));
            }
        }
        return sumDigitAfterDot;
    }

    private void digit(ArrayList<Character> charArray, ArrayList<Integer> digitArray, int i) {
        if ('0' == (charArray.get(i))) {
            digitArray.add(0);
        } else if ('1' == (charArray.get(i))) {
            digitArray.add(1);
        } else if ('2' == (charArray.get(i))) {
            digitArray.add(2);
        } else if ('3' == (charArray.get(i))) {
            digitArray.add(3);
        } else if ('4' == (charArray.get(i))) {
            digitArray.add(4);
        } else if ('5' == (charArray.get(i))) {
            digitArray.add(5);
        } else if ('6' == (charArray.get(i))) {
            digitArray.add(6);
        } else if ('7' == (charArray.get(i))) {
            digitArray.add(7);
        } else if ('8' == (charArray.get(i))) {
            digitArray.add(8);
        } else if ('9' == (charArray.get(i))) {
            digitArray.add(9);
        }
    }
}
