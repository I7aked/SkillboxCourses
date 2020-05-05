public class Manager implements Emploeey {
    private final double monthSalaryManager ;
    private final double saleProduct ;

    public Manager()
    {
        saleProduct = Math.round( 10000 + Math.random() * 200000);
        double monthValueManager = 1000;
        monthSalaryManager = Math.round( 11000 + Math.random() * 20000 + monthValueManager * (0.05));
    }

    @Override
    public double getMonthSalary() { return  monthSalaryManager ;  }

    @Override
    public double getSaleProduct(){return saleProduct;}



}
