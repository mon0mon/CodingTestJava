package 반복문;

import java.util.*;

//  수열과 구간 쿼리 2
//  https://school.programmers.co.kr/learn/courses/30/lessons/181923
public class Pg_181923_수열과구간쿼리2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Pg_181923_수열과구간쿼리2()
            .solution(new int[] {0, 1, 2, 4, 3}, new int[][] {
                {0, 4, 2},
                {0, 3, 2},
                {0, 2, 2}
            })));
    }

    public int[] solution(int[] arr, int[][] quires) {
        int[] res = new int[quires.length];

        int min;
        for (int i = 0; i < quires.length; i++) {
            min = Integer.MAX_VALUE;
            int s = quires[i][0];
            int e = quires[i][1];
            int k = quires[i][2];

            for (int j = s; j <= e; j++) {
                if (arr[j] > k) {
                    min = Math.min(min, arr[j]);
                }
            }
            res[i] = min == Integer.MAX_VALUE ? -1 : min;
        }

        return res;
    }
}
