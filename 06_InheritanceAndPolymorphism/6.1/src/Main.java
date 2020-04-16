import BankAccount.DepozitAccount;
import BankAccount.KardAccount;
import BankAccount.RaschetAccount;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws ParseException {




        RaschetAccount vasya = new RaschetAccount(0);
        vasya.PopolnenieBalansa(500);
        vasya.SnytieSBalansa(200);

        System.out.println("Vasya =" + vasya.getAccountMoney());

        KardAccount petya = new KardAccount(0);
        petya.setAccountMoney(500);
        petya.SnytieSBalansa(200);
        System.out.println("Petya =" + petya.getAccountMoney());

        DepozitAccount fedya = new DepozitAccount(0);
        fedya.setAccountMoney(1000);
        fedya.PopolnenieBalansa(200,"12.12.1990");
        fedya.SnytieSBalansa(100,"20.12.1990");
        System.out.println(" Fedya =" + fedya.getAccountMoney());

    }
}
