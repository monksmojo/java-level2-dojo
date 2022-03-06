package sandBox;

import java.util.ArrayList;

public class Hundred {
    static ArrayList<Integer> countList=new ArrayList<>();

    static void addNumber(){
        countList.add(10);
        countList.add(101);
    }

    static void DisplayNumber(){
        for (Integer number:countList) {
            System.out.println(number);
        }
    }
}
