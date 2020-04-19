import BankAccount.DepozitAccount;
import BankAccount.KardAccount;
import BankAccount.RaschetAccount;


public class Main {

    public static void main(String[] args)  {

        RaschetAccount vasya = new RaschetAccount(0);
        vasya.replenishmentMoney(500);
        vasya.withdrawalMoney(200);

        System.out.println("Vasya =" + vasya.getAccountMoney());

        KardAccount petya = new KardAccount(300);
        petya.withdrawalMoney(200);
        System.out.println("Petya =" + petya.getAccountMoney());

        DepozitAccount fedya = new DepozitAccount(200);
        fedya.replenishmentMoney(200);
        fedya.withdrawalMoney(100);



    }
}
