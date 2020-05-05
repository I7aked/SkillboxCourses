import java.util.*;

public class Company {


    //Посчитать количество менеджеров в списке через их зарплату и условие иф
    ArrayList<Emploeey> listEmploeeys = new ArrayList<>();

    public void hire (Emploeey emploeey)//Найм одного сотрудника

    {
        listEmploeeys.add(emploeey);
    }

    public void hireAll(int countOperator, int countManager, int countTopManager)//Найм списка сотрудников. Входящие данные - список котрудников
    //Спрашиваем количество вводимых сотрудников, реализуем через иф в консоли всё
    {
        for (int i = 0; i < countOperator; i++)
        {
            listEmploeeys.add(new Operator());
        }

        for (int j = 0; j < countManager; j++)
        {
            listEmploeeys.add(new Manager());
        }

        for (int k = 0; k < countTopManager; k++)
        {
            listEmploeeys.add(new TopManager());
        }
    }

    public void fire(int firstIndex, int secondIndex)//Увольнение сотрудника
    //Стираем сотрудников в этом диапазоне нашего Аррай лис
    //Возможно перед стиранием сотрудника, надо будет удалять его вклад в профит компании
    {
        if (secondIndex >= firstIndex + 1) {
            listEmploeeys.subList(firstIndex + 1, secondIndex + 1).clear();
        }
    }

    public double getIncome()//доход компании, метод возвращающий прибыль, считающий прибыль приносимую каждым сотрудника
    {
        //доход компании
        double profitMoneyCompany = 0;
        for (Emploeey listEmploeey : listEmploeeys) {
//            if (listEmploeeys.get(i).getMonthSalary() > 11000 && listEmploeeys.get(i).getMonthSalary() < 45000) {
            profitMoneyCompany = profitMoneyCompany + listEmploeey.getSaleProduct();
//            }
        }
        return profitMoneyCompany;
    }

    public void getTopSalaryStaff(int count)//выдаёт количество сотрудников по убыванию зп
    {
       ArrayList<Double> salaryEmploeey = new ArrayList<>();
        int numberNumber = 0;
       for (Emploeey emploeey:listEmploeeys)
       {
            salaryEmploeey.add(emploeey.getMonthSalary());//заполняем лист зарплатами
       }

        Collections.sort(salaryEmploeey);//сортировка листа с зарплатами

        if (count >= salaryEmploeey.size() )// есди заданное число больше размера списка
        {
            for (int i = salaryEmploeey.size(); i > 0; i--)
            {
                numberNumber++;
                System.out.println(numberNumber + " = " + salaryEmploeey.get(i-1));
            }
        }
        else{
            for (int i = salaryEmploeey.size(); i > salaryEmploeey.size() - count; i--)
            {
                numberNumber++;
                System.out.println( numberNumber + " = " + salaryEmploeey.get(i-1));
            }
        }
    }

    public void getLowestSalaryStaff(int count)//выдаёт количество сотрудников по возрастанию зп
    {
        ArrayList<Double> salaryEmploeey = new ArrayList<>();
        int numberNumber = 0;

        for (Emploeey emploeey:listEmploeeys)
        {
            salaryEmploeey.add(emploeey.getMonthSalary());//заполняем лист зарплатами
        }

        Collections.sort(salaryEmploeey);//сортировка листа с зарплатами

        if (count >= salaryEmploeey.size() )// есди заданное число больше размера списка
        {
            for (Double aDouble : salaryEmploeey) {
                numberNumber++;
                System.out.println(numberNumber + " = " + aDouble);
            }
        }
        else{

            for (int i = 0; i <  count; i++)
            {
                numberNumber++;
                System.out.println( numberNumber+ " = " + salaryEmploeey.get(i));
            }
        }
    }

     public int getListEmploeeysSize()
     {
      return listEmploeeys.size();
     }




}
