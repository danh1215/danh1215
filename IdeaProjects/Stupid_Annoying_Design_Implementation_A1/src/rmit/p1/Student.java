package rmit.p1;

import java.util.regex.Pattern;

public class Student {
    private String id;
    private String name;
    private Date birthdate;

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
    }
    private String capitalize(String str) {
        if(str == null || str.isEmpty()) {
            return str;
        }

        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

}
