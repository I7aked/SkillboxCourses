import java.util.Scanner;

public class Third
{

    public static void main(String[] args) {


        System.out.println("Введите количество элементов матрицы в новой строке");
        Scanner scanner = new Scanner(System.in) ;
        int kolichestvoIteracii = scanner.nextInt();
        int [][] matrix = new int [kolichestvoIteracii][kolichestvoIteracii];

    for (int i = 0; i < kolichestvoIteracii; i++)//определяем цикл по строкам
    {
        for (int j = 0; j <kolichestvoIteracii; j++)// определяем цикл по столбцам
        {
            if (i == j || (i+j+1) == (kolichestvoIteracii) )// условие на главную и побоную диагональ
                {
                    System.out.print("X");
                }
            else
                {
                    System.out.print(" ");
                }

        }
        System.out.println();
    }

    }
}
