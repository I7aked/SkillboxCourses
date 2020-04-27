package KlientsBase;

public class PersonalBisnessAccount  extends Client{

    public PersonalBisnessAccount() {
    super();
    }

    @Override
    public void replenishmentMoney(double summ) {
       if (summ < 1000)
       {
           super.replenishmentMoney( summ * (0.99));
       }
       else {
           super.replenishmentMoney(summ * (0.995));
       }

    }
}
