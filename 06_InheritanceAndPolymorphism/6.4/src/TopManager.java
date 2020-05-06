public class TopManager  implements Emploeey {
    private double monthSalaryTopManager;
    private final Company company;

    public TopManager( Company company)

    {
      monthSalaryTopManager = 50000;
      this.company = company;
    }

    @Override
    public double getMonthSalary()
    {
        if (getMonthValueTopManager() && monthSalaryTopManager!= 125000 ){
            monthSalaryTopManager = monthSalaryTopManager * 2.5;
        }
        return monthSalaryTopManager;
    }

    public boolean getMonthValueTopManager()
    {
        return getCompany().getIncome() > 1000000;
    }

    public Company getCompany()
    {
        return company;
    }

}
