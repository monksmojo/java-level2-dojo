package java8exercise.Q8;

public class Face3 implements Face1,Face2{
    @Override
    public void displayFace() {
        Face1.super.displayFace();
        Face2.super.displayFace();
        System.out.println("inside face 3 calss method");
    }
}
