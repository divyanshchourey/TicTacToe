import java.util.Scanner;

public class TicTacToeLogic {
    public static final int X = 1;
    public static final int O = -1;
    public static final int EMPTY = 0;
    int[][] board = new int[3][3];
    int player;

    public TicTacToeLogic(){
        clearBoard();
    }

    public void clearBoard(){
        for(int i=0; i<board.length; i++)
            for(int j=0; j<board[0].length; j++)
                board[i][j] = EMPTY;

        player = X;
    }

    public void putMark(int i, int j) throws  IllegalArgumentException{
        if((i<0) || (i>2) || (j<0) || (j>2))
            throw new IllegalArgumentException("Invalid board position.");
        if(board[i][j] != EMPTY)
            throw new IllegalArgumentException("Board position occupied!");
        board[i][j] = player;
        player = -player;
    }

    public boolean isWin(int mark){
        return((board[0][0] + board[0][1] + board[0][2] == mark*3)
                ||(board[1][0] + board[1][1] + board[1][2] == mark*3)
                ||(board[2][0] + board[2][1] + board[2][2] == mark*3)
                ||(board[0][1] + board[1][1] + board[2][1] == mark*3)
                ||(board[0][2] + board[1][2] + board[2][2] == mark*3)
                ||(board[0][0] + board[1][0] + board[2][0] == mark*3)
                ||(board[0][0] + board[1][1] + board[2][2] == mark*3)
                ||(board[2][0] + board[1][1] + board[0][2] == mark*3)
        );
    }

    public boolean isTie(){
        if(isWin(X) || isWin(O))
            return false;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(board[i][j] == 0)
                    return false;
            }
        }
        return true;
    }

    public int winner(){
        if(isWin(X))
            return (X);
        else if(isWin(O))
            return (O);
        else
            return 0;
    }


    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<3; i++) {
            for (int j = 0; j < 3; j++) {
                switch (board[i][j]) {
                    case X:
                        sb.append("X");
                        break;
                    case O:
                        sb.append("O");
                        break;
                    case EMPTY:
                        sb.append(" ");
                        break;
                }
                if(j<2) sb.append("|");
            }
            if(i<2) sb.append("\n-----\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        TicTacToeLogic game = new TicTacToeLogic();
        Scanner sc = new Scanner(System.in);
        while(game.winner()==-1 || game.winner()==0 || game.winner()==1){
            System.out.println("Player: "+((game.player == X)?1:2));
            System.out.println("Enter the position: ");
            game.putMark(sc.nextInt(), sc.nextInt());
            System.out.println(game);
        }
        String[] outcome = {"Tie", "O wins", "X wins"};
        System.out.println(outcome[1+game.winner()]);
    }
}
