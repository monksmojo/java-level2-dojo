package lambdaExpression;

interface FuncInterface1 {
    String sayHello();
    // this is a functional interface cause it only contains
    // one abstract method
}



// notes
// to use lambda expression, you need to either create your own functional interface or
// use the pre defined functional interface provided by Java.

// An interface with only single abstract method is called functional interface

// we can define more than one abstract method in the interface
// but then it will not be an functional interface

//we create a instance of the interface which will call the only present abstract method in it
//the instance also defines the body of the abstract method