import java.util.*;

public class Company {


    //Посчитать количество менеджеров в списке через их зарплату и условие иф
    ArrayList<Emploeey> listEmploeeys = new ArrayList<>();

    public void hire (Emploeey emploeey)//Найм одного сотрудника

    {
        listEmploeeys.add(emploeey);
    }

//    public void hireAll(int countOperator, int countManager, int countTopManager)//Найм списка сотрудников. Входящие данные - список котрудников
//    //Спрашиваем количество вводимых сотрудников, реализуем через иф в консоли всё
//    {
//        for (int i = 0; i < countOperator; i++)
//        {
//            listEmploeeys.add(new Operator());
//        }
//
//        for (int j = 0; j < countManager; j++)
//        {
//            listEmploeeys.add(new Manager());
//        }
//
//        for (int k = 0; k < countTopManager; k++)
//        {
//            listEmploeeys.add(new TopManager());
//        }
//    }

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
        setListSalaryEmploeey(salaryEmploeey);//добавление списка зарплат
        Collections.sort(salaryEmploeey);//сортировка листа с зарплатами
        Collections.reverse(salaryEmploeey);//разворачиваем список в обратном порядке
        soutSalaryList(count, salaryEmploeey);//распечатка заданного количества элементов
    }

    public void getLowestSalaryStaff(int count)//выдаёт количество сотрудников по возрастанию зп
    {
        ArrayList<Double> salaryEmploeey = new ArrayList<>();
        setListSalaryEmploeey(salaryEmploeey);//добавление списка зарплат
        Collections.sort(salaryEmploeey);//сортировка листа с зарплатами
        soutSalaryList(count, salaryEmploeey);//распечатка заданного количества элементов

    }

     public int getListEmploeeysSize()
     {
      return listEmploeeys.size();
     }

     private void setListSalaryEmploeey(ArrayList<Double> salaryEmploeey)
     {
         for (Emploeey emploeey:listEmploeeys)
         {
             salaryEmploeey.add(emploeey.getMonthSalary());//заполняем лист зарплатами
         }
     }

     private void soutSalaryList(int count, ArrayList<Double> salaryEmploeey)
     {
        int numberNumber = 0;
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


}
