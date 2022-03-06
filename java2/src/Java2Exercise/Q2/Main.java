//WAP to sorting string without using string Methods?.
package Java2Exercise.Q2;

public class Main {

    public static void main(String[] args) throws NullPointerException{
	// write your code here
        try {
            Q2SortingString obj=new Q2SortingString();
            obj.stringSelectionSort("zxvjhyucb");
        }catch (NullPointerException nue){
            System.out.println("empty string argument passed");
            System.out.println(nue);
        }
    }
}
