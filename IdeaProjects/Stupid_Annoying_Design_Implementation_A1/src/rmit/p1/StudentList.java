package rmit.p1;

import java.util.ArrayList;
import java.util.List;

public class StudentList {
    protected static List<Student> studentList = new ArrayList<>();

    public Student findById(String studentId){
        for (Student student:studentList) {
            if (student.getId().equals(studentId)){
                return student;
            }
        }
        return null;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
