package n_numbers;

import java.util.*;

class GameMachine {
    private int order, m, p;
    private StringBuilder sb;
    GameMachine (int m, int p) {
        this.m = m;
        this.p = p;
        order = 1;
        sb = new StringBuilder();
    }
    private void addOrder() {
        order++;
        if (order > m) order = 1;
    }
    public boolean say(String s) {
        if (order == p) {
            sb.append(s);
            addOrder();
            return true;
        }
        addOrder();
        return false;
    }
    public String toString() {
        return this.sb.toString();
    }
}

public class NNumbers {
    static Map<Integer,Character> map = new HashMap<Integer,Character>();
    static int n,t,m,p;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();  // 진법
        t = scanner.nextInt();  // 숫자의 개수
        m = scanner.nextInt();  // 사람의 수
        p = scanner.nextInt();  // 튜브의 순서
        scanner.close();
        
        char c = 'A';
        for (int i = 10; i < 16; i++) map.put(i,c++);
        
        GameMachine gm = new GameMachine(m,p);
        
        int num = 0;
        while (t > 0) {
            String s = convert(n,num);
            if (s.length() == 1) {
                if (gm.say(s)) t--;
            } else {                
                for (int i = 0; i < s.length() && t > 0; i++) {
                    if (gm.say(Character.toString(s.charAt(i)))) t--;
                }
            }
            num = num + 1;
        }
        System.out.println(gm);
    }

    public static String convert(int n, int num) {
        StringBuilder sb = new StringBuilder();
        if (num == 0) sb.append(0);
        while (num != 0) {
            int v = num % n;
            if (v <= 9) sb.append(v);
            else sb.append(map.get(v));
            num = num / n;
        }
        sb.reverse();
        return sb.toString();
    }
}