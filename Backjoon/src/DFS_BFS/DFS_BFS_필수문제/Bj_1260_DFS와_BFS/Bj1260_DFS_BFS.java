package DFS_BFS.DFS_BFS_필수문제.Bj_1260_DFS와_BFS;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

//  DFS와 BFS
//  https://www.acmicpc.net/problem/1260
public class Bj1260_DFS_BFS {
    //  그래프를 DFS와 BFS로 탐색한 결과를 출력하는 프로그램 작성
    //  DFS는 Stack, BFS는 Queue 사용
    //  RETRY ArrayList<LinkedList>는 너무 복잡한듯... 다시 구상하기
    static Stack<Integer> stack = new Stack<>();
    static ArrayList<LinkedList<Integer>> list;
    static int startNode;
    static int[][] relationNode;
    static int nodeCount;

    public static void main(String[] args) {

    }

    public static void search() {

    }

    private static void dfs(int start) {

    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        nodeCount = Integer.parseInt(st.nextToken());
        relationNode = new int[Integer.parseInt(st.nextToken())][2];
        startNode = Integer.parseInt(st.nextToken());

        list = new ArrayList<>(relationNode.length);
        for (int i = 0; i < relationNode.length; i++) {
            st = new StringTokenizer(br.readLine());
            relationNode[i] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }

        br.close();
    }
}
