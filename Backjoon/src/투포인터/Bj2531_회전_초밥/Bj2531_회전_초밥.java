/**
 * @project CodingTestJava
 * @author ARA
 * @since 2023-08-10 PM 7:59
 */

package 투포인터.Bj2531_회전_초밥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

//  회전 초밥
//  https://www.acmicpc.net/problem/2531
public class Bj2531_회전_초밥 {
    public static void main(String[] args) throws IOException {
        System.out.println(Bj2531_회전_초밥.solution());
    }

    public static int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer inputToken = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(inputToken.nextToken());
        int d = Integer.parseInt(inputToken.nextToken());
        int k = Integer.parseInt(inputToken.nextToken());
        int c = Integer.parseInt(inputToken.nextToken());

        int[] sushi = new int[N];
        for (int i = 0; i < sushi.length; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        int maxTypeCount = 0;
        Set<Integer> set;
        for (int i = 0; i < sushi.length; i++) {
            set = new HashSet<>();

            for (int j = 0; j < k; j++) {
                int idx = i + j;
                if (idx >= sushi.length) {
                    idx = idx - sushi.length;
                }

                set.add(sushi[idx]);
            }
            set.add(c);
            maxTypeCount = Math.max(maxTypeCount, set.size());
        }

        return maxTypeCount;
    }
}
