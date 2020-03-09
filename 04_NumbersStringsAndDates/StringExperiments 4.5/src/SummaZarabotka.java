public class SummaZarabotka
{
    public static void main(String[] args)
    {
        String text = "Вася заработал 5060 рублей, Петя - 7543 рубля, а Маша - 30330 рублей, Федя - 1234 рублей";
        double summ = 0;
        double schetchik =0.1;
        Character character = '1';

        String[] sentences = text.split("\\,\\s");// разбили выражение на чати, зависящие от запятой и пробела

              for (int i = 0; i < text.split("\\,\\s").length;i++)
              {
        sentences[i] = sentences[i].replaceAll("[^0-9]","");// убрали всё кроме цифр
        schetchik = schetchik * Math.pow(10,sentences[i].length()); //рассчитали количество разрядов для дальнейшего сложения

//            System.out.println(schetchik);
//            System.out.println(sentences[i]);

            for (int j =0; j < sentences[i].length();j++)
            { character = sentences[i].charAt(j); //определилил как character первый элемент разбитой нулевой строки
                summ = summ + Character.getNumericValue(sentences[i].charAt(j)) * schetchik;// суммируем всё
                schetchik = schetchik / 10;// понижаем разряды
//                System.out.println(summ);
            }
        }
System.out.println(summ);;
    }
}
