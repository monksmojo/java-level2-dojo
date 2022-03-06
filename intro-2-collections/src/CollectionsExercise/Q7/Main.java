//Print the elements of an array in the decreasing frequency
//if 2 numbers have same frequency then print the one which came first.

package CollectionsExercise.Q7;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("execution of Q7");
        Q7ArrayFrequency obj1=new Q7ArrayFrequency();
        obj1.freqArr.add(8);
        obj1.freqArr.add(8);
        obj1.freqArr.add(6);
        obj1.freqArr.add(2);
        obj1.freqArr.add(5);
        obj1.freqArr.add(2);
        obj1.freqArr.add(6);
        obj1.freqArr.add(6);
        System.out.println("unsorted array-->");
        System.out.println(obj1.freqArr);

        obj1.frequencyCount(); // converting array into map of frequency

        obj1.sortFrequency(); // sorting map on the bases of frequency

        obj1.traverseArray();// traversing the sorted map list
    }
}


class Q7ArrayFrequency {

    ArrayList<Integer> freqArr=new ArrayList<Integer>();
    LinkedHashMap<Integer,Integer> freqMap=new LinkedHashMap<Integer, Integer>();
    ArrayList<Map.Entry<Integer,Integer>> sortArr;

    void frequencyCount(){
        for (Integer ele:freqArr) {
            if(freqMap.containsKey(ele)){
                freqMap.put(ele,freqMap.get(ele)+1);
            }
            else{
                freqMap.put(ele,1);
            }
        }

    }//end of frequency count

    public void sortFrequency(){
        //conversion of map into list
        this.sortArr=new ArrayList<Map.Entry<Integer, Integer>>(freqMap.entrySet());
        System.out.println("not sorted frequency map");
        System.out.println(sortArr);

        System.out.println("sorting the map");
        Collections.sort(sortArr, new Comparator<Map.Entry<Integer, Integer>>() {

            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return - o1.getValue().compareTo(o2.getValue());
            }//end of comparator

        }); // end of Collections.sort()

        System.out.println("sorted frequency array");
        System.out.println(sortArr);
    }// end of function

    public void traverseArray(){
        System.out.println("sorted array in descending order");
        for (Map.Entry<Integer,Integer> entry:sortArr) {
            int frequency=entry.getValue();
            while (frequency >= 1){
                System.out.print(entry.getKey()+" ");
                --frequency;
            }
        }
    }

}

