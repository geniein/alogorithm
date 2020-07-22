package Collection;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Graph{
    class Node{
        int data;
        LinkedList<Node> adjacent;
        boolean marked;

        Node(int data){
            this.data = data;
            this.marked = false;
            adjacent = new LinkedList<>();
        }
    }

    Node[] nodes;

    Graph(int size){
        nodes = new Node[size];
        for(int i =0; i<size;i++){
            nodes[i] = new Node(i);
        }
    }

    void addEdge(int t1, int t2){
        Node n1 =nodes[t1];
        Node n2 =nodes[t2];
        if(!n1.adjacent.contains(n2)){
            n1.adjacent.add(n2);
        }
        if(!n2.adjacent.contains(n1)){
            n2.adjacent.add(n1);
        }
    }

    void dfs() {
        dfs(0);
    }
    void dfs(int index){
        Node node = nodes[index];
        Stack<Node> st = new Stack<>();
        st.push(node);
        node.marked = true;
        while(!st.isEmpty()){
            Node r = st.pop();
            for(Node n : r.adjacent){
                if(!n.marked){
                    n.marked = true;
                    st.push(n);
                }
            }
            out(r);
        }            
    }
    void bfs(){
        bfs(0);
    }
    
    void bfs(int index){
        Node node = nodes[index];
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        node.marked = true;
        while(!q.isEmpty()){
            Node r = q.poll();
            for(Node n : r.adjacent){
                if(!n.marked){
                    n.marked = true;
                    q.add(n);
                }
            }            
            out(r);
        }            
    }

    void out(Node n){
        System.out.println(n.data + " ");
    }

    void dfsR(Node n){
        if(n == null) return;        
        n.marked = true;
        out(n);
        for(Node r : n.adjacent){
            if(!r.marked){                
                dfsR(r);
            }                
        }        
    }

    void dfsR(int index){
        Node r = nodes[index];
        dfsR(r);
    }
    void dfsR(){        
        dfsR(0);
    }
}        


public class FirstSearch{
    public static void main(String[] args) {
        Graph g = new Graph(9);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(5, 6);
        g.addEdge(5, 7);
        g.addEdge(7, 8);
        g.dfsR();
    }
}