public class Main {
    public static void main(String[] args) {

        Company company = new Company();

        company.hire(new Manager());
        company.hire(new Operator());
        company.hire(new TopManager());
        company.getTopSalaryStaff(3);
        System.out.println("Зарплаты трёх типов сотрудников");

        company.hireAll(180,30,2);
        System.out.println("Добавляем определённое количество операторов, менеджеров и топ менеджеров");

        company.fire(2,200);//стираем сотрудников со 2 по 200
        company.getLowestSalaryStaff(70);

    }
}
