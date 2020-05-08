public class TopManager  implements Emploeey {
    private final double monthSalaryTopManager;
    private final Company company;

    public TopManager( Company company)

    {
      monthSalaryTopManager = 50000;
      this.company = company;
    }

    @Override
    public double getMonthSalary()
    {
        if (!getMonthValueTopManager() ){
          return   monthSalaryTopManager ;
        }
        else {
            return monthSalaryTopManager * (2.5);
        }
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
