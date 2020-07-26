package hIndex;

import java.util.ArrayList;
import java.util.List;

public class HIndex {
    public int solution(int[] citations) {
        int answer = 0;
        int total = citations.length;
        List<Integer> ls = new ArrayList<>();

        for(int i =0; i<=total; i++){
            ls.add(index(citations, i));
        }
        for(int v : ls){
            if(answer <= v){
                answer = v;
            }
        }
        System.out.println(answer);
        return answer;
    }

    private int index(int[] citations, int index){
        int h = 0;
        List<Integer> lsUp = new ArrayList<>();
        List<Integer> lsDown = new ArrayList<>();

        for(int v : citations){
            if(v >= index){
                lsUp.add(v);
            }else{
                lsDown.add(v);
            }
        }

        if(lsUp.size() >= index && lsDown.size() < index){
            h = index;
        }

        return h;
    }

    public static void main(String[] args) {
        //int[] citations = {3, 0, 6, 1, 5};
        int[] citations = {5, 5, 5, 5, 5};

        new HIndex().solution(citations);
    }
    
}