//Q9.Write a program to display values of enums using a constructor.
// & getPrice() method (Example display house & their prices)
package Java1Exercise.Q9;

public class Main {

    public static void main(String[] args) {
        System.out.println("Executing of Q-9");

        Q9Home[] homes=Q9Home.values();
        for (Q9Home house:homes) {
            System.out.println("cost of"+house+"is"+house.getPrice());
        }
    }
}


enum Q9Home {
    ONEBHK(25.60),TWOBHK(60.90),THREEBHK(90.10);
    double price;
    Q9Home(double p){
        this.price=p;
    }
    public double getPrice(){
        return  this.price;
    }
}

