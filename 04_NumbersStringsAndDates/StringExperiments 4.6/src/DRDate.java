import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DRDate {

    public static void main(String[] args) {
       DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date date = new Date(90,3,10);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        int myAge = 0;
        String birthDay="";
       
        while (myAge<30) {
            date = calendar.getTime();
            birthDay = date.toString();
            birthDay = birthDay.replaceAll("([^A-z]{3,3}.*)$", "");
            birthDay = birthDay.replaceAll("Apr", "");

//            System.out.println(calendar.getTime());
//            System.out.println(birthDay);
//            System.out.println(dateFormat.format(date));
            System.out.println(myAge + " - " + dateFormat.format(date) + " - " + birthDay);
            calendar.add(calendar.MONTH,12);
            myAge++;
        }
    }
}
