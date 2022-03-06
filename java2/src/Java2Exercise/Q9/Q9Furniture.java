package Java2Exercise.Q9;

public abstract class Q9Furniture {
    String material;
    int weight;
    Q9Furniture(String m,int w){
        this.material=m;
        this.weight=w;
    }
    abstract void furnitureInfo();
}


