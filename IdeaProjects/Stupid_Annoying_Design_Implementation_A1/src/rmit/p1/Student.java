package rmit.p1;

import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;

public class Student {
    private String id;
    private String name;
    private Date birthdate;
    private List<Course> courses = new ArrayList<>();

    @Override
    public String toString() {
        return "Student{" +
                "ID:\"" + id + '\"' +
                ", Name:\"" + name + '\"' +
                ", Date of Birth: " + birthdate.toString() +
                '}';
    }
    public String toCSVString(){
        return  id + ","+
                name + ","+
                birthdate.toCSVString()+"\n";
    }

    public Student(String id, String name, Date birthdate) throws InvalidStudentInfoException{
        if (!Pattern.matches("s[0-9]{7}",id)){
            throw new InvalidStudentInfoException("Invalid ID. Example: s1234567");
        }
        else this.id = id;
        String[] names = name.split(" ");
        boolean capitalized = true;
        for (String part: names) {
            if (!capitalize(part.toLowerCase()).equals(part)){
                capitalized = false;
            }
        }
        if (!capitalized){
            throw new InvalidStudentInfoException("First letters should be capitalized.");
        }
        else this.name = name;

        this.birthdate = birthdate;

        StudentList.studentList.add(this);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public List<Course> getCourses() {
        return courses;
    }


    private String capitalize(String str) {
        if(str == null || str.isEmpty()) {
            return str;
        }

        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

}
