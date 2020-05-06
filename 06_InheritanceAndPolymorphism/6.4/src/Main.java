public class Main {
    public static void main(String[] args) {

        Company company = new Company();

        company.hire(new Manager());
        company.hire(new Operator());
        company.hire(new TopManager(company));
        company.getTopSalaryStaff(3);
        System.out.println("Зарплаты трёх типов сотрудников");
        System.out.println(company.getIncome());
        System.out.println("+++++++++++++");

        company.hire(new Manager());
        company.hire(new Manager());
        company.hire(new Manager());
        company.hire(new Manager());
        company.hire(new Manager());
        company.hire(new Manager());
        company.hire(new Manager());
        company.hire(new Manager());
        company.hire(new Manager());
        company.hire(new Manager());
        company.hire(new Manager());
        company.hire(new Manager());

        company.hire(new TopManager(company));
        System.out.println(company.getIncome());

        System.out.println("+++++++++++++");

        company.getTopSalaryStaff(3);


//        company.hireAll(10,130,2);
//        System.out.println("Добавляем определённое количество операторов, менеджеров и топ менеджеров");

//        company.getTopSalaryStaff(8);

//        company.fire(2,200);
//        company.getLowestSalaryStaff(70);

    }
}
