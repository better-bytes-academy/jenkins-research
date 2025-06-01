package main.java;
import java.util.HashMap;
public class TanXuat {
    public static void main(String[] args) {
        int[] hahihi={1,1,1,1,2,2,2,4,4,6,6,6,8,8,8,9,9,9,9,9,};
        HashMap<Integer, Integer> tanxuat = new HashMap<>();
        for(int ha:hahihi){
            if(tanxuat.containsKey(ha)){
                tanxuat.put(ha,tanxuat.get(ha)+1);
            }else{
                tanxuat.put(ha,1);
            }
        }
        System.out.println("Tần suất xuất hiện của các phần tử:");
        for (int key : tanxuat.keySet()) {
            System.out.println("Giá trị " + key + " xuất hiện " + tanxuat.get(key) + " lần");
        }
    }
}
