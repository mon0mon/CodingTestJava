/**
 * @project CodingTestJava
 * @author ARA
 * @since 2023-08-12 AM 3:32
 */

package dp.Bj9465_스티커;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//  스티커
//  https://www.acmicpc.net/problem/9465
public class Bj9465_스티커 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tcCount = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < tcCount; i++) {
            int colCount = Integer.parseInt(br.readLine());
            int[][] stickers = new int[2][colCount];
            int[][] sum = new int[2][colCount];
            StringTokenizer row1 = new StringTokenizer(br.readLine(), " ");
            StringTokenizer row2 = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < colCount; j++) {
                stickers[0][j] = Integer.parseInt(row1.nextToken());
                stickers[1][j] = Integer.parseInt(row2.nextToken());
            }

            sum[0][0] = stickers[0][0];
            sum[1][0] = stickers[1][0];

            for (int j = 1; j < colCount; j++) {
                sum[0][j] = Math.max(sum[0][j-1], sum[1][j-1] + stickers[0][j]);
                sum[1][j] = Math.max(sum[1][j-1], sum[0][j-1] + stickers[1][j]);
            }

            result.append(Math.max(sum[0][colCount - 1], sum[1][colCount - 1])).append('\n');
        }

        System.out.println(result);
    }
}
