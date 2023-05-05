import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//  최댓값 2
//  https://codeup.kr/problem.php?id=4596&rid=0
public class Codeup_4596_최댓값2 {
    public static void main(String[] args) throws IOException {
        int[][] table = new int[9][9];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int maxNum = Integer.MIN_VALUE;
        int x = 0, y = 0;
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
                if (maxNum < table[i][j]) {
                    x = i + 1;
                    y = j + 1;
                    maxNum = table[i][j];
                }
            }
        }

        System.out.println(maxNum);
        System.out.println(x + " " + y);
    }
}
