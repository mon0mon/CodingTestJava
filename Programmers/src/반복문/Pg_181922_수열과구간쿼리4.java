package 반복문;

import java.util.*;

//  수열과 구간 쿼리 4
//  https://school.programmers.co.kr/learn/courses/30/lessons/181922
public class Pg_181922_수열과구간쿼리4 {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new Pg_181922_수열과구간쿼리4()
//            .solution(new int[] {0, 1, 2, 4, 3}, new int[][] {
//                {0, 4, 1},
//                {0, 3, 2},
//                {0, 3, 3},
//            })));
        System.out.println(Arrays.toString(new Pg_181922_수열과구간쿼리4()
            .solution(new int[] {0, 1, 2, 4, 3}, new int[][] {
                {0, 4, 1},
                {0, 3, 2},
                {0, 3, 3},
            })));
    }

    public int[] solution(int[] arr, int[][] queries) {
        int[] res = Arrays.copyOf(arr, arr.length);

        for (int i = 0; i < queries.length; i++) {
            int s = queries[i][0];
            int e = queries[i][1];
            int k = queries[i][2];

            for (int j = s; j <= e; j++) {
                if (j % k == 0) {
                    res[j]++;
                }
            }
        }

        return res;
    }
}
