package Java_Practice.Practice_5_Parsing.ParseDigit;

import java.util.ArrayList;

/**
 * Created by Splayd on 13.01.2017.
 * Parse String to Double;
 */
public class ParseDigit {
    public static void main(String[] args) {
        Parse parse = new Parse();
        String inputTest = "-.56e-2";
        System.out.println(parse.parseString(inputTest));
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
