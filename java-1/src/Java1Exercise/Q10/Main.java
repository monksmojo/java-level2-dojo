//Q10.Write a single program for following operation using overloading
//  A) Adding 2 integer number
//  B) Adding 2 double
//  C) multiplying 2 float
//  D) multiplying 2 int
//  E) concate 2 string
//  F) Concate 3 String
package Java1Exercise.Q10;

public class Main {

    public static void main(String[] args){
        System.out.println("Executing of Q-10");
        Q10overloading obj=new Q10overloading();
        System.out.println(obj.adding(10,20));
        System.out.println(obj.adding(24.3567,45.8765));
        System.out.println(obj.multiply(20,10));
        System.out.println(obj.multiply(2.9f,3.8f));
        try {
            System.out.println(obj.concat("Jimmy","page"));
            System.out.println(obj.concat("john","paul","jones"));
        }catch (NullPointerException nue){
            System.out.println("null argument passed");
            System.out.println(nue);
        }

    }
}

class Q10overloading {
    public int adding(int a, int b){
        return a+b;
    }

    public double adding(double a,double b){
        return a+b;
    }

    public int multiply(int a,int b){
        return a*b;
    }

    public float multiply(float a,float b){
        return a*b;
    }

    public String concat(String a,String b){
        return a.concat(b);
    }

    public String concat(String a,String b,String c){
        return a.concat(b).concat(c);
    }
}