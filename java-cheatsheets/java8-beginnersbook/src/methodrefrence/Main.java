package methodrefrence;

public class Main {

    void sayHelloFromMain(){
        System.out.println("hello from main class method");
    }

    public static void main(String[] args) {
        // method reference.
        // Method reference is a shorthand notation of a lambda expression
        // to call a method -->
//        1. Method reference to an instance method of an object – object::instanceMethod

        // we will first create a instance of Main class-->
        Main mainObject=new Main();
        // now that instance of the main method is created
        // we can call helloFromMain() method from above instance using this
        mainObject.sayHelloFromMain();
        // we  can assign this method to the abstract method of the functional interface
        // using method reference  mainObject::helloFromMain;

        MFInterface1 mfInterface1=mainObject::sayHelloFromMain;

        // now the body of the function is applied to the functional interface having a single method
        // MFInterface1 have single abstract method sayHello() whose definition is now the body of method.
        // sayHelloFromMain()
        mfInterface1.sayHello();

//        2. Method reference to a static method of a class – Class::staticMethod
//        3. Method reference to an instance method of an arbitrary object of a particular type – Class::instanceMethod
//        4. Method reference to a constructor – Class::new
    }
}
