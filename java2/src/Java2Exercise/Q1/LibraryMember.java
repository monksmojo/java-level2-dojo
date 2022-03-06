package Java2Exercise.Q1;


public class LibraryMember {
    int id;
    String memberName;
    LibraryBook rentedBook=null;

    LibraryMember(int id,String mn, LibraryBook rb){
        this.id=id;
        this.memberName=mn;
        this.rentedBook=rb;
        System.out.println("book assigned");
    }

}
