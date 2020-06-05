package Changjiang.sparsearray;

public class SparseArrayDemo {
    public static void main(String[] args) {

        //declare a chessboard
        int[][] chessBoard = new int[11][11];

        //declare a number that count valid data
        int countNum = 0;
        int count = 0;

        //initialize chessboard data
        chessBoard[2][3] = 1;
        chessBoard[3][4] = 2;
        chessBoard[4][2] = 1;

        // show the original data
        System.out.println("This is the original array");
        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard[i].length; j++) {
                if (chessBoard[i][j] != 0) {
                    countNum++;
                }
                System.out.printf("%d\t", chessBoard[i][j]);
            }

            System.out.println();
        }

        //declare sparse array
        int[][] sparseArr = new int[countNum + 1][3];

        sparseArr[0][0] = chessBoard.length;
        sparseArr[0][1] = chessBoard[0].length;
        sparseArr[0][2] = countNum;

        //put data in chessboard into sparse array
        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard[i].length; j++) {
                if (chessBoard[i][j] != 0) {

                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessBoard[i][j];
                }
            }
        }

        //show the sparse array
        System.out.println("This is the sparse array");
        for (int i = 0; i < sparseArr.length; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf("%d\t", sparseArr[i][j]);
            }
            System.out.println();
        }

        // put the sparse array's data back to a new array
        int[][] newChessboard = new int[sparseArr[0][0]][sparseArr[0][1]];

        for (int i = 1; i <= sparseArr[0][2]; i++) {
            newChessboard[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        //show new chessboard data
        System.out.println("This is the new chessboard array");
        for (int i = 0; i < newChessboard.length; i++) {
            for (int j = 0; j < newChessboard[i].length; j++) {
                if (newChessboard[i][j] != 0) {
                    countNum++;
                }
                System.out.printf("%d\t", newChessboard[i][j]);
            }

            System.out.println();
        }
    }
}
