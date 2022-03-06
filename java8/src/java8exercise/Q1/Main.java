//Q-1 Write the following a functional interface and implement it using lambda:

//    (1) First number is greater than second number or not
//          Parameter (int ,int ) Return boolean
//    (2) Increment the number by 1 and return incremented value
//          Parameter (int) Return int
//    (3) Concatenation of 2 string
//          Parameter (String , String ) Return (String)
//    (4) Convert a string to uppercase and return .
//          Parameter (String) Return (String)


package java8exercise.Q1;

public class Main {

    public static void main(String[] args) {
	// write your code here
/////////////////////////////////////(1)///////////////////////////////////////////////
        System.out.println(" to check wether first number is greater than second");
        Greatest grt=(num1,num2)-> num1>num2;
            if(grt.meGreatest(101,20)){
                System.out.println("first number is greater");
            }
            else{
                System.out.println("first number is not greater");
            }

///////////////////////////////////////(2)/////////////////////////////////////////////////
        System.out.println("increment a integer value");
        Incrementer icr=(num3)-> num3+=1;

            int incrvar=20;
            System.out.println("icrementing"+incrvar+"by 1");
            System.out.println("result-->"+icr.incrementMe(incrvar));


///////////////////////////////////////(3)/////////////////////////////////////////////
            System.out.println("concatenation of 2 Strings");
            Concatenation con=(str1,str2)->str1+str2;
            String str1="Good";
            String str2="morning";
            System.out.println("concatenating "+str1+" and "+ str2);
            System.out.println(con.concatenateTwo(str1,str2));

////////////////////////////////////(4)/////////////////////////////////////////////////
            System.out.println("converting string to the uppercase");
            Uppercase up=(str3)->str3.toUpperCase();
            String str3="udit";
            System.out.println(str3+" in upper case will be "+up.Toupper(str3));



    }
}
