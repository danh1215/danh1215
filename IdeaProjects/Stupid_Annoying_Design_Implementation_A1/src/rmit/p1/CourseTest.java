package rmit.p1;

import org.junit.Test;

public class CourseTest {
    @Test
    public void courseTest(){

        try{
            Course c1 = new Course("COSC2020","Intro to Software Development",12);
            System.out.println(c1);
            System.out.println(c1.toCSVString());
            c1.getName();
            c1.getId();
            c1.getNumber_of_credits();
            c1.setId("COSC1000");
            c1.setName("Intro to IT");
            c1.setNumber_of_credits(24);
            Course c3 = new Course("COSC20DB","Intro to Programming",12);
        }
        catch(InvalidCourseInfoException e){
            System.out.println(e); }

        try{
            Course c2 = new Course("ABCD1234","Building IT System",100);
        }
        catch(InvalidCourseInfoException e){
            System.out.println(e); }
    }

}
