/* 문제 설명
매운 것을 좋아하는 Leo는 모든 음식의 스코빌 지수를 K 이상으로 만들고 싶습니다. 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 Leo는 스코빌 지수가 가장 낮은 두 개의 음식을 아래와 같이 특별한 방법으로 섞어 새로운 음식을 만듭니다.

섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
Leo는 모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복하여 섞습니다.
Leo가 가진 음식의 스코빌 지수를 담은 배열 scoville과 원하는 스코빌 지수 K가 주어질 때, 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수를 return 하도록 solution 함수를 작성해주세요.

제한 사항
scoville의 길이는 1 이상 1,000,000 이하입니다.
K는 0 이상 1,000,000,000 이하입니다.
scoville의 원소는 각각 0 이상 1,000,000 이하입니다.
모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return 합니다. */
package spicier;
import java.util.PriorityQueue;

class Solution {

    class Spicier{

        // public int spicier(int[]  scoville, int K){
        //     int answer = 0;
            
        //     PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();

        //     for(int i=0; i<scoville.length; i++){
        //         priorityQueue.offer(scoville[i]);
        //     }
            
        //     while(priorityQueue.peek() < K){
        //         int result = 0;                
                
        //         if(priorityQueue.size() <2){
        //             return -1;
        //         }

        //         int a = priorityQueue.poll();
        //         int b = priorityQueue.poll();
                
        //         result = a + (b*2);
        //         priorityQueue.offer(result);
        //         answer++;
        //     }
        //     return answer;
        // }
       
    }
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int value : scoville){
            pq.add(value);
        }

        while(pq.peek() < K){            
            int nextValue = pq.poll() + (pq.poll() * 2);
            pq.add(nextValue);
            if(pq.size()<2 && nextValue < K){
                return -1;
            }
            answer++;
        }
        System.out.println(answer);
        return answer;
    }
    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        new Solution().solution(scoville, 7);

    }
}