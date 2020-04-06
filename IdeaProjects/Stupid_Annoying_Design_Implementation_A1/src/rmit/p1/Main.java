package rmit.p1;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
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
        Course c2 = new Course("COSC2769","Practical Data Science",12);
        Course c3 = new Course("COSC2589","Security in Computing and Information Technology",12);
        Course c4 = new Course("COSC2096","Introduction To Programming",12);
        Course c5 = new Course("COSC1768","Data Structures & Algorithms",12);
        Course c6 = new Course("COSC2337","Web Programming",12);
        Course c7 = new Course("COSC2440","Software Architecture: Design & Implementation",12);
        Course c8 = new Course("COSC2805","Building IT Systems",12);

        StudentEnrollmentList enrollmentList = new StudentEnrollmentList();
        StudentList studentList = new StudentList();
        CourseList courseList = new CourseList();


//        printCourses();
//        printStudents();
//        printEnrollments(enrollmentList);

        //Enrollment Management test:
        //1 student 1 semester
        enrollmentList.add(new StudentEnrollment(s1,c1,"2020A"));
        enrollmentList.add(new StudentEnrollment(s1,c3,"2020A"));
        enrollmentList.add(new StudentEnrollment(s1,c5,"2020A"));

        //all students of 1 course in 1 semester
        enrollmentList.add(new StudentEnrollment(s2,c3,"2020B"));
        enrollmentList.add(new StudentEnrollment(s6,c3,"2020B"));
        enrollmentList.add(new StudentEnrollment(s5,c3,"2020B"));
        enrollmentList.add(new StudentEnrollment(s9,c3,"2020B"));
        enrollmentList.add(new StudentEnrollment(s7,c3,"2020B"));

        //all courses offered in one semester
        enrollmentList.add(new StudentEnrollment(s2,c7,"2020B"));
        enrollmentList.add(new StudentEnrollment(s3,c8,"2020B"));
        enrollmentList.add(new StudentEnrollment(s10,c1,"2020B"));
        enrollmentList.add(new StudentEnrollment(s8,c6,"2020B"));
        enrollmentList.add(new StudentEnrollment(s10,c2,"2020B"));
        enrollmentList.add(new StudentEnrollment(s4,c4,"2020B"));

        Scanner input = new Scanner(System.in);
        int menuChoice = 927498256;
        while ((menuChoice < 8 && menuChoice > 0)|| menuChoice == 927498256) {
            System.out.println();
            System.out.println("************************************");
            System.out.println("Student Enrollment Manager v1.0");
            System.out.println("1. View courses list");
            System.out.println("2. View students list");
            System.out.println("3. View enrollment list");
            System.out.println("4. Enroll a student");
            System.out.println("5. Manage a student's courses in a semester");
            System.out.println("6. Update a student enrollment");
            System.out.println("7. Delete a student enrollment");
            System.out.println("8. Print all students enrolled in a course in a semester");
            System.out.println("9. Print all courses offered in one semester");
            System.out.println("10. Exit");
            try{
                menuChoice = input.nextInt();
            }
            catch (InputMismatchException e){
                menuChoice = 10;
            }
            switch(menuChoice) {
                case 1:
                    System.out.println("Selected 1. View courses list");
                    printCourses(courseList);
                    break;
                case 2:
                    System.out.println("Selected 2. View students list");
                    printStudents(studentList);
                    break;
                case 3:
                    System.out.println("Selected 3. View enrollment list");
                    printEnrollments(enrollmentList);
                    break;
                case 4:
                    System.out.println("Selected 4. Enroll a student");
                    System.out.println("Please enter student ID (example: s1234567): ");
                    String studentId = input.next();
                    //System.out.println("inputted: " + studentId);
                    if (Pattern.matches("s[0-9]{7}", studentId)) {
                        Student enrolling_student = studentList.findById(studentId);
                        if (enrolling_student != null) {
                            System.out.println("Please enter course ID (example: COSC1234): ");
                            String courseId = input.next();
                            //System.out.println("inputted: " + courseId);
                            if (Pattern.matches("[A-Z]{4}[0-9]{4}", courseId)) {
                                Course enrolling_course = courseList.findById(courseId);
                                if (enrolling_course != null) {
                                    System.out.println("Please enter semester (available semesters: 2020A,2020B,2020C): ");
                                    String semester = input.next();
                                    if (semester.equals("2020A") || semester.equals("2020B") || semester.equals("2020C")) {
                                        StudentEnrollment enroll = new StudentEnrollment(enrolling_student, enrolling_course, semester);
//                                        boolean isDuplicate = false;
//                                        for (StudentEnrollment enrollment : enrollmentList.getAll()){
//                                            if (enrollment.equals(enroll)){
//                                                System.out.println("This enrollment has already existed in the system.");
//                                                isDuplicate = true;
//                                                break;
//                                            }
//                                        }
//                                        if (!isDuplicate){
//                                            enrollmentList.add(enroll);
//                                            System.out.println("Enrollment successful");
//                                            break;
//                                        } else break;
                                        boolean isDuplicate = enroll.isDuplicate(enrollmentList.getAll());
                                        if (isDuplicate) {
                                            System.out.println("This enrollment has already existed in the system.");
                                            break;
                                        } else {
                                            enrollmentList.add(enroll);
                                            System.out.println("Enrollment successful");
                                            break;
                                        }
                                    } else System.out.println("Invalid semester input. Please try again.");
                                    break;
                                } else System.out.println("Course not found. Please try again");
                                break;
                            } else System.out.println("Invalid course input. Please try again");
                            break;
                        } else System.out.println("Student not found. Please try again");
                        break;
                    } else System.out.println("Invalid ID input");
                    break;
                case 5:
                    System.out.println("Selected 5. Manage student's course in semester");
                    System.out.println("Please enter student ID (example: s1234567): ");
                    String studentId1 = input.next();
                    //System.out.println("inputted: " + studentId1);
                    if (Pattern.matches("s[0-9]{7}", studentId1)) {
                        Student student = studentList.findById(studentId1);
                        if (student != null) {
                            System.out.println("Please enter semester (available semesters: 2020A,2020B,2020C): ");
                            String semester = input.next();
                            if (semester.equals("2020A") || semester.equals("2020B") || semester.equals("2020C")) {
                                int courseCount = 0;
                                List<StudentEnrollment> enrollments = new ArrayList<>();
                                for (StudentEnrollment studentEnrollment : enrollmentList.getAll()) {
                                    if (studentEnrollment.getStudent().getId().equals(studentId1)) {
                                        if (studentEnrollment.getSemester().equals(semester)) {
                                            courseCount++;
                                            enrollments.add(studentEnrollment);
                                        }
                                    }
                                }
                                if (courseCount != 0) {
                                    System.out.println("In semester " + semester + " ," + student.getName() + " enrolled " + courseCount + " course(s), which are: ");
                                    for (StudentEnrollment enrollment : enrollments) {
                                        System.out.println(enrollment.toString());
                                    }
                                    int manageChoice = 927498256;
                                    while ((manageChoice < 5 && manageChoice > 0) || manageChoice == 927498256) {
                                        System.out.println("Managing " + student.getName() + "'s enrollment in semester " + semester);
                                        System.out.println("1. Add a new enrollment");
                                        System.out.println("2. Delete an enrollment");
                                        System.out.println("3. Print that list again");
                                        System.out.println("4. Save a CSV file of that list");
                                        System.out.println("5. Return");
                                        manageChoice = input.nextInt();
                                        switch (manageChoice) {
                                            case 1:
                                                System.out.println("Selected 1. Add a new enrollment");
                                                System.out.println("Please enter course ID (example: COSC1234): ");
                                                String courseId = input.next();
                                                if (Pattern.matches("[A-Z]{4}[0-9]{4}", courseId)) {
                                                    Course course = courseList.findById(courseId);
                                                    if (course != null) {
                                                        StudentEnrollment enrollment = new StudentEnrollment(student, course, semester);
                                                        enrollmentList.add(enrollment);
                                                        enrollments.add(enrollment);
                                                        System.out.println("Added new enrollment successfully");
                                                        break;
                                                    } else System.out.println("Course not found. Please try again");
                                                    break;
                                                } else System.out.println("Invalid course input. Please try again");
                                                break;
                                            case 2:
                                                System.out.println("Selected 2. Delete an enrollment");
                                                System.out.println("Please enter course ID (example: COSC1234): ");
                                                String courseId2 = input.next();
                                                if (Pattern.matches("[A-Z]{4}[0-9]{4}", courseId2)) {
                                                    Course course = courseList.findById(courseId2);
                                                    if (course != null) {
                                                        enrollmentList.delete(studentId1, courseId2);
                                                        enrollments.remove(enrollmentList.getOne(studentId1, courseId2));
                                                        System.out.println("Delete enrollment successfully");
                                                        break;
                                                    } else System.out.println("Course not found. Please try again");
                                                    break;
                                                } else System.out.println("Invalid course input. Please try again");
                                                break;
                                            case 3:
                                                System.out.println("Selected 3. Print that list again");
                                                for (StudentEnrollment enrollment : enrollments) {
                                                    System.out.println(enrollment.toString());
                                                }
                                                break;
                                            case 4:
                                                System.out.println("Selected 4. Save a CSV file of that list");
                                                StringBuffer stringBuilder = new StringBuffer();
                                                for (StudentEnrollment enrollment : enrollments) {
                                                    stringBuilder.append(enrollment.toCSVString());
                                                }
                                                String string = stringBuilder.toString();
                                                writeStringToFile(string, student.getName().replace(" ", "") + "_" + semester + ".csv");
                                                System.out.println("File saved successfully.");
                                                System.out.println("File will be accessible after the program is closed");
                                                break;
                                        }
                                    }
                                } else System.out.println("The student had not enrolled in any course");
                                break;
                            } else System.out.println("Invalid semester input. Please try again");
                            break;
                        } else System.out.println("Student not found. Please try again");
                        break;
                    } else System.out.println("Invalid ID input. Please try again");
                    break;
                case 6: // Update student
                    System.out.println("Selected 6. Update a student enrollment");
                    System.out.println("Please enter student ID (example: s1234567): ");
                    String studentId2 = input.next();
                    //System.out.println("inputted: " + studentId1);
                    if (Pattern.matches("s[0-9]{7}", studentId2)) {
                        Student student = studentList.findById(studentId2);
                        if (student != null) {
                            if (student.getCourses().size() != 0){
                                System.out.println("List of courses " + student.getName() + " is currently enrolling: ");
                                for (Course course : student.getCourses()) {
                                    System.out.println(course);
                                }
                                System.out.println("Please specify the enrollment to be updated");
                                System.out.println("***");
                                System.out.println("Available options: ");
                                for (Course course : student.getCourses()) {
                                    System.out.println(course.getId());
                                }
                                System.out.println("Enter the course ID: ");
                                String courseId2 = input.next();
                                boolean isInputValid = false;
                                for (Course course: student.getCourses()){
                                    if (course.getId().equals(courseId2)){
                                        isInputValid = true;
                                    }
                                }
                                if (isInputValid){
                                    StudentEnrollment specificedEnrollment = enrollmentList.getOne(studentId2,courseId2);
                                    System.out.println("Enrollment specified: " + specificedEnrollment);
                                    System.out.println("Please input the changes to be made.");
                                    System.out.println("Input new course code: ");
                                    String courseId3 = input.next();
                                    if (Pattern.matches("[A-Z]{4}[0-9]{4}", courseId3)) {
                                        Course course = courseList.findById(courseId3);
                                        if (course != null) {
                                            System.out.println("Input new semester: ");
                                            String sem3 = input.next();
                                            if (sem3.equals("2020A") || sem3.equals("2020B") || sem3.equals("2020C")){
                                                if (!(specificedEnrollment.getCourse().getId().equals(courseId3) && specificedEnrollment.getSemester().equals(sem3))){
                                                    StudentEnrollment testingDuplicate = new StudentEnrollment(student,course,sem3);
                                                    if (!testingDuplicate.isDuplicate(enrollmentList.getAll())){
                                                        System.out.println("Update successful.");
                                                        System.out.println(specificedEnrollment + " has been changed into");
                                                        enrollmentList.update(specificedEnrollment,course,sem3);
                                                        System.out.println(specificedEnrollment);
                                                        break;
                                                    }
                                                    else{
                                                        System.out.println("The changes inputted is clashing with another existing enrollment.");
                                                        break;
                                                    }
                                                }
                                                else{
                                                    System.out.println("Invalid input.");
                                                    System.out.println("Inputted: " + courseId3 + " " + sem3);
                                                    System.out.println("Enrollment to be changed: " + specificedEnrollment);
                                                    break;
                                                }
                                            } else System.out.println("Invalid semester input. Please try again"); break;
                                        } else System.out.println("Course not found. Please try again"); break;
                                    } else System.out.println("Invalid course ID input. Please try again");break;
                                }else{
                                    System.out.println("Input is not matched with any available option. Please try again.");break;
                                }

                            }
                            else{
                                System.out.println("The student is currently not enrolled in any course.");
                                System.out.println("Please choose the option 'Enroll a student' to make a new enrollment for the student.");
                                break;
                            }
                        }
                        else System.out.println("Student not found. Please try again"); break;
                    }else System.out.println("Invalid student ID input. Please try again"); break;

                case 7: //Delete enrollment
                    System.out.println("Selected 7. Delete a student enrollment");
                    System.out.println("Please enter student ID (example: s1234567): ");
                    String studentId3 = input.next();
                    //System.out.println("inputted: " + studentId1);
                    if (Pattern.matches("s[0-9]{7}", studentId3)) {
                        Student student = studentList.findById(studentId3);
                        if (student != null) {
                            if (student.getCourses().size() != 0){
                                System.out.println("List of courses " + student.getName() + " is currently enrolling: ");
                                for (Course course : student.getCourses()) {
                                    System.out.println(course);
                                }
                                System.out.println("Please specify the enrollment to be updated");
                                System.out.println("***");
                                System.out.println("Available options: ");
                                for (Course course : student.getCourses()) {
                                    System.out.println(course.getId());
                                }
                                System.out.println("Enter the course ID: ");
                                String courseId2 = input.next();
                                boolean isInputValid = false;
                                for (Course course: student.getCourses()){
                                    if (course.getId().equals(courseId2)){
                                        isInputValid = true;
                                    }
                                }
                                if (isInputValid){
                                    StudentEnrollment specificedEnrollment = enrollmentList.getOne(studentId3,courseId2);
                                    System.out.println("Enrollment specified: " + specificedEnrollment);
                                    while (true) {
                                        System.out.println("Confirm delete this enrollment (Y/N)");
                                        String select = input.next();
                                        if (select.equals("Y") || select.equals("y")) {
                                            enrollmentList.delete(studentId3,courseId2);
                                            System.out.println("Enrollment dropped!");
                                        }
                                        if (select.equals("N") || select.equals("n")) {
                                            break;
                                        }
                                    }
                                }else{
                                    System.out.println("Input is not matched with any available option. Please try again.");break;
                                }

                            }
                            else{
                                System.out.println("The student is currently not enrolled in any course.");
                                System.out.println("Please choose the option 'Enroll a student' to make a new enrollment for the student.");
                                break;
                            }
                        }
                        else System.out.println("Student not found. Please try again"); break;
                    }else System.out.println("Invalid student ID input. Please try again"); break;
                case 8: // Students enrolled in a course in a semester
                    System.out.println("Selected 8. Print all students enrolled in a course in a semester");
                    System.out.println("Please enter course ID (example: COSC1234): ");
                    String courseId = input.next();
                    if (Pattern.matches("[A-Z]{4}[0-9]{4}", courseId)) {
                        Course course = courseList.findById(courseId);
                        if (course != null) {
                            System.out.println("Please enter semester (available semesters: 2020A,2020B,2020C): ");
                            String semester = input.next();
                            if (semester.equals("2020A") || semester.equals("2020B") || semester.equals("2020C")) {
                                int studentCount = 0;
                                List<StudentEnrollment> enrollments = new ArrayList<>();
                                for (StudentEnrollment studentEnrollment : enrollmentList.getAll()) {
                                    if (studentEnrollment.getCourse().getId().equals(courseId)) {
                                        if (studentEnrollment.getSemester().equals(semester)) {
                                            enrollments.add(studentEnrollment);
                                            studentCount++;
                                        }
                                    }
                                }
                                if (studentCount != 0) {
                                    System.out.println("All students enrolled in " + course.getId() + " " + course.getName() + " in sem " + semester + ":");
                                    for (StudentEnrollment enrollment : enrollments) {
                                        System.out.println(enrollment.getStudent().toString());
                                    }
                                    while (true) {
                                        System.out.println("Would you like to save a CSV file of this? (Y/N)");
                                        String select = input.next();
                                        if (select.equals("Y") || select.equals("y")) {
                                            StringBuffer stringBuilder = new StringBuffer();
                                            for (StudentEnrollment enrollment : enrollments) {
                                                stringBuilder.append(enrollment.getStudent().toCSVString());
                                            }
                                            String string = stringBuilder.toString();
                                            writeStringToFile(string, courseId + "_" + semester + "_Students" + ".csv");
                                            System.out.println("File saved successfully.");
                                            System.out.println("File will be accessible after the program is closed");
                                            break;
                                        }
                                        if (select.equals("N") || select.equals("n")) {
                                            break;
                                        }
                                    }
                                    break;

                                } else
                                    System.out.println("There are no students enrolled in " + course.getId() + " " + course.getName() + " in sem " + semester);
                            } else System.out.println("Invalid semester input. Please try again");
                            break;
                        } else System.out.println("Course not found. Please try again");
                        break;
                    } else System.out.println("Invalid ID input. Please try again");
                case 9: // courses offered in one semester
                    System.out.println("Selected 9. Print all courses offered in one semester");
                    System.out.println("Please enter semester (available semesters: 2020A,2020B,2020C): ");
                    String semester = input.next();
                    if (semester.equals("2020A") || semester.equals("2020B") || semester.equals("2020C")) {
                        List<Course> courses = new ArrayList<>();
                        for (StudentEnrollment studentEnrollment : enrollmentList.getAll()) {
                            if (studentEnrollment.getSemester().equals(semester)) {
                                if (courses.indexOf(studentEnrollment.getCourse()) == -1) {
                                    courses.add(studentEnrollment.getCourse());
                                }
                            }
                        }
                        if (courses.size() != 0) {
                            System.out.println("All the courses that are available in sem " + semester + ":");
                            for (Course course : courses) {
                                System.out.println(course.toString());
                            }
                            while (true) {
                                System.out.println("Would you like to save a CSV file of this? (Y/N)");
                                String select = input.next();
                                if (select.equals("Y") || select.equals("y")) {
                                    StringBuffer stringBuilder = new StringBuffer();
                                    for (Course course : courses) {
                                        stringBuilder.append(course.toCSVString());
                                    }
                                    String string = stringBuilder.toString();
                                    writeStringToFile(string, semester + "_Courses" + ".csv");
                                    System.out.println("File saved successfully.");
                                    System.out.println("File will be accessible after the program is closed");
                                    break;
                                }
                                if (select.equals("N") || select.equals("n")) {
                                    break;
                                }
                            }
                            break;
                        } else System.out.println("There are no courses available in semester " + semester);
                        break;

                    } else System.out.println("Invalid semester input. Please try again");
                    break;
            }
        }
    }




    private static void printCourses(CourseList courseList){
        System.out.println("Sample Courses:");
        for (Course course:courseList.getCourseList()) {
            System.out.println(course.toString());
        }
    }
    private static void printStudents(StudentList studentList){
        System.out.println("Sample Students:");
        for (Student student: studentList.getStudentList()) {
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


