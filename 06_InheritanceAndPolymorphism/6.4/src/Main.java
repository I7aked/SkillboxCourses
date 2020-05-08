import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Company company = new Company();
        ArrayList<Emploeey> listOfEmploeeys = new ArrayList<>();

        company.hire(new Manager());
        company.hire(new Operator());
        company.hire(new TopManager(company));
        company.getTopSalaryStaff(3);
        System.out.println("Зарплаты трёх типов сотрудников");
        System.out.println(company.getIncome());
        System.out.println("+++++++++++++");

        for (int i = 0; i < 80; i ++) {
            listOfEmploeeys.add(new Manager());
        }

        for (int i = 0; i < 180; i ++) {
            listOfEmploeeys.add(new Operator());
        }

        for (int i = 0; i < 2; i ++) {
            listOfEmploeeys.add(new TopManager(company));
        }

        company.hire(new TopManager(company));
        System.out.println(company.getIncome());

        System.out.println("+++++++++++++");

        company.getTopSalaryStaff(10);


        company.hireAll(listOfEmploeeys);
        System.out.println("Добавляем определённое количество операторов, менеджеров и топ менеджеров");

        company.getTopSalaryStaff(8);
        System.out.println("+++++++++++++");
        company.fire(2,150);
        company.getLowestSalaryStaff(60);

    }
}
