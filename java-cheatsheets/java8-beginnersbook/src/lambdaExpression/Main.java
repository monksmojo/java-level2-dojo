package lambdaExpression;


import arrayLists.NameList;

public class Main {

    public static void main(String[] args) {

        // creating the instance of the functional interface
        // the instance also defines the body of the abstract method
        FuncInterface1 funcInterface1=()->{
            return "hello world";
        };

        // older way to creating instance of the functional interface
        // that defines the body of the abstract method
        FuncInterface2 funcInterface2=new FuncInterface2() {
            @Override
            public int increment(int num) {
                return num+1;
            }
        }; // newer way are the lambda

        // creating instance and defining the method using lambda
        FuncInterface3 funcInterface3=(String s1, String s2)->{
            return s1.concat(s2);
        };

        // more shorter way lambda inbuilt function
        FuncInterface3 funcInterface31= String::concat;

        System.out.println(funcInterface1.sayHello());
        // the instance of the interface will call the method
        // which will return the value

        System.out.println(funcInterface2.increment(5));

        System.out.println(funcInterface3.stringConcat("hello "," world !"));

        System.out.println(funcInterface31.stringConcat("welcome "," to end "));

        // traversing the list of the names using for each and lambda
        NameList nameList=new NameList();
        nameList.getList().forEach(
                // for each takes the consumer
                (names)->{
                    System.out.println(names);
                }
        );
    }

    // search for method references
}

/*
 notes
 Lambda expression is a new feature which is introduced in Java 8.
 A lambda expression is an anonymous function.
 A function that doesn’t have a name and doesn’t belong to any class.
 A lambda expression in Java has these main parts:
Lambda expression only has body and parameter list.
1. No name – function is anonymous so we don’t care about the name
2. Parameter list
3. Body – This is the main part of the function.
4. No return type keyword specified.
 */

/*
Other Features are
supplier
consumer
predicate
functional interface
lambda functions
are all the features of the java 8
 */
