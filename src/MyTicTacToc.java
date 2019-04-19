import java.util.Scanner;
public class MyTicTacToc {
    public static final char SYMBOL_X = 'X';
    public static final char SYMBOL_0 = '0';
    public static final int GAME_SIZE = 3;
    char[][] game = new char[3][3];
    Player player1;
    Player player2;
    public MyTicTacToc(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }
    public void showGame() {
        for (int i = 0; i < GAME_SIZE; i++) {
            for (int j = 0; j < GAME_SIZE; j++) {
                System.out.print(game[i][j] + " ");
            }
            System.out.println();
        }
    }
    public void initBoard() {
        for (int i = 0; i < GAME_SIZE; i++) {
            for (int j = 0; j < GAME_SIZE; j++) {
                game[i][j] = '.';
            }
        }
    }
    public Move readMove() {
        Scanner s = new Scanner(System.in);
        String mymove = s.nextLine();
        System.out.println("Next move:");
        String[] split = mymove.split("-");
        int line = Integer.valueOf(split[0]);
        int col = Integer.valueOf(split[1]);
        Move m = new Move(line, col);
        return m;
    }
    public void makeMove(Move move, char symbol) {
        game[move.line][move.col] = symbol;
    }
    public boolean isWinLine(int line, char symbol) {
        boolean isWin = true;
        int i = 0;
        while (i < GAME_SIZE && isWin == true) {
            if (game[line][i] != symbol) {
                isWin = false;
            }
            i++;
        }
        return isWin;
    }
    public boolean isWinCol(int col, char symbol) {
        boolean isWin = true;
        int i = 0;
        while (i < GAME_SIZE && isWin == true) {
            if (game[i][col] != symbol) {
                isWin = false;
            }
            i++;
        }
        return isWin;
    }
    public boolean isWinDiag1(char symbol) {
        boolean isWin = true;
        int i = 0;
        while (i < GAME_SIZE && isWin == true) {
            if (game[i][i] != symbol) {
                isWin = false;
            }
            i++;
        }
        return isWin;
    }
    public boolean isWinDiag2(char symbol) {
        boolean isWin = true;
        int i = 0;
        while (i < GAME_SIZE && isWin == true) {
            if (game[i][GAME_SIZE - i - 1] != symbol) {
                isWin = false;
            }
            i++;
        }
        return isWin;
    }
    public boolean isWin(Move move, char symbol) {
        boolean isWin = false;
        // testez linii
        isWin = isWinLine(move.line, symbol);

        if (isWin == false) {
            //teste coloane
            isWin = isWinCol(move.col, symbol);
        }
        if (isWin == false && move.line == move.col) {
            // teste diagl
            isWin = isWinDiag1(symbol);
        }
        if (isWin == false && move.line == GAME_SIZE - move.col - 1) {
            // testez diag2
            isWin = isWinDiag2(symbol);
        }
        return isWin;
    }
    public void playGame() {
        initBoard();
        System.out.println("Incepe jocul");
        showGame();
        Player currentPlayer = player1;
        char currentsymbol = SYMBOL_X;

        int nrMoves = 0;
        boolean isWin = false;
        while (isWin == false && nrMoves < GAME_SIZE * GAME_SIZE) {
            //citesc mutare
            Move move = readMove();
            System.out.println(move.line);
            System.out.println(move.col);
            //valide mutare
            //efectuez mutare
            makeMove(move, currentsymbol);
            showGame();
            //numar mutare
            nrMoves++;
            if (nrMoves >= 2 * GAME_SIZE - 1) {

                //verific starea de win
                isWin = isWin(move, currentsymbol);
            }
            //daca nu e win sau mai sam mutari == schimba jucatorul
            if (!isWin) {
                if (currentPlayer == player1) {
                    currentPlayer = player2;
                    currentsymbol = SYMBOL_0;
                } else {
                    currentPlayer = player1;
                    currentsymbol = SYMBOL_X;
                }
            }
        }
        if (isWin == true) {
            System.out.println(currentPlayer.name + " " + "Castigator Joc !");
        } else {
            System.out.println("Next Game");
        }
    }

}
//afisez mesaj castigator











