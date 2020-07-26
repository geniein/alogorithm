package diskControl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class DiskControl {
    class Disk implements Comparable<Disk>{
        private int reqTime;
        private int needTime;

        public Disk(int _reqTime, int _needTime){
            this.reqTime = _reqTime;
            this.needTime = _needTime;
        }

        @Override
        public int compareTo(Disk o) {
            // TODO Auto-generated method stub            
            return needTime - o.needTime;
        }
    }

    public int solution(int[][] jobs) {
        int answer = 0;
        LinkedList<Disk> dsLs = new LinkedList<>();
        PriorityQueue<Disk> pq = new PriorityQueue<>();
        for(int[] i : jobs){
            dsLs.add(new Disk(i[0], i[1]));
        }
        
        Collections.sort(dsLs, new Comparator<Disk>(){
            @Override
            public int compare(Disk o1, Disk o2) {
                // TODO Auto-generated method stub        
                return o1.reqTime - o2.reqTime;
            }
        });
        int cnt =0;
        int time = 0;

        while(cnt<jobs.length){
            while(!dsLs.isEmpty() && dsLs.peek().reqTime>=time){
                pq.offer(dsLs.poll());
            }
            if(!pq.isEmpty()){
                Disk d = pq.peek();
                if(d.reqTime<=time){
                    d = pq.poll();
                    time += d.needTime;
                    answer += time - d.reqTime;                    
                    cnt++;
                }
            }else{
                time++;
            }          
        }
        System.out.println(Math.floor(answer/jobs.length));
        answer = (int) Math.floor(answer/jobs.length); 
        return answer;
    }    
    
    public static void main(String[] args) {
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        new DiskControl().solution(jobs);
    }
}


// class Disk implements Comparable<Disk>{
    //     int reqTime;
    //     int needTime;
        
    //     public Disk(int reqTime, int needTime){
    //         this.reqTime = reqTime;
    //         this.needTime = needTime;
    //     }
        
    //     @Override
    //     public int compareTo(Disk o) {
    //         // TODO Auto-generated method stub
    //         if (this.needTime > o.needTime) {
    //             return 1;
    //         } else if (this.needTime < o.needTime) {
    //             return -1;
    //         }
    //         return 0;
    //     }
    // }
    // public int solution(int[][] jobs) {
    //     int answer = 0;  
    //     int count = 0;
    //     LinkedList<Disk> waiting = new LinkedList<>();
    //     PriorityQueue<Disk> pq = new PriorityQueue<>();
    //     for(int[] value : jobs){
    //         Disk d = new Disk(value[0], value[1]);
    //         waiting.add(d);
    //     }

    //     Collections.sort(waiting, new Comparator<Disk>(){
    //       @Override
    //       public int compare(Disk o1, Disk o2) {
    //           // TODO Auto-generated method stub
    //           return o1.reqTime - o2.reqTime;
    //       }  
    //     });

    //     int cnt = 0;
    //     while(cnt < jobs.length){
    //         while(!waiting.isEmpty() && waiting.peek().reqTime <= count) {
    //             pq.offer(waiting.poll());
    //         }    
    //         if(!pq.isEmpty()){
    //             Disk d = pq.peek();            
    //             if(d.reqTime <=count){
    //                 d = pq.poll();
    //                 count += d.needTime;                    
    //                 answer += count- d.reqTime;
    //                 cnt++;                              
    //                 System.out.println(answer);
    //             }else {
    //                 count++;
    //             }                
    //         }
    //     }
    //     System.out.println(answer);
    //     answer = (int)Math.floor(answer /jobs.length);
        
    //     return answer;
    // }