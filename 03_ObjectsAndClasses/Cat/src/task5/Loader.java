package task5;

public class Loader

{
    private double weight;

    public static void main(String[] args)
    {

        double vesFeed = 50; //g добавляет кошка как поест

        Cat fedor = new Cat(4321 ); // описываем кота Фёдора
        System.out.println(" Вес Фёдора " + fedor.getWeight());


        System.out.println(); // пустая строка

        Cat feya =  getKitten();

        System.out.println("feya ves " + feya.getWeight()); // пустая строка
        System.out.printf("" );

    }

    private static Cat getKitten(double weight)  { return new Cat(weight);}

    private static Cat getKitten(){

        return getKitten( (1000 + 500 * Math.random()));
    }


}



