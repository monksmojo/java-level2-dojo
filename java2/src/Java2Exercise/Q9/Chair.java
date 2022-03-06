package Java2Exercise.Q9;

class Chair extends Q9Furniture implements FurnitureTests{
    Chair(String m,int w){
        super(m,w);
    }

    void furnitureInfo(){
        System.out.println("chair material"+this.material);
        System.out.println("chair weight"+this.weight);
    }
    @Override
    public void stressTest(){
        if (this.weight < 2){
            System.out.println(" delicate chair");
        }
        else{
            System.out.println(" strong chair");
        }
    }

    public void fireTest(){
        if(this.material.equals("steel")){
            System.out.println("fire proof");
        }

        else{
            System.out.println("not fire proof");
        }
    }
}
