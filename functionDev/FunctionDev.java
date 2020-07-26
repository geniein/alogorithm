package functionDev;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.Queue;

public class FunctionDev {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        //List<Function> fnList = new ArrayList<>();
        Queue<Function> fnQ = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        IntStream.range(0, progresses.length)
                            .mapToObj(i -> new Function(progresses[i], speeds[i], i))
                            .collect(Collectors.toList()).forEach(f -> fnQ.add(f));
        int count = 0;
        while(!fnQ.isEmpty()){                        
            if(fnQ.peek().progresse >= 100){
                fnQ.poll();
                count++;
                if(fnQ.isEmpty()){
                    result.add(count);
                }
            }else{
                if(count == 0){
                    for(int i =0; i<fnQ.size(); i++){
                        Function f = fnQ.poll();
                        f.progresse = f.progresse + f.speed;
                        fnQ.offer(f);
                    }
                }else{
                    result.add(count);
                    count = 0;
                }                
            }            
        } 

        answer = result.stream().mapToInt(i -> i).toArray();
        for(int i : answer){
            System.out.println(i);
        }
        return answer;
    }

    class Function{
        private int progresse;
        private int speed;
        private int id;

        public Function(int _progresse, int _speed, int _id){
            this.progresse = _progresse;
            this.speed = _speed;
            this.id = _id;
        }
        
    }
    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        new FunctionDev().solution(progresses, speeds);
    }
}