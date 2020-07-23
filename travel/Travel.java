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
    List<List<String>> resultGlobal = new ArrayList<>();
    public Travel(String[][] tickets) {
        String[] answer = {};
        int ticketCount = tickets.length;
        boolean[] visist = new boolean[ticketCount];
        

        dfs(tickets,"ICN",visist,ticketCount,new ArrayList<>());        
        answer = new String[resultGlobal.get(0).size()];
        for(int i =0; i<resultGlobal.get(0).size();i++){
            System.out.println(resultGlobal.get(0).get(i));
            answer[i] = resultGlobal.get(0).get(i);
        }

        //return answer;      
    }    

    void dfs(String[][] tickets, String node, boolean[] visist, int ticketCount, List<String> result){         
        List<TicketDetail> nodeList = new ArrayList<>();
        List<String> resultList = new ArrayList<>();
        resultList.addAll(result);
        resultList.add(node);                       
        if(ticketCount == 0){
            // for(int i =0; i<resultList.size();i++){
            //     System.out.println(resultList.get(i));                
            // }
            resultGlobal.add(resultList);
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
                dfs(tickets,td.data[1], visist,ticketCount,resultList);
                visist[td.index] = false;        
            }            
        }     
    }
    
    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
        //String[][] tickets = {{"ICN", "A"}, {"ICN", "B"},{"B", "ICN"},{"A","C"}};
        new Travel(tickets);
    }
}