package bridgeTruck;

import java.util.LinkedList;
import java.util.Queue;

public class BridgeTruck {

    class Truck {
        int weight;
        int move;

        public Truck(int weight) {
            this.weight = weight;
            this.move = 1;
        }

        public void moving() {
            move++;
        }
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int count = 0;
        int onBridge = 0;
        Queue<Truck> bridgeQ = new LinkedList<>();
        Queue<Truck> listQ = new LinkedList<>();
        
        for(int value : truck_weights){
            listQ.offer(new Truck(value));         
        }                         
        while(!bridgeQ.isEmpty() || !listQ.isEmpty()){
            count++;
            if(bridgeQ.isEmpty()){
                Truck t = listQ.poll();
                onBridge += t.weight;
                bridgeQ.add(t);
                continue;
            }
            for(Truck value : bridgeQ){
                value.moving();
            }
            if(bridgeQ.peek().move > bridge_length){
                Truck t = bridgeQ.poll();
                onBridge -= t.weight;                
            }
            if(!listQ.isEmpty() && onBridge + listQ.peek().weight <= weight){
                Truck t = listQ.poll();
                bridgeQ.add(t);
                onBridge += t.weight;
            }
        }

        answer = count;

        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        int[] trucks = {7, 4, 5, 6};

        new BridgeTruck().solution(2, 10, trucks);
    }
}