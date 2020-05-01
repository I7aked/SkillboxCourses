public class TopManager  extends Company implements Emploeey {
    private double monthSalaryTopManager = 30000;

    @Override
    public double getMonthSalary() {
        if (getIncome() > 10000000){
            return (monthSalaryTopManager + monthSalaryTopManager * (1.5));}
        else {
            return monthSalaryTopManager;
        }
    }


}
