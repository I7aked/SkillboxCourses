public class Loader
{
    public static void main(String[] args)
    {
        String text = "Вася заработал 5060 рублей, Петя - 7543 рубля, а Маша - 30330 рублей";
        String zpVasya = "";
        String zpMasha = "";
        int k =0;
        int summ = 0;
        int i = 0;
        int j ;


           while (text.codePointAt(i) > 58 || text.codePointAt(i) < 47)//Проверка на является ли символ не цифрой
           {
               i++; //Пока находимсяя в цикле while также накапливаем счётчик
           }
           j = i;

           while (text.codePointAt(j) < 58 && text.codePointAt(j) > 47)//Проверка на является ли символ цифрой
            {
            j++; //Пока находимсяя в цикле while также накапливаем счётчик
             }
                zpVasya = text.substring(i,j);

           i = text.length()-1;

        while (text.codePointAt(i) > 58 || text.codePointAt(i) < 47)//Проверка на является ли символ не цифрой
            {
                i--; //Пока находимсяя в цикле while также накапливаем счётчик
          }

        j = i;

        while (text.codePointAt(j) < 58 && text.codePointAt(j) > 47)//Проверка на является ли символ цифрой
         {
             j--; //Пока находимсяя в цикле while также накапливаем счётчик
         }
        zpMasha = text.substring(j+1,i+1);
        summ = Integer.parseInt(zpVasya)+Integer.parseInt(zpMasha);
        System.out.println(summ);
    }


}