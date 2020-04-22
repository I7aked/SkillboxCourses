package BankAccount;

public class KardAccount extends RaschetAccount {

    public KardAccount (double accountMoney)
    {
        super(accountMoney);
    }

    public void withdrawalMoney (double summ)
    {
        super.withdrawalMoney( summ*(1.01));
    }


}
