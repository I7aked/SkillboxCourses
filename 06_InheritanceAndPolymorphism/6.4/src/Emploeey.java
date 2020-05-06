public interface Emploeey {

    double getMonthSalary();
    default double getSaleProduct()
    {
        return 0;
    }


}
