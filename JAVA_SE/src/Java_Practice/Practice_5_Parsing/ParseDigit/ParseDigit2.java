package Java_Practice.Practice_5_Parsing.ParseDigit;

import org.apache.commons.math3.util.Precision;

/**
 * Created by Splayd on 14.01.2017.
 * Parse String to Double;
 * Round to 15 Digits after dot;
 */
public class ParseDigit2 {
    public static void main(String[] args) {
        Parse2 parse = new Parse2();
        String inputTest = "-020.00300500e-11";
        System.out.println(parse.parseString2(inputTest));
    }
}

class Parse2 {
    public Double parseString2(String input) {
        StateMachine sm = new StateMachine();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            sm.next(c);
        }

        return sm.getResult();
    }

    private static class StateMachine {
        public void next(char c) {
            currentState = currentState.next(c, data);
        }

        State currentState = State.INIT;
        ParseData data = new ParseData();

        public Double getResult() {
            if (currentState == State.NUMBER || currentState == State.DOT_NUMBER || currentState == State.E_NUMBER) {
                if (!data.isE()) {
                    return Precision.round(data.getNumber() * data.sign, 15);
                } else {
                    if (data.getSignE() > 0) {
                        return Precision.round((data.getNumber() * data.sign) * Math.pow(10, data.getNumberE()), 15);
                    } else {
                        return Precision.round((data.getNumber() * data.sign) * Math.pow(0.1, data.getNumberE()), 15);
                    }
                }
            } else {
                return null;
            }
        }

        public enum State {
            INIT {
                @Override
                public State next(char c, ParseData data) {
                    if ('-' == c || '+' == c) {
                        if ('-' == c) {
                            data.setSign(-1);
                        }
                        if ('+' == c) {
                            data.setSign(1);
                        }
                        return INIT;
                    }
                    if ('.' == c) {
                        data.setDot(true);
                        return DOT_NUMBER;
                    }
                    if ('e' == c || 'E' == c) {
                        data.setE(true);
                        return INIT;
                    }
                    if (c - '0' <= 9 && c - '0' >= 0) {
                        data.addDigit(c - '0');
                        return NUMBER;
                    }
                    return INVALID_END;
                }
            }, NUMBER {
                @Override
                public State next(char c, ParseData data) {
                    if (c - '0' <= 9 && c - '0' >= 0) {
                        data.addDigit(c - '0');
                        return NUMBER;
                    }
                    if ('.' == c) {
                        data.setDot(true);
                        return DOT_NUMBER;
                    }
                    if ('e' == c || 'E' == c) {
                        data.setE(true);
                        return E_NUMBER;
                    }
                    return INVALID_END;
                }
            }, DOT_NUMBER {
                @Override
                public State next(char c, ParseData data) {
                    if (c - '0' <= 9 && c - '0' >= 0) {
                        data.setPowCount();
                        data.addDigit(c - '0');
                        return DOT_NUMBER;
                    }
                    if ('e' == c || 'E' == c) {
                        data.setE(true);
                        return E_NUMBER;
                    }
                    return INVALID_END;
                }
            }, E_NUMBER {
                @Override
                public State next(char c, ParseData data) {
                    if ('-' == c || '+' == c) {
                        if ('-' == c) {
                            data.setSignE(-1);
                        }
                        if ('+' == c) {
                            data.setSignE(1);
                        }
                        return E_NUMBER;
                    }
                    if (c - '0' <= 9 && c - '0' >= 0) {
                        data.powE(c - '0');
                        return E_NUMBER;
                    }
                    return INVALID_END;
                }
            }, VALID_END {
                @Override
                public State next(char c, ParseData data) {
                    if (c == ' ') return VALID_END;
                    return INVALID_END;
                }
            }, INVALID_END {
                @Override
                public State next(char c, ParseData data) {
                    return INVALID_END;
                }
            };

            public abstract State next(char c, ParseData data);
        }
    }

    public static class ParseData {
        private int sign = 1;
        private double number = 0;
        private boolean isDot = false;
        private double powCount = 1;
        private boolean isE = false;
        private int signE = 1;
        private int numberE = 0;

        public double getNumber() {
            return number;
        }

        public boolean isE() {
            return isE;
        }

        public int getNumberE() {
            return numberE;
        }

        public int getSignE() {
            return signE;
        }

        public void setDot(boolean dot) {
            isDot = dot;
        }

        public void setPowCount() {
            this.powCount = powCount / 10;
        }

        public void setSign(int sign) {
            this.sign = sign;
        }

        public void setE(boolean e) {
            isE = e;
        }

        public void setSignE(int signE) {
            this.signE = signE;
        }

        public void addDigit(int i) {
            if (!isDot) {
                number = number * 10 + i;
            } else {
                number = powCount * i + number;
            }
        }

        public void powE(int i) {
            numberE = numberE * 10 + i;
        }
    }
}