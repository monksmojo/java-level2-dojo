package multithreading.interrupt2;

import javax.print.DocFlavor;
import java.math.BigDecimal;

public class BigCalculations extends Thread {
    private BigDecimal base;
    private BigDecimal power;

    public BigCalculations(String name,BigDecimal base, BigDecimal power) {
        super(name);
        this.base = base;
        this.power = power;
    }

    @Override
    public void run() {
        System.out.println(this.getName()+" running");
        System.out.println(base+"^"+power+"="+calculatePower(base,power));
    }

    public BigDecimal calculatePower(BigDecimal base, BigDecimal power){
        BigDecimal result=BigDecimal.ONE;
        for(BigDecimal i = BigDecimal.ZERO;i.compareTo(power)!=0;i.add(BigDecimal.ONE)){
            if(Thread.currentThread().isInterrupted()){
                System.out.println("the calculatePower is interrupted ");
                return BigDecimal.ZERO;
            }
            result=result.multiply(base);
        }
        return result;
    }
}
