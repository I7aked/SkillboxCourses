public class Letters
{

    public static void main(String[] args)
    {
        String a ="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZП ";
        int i = 0;
        while(a.codePointAt(i) != 32 ) // Вконце списка букв поставил пробел чтоб проверять до этого значения цикл
        {

            System.out.println(a.codePointAt(i));
            i++;
        }
    }
}
