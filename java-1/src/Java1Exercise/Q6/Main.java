//Q6. There is an array with every element repeated twice except one.
// Find that element
package Java1Exercise.Q6;

public class Main {

    public static void main(String[] args){
        System.out.println("execution of Q-6");
        Q6RepeatOnce obj=new Q6RepeatOnce();
        int[] elements={9,9,11,10,11,22,22,33,33};
        System.out.println("using xor");
        int r=obj.xorApproach(elements);
        System.out.println("element occured once is(XOR) "+r);

        System.out.println("using naive approach");
        obj.naiveApproach(elements);
    }
}

class Q6RepeatOnce {
    public int xorApproach(int[] elements){
        int xor=elements[0];
        for (int i=1; i<elements.length; i++){
            xor= xor ^ elements[i];
        }
        return xor;
    }

    public void naiveApproach(int[] elements){
        boolean[] checked=new boolean[elements.length];
        for (int i = 0; i < elements.length; i++) {
            if (checked[i] == false) {
                boolean duplicate=false;
                for (int j = i + 1; j < elements.length; j++){
                    if(elements[i]==elements[j]){
                        duplicate=true;
                        checked[j]=true;
                    }//en of j if
                }//end of j index loop

                if(!duplicate){
                    System.out.println("element occured once is(naive) "+elements[i]);
                }

            }//end of if
        }//end of i index loop
    }//end of naive function
}
