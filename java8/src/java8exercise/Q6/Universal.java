package java8exercise.Q6;

public interface Universal {
    public default void defaultGlobal() {
        System.out.println("indside default method of Universal interface");
    }

    public static void staticGlobal(){
        System.out.println("inside the static method of Universal interface");
    }
}
