package java8exercise.Q1;

// (1) First number is greater than second number or not
//     Parameter (int ,int ) Return boolean
@FunctionalInterface
interface Greatest{
    boolean meGreatest(int num1, int num2);
}
