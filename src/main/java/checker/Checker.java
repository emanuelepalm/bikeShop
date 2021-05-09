package checker;

import java.util.Scanner;

public class Checker {
    Scanner scanner = new Scanner(System.in);

    public int nextInt() {
      int nextInt;
      char input = scanner.next().charAt(0);
      if(Character.isDigit(input)) {
          nextInt = Character.getNumericValue(input);
          return nextInt;
      } else {
          nextInt = -1;
          return nextInt;
      }
    }

}
