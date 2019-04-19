import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Numele primului jucator");
        String player1Name = scanner.nextLine();
        System.out.println("Numee celui de al 2-lea jucator");
        String player2Name = scanner.nextLine();
        Player player1 = new Player(player1Name);
        Player player2 = new Player(player2Name);
        MyTicTacToc myTicTacToc = new MyTicTacToc(player1, player2);
        myTicTacToc.playGame();
        boolean playGame = true;
        while (playGame) {
            myTicTacToc.playGame();
            System.out.println("doriti sa incepeti un joc nou ? please answer with yes or no");
            String playAnotherGame = scanner.nextLine().trim().toLowerCase();
            if (playAnotherGame.equals("yes")) {
                playGame = true;
            } else if (playAnotherGame.equals("no")) {
                playGame = false;
            } else {
                System.out.println("not a valid answer , please answer with yes or no");
                playGame = false;
            }
        }
    }
}


