package rmit.p1;

public class Date {
    private int day;
    private int month;
    private int year;

    public Date(String date) {
        String[] arr = date.split("/");
        this.day = Integer.parseInt(arr[0]);
        this.month = Integer.parseInt(arr[1]);
        this.year = Integer.parseInt(arr[2]);
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
}
