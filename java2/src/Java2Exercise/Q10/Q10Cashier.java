package Java2Exercise.Q10;

import java.util.Random;

class Q10Cashier{

    Q10CoffeeOrders co1;

    int genrateOrderId(){
        Random rand=new Random();
        int token= rand.nextInt(1000);
        return token;
    }

    int takeOrders(String customerName,String customerCofee,int orderAmount)
    {
        if(orderAmount > 0){
            int token=this.genrateOrderId();
            co1=new Q10CoffeeOrders(token,"preparing",customerCofee);
            Q10CoffeeOrders.pendingOrders[Q10CoffeeOrders.Total_orders-1]=co1;
            return token;
        }
        else return -1;
    }
}