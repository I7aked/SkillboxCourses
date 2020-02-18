package task4;

public class Loader
{

    public static void main(String[] args)
    {


        Cat feya = new Cat(); // описываем кота
        feya.setColorCat(colorCat.BLACK); //Задаём Фее чёрный цвет
        Cat zhuzha = new Cat(); // описываем кота
        zhuzha.setColorCat(colorCat.ORANGE); //Задаём Жуже оранжевый цвет

        System.out.println("Глaз У котиков примерно по  " + Cat.EYE_CAT );
        System.out.println("Минимальный вес котика " + Cat.MIN_WEIGHT); //
        System.out.println("Максимальный вес котика " + Cat.MAX_WEIGHT); //
        System.out.println();

    }
}
