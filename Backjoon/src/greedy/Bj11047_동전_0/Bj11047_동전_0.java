/**
 * @project CodingTestJava
 * @author ARA
 * @since 2023-07-29 PM 10:48
 */

package greedy.Bj11047_동전_0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//  동전 0
//  https://www.acmicpc.net/problem/11047
public class Bj11047_동전_0 {
    public static void main(String[] args) throws IOException {
        System.out.println(new Bj11047_동전_0().solution());
    }

    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer inputToken = new StringTokenizer(br.readLine());

        int coinCount = Integer.parseInt(inputToken.nextToken());
        int money = Integer.parseInt(inputToken.nextToken());
        int[] coin = new int[coinCount];
        int requireCoinCount = 0;

        for (int i = coinCount - 1; i >= 0; i--) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < coin.length; i++) {
            if (coin[i] <= money) {
                money -= coin[i];
                i--;
                requireCoinCount++;
            }
        }

        return requireCoinCount;
    }
}
