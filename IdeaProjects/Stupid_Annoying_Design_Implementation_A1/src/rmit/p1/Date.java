package rmit.p1;

public class Date {
    private int day;
    private int month;
    private int year;

    public Date(String date) throws InvalidDateException{
        String[] arr = date.split("/");
        int day,month,year;
        day = Integer.parseInt(arr[0]);
        if (day > 31 || day < 1){
            throw new InvalidDateException("Invalid day input");
        }
        else this.day = day;

        month = Integer.parseInt(arr[1]);
        if (month > 12 || month < 1){
            throw new InvalidDateException("Invalid month input");
        }
        else this.month = month;

        year = Integer.parseInt(arr[2]);
        if (year < 0){
            throw new InvalidDateException("Invalid year input");
        }
        else this.year = year;
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
