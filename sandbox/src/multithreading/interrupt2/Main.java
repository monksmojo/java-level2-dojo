package multithreading.interrupt2;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        BigCalculations bigCalculations=new BigCalculations("power calculate",new BigDecimal(10000),
                new BigDecimal(10));
        bigCalculations.start();
        bigCalculations.interrupt();
    }
}
