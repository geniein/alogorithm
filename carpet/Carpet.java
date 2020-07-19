package carpet;

public class Carpet {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int hori = 3;
        int vertical = 3;
        
        while(true){
            if(brown == (hori*2 + 2*(vertical -2)) && yellow == (vertical-2)*(hori-2)){
                answer[0] = hori;
                answer[1] = vertical;
                break;
            }else{
                if(hori<=vertical){
                    hori++;
                    vertical = 3;
                }else{
                    vertical++;
                }
            }
        }
        for(int val : answer){
            System.out.println(val);
        }                    
        return answer;
    }    

    public static void main(String[] args) {
        new Carpet().solution(24, 24);
    }
}