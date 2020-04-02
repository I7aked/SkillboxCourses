public class Matrix
{ String [][] chessBoard = new String [8][8];

    public void inizilians()
    {

        int wordChessBord = 10;
        String stroka ="";

        for (int i = 0;i < 8; i++)
        {
            switch (wordChessBord) {//определяем строки шахматной доски
                case 10:
                    stroka = "A";
                    break;
                case 11:
                    stroka = "B";
                    break;
                case 12:
                    stroka = "C";
                    break;
                case 13:
                    stroka = "D";
                    break;
                case 14:
                    stroka = "E";
                    break;
                case 15:
                    stroka = "F";
                    break;
                case 16:
                    stroka = "G";
                    break;
                default:
                    stroka = "H";
                    break;
            }

            for (int j = 0; j < 8; j++)
            {
                chessBoard[j][i] = "" + stroka + String.valueOf(8-j);
            }
            wordChessBord++;
        }
}
    public void printtt()
    {
        for (int i = 0;i < 8; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                System.out.print(chessBoard[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public void reverse()
    {
        String[][] chessBoardSecond = new String[8][8];

        for (int i = 0;i < 8; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                chessBoardSecond[7-j][i] = chessBoard[i][j];
            }
        }

        for (int i = 0;i < 8; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                chessBoard[i][j] = chessBoardSecond[i][j];
            }
        }
    }

}
