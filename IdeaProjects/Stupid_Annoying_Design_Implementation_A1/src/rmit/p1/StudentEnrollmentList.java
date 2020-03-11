package rmit.p1;

import java.util.ArrayList;
import java.util.List;

public class StudentEnrollmentList implements StudentEnrollmentManager{
    private List<StudentEnrollment> enrollments = new ArrayList<>();

    @Override
    public void add(StudentEnrollment enrollment) {
        enrollments.add(enrollment);
    }

    @Override
    public void update(String id, Course course, String semester) {
        for (StudentEnrollment enrollment : enrollments) {
            if (enrollment.getStudent().getId().equals(id)){
                System.out.println("Found student. Making changes");
                enrollment.setCourse(course);
                enrollment.setSemester(semester);
            }
            else System.out.println("Student not found");
        }


    }

    @Override
    public void delete(String studentId, String courseId) {
        if (getOne(studentId,courseId) != null){
            System.out.println("Enrollment found.");
            this.enrollments.remove(getOne(studentId,courseId));
        }
        else System.out.println("Enrollment not found.");
    }

    @Override
    public StudentEnrollment getOne(String studentId, String courseId) {
        for (StudentEnrollment enrollment : enrollments) {
            if (enrollment.getStudent().getId().equals(studentId)){
                System.out.println("Found student.");
                Student target = enrollment.getStudent();
                for (Course course : target.getCourses()) {
                    if (course.getId().equals(courseId)){
                        System.out.println("Found the enrollment");
                        return enrollment;
                    }
                    else System.out.println("The student did not apply for that course.");
                }

            }
            else System.out.println("Student not found");
        }
        return null;
    }

    @Override
    public List<StudentEnrollment> getAll() {
        return enrollments;
    }
}
