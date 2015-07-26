import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JAVAC {
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    while (true) {
      String line = in.readLine();
      if (line == null) break;
      if (!startsWithSmallLetter(line)) {
        System.out.println("Error!");
        continue;
      }
      if (!properEnding(line)) {
        System.out.println("Error!");
        continue;
      }
      if (onlysmall(line)) {
        System.out.println(line);
        continue;
      }
      if (containsCapital(line) && containsUnderScore(line)) {
        System.out.println("Error!");
        continue;
      }
      if(containsDoubleUnderScore(line)){
        System.out.println("Error!");
                continue;
      }
      if (javainput(line)) {
        translateC(line);
        continue;
      }
      if (cppinput(line)) {
        translatejava(line);
        continue;
      }
    }
  }

  private static boolean containsDoubleUnderScore(String line) {
    for (int i = 0; i < line.length()-1; i++) {
          if (line.charAt(i) == '_' && line.charAt(i+1) == '_') {
            return true;
          }
        }
        return false;
  }

  private static boolean properEnding(String line) {
    char temp = line.charAt(line.length() - 1);
    if (smallletter(temp) || capitalLetter(temp)) {
      return true;
    }
    return false;
  }

  private static void translatejava(String line) {
    StringBuilder str = new StringBuilder();
    for (int i = 0; i < line.length(); i++) {
      char temp = line.charAt(i);
      if (smallletter(temp)) {
        str.append(temp);
        continue;
      }
      if (temp == '_') {
        str.append(toCapital(line.charAt(i + 1)));
        i++;
      }
    }
    System.out.println(str.toString());

  }

  private static char toCapital(char temp) {
    char capital = (char) (temp + ('A' - 'a'));
    return capital;
  }

  private static void translateC(String line) {
    StringBuilder str = new StringBuilder();
    for (int i = 0; i < line.length(); i++) {
      char temp = line.charAt(i);
      if (smallletter(temp)) {
        str.append(temp);
        continue;
      }
      if (capitalLetter(temp)) {
        str.append('_');
        str.append(toSmall(temp));
      }
    }
    System.out.println(str.toString());
  }

  private static char toSmall(char temp) {
    char small = (char) (temp - ('A' - 'a'));
    return small;
  }

  private static boolean cppinput(String line) {
    for (int i = 0; i < line.length(); i++) {
      char temp = line.charAt(i);
      if (smallletter(temp) || temp == '_') {
        continue;
      } else {
        return false;
      }
    }
    return true;
  }

  private static boolean javainput(String line) {
    for (int i = 0; i < line.length(); i++) {
      char temp = line.charAt(i);
      if (smallletter(temp) || capitalLetter(temp)) {
        continue;
      } else {
        return false;
      }
    }
    return true;
  }

  private static boolean containsUnderScore(String line) {
    for (int i = 0; i < line.length(); i++) {
      if (line.charAt(i) == '_') {
        return true;
      }
    }
    return false;
  }

  private static boolean containsCapital(String line) {
    for (int i = 0; i < line.length(); i++) {
      if (capitalLetter(line.charAt(i))) {
        return true;
      }
    }
    return false;
  }

  private static boolean onlysmall(String line) {
    for (int i = 0; i < line.length(); i++) {
      if (!smallletter(line.charAt(i))) {
        return false;
      }
    }
    return true;
  }

  private static boolean startsWithSmallLetter(String line) {
    char temp = line.charAt(0);
    if (smallletter(temp)) {
      return true;
    }
    return false;
  }

  private static boolean smallletter(char temp) {
    if (temp >= 'a' && temp <= 'z') {
      return true;
    }
    return false;
  }

  private static boolean capitalLetter(char temp) {
    if (temp >= 'A' && temp <= 'Z') {
      return true;
    }
    return false;
  }


}
