package BankAccount;


public class RaschetAccount {

   public double accountMoney;

   public RaschetAccount(double accountMoney)
   {
       this.accountMoney = accountMoney;
   }

    public void replenishmentMoney(double summ)
    {
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
