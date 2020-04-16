package BankAccount;

public class KardAccount extends RaschetAccount {

    public KardAccount (double accountMoney)
    {
        super(accountMoney);
    }

    public void SnytieSBalansa(double summ)
    {
        this.summ = summ;
        accountMoney = accountMoney - summ*(1.01) ;
    }


}
