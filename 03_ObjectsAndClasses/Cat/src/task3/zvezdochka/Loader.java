package task3.zvezdochka;

public class Loader
{

    public static void main(String[] args)
    {

        double vesFeed = 100; //g добавляет кошка как поест

        Cat fedor = new Cat(); // описываем кота Фёдора
        Cat logan = new Cat(); // описываем кота
        Cat stepan = new Cat(); // описываем кота
        Cat zhuzha = new Cat(); // описываем кота
        Cat feya = new Cat(); // описываем кота

        System.out.println(zhuzha.getWeight());
        System.out.println(feya.getWeight()); // Выдаём вес фёдора и других кошек ниже
        System.out.println(); // пустая строка

        for (int i = 1; i < 50; i++ ) // Счётчик для кормёшки кошки
        {
            if (zhuzha.catAlive() == false ) { // проверка условия жизни кошки
                System.out.println("Взорвавшуюся кошку не покормить");
                break; // прерывание цикла
                }
            zhuzha.feed(vesFeed); // кормим Жужу
    }
        System.out.println("Жужа вес =" + zhuzha.getWeight()); // пустая строка
        System.out.println(); // пустая строка

        for (int i = 1; i < 50; i++ ) // Счётчик для похождений в туалет
        {
            if (feya.catAlive() == false ) // проверка условия жизни кошки
            {System.out.println("Мёртвой кошке не нужен туалет");
            break;}// прерывание цикла
            feya.pee(); // туалет Феи
        }
        System.out.println("Фея вес =" + feya.getWeight()); // Вес Фея
            feya.pee();
        System.out.println();
        System.out.println("Фея вес =" + feya.getWeight()); // Вес Фея

    }
}
