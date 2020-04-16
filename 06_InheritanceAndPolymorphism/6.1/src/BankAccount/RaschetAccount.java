package BankAccount;

import java.util.Scanner;

public class RaschetAccount {

   public double accountMoney;
   public double summ;

   public RaschetAccount(double accountMoney)
   {
       this.accountMoney = accountMoney;
   }

    public void PopolnenieBalansa(double summ)
    {
        this.summ = summ;
        accountMoney = accountMoney + summ;
    }

    public void SnytieSBalansa(double summ)
    {
        this.summ = summ;
        accountMoney = accountMoney - summ ;
    }

    public double getAccountMoney()
    {
        return accountMoney;
    }

    public void setAccountMoney(double accountMoney)
    {
        this.accountMoney = accountMoney;
    }
}
