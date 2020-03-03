public class Main
{
    public static void main(String[] args)
    {
        Container container = new Container();
        container.count += 691;

        System.out.println(container.count);

        Container container2 = new Container();

        System.out.println(" Сумма цифр = " + container2.sumDigits(container.count));




    }


}
