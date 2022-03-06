package java8course;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ARRAYLIST2D {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int listSize=input.nextInt();
        List<Integer> myList=new ArrayList<>(listSize);
        for(int i=0; i<listSize; i++){
            myList.add(i,input.nextInt());
        }
        int query=input.nextInt();
        while(query>0){
            String subQuery=input.next();
            switch (subQuery){
                case "Insert":{
                    int x=input.nextInt();
                    int y=input.nextInt();
                    myList.add(x,y);
                    break;
                }
                case "Delete":{
                    int x=input.nextInt();
                    myList.remove(x);
                    break;
                }
                default:
                    System.out.println("should not reach here");
            }
            --query;
        }
        for (int ele:myList) {
            System.out.print(ele+" ");
        }
    }
}