package com.VoterApplication.VoterRegistration;

public class Solution {

        public static boolean isValid(String s) {
            int round = 0;  // for ()
            int curly = 0;  // for {}
            int square = 0; // for []

            for (char ch : s.toCharArray()) {
                switch (ch) {
                    case '(':
                        round++;
                        break;
                    case ')':
                        if (round == 0) return false;
                        round--;
                        break;
                    case '{':
                        curly++;
                        break;
                    case '}':
                        if (curly == 0) return false;
                        curly--;
                        break;
                    case '[':
                        square++;
                        break;
                    case ']':
                        if (square == 0) return false;
                        square--;
                        break;
                    default:
                        // Ignore non-parenthesis characters
                        break;
                }
            }

            return round == 0 && curly == 0 && square == 0;
        }

        public static void main(String[] args) {
            System.out.println(isValid("({[]})")); // true
            System.out.println(isValid("([)]"));  // false
        }


}
