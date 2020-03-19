import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DRDate {

    public static void main(String[] args) {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date date = new Date(90,3,10);

        Locale[] locales = {
                Locale.getDefault(),
                Locale.US};

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        int myAge = 0;
        String birthDay="";

        while (myAge<30) {
            date = calendar.getTime();
            System.out.println(myAge + " - " + dateFormat.format(date) + " - " + new SimpleDateFormat("EEEE",locales[0]).format(date));
            System.out.println(myAge + " - " + dateFormat.format(date) + " - " + new SimpleDateFormat("E",locales[1]).format(date));

            calendar.add(calendar.MONTH,12);
            myAge++;
        }
    }
}
