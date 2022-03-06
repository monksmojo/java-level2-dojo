//Q11.Create 3 sub class of bank SBI,BOI,ICICI all 4 should have method called getDetails
// which provide there specific details like rateofinterest etc,
// print details of every banks
package Java1Exercise.Q11;

public class Main {

    public static void main(String[] args){
        System.out.println("Executing of Q-11");
        Q11Bank.SbiBank sbi1=new Q11Bank().new SbiBank();
        sbi1.getDetails();
        Q11Bank.BoiBank boi1=new Q11Bank().new BoiBank();
        boi1.getDetails();
        icici.getDetails();
    }//end of main function

    static Q11Bank icici=new Q11Bank() {
        void getDetails() {
            System.out.println("bank name-ICICI BANK");
            System.out.println("headquarter Delhi");
            super.getDetails();
        }
    };//anonymous inner class with Q11Bank as base class
}


class Q11Bank {
    void getDetails(){
        System.out.println("current rate of interest is 8.6");
    }
    class SbiBank{
        void getDetails(){
            System.out.println("bank name-state bank of india");
            System.out.println("headquarter Mumbai");
            System.out.println("rate of interest->7.8");
        }
    }//nested inner class sbi

    class BoiBank{
        void getDetails(){
            System.out.println("bank name-Bank of india");
            System.out.println("headquarter Assam");
            System.out.println("rate of interest->8.1");
        }
    }//nested inner class BoiBank

}

