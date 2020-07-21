package runner;
import java.util.*;
public class Runner {

    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        solution(participant,completion);
    }

    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        
        for(String value : participant){
            if(map.get(value) == null){
                map.put(value, 1);
            }else {
                map.put(value, map.get(value) + 1);
            }
        }

        for(String value : completion){
            if(map.get(value) == null){
                answer = value;
                break;                
            }else {
                map.put(value, map.get(value) -1);
            }
        }

        for(String value : map.keySet()){
            if(map.get(value) == 1){
                answer = value;
            }
        }
        return answer;
    }    
}