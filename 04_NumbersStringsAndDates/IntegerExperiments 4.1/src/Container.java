public class Container
{
    public int count;
    public Integer number;


    public  Integer sumDigits(Integer number)
    {
        this.number = number;
        int summ = 0;
        String digits = Integer.toString(number);
        Character character =  digits.charAt(0);

        System.out.println("character=" + Character.getNumericValue(character));
        summ = summ + Character.getNumericValue(character);
       // digit = number.toString();
        //number = 0;

        for (int i = 1; i <= 2; i++)
        {
            character =  digits.charAt(i);
            System.out.println("character=" + Character.getNumericValue(character));
            summ = summ + Character.getNumericValue(character);
        }

        number = summ;
        return number;
    }

}