public class Operator extends Company implements Emploeey {
    private final double monthSalaryOperator;

    public Operator()
    {
        monthSalaryOperator =  Math.round( 1000 + Math.random() * 10000);
    }

    @Override
    public double getMonthSalary() {
        return monthSalaryOperator;
    }

    @Override
    public double getSaleProduct(){
        return 0;}
}
