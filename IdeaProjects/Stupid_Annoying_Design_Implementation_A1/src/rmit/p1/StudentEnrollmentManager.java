package rmit.p1;

import java.util.ArrayList;

public interface StudentEnrollmentManager {
    public void add(StudentEnrollment enrollment);
    public void update();
    public void delete();
    public void getOne();
    public ArrayList<StudentEnrollment> getAll();
}
