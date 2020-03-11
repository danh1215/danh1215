package rmit.p1;

import java.util.regex.Pattern;

public class Course {
    private String id;
    private String name;
    private int number_of_credits;

    @Override
    public String toString() {
        return "Course{" +
                "ID:\"" + id + '\"' +
                ", Name:\"" + name + '\"' +
                ", Credits:" + number_of_credits +
                '}';
    }

    public Course(String id, String name, int number_of_credits) throws InvalidCourseInfoException{
        if (!Pattern.matches("[A-Z]{4}[0-9]{4}",id)){
            throw new InvalidCourseInfoException("Invalid course ID");
        }
        else this.id = id;
        this.name = name;
        if (number_of_credits < 0 || number_of_credits > 24){
            throw new InvalidCourseInfoException("Invalid number of credits");
        }
        else this.number_of_credits = number_of_credits;
        CourseList.courseList.add(this);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getNumber_of_credits() {
        return number_of_credits;
    }

}
