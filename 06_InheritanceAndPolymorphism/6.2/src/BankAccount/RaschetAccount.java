package BankAccount;


import java.util.Calendar;

public class RaschetAccount {

   protected Calendar replenishmentAccountDate = Calendar.getInstance();

   protected double accountMoney;

   public RaschetAccount(double accountMoney)
   {
       this.accountMoney = accountMoney;
   }

    public void replenishmentMoney(double summ)

    {
        replenishmentAccountDate = Calendar.getInstance();
        accountMoney = accountMoney + summ;
    }

    public void withdrawalMoney (double summ)
    {
        accountMoney = accountMoney - summ ;
    }

    public double getAccountMoney()
    {
        return accountMoney;
    }

}
