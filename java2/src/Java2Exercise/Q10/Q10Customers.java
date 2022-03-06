package Java2Exercise.Q10;

public class Q10Customers {
    String customerName;
    String customerCofee;
    int orderAmount;
    int token;
    Q10Cashier c1;
    Q10CoffeeOrders c2;

    Q10Customers(String customerName,String customerCofee,int orderAmount){
    this.customerName=customerName;
    this.customerCofee=customerCofee;
    this.orderAmount=orderAmount;
    token=c1.takeOrders(customerName,customerCofee,orderAmount);
    }

    public String getStatus(){
        return c2.checkStatus();
    }

    public Q10CoffeeOrders getCoffee(){
        return c2.getOrder();
    }
}