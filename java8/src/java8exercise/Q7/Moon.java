package java8exercise.Q7;

public interface Moon {
    public default void defaultCall(){
        System.out.println("calling from moon interface");
    }
}
