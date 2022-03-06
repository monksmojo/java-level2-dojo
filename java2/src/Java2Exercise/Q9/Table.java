package Java2Exercise.Q9;

class Table extends Q9Furniture implements FurnitureTests{
    Table(String m,int w){
        super(m,w);
    }
    void furnitureInfo(){
        System.out.println("Table material"+this.material);
        System.out.println("Table weight"+this.weight);


    }

    @Override
    public void stressTest() {
        if (weight < 10){
            System.out.println("delicate Table");
        }
        else{
            System.out.println("strong Table");
        }
    }

    @Override
    public void fireTest() {
        if(this.material.equals("steel")){
            System.out.println("fire proof");
        }

        else{
            System.out.println("not fire proof");
        }

    }
}
