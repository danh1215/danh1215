package rmit.p1;

import org.junit.Test;

public class CourseListTest {
    @Test
    public void courseListTest()throws InvalidCourseInfoException{
        CourseList courseList = new CourseList();
        courseList.getCourseList();
        Course c1 = new Course("COSC2020","Intro to Software Development",12);
        courseList.findById("COSC2020");
        courseList.findById("COSC0902");
    }
}
