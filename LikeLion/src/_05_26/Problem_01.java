package _05_26;/*
철수는 외환 업무 처리를 위해 해외 지점에서 영어로 불러주는 숫자를 받아
적으려 합니다. 다행히 상대방은 "zero"부터 "nine"까지의 단어를 사용해
숫자를 말해줍니다.
예를 들어 불러준 숫자가 "onesevenfive"이면 상대가 말한 숫자는 차례로
"one", "seven", "five"이므로, 철수는 175를 받아적으면 됩니다.
영어로 된 숫자가 들어있는 문자열 number가 주어질때, 이를 숫자로 변환해
return하도록 solution함수를 완성해주세요.
 */

/*
제한사항
number의 길이는 3이상, 1,000이하 입니다.
number는 알파뱃 소문자로만 이루어져있습니다.
올바르게 숫자로 바꿀 수 있있는 경우만 입력으로 주어집니다.
사용되는 단어는 zero,one,two,three,four,five,six,seven,eight,nine 입니다.
숫자가 커질 수 있으므로, 문자열 형태로 return해주세요.
 */

/*
입출력 예
number = "onesevenfive" , return = "175"
number = "threetwo", return = "32"
number = "fourthreenine", return = "439"
number = "eight", return = 8"
number = "fivetwoonetwo", return = "5212"
number = "zerosix", return = "06"
 */

import java.util.*;

public class Problem_01 {
    private static HashMap<String, String> wordMap = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(solution("onesevenfive"));
        System.out.println(solution("threetwo"));
        System.out.println(solution("fourthreenine"));
        System.out.println(solution("eight"));
        System.out.println(solution("fivetwoonetwo"));
        System.out.println(solution("zerosix"));
    }

    /*
    글자 길이는 3 ~ 5자 사이
     */
    public static String solution(String str) {
        wordMap.put("one", "1");
        wordMap.put("two", "2");
        wordMap.put("three", "3");
        wordMap.put("four", "4");
        wordMap.put("five", "5");
        wordMap.put("six", "6");
        wordMap.put("seven", "7");
        wordMap.put("eight", "8");
        wordMap.put("nine", "9");
        wordMap.put("zero", "0");

        StringBuilder sb = new StringBuilder();
        StringBuilder res = new StringBuilder();

        char[] chars = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            sb.append(chars[i]);
            if (wordMap.containsKey(sb.toString())) {
                res.append(wordMap.get(sb.toString()));
                sb.replace(0, sb.length(), "");
            }
        }

        return res.toString();
    }
}
