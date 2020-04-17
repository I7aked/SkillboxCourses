import BankAccount.DepozitAccount;
import BankAccount.KardAccount;
import BankAccount.RaschetAccount;


import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args)  {

        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();

        RaschetAccount vasya = new RaschetAccount(0);
        vasya.replenishmentMoney(500);
        vasya.withdrawalMoney(200);

        System.out.println("Vasya =" + vasya.getAccountMoney());

        KardAccount petya = new KardAccount(300);
        petya.withdrawalMoney(200);
        System.out.println("Petya =" + petya.getAccountMoney());

        DepozitAccount fedya = new DepozitAccount(0);
        fedya.replenishmentMoney(200,date);

        calendar.setTime(date);
        calendar.roll(Calendar.MONTH,+3);
        date = calendar.getTime();

        fedya.withdrawalMoney(100,date);


    }
}
