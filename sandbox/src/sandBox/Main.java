package sandBox;


import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//        double d1 = 2.009;
//        double d2 = 2.979;
//
//        System.out.println( Math.floor(d1*100)/100);
//        System.out.println( Math.floor(d2*100)/100);
//
//        System.out.println( Math.round(d1*100)/100);
//        System.out.println( Math.round(d2*100)/100);
//
//        double a = 123.13698;
//        double roundOff = Math.round(a*100)/100;

//        System.out.println(roundOff);
        BigDecimal sum=new BigDecimal("14.731775294");
        BigDecimal theCostUsage=new BigDecimal("20.624485412146");
        BigDecimal answer1=sum.divide(theCostUsage, new MathContext(8)).multiply(new BigDecimal(100));
        BigDecimal answer2=sum.divide(theCostUsage,5,RoundingMode.HALF_UP).multiply(new BigDecimal(100));
        System.out.println(answer1);
        System.out.println(answer2);

    }

}
