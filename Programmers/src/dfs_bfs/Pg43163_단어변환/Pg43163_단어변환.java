/**
 * @project CodingTestJava
 * @author ARA
 * @since 2023-08-08 PM 3:48
 */

package dfs_bfs.Pg43163_단어변환;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

//  단어변환
//  https://school.programmers.co.kr/learn/courses/30/lessons/43163
//  RETRY
public class Pg43163_단어변환 {

    private String begin;
    private String target;
    private char[][] wordsCharAry;

    public static void main(String[] args) {
        System.out.println(new Pg43163_단어변환().solution(
                "hit",
                "cog",
                new String[]{"hot", "dot", "dog", "lot", "log", "cog"}
        ));
        System.out.println(new Pg43163_단어변환().solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"}));
    }

    public int solution(String begin, String target, String[] words) {
        this.target = target;

        wordsCharAry = new char[words.length][];
        for (int i = 0; i < wordsCharAry.length; i++) {
            wordsCharAry[i] = words[i].toCharArray();
        }

        Deque<char[]> queue = new ArrayDeque<>();
        char[] beginAry = begin.toCharArray();
        char[] startAry = new char[beginAry.length + 1];
        for (int i = 0; i < beginAry.length; i++) {
            startAry[i] = beginAry[i];
        }
        startAry[startAry.length - 1] = 0;

        queue.offer(startAry);
        while (!queue.isEmpty()) {
            char[] curWord = queue.poll();

            if (Arrays.equals(target.toCharArray(), 0, target.toCharArray().length, curWord, 0, curWord.length - 1)) {
                return curWord[curWord.length - 1];
            }

            
        }

        return 0;
    }

    public int getDifferenceCount(char[] src, char[] comp) {
        int count = 0;

        for (int i = 0; i < src.length; i++) {
            if (src[i] != comp[i]) {
                count++;
            }
        }

        return count;
    }
}
