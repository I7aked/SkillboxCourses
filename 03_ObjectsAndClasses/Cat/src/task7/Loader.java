package task7;

public class Loader

{
    private double weight;
    private String catColor;

    public static void main(String[] args)
    {

        Cat fedor = new Cat(1000.0,"чёрный"); // описываем кота Фёдора
        fedor.setCatColor("green");
        fedor.setWeight(1210);
        System.out.println(" Вес Фёдора " + fedor.getWeight());
        System.out.println(" Цвет Фёдора " + fedor.getCatColor());

        System.out.println();
        Cat feya = new Cat(fedor);
        System.out.println(feya.getCatColor() + " Цвет Феи");
        System.out.println(feya.getWeight() + " Вес Феи");

    }
}
