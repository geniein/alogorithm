package wordChain;

import java.util.HashSet;

public class WordChain {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        HashSet<String> hs = new HashSet<>();
        int idx = 0;
        int round = 0;
        char nextChar = words[0].charAt(0);
        for(int i=0; i<words.length; i++){
            idx = i % n;
            if(idx == 0){
                round++;
            }

            if(!hs.add(words[i])){
                answer[0] = idx +1;
                answer[1] = round;
                break;
            }else {
                if(nextChar != words[i].charAt(0)){                    
                    answer[0] = idx +1;
                    answer[1] = round;
                    break;
                }else {
                    nextChar = words[i].charAt(words[i].length()-1);
                }
            }
        }

        for(int i : answer){
            System.out.println(i);
        }

        return answer;
    }
    public static void main(String[] args) {
        String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};
        int n = 2;

        new WordChain().solution(n, words);
    }
}