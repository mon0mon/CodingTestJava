/**
 * @project CodingTestJava
 * @author ARA
 * @since 2023-07-24 AM 12:25
 */

package dfs_bfs.Bj2583_영역_구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//  영역 구하기
//  https://www.acmicpc.net/problem/2583
public class Bj2583_영역_구하기 {
    private int height;
    private int length;
    private int size;
    private int[][] paper;
    private boolean[][] visited;

    public static void main(String[] args) throws IOException {
        System.out.println(new Bj2583_영역_구하기().solution());
    }
    
    public String solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer inputToken = new StringTokenizer(br.readLine());

        height = Integer.parseInt(inputToken.nextToken());
        length = Integer.parseInt(inputToken.nextToken());
        int rowCount = Integer.parseInt(inputToken.nextToken());

        paper = new int[height][length];
        visited = new boolean[height][length];

        for (int i = 0; i < rowCount; i++) {
            
        }

        return null;
    }
}
