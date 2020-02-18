package task2;

public class Loader
{

    public static void main(String[] args)
    {


        double vesFeed = 50; //g добавляет кошка как поест

        Cat fedor = new Cat(); // описываем кота Фёдора

        System.out.println("fedor weight " + fedor.getWeight()); // Выдаём вес фёдора и других кошек ниже
        System.out.println(); // пустая строка


        for (int i=1;i<6;i++) { fedor.feed(vesFeed); }

        System.out.println("Fedor съел " + fedor.weightFood() + "g"); // пустая строка
        System.out.println("Fedor weight " + fedor.getWeight() + "g" ); // пустая строка


        for (int i=1;i<6;i++) { fedor.pee(); }

        System.out.println();
        System.out.println("fedor сходил в туалет на= " + fedor.getPee());//Проверяем нынешний вес Фёдора после мяукания
        System.out.println("Fedor weight " + fedor.getWeight() + "g"); // пустая строка

    }
}