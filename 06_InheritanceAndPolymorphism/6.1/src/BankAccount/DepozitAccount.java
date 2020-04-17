package BankAccount;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class DepozitAccount extends RaschetAccount {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd.mm.yyyy", Locale.getDefault());
    Calendar calendar = Calendar.getInstance();
    Date date = new Date();

    public DepozitAccount(double accountMoney)
    {
        super(accountMoney);
    }


    @Override
    public void replenishmentMoney(double summ) {
        super.replenishmentMoney(summ);
    }

    public void replenishmentMoney(double summ, Date data) {
        this.date = data;
        accountMoney = accountMoney + summ;

    }

    @Override
    public void withdrawalMoney(double summ) {
        super.withdrawalMoney(summ);
    }

    public void withdrawalMoney (double summ, Date  withdrawalDate) {

//       long raznicaDays = timeDate.getTime() - date.getTime();//Считается разница в милисекундах в заданных датах
//       long kolichestvoDays = TimeUnit.DAYS.convert(raznicaDays,TimeUnit.MILLISECONDS);//Переводится цифра в дни
        calendar.setTime(date); //Установили календарь введённой ранее датой
        calendar.roll(Calendar.MONTH,+1); //Увеличили дату на месяц
        date = calendar.getTime(); //Установили новую дату на месяц больше

        if (date.getTime() - withdrawalDate.getTime() > 0){//Проверяется разница между датами
            System.out.println("Вы не можете снять деньга раньше месяца с момента пополнения");
        }
        else{
             accountMoney = accountMoney - summ ;
            System.out.println( "У Вас на счету =" + getAccountMoney());
        }
    }
}
