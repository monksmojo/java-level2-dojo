/*
Design a Data Structure SpecialStack that supports all the stack operations
like push(), pop(), isEmpty(), isFull() and an additional operation getMin()
which should return the minimum element from the SpecialStack.
(Expected complexity ­-O(1))
 */
package CollectionsExercise.Q8;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
//  write your code here
        System.out.println("execution of Q8");
        Q8SpecialStack obj1= new Q8SpecialStack();

        obj1.checkFull();
        obj1.checkEmpty();

        System.out.println("performing push operations");
        obj1.pushElement(30);
        obj1.pushElement(20);
        obj1.pushElement(5);
        obj1.pushElement(10);
        obj1.pushElement(3);

        obj1.checkEmpty();
        obj1.checkFull();

        System.out.println("min element->"+obj1.getMin());
        System.out.println("performing pop operation");

        System.out.println(obj1.popE());
        System.out.println(obj1.popE());
        System.out.println(obj1.popE());
        System.out.println("min element->"+obj1.getMin());
    }
}


class Q8SpecialStack extends Stack<Integer>{
    // extended stack is main stack

    Stack<Integer> minStack=new Stack<Integer>();
    // The secondary stack to store min element


    void pushElement(Integer currentElement){

        if(super.isEmpty()==true){
            super.push(currentElement);
            minStack.push(currentElement);

            System.out.print(super.peek()+" ");
            // just to see what's being inserted in main stack
        }

        else{
                super.push(currentElement);
                Integer aElement=minStack.pop();
                minStack.push(aElement);

                if(currentElement <aElement){
                    minStack.push(currentElement);
                }

                else{
                minStack.push(aElement);
                }

            System.out.print(super.peek()+" ");
            // just to see what's being inserted in main stack
        }// end of else

    }// end of push element

    Integer popE(){

        if(super.isEmpty()){
            System.out.println("stack empty");
            return null;
        }
        else{
            minStack.pop();
            Integer pElement=super.pop();
            return pElement;
        }// end of else
    }//end of popE

    Integer getMin(){
        Integer minElement=minStack.peek();
        return minElement;
    }

    void checkEmpty(){
        if(super.isEmpty()){
            System.out.println("stack is empty");
        }
        else{
            System.out.println("\n stack not empty");
        }
    }


    void checkFull(){
        if(super.size()>super.capacity()){
            System.out.println("stack is full");
        }
        else{
            System.out.println("stack is not full");
        }
    }

}// end of class