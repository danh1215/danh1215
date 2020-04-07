package rmit.p1;

import org.junit.Test;

public class StudentTest {
    @Test
    public void studentTest(){
        try{
            Student s1 = new Student("s3707216","Luu Xuan Van",new Date("4/12/2000"));
            s1.getCourses();
            s1.getName();
            s1.getBirthdate();
            s1.getId();
            System.out.println(s1.toString());
            System.out.println(s1.toCSVString());
            Student s2 = new Student("s3804120","do viet quoc",new Date("13/1/1998")); }
        catch (InvalidStudentInfoException | InvalidDateException e){
            System.out.println(e); }try{
            Student s2 = new Student("s3800","Do Viet Quoc",new Date("13/1/1998"));
        }
        catch (InvalidStudentInfoException | InvalidDateException e){
            System.out.println(e); }
    }
}
