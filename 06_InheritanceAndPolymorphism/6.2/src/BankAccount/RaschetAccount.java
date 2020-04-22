package BankAccount;


import java.util.Calendar;

public class RaschetAccount {

   private Calendar replenishmentAccountDate;

   private double accountMoney;

   public RaschetAccount(double accountMoney)
   {
       this.accountMoney = accountMoney;
   }

    public void replenishmentMoney(double summ)
    {
        getReplenishmentAccountDate();
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

    public Calendar getReplenishmentAccountDate()
    {
        replenishmentAccountDate = Calendar.getInstance();
        return replenishmentAccountDate;
    }

}
