package 누적합;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Bj10211_MaximumSubarray {
    public static void main(String[] args) throws IOException {
        System.setIn(new ByteArrayInputStream(("2\n" +
            "5\n" +
            "1 2 3 4 5\n" +
            "5\n" +
            "2 1 -2 3 -5").getBytes()));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());
        int count = 0, max = 0, sum = 0, idx = 1;
        int[] ary = new int[1];

        while (count != T) {
            if (st == null) {
                ary = new int[Integer.parseInt(br.readLine()) + 1];
                st = new StringTokenizer(br.readLine());
                max = 0;
                sum = 0;
                idx = 1;
                continue;
            }

            if (!st.hasMoreTokens()) {
                System.out.println(max);
                st = null;
                count++;
                continue;
            }

            ary[idx] = Integer.parseInt(st.nextToken()) + ary[idx-1];
            sum = ary[idx++];
            max = Math.max(Math.max(sum, max), ary[idx-1] - ary[idx-2]);
        }

        br.close();
    }
}
