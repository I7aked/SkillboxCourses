package task6;

public class Loader

{
    private double weight;
    private String catColor;
    public static void main(String[] args)
    {

        double vesFeed = 50; //g добавляет кошка как поест

        Cat fedor = new Cat(1000); // описываем кота Фёдора
        System.out.println(" Вес Фёдора " + fedor.getWeight());


        System.out.println(); // пустая строка

        Cat feya =  getKitten(1100);
        System.out.println("feya ves " + feya.getWeight()); // пустая строка

    }
    private static Cat getKitten(double weight)
    {
       return new Cat(1100);
    }
}
