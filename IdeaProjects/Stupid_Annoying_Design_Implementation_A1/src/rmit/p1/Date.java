package rmit.p1;

public class Date {
    private int day;
    private int month;
    private int year;

    @Override
    public String toString() {
        switch(month){
            case 1:
                switch(day){
                    case 1:
                        return "Jan " + day +"st, " + year;
                    case 2:
                        return "Jan " + day +"nd, " + year;
                    case 3:
                        return "Jan " + day +"rd, " + year;
                    case 21:
                        return "Jan " + day +"st, " + year;
                    case 22:
                        return "Jan " + day +"nd, " + year;
                    case 23:
                        return "Jan " + day +"rd, " + year;
                    case 31:
                        return "Jan " + day +"st, " + year;
                }
                return "Jan " + day +"th, " + year;
            case 2:
                switch(day){
                    case 1:
                        return "Feb " + day +"st, " + year;
                    case 2:
                        return "Feb " + day +"nd, " + year;
                    case 3:
                        return "Feb " + day +"rd, " + year;
                    case 21:
                        return "Feb " + day +"st, " + year;
                    case 22:
                        return "Feb " + day +"nd, " + year;
                    case 23:
                        return "Feb " + day +"rd, " + year;
                    case 31:
                        return "Feb " + day +"st, " + year;
                }
                return "Feb " + day +"th, " + year;
            case 3:
                switch(day){
                    case 1:
                        return "Mar " + day +"st, " + year;
                    case 2:
                        return "Mar " + day +"nd, " + year;
                    case 3:
                        return "Mar " + day +"rd, " + year;
                    case 21:
                        return "Mar " + day +"st, " + year;
                    case 22:
                        return "Mar " + day +"nd, " + year;
                    case 23:
                        return "Mar " + day +"rd, " + year;
                    case 31:
                        return "Mar " + day +"st, " + year;
                }
                return "Mar " + day +"th, " + year;
            case 4:
                switch(day){
                    case 1:
                        return "Apr " + day +"st, " + year;
                    case 2:
                        return "Apr " + day +"nd, " + year;
                    case 3:
                        return "Apr " + day +"rd, " + year;
                    case 21:
                        return "Apr " + day +"st, " + year;
                    case 22:
                        return "Apr " + day +"nd, " + year;
                    case 23:
                        return "Apr " + day +"rd, " + year;
                    case 31:
                        return "Apr " + day +"st, " + year;
                }
                return "Apr " + day +"th, " + year;
            case 5:
                switch(day){
                    case 1:
                        return "May " + day +"st, " + year;
                    case 2:
                        return "May " + day +"nd, " + year;
                    case 3:
                        return "May " + day +"rd, " + year;
                    case 21:
                        return "May " + day +"st, " + year;
                    case 22:
                        return "May " + day +"nd, " + year;
                    case 23:
                        return "May " + day +"rd, " + year;
                    case 31:
                        return "May " + day +"st, " + year;
                }
                return "May " + day +"th, " + year;
            case 6:
                switch(day){
                    case 1:
                        return "Jun " + day +"st, " + year;
                    case 2:
                        return "Jun " + day +"nd, " + year;
                    case 3:
                        return "Jun " + day +"rd, " + year;
                    case 21:
                        return "Jun " + day +"st, " + year;
                    case 22:
                        return "Jun " + day +"nd, " + year;
                    case 23:
                        return "Jun " + day +"rd, " + year;
                    case 31:
                        return "Jun " + day +"st, " + year;
                }
                return "Jun " + day +"th, " + year;
            case 7:
                switch(day){
                    case 1:
                        return "Jul " + day +"st, " + year;
                    case 2:
                        return "Jul " + day +"nd, " + year;
                    case 3:
                        return "Jul " + day +"rd, " + year;
                    case 21:
                        return "Jul " + day +"st, " + year;
                    case 22:
                        return "Jul " + day +"nd, " + year;
                    case 23:
                        return "Jul " + day +"rd, " + year;
                    case 31:
                        return "Jul " + day +"st, " + year;
                }
                return "Jul " + day +"th, " + year;
            case 8:
                switch(day){
                    case 1:
                        return "Aug " + day +"st, " + year;
                    case 2:
                        return "Aug " + day +"nd, " + year;
                    case 3:
                        return "Aug " + day +"rd, " + year;
                    case 21:
                        return "Aug " + day +"st, " + year;
                    case 22:
                        return "Aug " + day +"nd, " + year;
                    case 23:
                        return "Aug " + day +"rd, " + year;
                    case 31:
                        return "Aug " + day +"st, " + year;
                }
                return "Aug " + day +"th, " + year;
            case 9:
                switch(day){
                    case 1:
                        return "Sep " + day +"st, " + year;
                    case 2:
                        return "Sep " + day +"nd, " + year;
                    case 3:
                        return "Sep " + day +"rd, " + year;
                    case 21:
                        return "Sep " + day +"st, " + year;
                    case 22:
                        return "Sep " + day +"nd, " + year;
                    case 23:
                        return "Sep " + day +"rd, " + year;
                    case 31:
                        return "Sep " + day +"st, " + year;
                }
                return "Sep " + day +"th, " + year;
            case 10:
                switch(day){
                    case 1:
                        return "Oct " + day +"st, " + year;
                    case 2:
                        return "Oct " + day +"nd, " + year;
                    case 3:
                        return "Oct " + day +"rd, " + year;
                    case 21:
                        return "Oct " + day +"st, " + year;
                    case 22:
                        return "Oct " + day +"nd, " + year;
                    case 23:
                        return "Oct " + day +"rd, " + year;
                    case 31:
                        return "Oct " + day +"st, " + year;
                }
                return "Oct " + day +"th, " + year;
            case 11:
                switch(day){
                    case 1:
                        return "Nov " + day +"st, " + year;
                    case 2:
                        return "Nov " + day +"nd, " + year;
                    case 3:
                        return "Nov " + day +"rd, " + year;
                    case 21:
                        return "Nov " + day +"st, " + year;
                    case 22:
                        return "Nov " + day +"nd, " + year;
                    case 23:
                        return "Nov " + day +"rd, " + year;
                    case 31:
                        return "Nov " + day +"st, " + year;
                }
                return "Nov " + day +"th, " + year;
            case 12:
                switch(day){
                    case 1:
                        return "Dec " + day +"st, " + year;
                    case 2:
                        return "Dec " + day +"nd, " + year;
                    case 3:
                        return "Dec " + day +"rd, " + year;
                    case 21:
                        return "Dec " + day +"st, " + year;
                    case 22:
                        return "Dec " + day +"nd, " + year;
                    case 23:
                        return "Dec " + day +"rd, " + year;
                    case 31:
                        return "Dec " + day +"st, " + year;
                }
                return "Dec " + day +"th, " + year;
        }
        return "";
    }

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
