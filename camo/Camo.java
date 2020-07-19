package camo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class Camo {
    // public static int solution(String[][] clothes) {
    //     int answer = 0;
    //     int count = 1;
    //     Map<String, List<String>> map = new HashMap<>();

    //     for(String[] list : clothes){
    //         List<String> a = new ArrayList<>();
    //         if(map.get(list[1]) == null ){
    //             a.add(list[0]);
    //             map.put(list[1],a);
    //         }else {
    //             a = map.get(list[1]);
    //             a.add(list[0]);
    //             map.put(list[1], a);
    //         }
    //     }
    //     Iterator<String> keys = map.keySet().iterator();
    //     while ( keys.hasNext() ) {
    //         String key = keys.next();
    //         //System.out.println("key : " + key +" values : "+map.get(key).size());
    //         count *= (map.get(key).size()+1);
    //     }
    //     answer = count -1;
    //     return answer;
    // }
    //Lamda
    public static int solution(String[][] clothes) {
        int value = 0;

        value = Arrays.stream(clothes)
                .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
                .values()
                .stream()
                .collect(reducing(1L, (x, y) -> x * (y + 1))).intValue() - 1;                
        return value;
    }

    public static void main(String[] args) {
        String[][] clothes = 	{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};        
        int result = 0;
        result = solution(clothes);
        System.out.println(result);
    }

}