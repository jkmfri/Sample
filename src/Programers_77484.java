import sun.security.util.Cache;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.IntStream;

//https://programmers.co.kr/learn/courses/30/lessons/77484
//로또의 최고 순위와 최저 순위
public class Programers_77484 {

    public static void main(String[] args) {

        int[] answer = new int[2];
        int[] lottos = {44, 1, 0, 0, 31, 25};
        //int[] lottos = {0, 0, 0, 0, 0, 0};
        //int[] lottos = {45, 4, 35, 20, 3, 9};

        int[] win_nums = {31, 10, 45, 1, 6, 19};
        //int[] win_nums = {38, 19, 20, 40, 15, 25};
        //int[] win_nums = {20, 9, 3, 45, 4, 35};

        answer = solution(lottos, win_nums);

    }

    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int sucCnt = 0; //맞은 갯수
        int nonCnt = 0; //모르는 갯수
        HashMap<Integer, Integer> winGrdArr = new HashMap<Integer, Integer>();
        winGrdArr.put(0, 6);
        winGrdArr.put(1, 6);
        winGrdArr.put(2, 5);
        winGrdArr.put(3, 4);
        winGrdArr.put(4, 3);
        winGrdArr.put(5, 2);
        winGrdArr.put(6, 1);

        for( int i=0; i < lottos.length; i++ ){
            int temp = lottos[i];
            if( temp == 0 ){
                nonCnt++;
            }else{
                if( IntStream.of(win_nums).anyMatch(x -> x == temp) ) sucCnt++;
            }
        }

        System.out.println("sucCnt / nonCnt : " + sucCnt + " / " + nonCnt);
        answer[0] = winGrdArr.get(sucCnt+nonCnt);
        answer[1] = winGrdArr.get(sucCnt);
        System.out.println("answer : " + Arrays.toString(answer));

        return answer;
    }
}
