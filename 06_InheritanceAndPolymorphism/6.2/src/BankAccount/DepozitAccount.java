package BankAccount;

import java.util.Calendar;
import java.util.Date;



public class DepozitAccount extends RaschetAccount {

    public DepozitAccount(double accountMoney)
    {
        super(accountMoney);
    }

    @Override
    public void withdrawalMoney(double summ) {

        Calendar withdrawalAccountDate = Calendar.getInstance();
        withdrawalAccountDate.add(Calendar.MONTH,1);//Уменьшаем дату на месяц для дальшнйшего сравнения с датой поступления платежа

        if (withdrawalAccountDate.before(replenishmentAccountDate)){//Проверяется разница между датами
            System.out.println("Вы не можете снять деньга раньше месяца с момента пополнения");
        }
        else{
            accountMoney = accountMoney - summ ;
            System.out.println( "У Вас на счету =" + getAccountMoney());
        }
    }

}
