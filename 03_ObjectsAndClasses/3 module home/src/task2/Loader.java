package task2;

public class Loader
{

    public static void main(String[] args)
    {
        double startWeight = 1;

        double vesFeed = 50; //g добавляет кошка как поест

        Cat fedor = new Cat(); // описываем кота Фёдора

        System.out.println("fedor weight " + fedor.getWeight()); // Выдаём вес фёдора и других кошек ниже
        System.out.println(); // пустая строка
        startWeight = fedor.getWeight();

        for (int i=1;i<6;i++) { fedor.feed(vesFeed); }

        fedor.kalorii(startWeight);

        System.out.println("fedor weight " + fedor.getWeight());//Проверяем нынешний вес Фёдора после мяукания
        System.out.println("Fedor съел " + fedor.weightFood() + "g"); // пустая строка
        System.out.println(); // пустая строка

        for (int i=1;i<6;i++) { fedor.pee(); }

        System.out.println();
        System.out.println("fedor weight " + fedor.getWeight());//Проверяем нынешний вес Фёдора после мяукания
        System.out.println("Fedor съел " + fedor.weightFood() + "g"); // пустая строка

    }
}