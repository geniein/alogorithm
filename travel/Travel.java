package travel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Travel {
    class TicketDetail {
        int index;
        String[] data;
        boolean marked;

        TicketDetail(String[] data, int index){
            this.index = index;
            this.data = data;
            this.marked = false;
        }
    }
    public Travel(String[][] tickets) {
        String[] answer = {};
        int ticketCount = tickets.length;
        boolean[] visist = new boolean[ticketCount];
        List<String> result = new ArrayList<>();

        dfs(tickets,"ICN",visist,ticketCount,result);
        answer = new String[result.size()];
        for(int i =0; i<result.size();i++){
            //System.out.println(result.get(i));
            answer[i] = result.get(i);
        }

        //return answer;      
    }    

    void dfs(String[][] tickets, String node, boolean[] visist, int ticketCount, List<String> result){         
        List<TicketDetail> nodeList = new ArrayList<>();
        result.add(node);
        System.out.println(ticketCount);
        if(ticketCount == 0){
            for(int i =0; i<result.size();i++){
                System.out.println(result.get(i));                
            }
            return;
        }
        for(int i =0; i< tickets.length; i++){
            if(node.equals(tickets[i][0]) && !visist[i]){                
                nodeList.add(new TicketDetail(tickets[i], i));
            } 
        }
        nodeList.sort(new Comparator<TicketDetail>(){
            @Override
            public int compare(TicketDetail o1, TicketDetail o2) {                
                return o1.data[1].compareTo(o2.data[1]);
            }
        });

        if(!nodeList.isEmpty()){
            ticketCount--;
            for(TicketDetail td : nodeList){
                visist[td.index] = true;
                //System.out.println(td.data[1] + "//" + nodeList.size());
                // for(String v : result){
                //     System.out.println(v);    
                //     System.out.println("--");
                // }
                //System.out.println(ticketCount);
                dfs(tickets,td.data[1], visist,ticketCount,result);
            }            
        }     
    }
    
    public static void main(String[] args) {
        //String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
        String[][] tickets = {{"ICN", "A"}, {"ICN", "B"},{"B", "ICN"}};
        new Travel(tickets);
    }
}