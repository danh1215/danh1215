package rmit.p1;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws InvalidDateException,InvalidStudentInfoException,
            InvalidCourseInfoException{
        //Demo testing
        //Students
        Student s1 = new Student("s3707216","Luu Xuan Van",new Date("4/12/2000"));
        Student s2 = new Student("s3804120","Do Viet Quoc",new Date("13/1/1998"));
        Student s3 = new Student("s3881913","Dang Phuong Son",new Date("10/5/1999"));
        Student s4 = new Student("s3650179","Le Van Khanh",new Date("28/8/2000"));
        Student s5 = new Student("s3736116","Tran Phuc Tam",new Date("19/2/1996"));
        Student s6 = new Student("s3781338","Bui Duy Minh",new Date("1/8/1999"));
        Student s7 = new Student("s3751920","Nguyen Thien Tuyen",new Date("4/9/1998"));
        Student s8 = new Student("s3758187","Pham Ngoc Chi",new Date("16/6/2000"));
        Student s9 = new Student("s3758839","Hoang To Quyen", new Date("5/5/1998"));
        Student s10 = new Student("s3695197","Thai Phuong Yen",new Date("27/12/1999"));

        //Courses
        Course c1 = new Course("COSC2020","Intro to Software Development",12);
        Course c2 = new Course("COSC2769","What the hell",12);
        Course c3 = new Course("COSC2589","What the fuck",12);
        Course c4 = new Course("COSC2096","Holy hell",12);
        Course c5 = new Course("COSC1768","Piece of shit",12);
        Course c6 = new Course("COSC2337","Son of a Bitch",12);
        Course c7 = new Course("COSC2771","Intro to Sucking dicks",12);
        Course c8 = new Course("COSC2805","Advanced Prostate Massaging",12);

        StudentEnrollmentList enrollmentList = new StudentEnrollmentList();

//        printCourses();
//        printStudents();
//        printEnrollments(enrollmentList);

        //Enrollment Management test:
        //1 student 1 semester
        enrollmentList.add(new StudentEnrollment(s1,c1,"2020A"));
        enrollmentList.add(new StudentEnrollment(s1,c3,"2020A"));
        enrollmentList.add(new StudentEnrollment(s1,c5,"2020A"));

        //

        Scanner input = new Scanner(System.in);
        int menuChoice = 99;
        while ((menuChoice < 6 && menuChoice > 0)|| menuChoice == 99) {
            System.out.println();
            System.out.println("************************************");
            System.out.println("Student Enrollment Manager v1.0");
            System.out.println("1. View courses list");
            System.out.println("2. View students list");
            System.out.println("3. View enrollment list");
            System.out.println("4. Enroll a student");
            System.out.println("5. Manage a student's courses in a semester");
            menuChoice = input.nextInt();
            switch(menuChoice){
                case 1:
                    System.out.println("Selected 1. View courses list");
                    printCourses();
                    break;
                case 2:
                    System.out.println("Selected 2. View students list");
                    printStudents();
                    break;
                case 3:
                    System.out.println("Selected 3. View enrollment list");
                    printEnrollments(enrollmentList);
                    break;
                case 4:
                    System.out.println("Selected 4. Enroll a student");
                    System.out.println("Please enter student ID (example: s1234567): ");
                    String studentId = input.next();
                    System.out.println("inputted: " + studentId);
                    if (Pattern.matches("s[0-9]{7}",studentId)){
                        Student enrolling_student = StudentList.findById(studentId);
                        if (enrolling_student != null){
                            System.out.println("Please enter course ID (example: COSC1234): ");
                            String courseId = input.next();
                            System.out.println("inputted: " + courseId);
                            if (Pattern.matches("[A-Z]{4}[0-9]{4}",courseId)){
                                Course enrolling_course = CourseList.findById(courseId);
                                if ( enrolling_course != null){
                                    System.out.println("Please enter semester (available semesters: 2020A,2020B,2020C): ");
                                    String semester = input.next();
                                    if (semester.equals("2020A") ||semester.equals("2020B") ||semester.equals("2020C")){
                                        enrollmentList.add(new StudentEnrollment(enrolling_student,enrolling_course,semester));
                                        System.out.println("Enrollment successful");
                                        break;
                                    }
                                    else System.out.println("Invalid semester input. Please try again."); break;
                                }
                                else System.out.println("Course not found. Please try again");break;
                            }
                            else System.out.println("Invalid course input. Please try again");break;
                        }
                        else System.out.println("Student not found. Please try again");break;
                    }
                    else System.out.println("Invalid ID input");
                    break;
                case 5:
                    System.out.println("Selected 5. Manage student's course in semester");
                    System.out.println("Please enter student ID (example: s1234567): ");
                    String studentId1 = input.next();
                    System.out.println("inputted: " + studentId1);
                    if (Pattern.matches("s[0-9]{7}",studentId1)) {
                        Student student = StudentList.findById(studentId1);
                        if(student != null){
                            System.out.println("Please enter semester (available semesters: 2020A,2020B,2020C): ");
                            String semester = input.next();
                            if (semester.equals("2020A") ||semester.equals("2020B") ||semester.equals("2020C")){
                                int courseCount = 0;
                                List<StudentEnrollment> enrollments = new ArrayList<>();
                                for (StudentEnrollment studentEnrollment: enrollmentList.getAll()){
                                    if (studentEnrollment.getStudent().getId().equals(studentId1)){
                                        if (studentEnrollment.getSemester().equals(semester)) {
                                            courseCount++;
                                            enrollments.add(studentEnrollment);
                                        }
                                    }
                                }
                                if (courseCount != 0){
                                    System.out.println("In semester " + semester +" ,"+student.getName() + " enrolled " +courseCount+ " course(s), which are: ");
                                    for (StudentEnrollment enrollment : enrollments){
                                        System.out.println(enrollment.toString());
                                    }
                                    int manageChoice = 99;
                                    while ((manageChoice < 5 && manageChoice > 0) || manageChoice == 99){
                                        System.out.println("Managing " + student.getName() + "'s enrollment in semester " + semester);
                                        System.out.println("1. Add a new enrollment");
                                        System.out.println("2. Delete an enrollment");
                                        System.out.println("3. Print that list again");
                                        System.out.println("4. Save a CSV file of that list");
                                        System.out.println("5. Return");
                                        manageChoice = input.nextInt();
                                        switch (manageChoice){
                                            case 1:
                                                System.out.println("Please enter course ID (example: COSC1234): ");
                                                String courseId = input.next();
                                                if (Pattern.matches("[A-Z]{4}[0-9]{4}",courseId)){
                                                    Course course = CourseList.findById(courseId);
                                                    if (course!= null){
                                                        StudentEnrollment enrollment = new StudentEnrollment(student,course,semester);
                                                        enrollmentList.add(enrollment);
                                                        enrollments.add(enrollment);
                                                        System.out.println("Added new enrollment successfully");
                                                        break;
                                                    }
                                                    else System.out.println("Course not found. Please try again");break;
                                                }
                                                else System.out.println("Invalid course input. Please try again");break;
                                            case 2:
                                                System.out.println("Please enter course ID (example: COSC1234): ");
                                                String courseId2 = input.next();
                                                if (Pattern.matches("[A-Z]{4}[0-9]{4}",courseId2)){
                                                    Course course = CourseList.findById(courseId2);
                                                    if (course!= null){
                                                        enrollmentList.delete(studentId1,courseId2);
                                                        enrollments.remove(enrollmentList.getOne(studentId1,courseId2));
                                                        System.out.println("Delete enrollment successfully");
                                                        break;
                                                    }
                                                    else System.out.println("Course not found. Please try again");break;
                                                }
                                                else System.out.println("Invalid course input. Please try again");break;
                                            case 3:
                                                for (StudentEnrollment enrollment : enrollments){
                                                    System.out.println(enrollment.toString());
                                                }
                                                break;
                                            case 4:
                                                StringBuffer stringBuffer = new StringBuffer();
                                                for (StudentEnrollment enrollment : enrollments){
                                                    stringBuffer.append(enrollment.toCSVString());
                                                }
                                                String string = stringBuffer.toString();
                                                writeStringToFile(string,  student.getName().replace(" ","") +"_"+ semester + ".csv");
                                                System.out.println("File saved successfully.");
                                                System.out.println("File will be accessible after the program is closed");
                                                break;
                                        }
                                    }
                                }else System.out.println("The student had not enrolled in any course"); break;
                            }else System.out.println("Invalid semester input. Please try again");break;
                        }else System.out.println("Student not found. Please try again");break;
                    }else System.out.println("Invalid ID input. Please try again");break;
            }
        }
    }




    private static void printCourses(){
        System.out.println("Sample Courses:");
        for (Course course:CourseList.courseList) {
            System.out.println(course.toString());
        }
    }
    private static void printStudents(){
        System.out.println("Sample Students:");
        for (Student student: StudentList.studentList) {
            System.out.println(student.toString());
        }
    }
    private static void printEnrollments(StudentEnrollmentList studentEnrollmentList){
        if (studentEnrollmentList.getAll().size() == 0){
            System.out.println("Student enrollment list is currently empty.");
        }
        else for (StudentEnrollment enrollment: studentEnrollmentList.getAll()) {
            System.out.println(enrollment.toString());
        }
    }
    private static void writeStringToFile(String s, String filename) {
        FileOutputStream write_file = null;
        try {
            write_file = new FileOutputStream(filename);
            write_file.write(s.getBytes());
            write_file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


