package rmit.p1;

import java.util.List;

public interface StudentEnrollmentManager {
    public void add(StudentEnrollment enrollment);
    public void update(String id, Course course, String semester);
    public void delete(String studentId, String courseId);
    public StudentEnrollment getOne(String studentId, String courseId);
    public List<StudentEnrollment> getAll();
}
