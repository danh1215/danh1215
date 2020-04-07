package rmit.p1;

        import org.junit.Test;

public class StudentListTest {
    @Test
    public void studentListTest()throws InvalidStudentInfoException,InvalidDateException{
        StudentList studentList = new StudentList();
        studentList.getStudentList();
        studentList.findById("");
        Student s2 = new Student("s3804210","Do Viet Quoc",new Date("13/1/1998"));
        studentList.findById("s3804210");
        studentList.findById("s0202022");

    }
}
