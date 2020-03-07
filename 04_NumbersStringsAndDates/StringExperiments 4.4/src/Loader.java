public class Loader
{
    public static void main(String[] args)
    {
        String text = "Вася заработал 5060 рублей, Петя - 7543 рубля, а Маша - 30330 рублей";
        int firstNumberZpVasya = text.indexOf('5');
        int indexMasha = text.indexOf('М');
        int firstNumberZpMasha;
        int summ = 0;
        int schetchik =1000;
        int i = firstNumberZpVasya;

           while (text.codePointAt(i) < 58 && text.codePointAt(i) > 47)//Проверка на является ли символ цифрой
           {
               summ = summ + Character.getNumericValue(text.charAt(i)) * schetchik;//Суммируются все цифры идущие подряд
              schetchik = schetchik/10;
               i++; //Пока находимсяя в цикле while также накапливаем счётчик
           }
        System.out.println(summ);

           text =   text.substring(indexMasha); // уменьшили строку до "Маша - 30300 рублей"
            firstNumberZpMasha = text.indexOf('3'); // находим первую 3 в зп Маши
           i = firstNumberZpMasha;
            schetchik = 10000;

        while (text.codePointAt(i) < 58 && text.codePointAt(i) > 47)//Проверка на является ли символ цифрой
        {
            summ = summ + Character.getNumericValue(text.charAt(i)) * schetchik;//Суммируются все цифры идущие подряд
            schetchik = schetchik/10;
            i--; //Пока находимсяя в цикле while также накапливаем счётчик
        }
        System.out.println(summ);
    }


}