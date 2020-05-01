import java.util.*;

public class Company {

    ArrayList<Emploeey> listEmploeeys = new ArrayList<>();


    private double profitMoneyCompany = 50000000; //доход компании

    public void hire (Emploeey emploeey)//Найм одного сотрудника
    //Через консоль добавляем одного сотрудника
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
    //Стираем сотрудников в этом диапазоне нашего Аррай лист
    {
        for ( int i = secondIndex; i >  firstIndex;i-- ) {
            listEmploeeys.remove(i);
        }
    }

    public double getIncome()//доход компании
    {
        return profitMoneyCompany;
    }

    public void getTopSalaryStaff(int count)//выдаёт количество сотрудников по убыванию зп
    //Добавляем проверку задаваемого количества с фактическим количеством сотрудников
    // Реализовать через создание дополнительного List, поместив в него данные по зп
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
    //Добавляем проверку задаваемого количества с фактическим количеством сотрудников
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
            for (int i = 0; i < salaryEmploeey.size(); i++)
            {
                numberNumber++;
                System.out.println( numberNumber+ " = " + salaryEmploeey.get(i));
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
