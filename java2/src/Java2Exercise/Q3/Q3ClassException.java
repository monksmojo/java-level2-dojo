package Java2Exercise.Q3;

public class Q3ClassException {
    public void notFound(){
        try{

            Class c1=Class.forName("java.Limbo");

        }catch (ClassNotFoundException ex){
            System.out.println(ex);
        }//end of catch
    }

}

