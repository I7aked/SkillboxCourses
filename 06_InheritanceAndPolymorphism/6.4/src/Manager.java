public class Manager extends Company implements Emploeey {
    private double monthSalaryManager = 20000 + Math.random() * 10000;
    private double monthValueManager = 1000;

    @Override
    public double getMonthSalary() {
    return (Math.round( monthSalaryManager + monthValueManager * (0.05)));
    }

}
