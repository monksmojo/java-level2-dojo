package multithreading.exercise2;
import java.math.BigInteger;

import java.math.BigInteger;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        BigInteger base1,base2,pow1,pow2;
        Random random=new Random();
        base1=new BigInteger(String.valueOf(random.nextInt(90000)));
        base2=new BigInteger(String.valueOf(random.nextInt(90000)));
        pow1=new BigInteger(String.valueOf(random.nextInt(90000)));
        pow2=new BigInteger(String.valueOf(random.nextInt(90000)));
        ComplexCalculation complexCalculation=new ComplexCalculation();
        complexCalculation.calculateResult(base1,base2,pow1,pow2);
    }
}


