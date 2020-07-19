package print;

import java.util.LinkedList;
import java.util.Queue;

public class Print {

    class Document{
        int priority;
        int location;

        public Document(int priority, int location){
            this.priority = priority;
            this.location = location;
        }
    }

    public int solution(int[] priorities, int location) {
        int answer = 0;        
        Queue<Document> listQ = new LinkedList<>();
        Queue<Document> resultQ = new LinkedList<>();
        for(int i = 0; i< priorities.length; i++){
            Document docu = new Document(priorities[i], i);
            listQ.add(docu);
        }

        while(!listQ.isEmpty()){
            Document docu = listQ.peek();
            int max = max(priorities);
            if(docu.priority >= max){
                docu = listQ.poll();
                priorities[docu.location] = 0;
                resultQ.add(docu);
                if(docu.location == location){
                    break;
                }
            }else {
                docu = listQ.poll();
                listQ.add(docu);
            }
        }
        answer = resultQ.size();
        System.out.println((answer));
        return answer;
    }
    private int max(int[] list){
        int result =0;
        for(int value : list){
            if(value >result){
                result = value;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] priorities = {2, 1, 3, 2};        
        new Print().solution(priorities, 2);
    }
}