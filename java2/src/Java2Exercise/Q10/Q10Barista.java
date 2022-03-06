package Java2Exercise.Q10;

public class Q10Barista {


    Q10CoffeeOrders currentOrder;
    static int completedOrder;

    public void OrderPreparing(){
        currentOrder=Q10CoffeeOrders.pendingOrders[Q10CoffeeOrders.Total_orders];
        currentOrder.setStatus("preparing");
    }


    public void OrderPrepared(){
        currentOrder.setStatus("collect");
        completedOrder+=1;
        Q10CoffeeOrders.completedOrders[completedOrder]=currentOrder;
    }

}
