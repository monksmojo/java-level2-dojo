//Design classes having attributes for furniture where
// there are wooden chairs and tables,metal chairs and tables.
// There are stress and fire tests for each products.
package Java2Exercise.Q9;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("executing of Question 9");
        Chair woodChair=new Chair("wood",1);
        woodChair.furnitureInfo();
        woodChair.fireTest();
        woodChair.stressTest();


        Table steelTable=new Table("steel",15);
        steelTable.furnitureInfo();
        steelTable.fireTest();
        steelTable.stressTest();
    }
}
