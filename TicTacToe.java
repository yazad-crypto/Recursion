import java.util.Scanner;

public class TicTacToe {
    private char[][] board;
    private char currentPlayer;

    public TicTacToe() {
        board = new char[3][3];
        currentPlayer = 'X';
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }

        playGame();
    }

    public void playGame() {
        Scanner s = new Scanner(System.in);
        System.out.print("Choose a character (x or o): ");
        if(s.nextLine().toLowerCase().contains("x")){
            currentPlayer = 'x';
        }
        else{
            currentPlayer = 'o';
        }
        System.out.println();
        //s.close();

        playTurn();
    }

    public void playTurn(){
        int xcoord;
        int ycoord;
        Scanner sy = new Scanner(System.in);
        System.out.print("Choose a y coord: ");
        ycoord = sy.nextInt();
        //System.out.println();
        System.out.print("Choose a x coord: ");
        xcoord = sy.nextInt();

        placePiece(ycoord, xcoord);

        if(!checkWin()){
            switchPlayer();
            playTurn();
        }
    }

    public void switchPlayer(){
        if(currentPlayer == 'x'){
            currentPlayer = 'o';
        }
        else{
            currentPlayer = 'x';
        }
        System.out.println("It is " + currentPlayer + "'s turn now");
    }

    public void placePiece(int y, int x){
        board[(y-1)][(x-1)] = currentPlayer;
        printBoard();
    }

    public void printBoard(){
        for(int i = 0; i < board.length; i++){
            for(int o = 0; o < board[i].length; o++){
                System.out.print("[" + board[i][o] + "]");
            }
            System.out.println();
        }
        System.out.println();
    }

    public Boolean checkWin(){
        int row1 = 0;
        int col1 = 0;
        return (checkRow(0, 0));
    }

    public Boolean checkRow(int rowy, int coly){
        if(board[rowy][coly] == currentPlayer){
            if(rowy > 3){
                return true;
            }
            checkRow(rowy++, coly);
        }
        return false;
        //return false;
    }

    public Boolean checkCol(int row, int col){
        return false;
    }

    public Boolean checkDiag(){
        return false;
    }
}
