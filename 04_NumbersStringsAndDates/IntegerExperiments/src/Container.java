public class Container
{
    public int count;
    public Integer number;
    public String stroka;

    public  Integer sumDigits(Integer number)
    {
        this.number = number;
        String digit;


        digit = number.toString();
        number = 0;
        for (int i = 0; i < digit.length(); i++)
        {
            stroka = "" + digit.charAt(i); // Нашёл такую конструкцию чтоб
            // вычленить каждую цифру и в следующей строке всё сложить
            number = number + Integer.parseInt(stroka);
        }
        return number;
    }

}