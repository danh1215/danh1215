package rmit.p1;

public class InvalidStudentInfoException extends Exception {
    public InvalidStudentInfoException(String message) {
        super(message);
        System.out.println("Invalid Student info exception: " + message);
    }
}
