import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreedish.ps on 01/10/14.
 */
public class PALIN {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Integer N;
    N = Integer.parseInt(br.readLine());
    while (N-- > 0) {

      String original = br.readLine();
      char[] str = original.toCharArray();
      int len = str.length;
      if (original.equals(new StringBuilder(original).reverse().toString())) {
        if (len % 2 == 0) {
          int left = len / 2 - 1;
          int right = len / 2;

          while (left >= 0) {
            if (str[left] == '9') {
              str[left] = str[right] = '0';
            } else {
              str[left]++;
              str[right]++;
              break;
            }
            left--;
            right++;
          }

          if (left < 0) {
            System.out.printf("1");
            for (int i = 1; i < len; i++) {
              System.out.print("0");
            }
            System.out.println("1");
          } else {
            System.out.println(new String(str));
            continue;
          }
        } else {
          int middle = len / 2;
          if (str[middle] < '9') {
            str[middle]++;
            System.out.println(new String(str));
            continue;
          } else {
            str[middle] = '0';
          }
          int left = len / 2 - 1;
          int right = len / 2 + 1;

          while (left >= 0) {
            if (str[left] == '9') {
              str[left] = str[right] = '0';
            } else {
              str[left]++;
              str[right]++;
              break;
            }
            left--;
            right++;
          }

          if (left < 0) {
            System.out.printf("1");
            for (int i = 1; i < len; i++) {
              System.out.print("0");
            }
            System.out.println("1");
          } else {
            System.out.println(new String(str));
            continue;
          }
        }
      } else {     //non palindrome
        int i, j;
        if (len % 2 != 0) {
          i = len / 2 - 1;
          j = len / 2 + 1;
        } else {
          i = len / 2 - 1;
          j = len / 2;
        }

        int flag = 0;

        while (i >= 0) {

          if (str[i] - str[j] > 0) {
            flag = 1;
            break;
          } else if (str[i] - str[j] < 0) {
            flag = 2;
            break;
          }

          i--;
          j++;
        }

        if (len % 2 != 0) {
          i = len / 2 - 1;
          j = len / 2 + 1;
        } else {
          i = len / 2 - 1;
          j = len / 2;
        }

        if (flag == 1) {    /*  line 1*/
          while (i >= 0) {
            str[j] = str[i];

            i--;
            j++;
          }
        } else if (flag == 2 && (len % 2 != 0) && str[len / 2] < '9') {    /* line 2*/
          str[len / 2]++;

          i = len / 2 - 1;
          j = len / 2 + 1;

          while (i >= 0) {
            str[j] = str[i];
            i--;
            j++;
          }
        } else {                          /* line 3   */

          if (len % 2 != 0) {
            str[len / 2] = '0';
          }

          while (i >= 0) {
            if (str[i] < '9') {
              str[i]++;
              str[j] = str[i];
              break;
            } else {
              str[i] = str[j] = '0';
            }
            i--;
            j++;
          }

          while (i >= 0) {
            str[j] = str[i];

            i--;
            j++;
          }
        }

        System.out.println(str);
      }
    }
  }

}
