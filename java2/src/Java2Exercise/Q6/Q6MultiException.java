package Java2Exercise.Q6;

public class Q6MultiException {
    public void testing(){
        try{
            int[] pi=new int[3];
            pi[5]=20/0;
        }catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }finally {
            System.out.println("program handled the exception successfully");
        }
    }
}
