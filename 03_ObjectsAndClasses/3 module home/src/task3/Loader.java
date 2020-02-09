package task3;

public class Loader
{

    public static void main(String[] args)
    {

        double vesFeed = 50; //g добавляет кошка как поест

        Cat fedor = new Cat(); // описываем кота Фёдора
        Cat logan = new Cat(); // описываем кота
        Cat stepan = new Cat(); // описываем кота
        Cat feya = new Cat(); // описываем кота
        Cat zhuzha = new Cat(); // описываем кота


        System.out.println("Количество котиков " + Cat.count); // Выдаём вес фёдора и других кошек ниже
        System.out.println(); // пустая строка

        while (zhuzha.getStatus() != "Exploded") // Условие на окончание цикла по взрыву кошки
        {
            zhuzha.feed(vesFeed); // кормим Жужу
        }
        System.out.println(); // пустая строка
        System.out.println("Количество котиков после взрыва одной" + Cat.getCount()); // Выдаём вес фёдора и других кошек ниже

        while (zhuzha.getStatus() != "Dead") // Условие на окончание цикла по взрыву кошки
        {
            zhuzha.pee(); // кормим Жужу
        }

        System.out.println(); // пустая строка
        System.out.println("Количество после смерти другой котиков " + Cat.getCount()); // Выдаём вес фёдора и других кошек ниже

    }
}
