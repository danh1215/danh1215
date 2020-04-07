package rmit.p1;

import org.junit.Test;

public class StudentEnrollmentListTest {
    @Test
    public void studentEnrollmentListTest() throws InvalidDateException,InvalidStudentInfoException,
            InvalidCourseInfoException{
        StudentEnrollmentList enrollmentList = new StudentEnrollmentList();
        enrollmentList.getAll();
        Student s1 = new Student("s3707216","Luu Xuan Van",new Date("4/12/2000"));
        Course c1 = new Course("COSC2020","Intro to Software Development",12);
        Course c3 = new Course("COSC2589","Security in Computing and Information Technology",12);
        Course c5 = new Course("COSC1768","Data Structures & Algorithms",12);
        StudentEnrollment e1 = new StudentEnrollment(s1,c1,"2020A");


        enrollmentList.add(e1);
        enrollmentList.add(new StudentEnrollment(s1,c3,"2020A"));
        enrollmentList.add(new StudentEnrollment(s1,c5,"2020A"));

        enrollmentList.update(e1,c5,"2020B");
        enrollmentList.getOne("s3707216","COSC1768");
        enrollmentList.getOne("s3700000","COSC1768");
        enrollmentList.getOne("","");
        enrollmentList.delete("s3707216","COSC1768");
        enrollmentList.delete("","");


    }
}
