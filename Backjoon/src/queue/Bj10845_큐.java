/**
 * @project CodingTestJava
 * @author ARA
 * @since 2023-06-21 0021 : AM 3:37
 */

package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//  큐
//  https://www.acmicpc.net/problem/10845
public class Bj10845_큐 {
    static int[] ary = new int[10_001];
    static int start = 0;
    static int tail = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int comCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < comCount; i++) {
            String[] com = br.readLine().split(" ");
            process(com);
        }
    }

    public static void process(String[] com) {
        switch(com[0]) {
            case "push" :
                ary[tail++] = Integer.parseInt(com[1]);
                break;
            case "pop" :
                System.out.println(tail == start ? -1 : ary[start++]);
                break;
            case "front" :
                System.out.println(tail == start ? -1 : ary[start]);
                break;
            case "back" :
                System.out.println(tail == start ? -1 : ary[tail-1]);
                break;
            case "size" :
                System.out.println(tail - start);
                break;
            case "empty" :
                System.out.println(tail == start ? 1 : 0);
                break;
        }
    }
}
