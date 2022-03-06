package Java2Exercise.Q4;

public class Q4Singleton {

    private static Q4Singleton singleChild=null;
    static int childNumber=0;
    public String childCreated="";

    private Q4Singleton(){
        childNumber+=1;// will increment every time child is created.
        childCreated="till now child created is"+childNumber;
    }

    public static Q4Singleton makeChild(){ // static method for creation of object
      if(Q4Singleton.singleChild==null){
          singleChild=new Q4Singleton();
      }
      return singleChild;
    }
}
