package Java2Exercise.Q10;

public class Q10CoffeeOrders {
    int orderNumberToken;
    String status;
    String coffeeName;

    //for whole class
    public static int Total_orders = 0;
    public static Q10CoffeeOrders[] pendingOrders=new Q10CoffeeOrders[20];
    public static Q10CoffeeOrders[] completedOrders=new Q10CoffeeOrders[20];

    Q10CoffeeOrders(int orderNumber,String status,String coffeeName){
        Total_orders+=1;
        this.orderNumberToken=orderNumber;
        this.coffeeName=coffeeName;
        this.status=status;

    }

    public String setStatus(String status){
        this.status=status;
        return  this.status;
    }

    public String checkStatus(){
        return this.status;
    }

    public Q10CoffeeOrders getOrder(){
        return Q10CoffeeOrders.completedOrders[Q10CoffeeOrders.Total_orders];
    }

}
