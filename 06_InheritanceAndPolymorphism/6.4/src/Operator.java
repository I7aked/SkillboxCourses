public class Operator extends Company implements Emploeey {
    private double monthSalaryOperator = 10000;

    @Override
    public double getMonthSalary() {
        return monthSalaryOperator;
    }
}
