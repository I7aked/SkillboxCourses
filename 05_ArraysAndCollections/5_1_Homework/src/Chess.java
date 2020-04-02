public class Chess {


    public static void main(String[] args) {

        Matrix chessBoard = new Matrix();
        chessBoard.inizilians();//Описали шахматную доску

        chessBoard.printtt();//Вывели в консоль

        chessBoard.reverse();//сделали поворот на 90 против часовой
        System.out.println();

        chessBoard.printtt();
        System.out.println();

        chessBoard.reverse();//сделали поворот на 90 против часовой
        System.out.println();

        chessBoard.printtt();
        System.out.println();

        chessBoard.reverse();//сделали поворот на 90 против часовой
        System.out.println();

        chessBoard.printtt();
        System.out.println();

        chessBoard.reverse();//сделали поворот на 90 против часовой
        System.out.println();

        chessBoard.printtt();

    }
}
