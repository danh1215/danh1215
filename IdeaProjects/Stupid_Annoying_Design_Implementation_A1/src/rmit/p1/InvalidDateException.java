package rmit.p1;

public class InvalidDateException extends Exception {
    public InvalidDateException(String message) {
        super(message);
        System.out.println("Invalid date exception: " + message);
    }
}
