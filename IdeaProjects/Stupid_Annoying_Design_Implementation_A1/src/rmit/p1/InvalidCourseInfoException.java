package rmit.p1;

public class InvalidCourseInfoException extends Exception {
    public InvalidCourseInfoException(String message) {
        super(message);
        System.out.println("Invalid course info: " + message);
    }
}
