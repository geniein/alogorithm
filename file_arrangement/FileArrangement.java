package file_arrangement;

import java.util.*;

class File implements Comparable<File>{
    String head;
    String number;
    String tail;
    File (String head, String number, String tail) {
        this.head = head;
        this.number = number;
        this.tail = tail;
    }
    public int compareTo(File o) {
        if (head.toLowerCase().compareTo(o.head.toLowerCase()) == 0) {
            int v1 = Integer.parseInt(number);
            int v2 = Integer.parseInt(o.number);
            return v1 - v2;
        }
        return head.toLowerCase().compareTo(o.head.toLowerCase());
    }
    public String toString() {
        return head + number + tail;
    }
}

public static File[] sort(File[] file) {
        Queue<File[]> q = new LinkedList<File[]>();
        for (int i = 0; i < file.length; i++) q.add(new File[]{file[i]});
        
        while (q.size() > 1) {
            File[] left = q.poll();
            File[] right = q.poll();
            q.add(merge(left,right));
        }
        return q.poll();
    }
    
public static File[] merge(File[] x, File[] y) {
    int left,right,count,leftEnd,rightEnd;
    left = right = count = 0;
    leftEnd = x.length;
    rightEnd = y.length;
    File[] tmp = new File[leftEnd + rightEnd];
    while (left < leftEnd && right < rightEnd) {
        if (x[left].compareTo(y[right]) <= 0) tmp[count++] = x[left++];
        else tmp[count++] = y[right++];
    }
    while (left < leftEnd) tmp[count++] = x[left++];
    while (right < rightEnd) tmp[count++] = y[right++];
    return tmp;
}