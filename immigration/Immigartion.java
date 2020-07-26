package immigration;

import java.util.Arrays;

public class Immigartion {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        Arrays.sort(times);
        long mid = 0;
        long min = 0;
        long max = 0;
        max = (long) n * times[times.length-1];
        
        while(min <= max){            
            long sum = 0;
            mid = (min + max)/2;
            for(int i : times){
                sum += mid / i;
            }
            if(sum < n){
                min = mid +1;
            }else {
                answer = answer > mid ? mid : answer;
                max = mid -1;
            }
        }
        //answer = binerySearch(n, times, 0, max);
        System.out.println(answer);
        return answer;
    }
    
    private long binerySearch(int n, int[] times, int min, int max){        
        long result = Long.MAX_VALUE;
        int middle = 0;
        
        while(min <= max){
            long sum = 0;
            middle = (min + max) /2;
            
            for(int i : times){
                sum += middle/i;
            }
            if(sum >=  n){
                result = result > middle ? middle : result;
                max = middle - 1;
            }else{
                min = middle + 1;
            }
        }

        return result;   
    }
    public static void main(String[] args) {
        int n = 6;
        int[] times = {7,10};
        new Immigartion().solution(n, times);
    }
}