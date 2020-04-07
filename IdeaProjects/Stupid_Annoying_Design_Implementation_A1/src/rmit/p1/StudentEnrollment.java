package rmit.p1;

import java.util.List;
import java.util.Objects;

public class StudentEnrollment{
    private Student student;
    private Course course;
    private String semester;

    @Override
    public String toString() {
        return "Student "+ student.getName() +
                ", ID: " + student.getId() +
                " enrolled in " + course.getId() +
                " " + course.getName() +
                ", sem " + semester;
    }

    public String toCSVString(){
        return  student.getName() + ","+
                student.getId() + ","+
                student.getBirthdate().toString() +","+
                course.getId() +","+
                course.getName() +","+
                semester+"\n";
    }

    public StudentEnrollment(Student student, Course course, String semester) {
        this.student = student;
        this.course = course;
        this.semester = semester;
        student.getCourses().add(course);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentEnrollment that = (StudentEnrollment) o;
        return Objects.equals(student, that.student) &&
                Objects.equals(course, that.course) &&
                Objects.equals(semester, that.semester);
    }

    public boolean isDuplicate(List<StudentEnrollment> studentEnrollmentList){
        for (StudentEnrollment enrollment:studentEnrollmentList) {
            if(this.equals(enrollment))
                return true; }
        return false;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public String getSemester() {
        return semester;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }
}
