package java8course.video14;

import java.util.ArrayList;
import java.util.List;

public class Student {
    String name;
    Integer gradeLevel;
    Integer gpa;
    String gender;
    List<String> hobbiesList;

    Student(String name, Integer gradeLevel, Integer gpa, String gender, List hobbiesList){
        this.name=name;
        this.gradeLevel=gradeLevel;
        this.gpa=gpa;
        this.gender=gender;
        this.hobbiesList=hobbiesList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(Integer gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public Integer getGpa() {
        return gpa;
    }

    public void setGpa(Integer gpa) {
        this.gpa = gpa;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<String> getHobbiesList() {
        return hobbiesList;
    }

    public void setHobbiesList(List<String> hobbiesList) {
        this.hobbiesList = hobbiesList;
    }
}
