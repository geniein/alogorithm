package pocketmon;

import java.util.HashSet;

public class Pocketmon {
    public int solution(int[] nums) {
        int answer = 0;
        HashSet<Integer> hs = new HashSet<>();

        for(int i : nums){
            if(hs.size() >=nums.length/2){
                break;
            }
            hs.add(i);            
        }
        answer = hs.size();
        System.out.println(answer);
        return answer;
    }
    public static void main(String[] args) {
        int[] nums = {3, 3, 3, 2, 2, 2};
        new Pocketmon().solution(nums);
    }
}