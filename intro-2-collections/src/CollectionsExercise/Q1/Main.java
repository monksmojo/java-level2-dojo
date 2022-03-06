/*
 Q-1Write Java code to define List .
 Insert 5 floating-point numbers in List, and using an iterator.
 find the sum of the numbers in List.
*/
package CollectionsExercise.Q1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("execution of Question-1");

        Q1ListSum list_object=new Q1ListSum();

        list_object.populateList(); // adding floating numbers to the list

        float result=list_object.sumOflist(); // sum of floating numbers in list

        System.out.println("addition of the float numbers of the list are ->"+result);
    }
}

class Q1ListSum {
    List<Float> floatList=new ArrayList<Float>();

    void populateList(){
        System.out.println("populating list");

        for(float i=1.5f; i<=5.5f; i++){
            floatList.add(i);
        }

        System.out.println("float numbers in the list are");

        System.out.println(floatList);
    }

    float sumOflist(){
        Iterator itr=floatList.iterator();

        float sum=0;

        while (itr.hasNext()){
            float a=(float)itr.next();
            sum+=a;
        }

        return sum;
    }
}
