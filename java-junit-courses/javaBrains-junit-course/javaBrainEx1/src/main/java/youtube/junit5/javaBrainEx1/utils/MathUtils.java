package youtube.junit5.javaBrainEx1.utils;

public class MathUtils {
    public int mathSum(int a,int b){
        return a+b;
    }

    public int mathSubtract(int a,int b){
        return a-b;
    }

    public int mathMultiply(int a,int b){
        return a*b;
    }

    public float mathDivision(float a, float b) throws ArithmeticException{
        float result=0;
        if(b==0){
            throw new ArithmeticException();
        }
        return result;
    }

    public double mathCircleArea(int r){
        return Math.PI * r * r;
    }

}
