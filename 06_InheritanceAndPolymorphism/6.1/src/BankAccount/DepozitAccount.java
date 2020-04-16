package BankAccount;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class DepozitAccount extends RaschetAccount {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd.mm.yyyy", Locale.getDefault());
    Calendar calendar = Calendar.getInstance();


    Date date = new Date();



    public DepozitAccount(double accountMoney)
    {
        super(accountMoney);
    }

    public void PopolnenieBalansa(double summ, String vvodDate) throws ParseException {

        this.summ = summ;
        date = dateFormat.parse(vvodDate);
        accountMoney = accountMoney + summ;
    }

    public void SnytieSBalansa(double summ, String  vvodDate) throws ParseException {
       Date timeDate;
       timeDate = dateFormat.parse(vvodDate);

       long raznicaDays = timeDate.getTime() - date.getTime();//Считается разница в милисекундах в заданных датах
        long kolichestvoDays = TimeUnit.DAYS.convert(raznicaDays,TimeUnit.MILLISECONDS);//Переводится цифра в дни
        
        if (kolichestvoDays < 30){
            System.out.println("Вы не можете снять деньга раньше месяца с момента пополнения");
        }
        else{
            this.summ = summ;
            accountMoney = accountMoney - summ ;
        }
    }
}
