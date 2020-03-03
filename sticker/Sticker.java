package sticker;

import java.util.*;
import java.io.*;
public class Sticker {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String args[]) throws IOException {
        run();
        bw.flush();
        bw.close();
        br.close();
    }
    static long[][] dp;
    static long[][] ARR;
    public static void run() throws IOException {
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());
            ARR = new long[2][m];
            dp = new long[2][100001];
            for (int k = 0; k < 2; k++) {
                StringTokenizer st = new StringTokenizer(br.readLine()," ");
                for (int j = 0; j < m; j++) {
                    ARR[k][j] = Long.parseLong(st.nextToken());
                }
            }
            long ans = Math.max(DFS(0,m-1), DFS(1,m-1));    
            bw.write(ans+"\n");
            bw.flush(); 
        }
    }
    public static long DFS(int n, int index) {
        if (index < 0) return 0;
        if (dp[n][index] != 0 ) return dp[n][index];
    
        dp[n][index] = (n == 0) ? DFS(1,index-1) : DFS(0,index-1);
        
        if (index >= 2) {
            int m = n == 0 ? 1 : 0;
            if (dp[n][index] < dp[m][index-2]) {
                dp[n][index] = dp[m][index-2];
            }
        }
        dp[n][index] += ARR[n][index];
        return dp[n][index];
    }
}