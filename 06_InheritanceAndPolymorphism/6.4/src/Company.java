import java.util.*;

public class Company {


    ArrayList<Emploeey> listEmploeeys = new ArrayList<>();

    public void hire (Emploeey emploeey)//Найм одного сотрудника

    {
        listEmploeeys.add(emploeey);
    }

    public void hireAll(ArrayList<Emploeey> emploeeyList)//Найм списка сотрудников. Входящие данные - список котрудников
    {
      listEmploeeys.addAll(emploeeyList);
    }

    public void fire(int firstIndex, int secondIndex)//Увольнение сотрудника
    //Стираем сотрудников в этом диапазоне нашего Аррай лис
    {
        if (secondIndex >= firstIndex + 1) {
            listEmploeeys.subList(firstIndex + 1, secondIndex + 1).clear();
        }
    }

    public double getIncome()//доход компании, метод возвращающий прибыль, считающий прибыль приносимую каждым сотрудника
    {
        //доход компании
        double profitMoneyCompany = 0;
        for (Emploeey listEmploeey : listEmploeeys)
        {
            profitMoneyCompany = profitMoneyCompany + listEmploeey.getSaleProduct();
        }
        return profitMoneyCompany;
    }

    public void getTopSalaryStaff(int count)//выдаёт количество сотрудников по убыванию зп
    {
        List<Emploeey> listEmploeeysSorted = new ArrayList<>();
        listEmploeeys.sort(Comparator.comparing(Emploeey::getMonthSalary));//сортировка листа с зарплатами
        Collections.reverse(listEmploeeys);//разворачиваем список в обратном порядке
        listEmploeeysSorted = soutSalaryList(count, listEmploeeys);//формируем список с необходимым для печати количеством сотрудников

        for (Emploeey emploeey : listEmploeeysSorted) {//распечатка заданного количества элементов
            System.out.println(emploeey.getMonthSalary());
        }
    }

    public void getLowestSalaryStaff(int count)//выдаёт количество сотрудников по возрастанию зп
    {
        List<Emploeey> listEmploeeysSorted = new ArrayList<>();
        listEmploeeys.sort(Comparator.comparing(Emploeey::getMonthSalary));//сортировка листа с зарплатами
        listEmploeeysSorted = soutSalaryList(count, listEmploeeys);//формируем список с необходимым для печати количеством сотрудников

        for (Emploeey emploeey : listEmploeeysSorted) {//распечатка заданного количества элементов
            System.out.println(emploeey.getMonthSalary());
        }
    }

     private List<Emploeey> soutSalaryList(int count, ArrayList<Emploeey> listEmploeeys)
     {
         if (count >= listEmploeeys.size() )// есди заданное число больше размера списка
         {
             return List.copyOf(listEmploeeys).subList(0,listEmploeeys.size());
         }
         else{
             return List.copyOf(listEmploeeys).subList(0, count);
         }

     }


}
