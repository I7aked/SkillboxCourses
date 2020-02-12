package task6;

public class Loader
{
    private double weight;

    public static void main(String[] args)
    {
        Cat fedor = new Cat(1000); // описываем кота Фёдора

        System.out.println(" Цвет Фёдора " + fedor.getCatColor(CatColor.GREY ));
        System.out.println(); // пустая строка

    }

}
