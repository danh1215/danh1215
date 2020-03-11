package rmit.p1;

import java.util.ArrayList;
import java.util.List;

public class StudentList {
    static List<Student> studentList = new ArrayList<>();

    public static Student findById(String studentId){
        for (Student student:studentList) {
            if (student.getId().equals(studentId)){
                return student;
            }
        }
        return null;
    }
}
