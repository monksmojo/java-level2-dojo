//Find common elements between two arrays.
package Java1Exercise.Q5;

public class Main {

    public static void main(String[] args) {
        System.out.println("executing Q-5");
        int[] array1={1,2,3,4,5};
        int[] array2={3,4,5,6,7};
        Q5CommonElement obj=new Q5CommonElement();
        obj.findCommon(array1,array2);
    }
}

class Q5CommonElement {
    public void findCommon(int[] array1,int[] array2){
        System.out.println("common elements in two arrays are->");
        for (int i=0; i<array1.length; i++){

            for (int j=0; j< array2.length; j++){

                if (array1[i]==array2[j]){
                    System.out.println(array1[i]);
                    break;
                }//end of if
            }// end of inner for
        }// end of outer for
    }//end of function
}//end of class
