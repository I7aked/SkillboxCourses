package KlientsBase;

public class CompanyBisnessAccount extends Client {

    public CompanyBisnessAccount() {
      super();
    }

    @Override
    public void withdrawalMoney(double summ) {
//        super.withdrawalMoney(summ);
        if (accountMoney >= summ * (1.01) ) {
            accountMoney = accountMoney - summ * (1.01);
            System.out.println("Комиссия составила= " + summ * (0.01));
        }
        else{
            System.out.println("Недостаточно средств для снятия");
        }

    }
}
