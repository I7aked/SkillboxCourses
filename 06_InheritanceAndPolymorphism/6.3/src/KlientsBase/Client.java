package KlientsBase;


public abstract class Client {

    private double accountMoney;

    public Client()
    {
    accountMoney = 0;
    }

    public void replenishmentMoney(double summ)
    {
        accountMoney = accountMoney + summ;
    }

    public void withdrawalMoney (double summ)

    {
       if (accountMoney >= summ) {
           accountMoney = accountMoney - summ;
       }
       else{
           System.out.println("Недостаточно средств");
       }
    }

    public double getAccountMoney() {
        return accountMoney;
    }

//    public void setAccountMoney(double accountMoney) {
//        this.accountMoney = accountMoney;
//    }




}
