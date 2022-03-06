package multithreading.exercise2;

import java.math.BigInteger;

class ComplexCalculation {

    public BigInteger calculateResult(BigInteger base1, BigInteger power1, BigInteger base2, BigInteger power2) {
        BigInteger result;
        PowerCalculatingThread p1, p2;
        p1 = new PowerCalculatingThread(base1, power1);
        p2 = new PowerCalculatingThread(base2, power2);
        p1.start();
        p2.start();
        try {
            p1.join();
            p2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        result = p1.getResult().add(p2.getResult());
        return result;
    }

}
