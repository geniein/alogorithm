package shuttle_bus;

import java.util.*;

class  ShuttleBus{
    static int[] crewTimeTable = null;
    static int[] busTimeTable = null;

    static void stringToMinute(String[] timetable){
        for(int i=0; i<timetable.length; i++){
            int hour = Integer.parseInt(timetable[i].substring(0,2));
            int minute = Integer.parseInt(timetable[i].substring(3, 5));
            crewTimeTable[i] = hour*60 + minute;
        }
    }

    static void stringToMinute(int n, int t){
        int firstTime = 540;

        for(int i=0; i<n; i++){
            busTimeTable[i] = firstTime+ t*i;
        }
    }

    
    static int getToBusStopTime(int m){
        int answer = 0;
        int max = m;
        boolean flag = false;
        int tmp = 0;

        List<Integer> consTime = new LinkedList<>();

        Arrays.sort(crewTimeTable);

        int i=0, j=0;
        while(i<busTimeTable.length){
            max = m;
            flag = false;
            tmp = 0;
            j=0;
            while(j<crewTimeTable.length){
                if(crewTimeTable[j] < 0){
                    j++;
                    continue;
                }
                if(max <= 0){
                    consTime.add(tmp-1);
                    break;
                }

                if(busTimeTable[i] >= crewTimeTable[j]){
                    tmp = crewTimeTable[j];
                    crewTimeTable[j] = -1;
                    max -= 1;
                }
                j++;
            }
            printArr(crewTimeTable);
            if(max > 0){
                max -= 1;
                consTime.add(busTimeTable[i]);
            }
            i++;
        }

        if(max <= 0){
            consTime.add(tmp-1);
        }
        Collections.sort(consTime);
        System.out.println(consTime);
        answer = consTime.get(consTime.size()-1);

        return answer;
    }



    static String minuteToHourMin(int min){
        String str = "";

        String hour = String.valueOf(min/60);
        String minute = String.valueOf(min - ((min/60)*60));
        if(hour.length() < 2){
            hour = "0" + hour;
        }
        if(minute.length() < 2){
            minute = "0" + minute;
        }
        str = hour + ":" + minute;
        return str;
    }

    static void printArr(int[] arr){
        for(int ai : arr){
            System.out.print(ai + " ");
        }
        System.out.println();
    }

    public static String solution(int n, int t, int m, String[] timetable) {
        String answer = "";

        crewTimeTable = new int[timetable.length];
        stringToMinute(timetable);
        
        busTimeTable = new int[n];
        stringToMinute(n, t);

        int min = getToBusStopTime(m);
        answer = minuteToHourMin(min);

        return answer;
    }
}