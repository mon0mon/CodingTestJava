/**
 * @project CodingTestJava
 * @author ARA
 * @since 2023-07-22 AM 10:46
 */

package dfs_bfs.Bj2644_촌수계산;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

//  촌수계산
//  https://www.acmicpc.net/problem/2644
public class Bj2644_촌수계산 {
/*
9
7 3
7
1 2
1 3
2 7
2 8
2 9
4 5
4 6
 */

    public static void main(String[] args) throws IOException {
        System.out.println(new Bj2644_촌수계산().solution());
    }

    public int solution() throws IOException {
        Scanner sc = new Scanner(System.in);

        int familyMemberCount = sc.nextInt();
        int[][] family = new int[familyMemberCount + 1][familyMemberCount + 1];
        boolean[][] visited = new boolean[familyMemberCount + 1][familyMemberCount + 1];

        int start = sc.nextInt();
        int dest = sc.nextInt();

        if (dest > start) {
            int temp = start;
            start = dest;
            dest = temp;
        }

        int edgeCount = sc.nextInt();
        for (int i = 0; i < edgeCount; i++) {
            int person1 = sc.nextInt();
            int person2 = sc.nextInt();

            family[person1][person2] = 1;
            family[person2][person1] = 1;
        }

        Deque<int[]> queue = new ArrayDeque<>();
        int relationNumber = -1;
        queue.offer(new int[] {start, 0});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            if (current[0] == dest) {
                relationNumber = current[1];
                break;
            }

            for (int i = 1; i < familyMemberCount + 1; i++) {
                if (family[current[0]][i] == 1 && !visited[current[0]][i]) {
                    queue.offer(new int[] {i, current[1] + 1});
                    visited[current[0]][i] = true;
                }
            }
        }

        return relationNumber;
    }
}
