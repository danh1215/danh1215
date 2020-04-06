package rmit.p1;

import java.util.ArrayList;
import java.util.List;

public class CourseList {
    protected static List<Course> courseList = new ArrayList<>();

    public List<Course> getCourseList() {
        return courseList;
    }

    public Course findById(String courseId){
        for(Course course: courseList){
            if (course.getId().equals(courseId)){
                return course;
            }
        }
        return null;
    }
}
