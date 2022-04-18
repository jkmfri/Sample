import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {

        int[] answer = {};
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 1;

        answer = solution(id_list, report, k);

    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        //int[] answer = {};
        int[] answer = new int[id_list.length];

        HashSet<String> hashSet = new HashSet<>(Arrays.asList(report));
        String[] aReport = hashSet.toArray(new String[0]); //중복제거
        HashMap<String, Integer> idCompMap = new HashMap<>();
        HashMap<String, ArrayList> idCompArrList = new HashMap<>();

        for(int i=0; i < aReport.length; i++){
            String[] temp = aReport[i].split(" ");

            //id별 신고당한 횟수
            if(!idCompMap.containsKey(temp[1])){
                idCompMap.put(temp[1], 1); //신고목록 추가
            }else{
                idCompMap.put(temp[1], idCompMap.get(temp[1])+1); //신고당한횟수 추가
            }

            //id별 신고한 id들
            if( !idCompArrList.containsKey(temp[1]) ){
                ArrayList<String> tempArrList = new ArrayList<>();
                tempArrList.add(temp[0]);
                idCompArrList.put(temp[1], tempArrList);
            }else{
                ArrayList<String> tempArrList = new ArrayList<>();
                tempArrList = idCompArrList.get(temp[1]);
                tempArrList.add(temp[0]);
                idCompArrList.put(temp[1],  tempArrList);
            }
        }

        for( int i=0; i < id_list.length; i++ ){
            System.out.println("id_list[i] : " + id_list[i]);
            ArrayList<String> tempArrList = new ArrayList<>();
            if( idCompMap.containsKey(id_list[i]) && idCompMap.get(id_list[i]) >= k ){
                tempArrList = idCompArrList.get(id_list[i]);
                for( String j : tempArrList ){
                    System.out.println(j + " / " +Arrays.asList(id_list).indexOf(j));
                    answer[Arrays.asList(id_list).indexOf(j)]++;
                }
            }
        }

        //id별 신고당한 횟수 결과
        System.out.println("idCompMap.toString() >>>>>>>>>>>>>");
        System.out.println(idCompMap.toString());
        //id별 신고한 id들
        System.out.println("idCompArrList.toString() >>>>>>>>>>>>>");
        System.out.println(idCompArrList.toString());
        System.out.println("Arrays.toString(answer) >>>>>>>>>>>>>");
        System.out.println(Arrays.toString(answer));
        return answer;
    }

}