package multithreading.joins;

import java.math.BigInteger;

public class FactorialThread extends Thread{
    BigInteger result=BigInteger.ONE;
    long factorialOf;
    boolean isFinished=false;

    public FactorialThread(Long factorialOf) {
        this.factorialOf = factorialOf;
    }

    @Override
    public void run() {
        for(long i=factorialOf; i>0; i--){
            this.result=result.multiply(new BigInteger(String.valueOf(factorialOf)));
        }
        isFinished=true;
    }

    public BigInteger getResult() {
        return result;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public long getFactorialOf() {
        return factorialOf;
    }
}
