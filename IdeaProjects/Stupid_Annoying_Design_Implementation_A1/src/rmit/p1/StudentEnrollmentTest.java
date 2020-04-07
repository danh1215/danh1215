package rmit.p1;

import org.junit.Test;

public class StudentEnrollmentTest {
    @Test
    public void studentEnrollmentTest()throws InvalidDateException,InvalidStudentInfoException,
            InvalidCourseInfoException{
        Student s1 = new Student("s3707216","Luu Xuan Van",new Date("4/12/2000"));
        Course c1 = new Course("COSC2020","Intro to Software Development",12);
        StudentEnrollmentList enrollmentList = new StudentEnrollmentList();
        StudentEnrollment enrollment = new StudentEnrollment(s1,c1,"2020A");
        StudentEnrollment e2 = new StudentEnrollment(s1,c1,"2020A");
        enrollment.equals(e2);
        enrollment.toString();
        enrollment.toCSVString();
        enrollment.getSemester();
        enrollment.getCourse();
        enrollment.getStudent();
        enrollment.isDuplicate(enrollmentList.getAll());
        enrollment.setSemester("2020B");
        enrollment.setCourse(c1);
        enrollment.equals(enrollment);
        enrollmentList.add(enrollment);
        enrollment.isDuplicate(enrollmentList.getAll());
        Course c2 = new Course("COSC2021","Intro to Software Development",12);
        StudentEnrollment e1 = new StudentEnrollment(s1,c2,"2020B");
        enrollment.equals(e1);


    }
}
