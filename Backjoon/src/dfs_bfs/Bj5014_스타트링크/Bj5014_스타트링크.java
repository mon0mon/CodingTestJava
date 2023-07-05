/**
 * @project CodingTestJava
 * @author ARA
 * @since 2023-06-21 0021 : AM 3:38
 */

package dfs_bfs.Bj5014_스타트링크;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//  RETRY queue-나중에 다시 풀어볼 문제
//  스타트링크
//  https://www.acmicpc.net/problem/5014
//public class Bj5014_스타트링크 {
//
//    public static void main(String[] args) throws IOException {
//        solution();
//    }
//
//    public static void solution() throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int[] ary = Arrays.stream(br.readLine().split(" "))
//            .mapToInt(Integer::parseInt)
//            .toArray();
//
//        //  엘리베이터로 도달 할 수 없는 경우일 때
//        if ((ary[Var.G.value] - ary[Var.S.value]) %
//            (Math.abs(ary[Var.U.value] - ary[Var.D.value])) != 0) {
//            System.out.println("use the stairs");
//            return;
//        }
//
//        //  엘리베이터로 도달 할 수 없는 경우 2
//        if (ary[Var.G.value] - ary[Var.S.value] < 0
//            && ary[Var.D.value] <= 0) {
//            System.out.println("use the stairs");
//            return;
//        }
//
//        int pos = ary[Var.S.value];
//        int dest = ary[Var.G.value];
//        int count = 0;
//        for (; ; ) {
//            if (pos + ary[Var.U.value] < dest) {
//                pos += ary[Var.U.value];
//                count++;
//            } else if (pos + ary[Var.U.value] > dest) {
//                pos -= ary[Var.D.value];
//                count++;
//            } else {
//                System.out.println(++count);
//                return;
//            }
//        }
//    }
//}
//
//enum Var {
//    F(0),
//    S(1),
//    G(2),
//    U(3),
//    D(4);
//
//    int value;
//
//    Var(int value) {
//        this.value = value;
//    }
//}

//public class Bj5014_스타트링크 {
//
//    public static void main(String[] args) throws IOException {
//        solution();
//    }
//
//    public static void solution() throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int[] ary = Arrays.stream(br.readLine().split(" "))
//            .mapToInt(Integer::parseInt)
//            .toArray();
//
//        //  엘리베이터로 도달 할 수 없는 경우일 때
//        if ((ary[2] - ary[1]) %
//            (Math.abs(ary[3] - ary[4])) != 0) {
//            System.out.println("use the stairs");
//            return;
//        }
//
//        //  엘리베이터로 도달 할 수 없는 경우 2
//        if (ary[2] - ary[1] < 0
//            && ary[4] <= 0) {
//            System.out.println("use the stairs");
//            return;
//        }
//
//        int pos = ary[1];
//        int dest = ary[2];
//        int count = 0;
//        for (; ; ) {
//            if (pos + ary[3] < dest || pos + ary[3] > ary[0]) {
//                pos += ary[3];
//                count++;
//            } else if (pos + ary[3] > dest) {
//                pos -= ary[4];
//                count++;
//            } else {
//                System.out.println(++count);
//                return;
//            }
//        }
//    }
//}

//  https://zoonvivor.tistory.com/144
public class Bj5014_스타트링크 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        int F = Integer.parseInt(str[0]);
        int S = Integer.parseInt(str[1]);
        int G = Integer.parseInt(str[2]);
        int U = Integer.parseInt(str[3]);
        int D = Integer.parseInt(str[4]);
        int[] arr = new int[F + 1];
        System.out.println(BFS(F, S, G, U, D, arr));

    }

    //  풀이
    //  1. 시작점부터 큐에 넣어 up, down 이동경로를 다시 큐에 넣는다.
    //  2. 큐에서 나온 점이 도착점과 같다면 종료한다.
    //  3. 범위가 0보다 작거나 최대값인 F보다 크다면 패스한다.
    public static String BFS(int Floor, int start, int end, int up, int down, int[] arr) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        arr[start] = 1;

        while (!q.isEmpty()) {
            int current = q.poll();
            if (current == end) {
                return String.valueOf(arr[current] - 1);
            }
            //다음 up 이동할 위치가 최대값보다 작고 방문하지 않은 지점이여야 한다.
            if (current + up <= Floor) {
                if (arr[current + up] == 0) {
                    arr[current + up] = arr[current] + 1;
                    q.add(current + up);
                }

            }
            //다음 down 이동할 위치가 최대값보다 작고 방문하지 않은 지점이여야 한다.
            if (current - down > 0) {
                if (arr[current - down] == 0) {
                    arr[current - down] = arr[current] + 1;
                    q.add(current - down);
                }
            }

        }
        return "use the stairs";
    }
}