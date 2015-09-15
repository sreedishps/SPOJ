import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class INVCNT {
  static Long counter = 0l;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Integer T = Integer.parseInt(br.readLine());
    while (T-- > 0) {
      br.readLine();
      counter = 0l;
      Integer N = Integer.parseInt(br.readLine());
      Integer arr[] = new Integer[N];
      for (int i = 0; i < N; i++) {
        arr[i] = Integer.parseInt(br.readLine());
      }
      mergeSortModified(arr, 0, N - 1);
//      for (int i = 0; i < N; i++) {
//        System.out.print(arr[i] + " ");
//      }
//      System.out.println();
      System.out.println(counter);
    }
  }

  private static void mergeSortModified(Integer[] arr, Integer start,
                                        Integer end) {
    if (start.intValue() >= end.intValue()) {
      return;
    }
    Integer mid = start + (end - start + 1) / 2;
    mergeSortModified(arr, start, mid - 1);
    mergeSortModified(arr, mid, end);
    merge(arr, start, mid, end);
  }

  private static void merge(Integer[] arr, Integer start, Integer mid,
                            Integer end) {
    Integer temp[] = new Integer[end - start + 1];
    int runner1 = start;
    int runner2 = mid;
    int i = 0;
    while (runner1 <= (mid - 1) || runner2 <= end) {
      if (runner1 > (mid - 1)) {
        temp[i] = arr[runner2];
        runner2++;
        i++;
        continue;
      }
      if (runner2 > end) {
        temp[i] = arr[runner1];
        runner1++;
        i++;
        continue;
      }
      if (arr[runner1] <= arr[runner2]) {
        temp[i] = arr[runner1];
        runner1++;
        i++;
        continue;
      } else {
        temp[i] = arr[runner2];
        counter+= ((mid-1) - runner1 +1);
        runner2++;
        i++;
        continue;
      }
    }

    for (int j = start; j <= end; j++) {
      arr[j] = temp[j-start];
    }

  }

}
