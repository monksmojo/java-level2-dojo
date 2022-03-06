package Java2Exercise.Q5;

public class Q5ObjectCloning implements Cloneable {
    double documentNumber;
    String documentName;

    Q5ObjectCloning(double number, String name){
        this.documentNumber=number;
        this.documentName=name;
    }

    Q5ObjectCloning(Q5ObjectCloning original){
        System.out.println("cloning object");
        System.out.println("invoking the copy constructor");
        this.documentNumber=original.documentNumber;
        this.documentName=original.documentName;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "{" + "documentNumber=" + documentNumber + ", documentName='" + documentName + '\'' +  '}';
    }
}
