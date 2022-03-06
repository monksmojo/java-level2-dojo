//Q-4.Write a program to sort HashMap by value.

package CollectionsExercise.Q4;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("execution of Q4");
        System.out.println("sorting of hashmap by value");
        Q4SortHashMap obj1= new Q4SortHashMap();
        obj1.populateMap(); // insert data in map
        obj1.callSort(); // sorting of map by value
        obj1.traverseMap(); // traversing of the map
    }
}

class Q4SortHashMap{
    HashMap<Integer,Integer> uMap = new HashMap<Integer, Integer>();//unsorted hashmap
    LinkedHashMap<Integer,Integer> sMap; //sorted hashmap
    ArrayList<Map.Entry<Integer,Integer>> mapList; // to convert uMap to a ArrayList
    public void populateMap(){
        Random rand=new Random();
        for(int i=10; i>0; i--){
            uMap.put(i,rand.nextInt(50));
        }
        System.out.println("unsorted map-->"+ uMap);
    }
    public void callSort(){
        // conversion of map into list
        mapList =new ArrayList<Map.Entry<Integer,Integer>>(uMap.entrySet());
        Collections.sort(mapList,new SortMap()); //sorting the map
    }

    public void traverseMap(){
        System.out.println("traversing the map");
        sMap = new LinkedHashMap<Integer, Integer>();//hashmap

        for (Map.Entry<Integer,Integer> temp: mapList) {
            sMap.put(temp.getKey(),temp.getValue());
        }

        System.out.println("sorted map-->"+ sMap);
    }
}

class SortMap implements Comparator<Map.Entry<Integer, Integer>>{
    @Override
    public int compare(Map.Entry<Integer,Integer> o1, Map.Entry<Integer, Integer> o2){
        if(o1.getValue()>o2.getValue()){
            return  1;
        }
        if(o1.getValue()<o2.getValue()){
            return  -1;
        }
        return 0;
    }//end of compare function
}// end of comparator class
