package task1;

public class Loader
{

    public static void main(String[] args)
    {
        double vesDrink = 2; // g добавляет кошка как попьёт
        double vesFeed = 5; //g добавляет кошка как по ест



        Cat fedor = new Cat(); // описываем кота Фёдора
        Cat logan = new Cat(); // описываем кота Логана
        Cat zhuzha = new Cat(); // описываем кошку Жужу
        Cat stepan = new Cat(); // описываем кота Степана
        Cat feya = new Cat(); // описываем кошку Фею

        System.out.println("fedor weight " + fedor.getWeight()); // Выдаём вес фёдора и других кошек ниже
        System.out.println("stepan weight " + stepan.getWeight());
        System.out.println("logan weight " + logan.getWeight());
        System.out.println("Жужа weight " + zhuzha.getWeight());
        System.out.println("feya weight " + feya.getWeight());
        System.out.println(); // пустая строка

        fedor.meow(); // Кот фёдор мяукает
        fedor.meow(); // Кот фёдор мяукает
        fedor.meow(); // Кот фёдор мяукает
        System.out.println("fedor weight " + fedor.getWeight());//Проверяем нынешний вес Фёдора после мяукания
        System.out.println(); // пустая строка

        stepan.drink(vesDrink); //Кот Степан пьёт
        stepan.drink(vesDrink); //Кот Степан пьёт
        System.out.println("stepan weight " + stepan.getWeight()); //Проверяем нынешний вес Stepana
        System.out.println(); // пустая строка

        logan.feed(vesFeed); // Кот Logan ест
        logan.feed(vesFeed); // Кот Logan ест
        System.out.println("logan weight " + logan.getWeight()); //Проверяем нынешний вес Logana
        System.out.println(); // пустая строка

        while (zhuzha.getStatus() != "Exploded") // Условие на окончание цикла по взрыву кошки
        {
        zhuzha.feed(vesFeed); // кормим Жужу
        }

        System.out.println("Жужа weight " + zhuzha.getWeight());
        System.out.println("Жужа " + zhuzha.getStatus());
        System.out.println(); // пустая строка

        while (feya.getStatus() != "Dead") // Условие на окончание цикла по смерти кошки
        {
            feya.meow(); // Фея мяукает
        }

        System.out.println("feya weight " + feya.getWeight());
        System.out.println("feya " + feya.getStatus() );

    }
}