import KlientsBase.CompanyBisnessAccount;
import KlientsBase.PersonalBisnessAccount;
import KlientsBase.PhysicalAccount;

public class Main {

    public static void main(String[] args) {

        PersonalBisnessAccount vasya = new PersonalBisnessAccount();
        vasya.replenishmentMoney(100);
        vasya.withdrawalMoney(50);
        System.out.println("vasya= " + vasya.getAccountMoney());

        CompanyBisnessAccount petya = new CompanyBisnessAccount();
        petya.replenishmentMoney(250);
        petya.withdrawalMoney(100);
        System.out.println("petya= " + petya.getAccountMoney());

        PhysicalAccount sasha = new PhysicalAccount();
        sasha.replenishmentMoney(200);
        sasha.withdrawalMoney(100);
        System.out.println("sasha= " + sasha.getAccountMoney());

    }
}
