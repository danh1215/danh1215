package rmit.p1;

import java.util.ArrayList;
import java.util.List;

public class CourseList {
    static List<Course> courseList = new ArrayList<>();

    public static Course findById(String courseId){
        for(Course course: courseList){
            if (course.getId().equals(courseId)){
                return course;
            }
        }
        return null;
    }
}
