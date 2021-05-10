package checker;

import java.util.Scanner;

public class Checker {
    Scanner scanner = new Scanner(System.in);
    public String nextLn() {
        String nextLn = scanner.nextLine();
        if (nextLn.trim().length() <= 0 || nextLn.isEmpty()) {
            nextLn = nextLn();
        }
        return nextLn;
    }
    public double nextDouble() {
        double nextDouble = scanner.nextDouble();
        return nextDouble;

    }

    public int nextInt() {
        int nextInt;
        String input = nextLn();
        if(!isInt(input)) {
            nextInt = -1;
        } else {
            nextInt = Integer.parseInt(input);
        }
        return nextInt;
    }

    public boolean isInt(String str)
    {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        if (str.charAt(0) == '-') {
            if (length == 1) {
                return false;
            }
            i = 1;
        }
        for (; i < length; i++) {
            char c = str.charAt(i);
            if (c <= '/' || c >= ':') {
                return false;
            }
        }
        return true;
    }

}
