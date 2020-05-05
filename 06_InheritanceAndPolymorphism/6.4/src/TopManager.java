public class TopManager  implements Emploeey {
    private double monthSalaryTopManager;
    private static boolean first;

    public TopManager()
    {
      monthSalaryTopManager = 50000;
    }

    @Override
    public double getMonthSalary()
    {
        if (getMonthValueTopManager()){
            monthSalaryTopManager = monthSalaryTopManager * 2.5;
        }
        return monthSalaryTopManager;
    }

    public boolean getMonthValueTopManager(Company company)
    {
        return company.getIncome() > 1000000;
    }



    @Override
    public double getSaleProduct(){
        return 0;}


}
