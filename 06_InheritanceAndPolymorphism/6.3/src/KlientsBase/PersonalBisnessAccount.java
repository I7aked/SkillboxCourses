package KlientsBase;

public class PersonalBisnessAccount  extends Client{

    public PersonalBisnessAccount() {
    super();
    }

    @Override
    public void replenishmentMoney(double summ) {
//        super.replenishmentMoney(summ);
       if (summ<1000)
       {
        accountMoney = accountMoney + summ * (0.99);
       }
       else {
         accountMoney = accountMoney + summ * (0.995);
       }

    }
}
