public class MyTicTacToc {

    public static final char SYMBOL_X = 'X';
    public static final char SYMBOL_0 = '0';

    public static final int GAME_SIZE = 3;



    char[][] game = new char[3][3];

    Player player1;
    Player player2;

    public MyTicTacToc(Player player1,Player player2){
        this.player1=player1;
        this.player2=player2;

    }
    public void showGame(){
        for(int i = 0; i < GAME_SIZE; i++){
            for(int j = 0; j < GAME_SIZE; j++){
                System.out.print(game[i][j] + " ");
            }
            System.out.println();
        }

    }

    public void initBoard(){
        for (int i = 0; i < GAME_SIZE; i++){
            for (int j = 0; j < GAME_SIZE; j++){
                game[i][j] = '.';

            }
        }

    }
    public boolean isWin(){
        // testez linii
        //teste coloane
        // teste diagl
        // testez diag2
        return false;

    }



    public void playGame(){
        initBoard();
        System.out.println("Incepe jocul");
        showGame();

        Player currentPlayer = player1;

        int nrMoves = 0;
        boolean isWin = false;
        while(isWin == false && nrMoves <9){

            //citesc mutare
            //valide mutare
            //efectuez mutare
            //numar mutare
            //verific starea de win

            //daca nu e win sau mai sam mutari == schimba jucatorul



        }
        //afisez mesaj castigator



    }



}
