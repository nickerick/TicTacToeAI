import java.util.Random;
import java.util.Scanner;

public class Engine {

    public static void printBoard(char[][] gameBoard) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(gameBoard[i][j] + " ");
                if (j == 2) {
                    System.out.println("|");
                }
            }
        }
        System.out.println("---------");
    } // end method

    public static void clearBoard(char[][] gameBoard) { // start function
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gameBoard[i][j] = ' ';
            }
        }
    } // end method

    public static int checkIfContinuePlay(String[] splitMenuInput) {
        int continueGame = 0;
        if (splitMenuInput[0].equals("exit")) {
            continueGame = 2;
        } else if (splitMenuInput.length != 3) {
            System.out.println("Bad parameters! ");
        } else { // begin else

            if (!splitMenuInput[0].equals("start") && !splitMenuInput[0].equals("exit")) {
                System.out.println("Bad parameters!");
            } else if (!splitMenuInput[1].equals("easy") && !splitMenuInput[1].equals("user") && !splitMenuInput[1].equals("medium") && !splitMenuInput[1].equals("hard")) {
                System.out.println("Bad parameters!");
            } else if (!splitMenuInput[2].equals("easy") && !splitMenuInput[2].equals("user") && !splitMenuInput[2].equals("medium") && !splitMenuInput[2].equals("hard")) {
                System.out.println("Bad parameters!");
            } else {
                continueGame = 1;
            }

        } // end else

        return continueGame;

    } // end method

    private static boolean checkIfWinner(char[][] gameBoard) {

        boolean ifWinner = false;
        char a = gameBoard[0][0];
        char b = gameBoard[0][1];
        char c = gameBoard[0][2];
        char d = gameBoard[1][0];
        char e = gameBoard[1][1];
        char f = gameBoard[1][2];
        char g = gameBoard[2][0];
        char h = gameBoard[2][1];
        char j = gameBoard[2][2];

        if (a == b && b == c && c != ' ') {
            System.out.printf(c + " wins\n\n");
            ifWinner = true;
        } else if (d == e && e == f && f != ' ') {
            System.out.printf(f + " wins\n\n");
            ifWinner = true;
        } else if (g == h && h == j && j != ' ') {
            System.out.printf(j + " wins\n\n");
            ifWinner = true;
        } else if (a == d && d == g && g != ' ') {
            System.out.printf(g + " wins\n\n");
            ifWinner = true;
        } else if (b == e && e == h && h != ' ') {
            System.out.printf(h + " wins\n\n");
            ifWinner = true;
        } else if (c == f && f == j && j != ' ') {
            ifWinner = true;
            System.out.printf(j + " wins\n\n");
        } else if (a == e && e == j && j != ' ') {
            ifWinner = true;
            System.out.printf(j + " wins\n\n");
        } else if (c == e && e == g && g != ' ') {
            System.out.printf(g + " wins\n\n");
            ifWinner = true;
        } else if (isMovesAvailable(gameBoard) == false) {
            System.out.print("Draw\n\n");
            ifWinner = true;
        }
        return ifWinner;
    } //end method

    public static void playGame(char[][] gameBoard, String player1, String player2) {
        boolean ifWinner = false;
        Engine.printBoard(gameBoard);

        while(true) {
            if (player1.equals("user")) {
                Engine.userPlace(gameBoard, 'X');
            }
            if (player1.equals("easy")) {
                System.out.println("Making move level \"easy\" ");
                Engine.computerPlaceRandom(gameBoard, 'X');
            }
            if (player1.equals("medium")) {
                System.out.println("Making move level \"medium\" ");
                if (!Engine.playMediumComputer(gameBoard, 'X')) {
                    Engine.computerPlaceRandom(gameBoard, 'X');
                }
            }
            if (player1.equals("hard")) {
                System.out.println("Making move level \"hard\" ");
                playBestMove(gameBoard, 'X', 'O');
            }

            Engine.printBoard(gameBoard);
            ifWinner = Engine.checkIfWinner(gameBoard);
            if (ifWinner) {
                break;
            }

            if (player2.equals("user")) {
                Engine.userPlace(gameBoard, 'O');
            }
            if (player2.equals("easy")) {
                System.out.println("Making move level \"easy\" ");
                Engine.computerPlaceRandom(gameBoard, 'O');
            }
            if (player2.equals("medium")) {
                System.out.println("Making move level \"medium\" ");
                if (!Engine.playMediumComputer(gameBoard, 'O')) {
                    Engine.computerPlaceRandom(gameBoard, 'O');
                }
            }
            if (player2.equals("hard")) {
                System.out.println("Making move level \"hard\" ");
                playBestMove(gameBoard, 'O', 'X');
            }

            Engine.printBoard(gameBoard);
            ifWinner = Engine.checkIfWinner(gameBoard);
            if (ifWinner) {
                break;
            }
        }
    } // end method

    private static void userPlace(char[][] gameBoard, char player) {
        int coord1 = 0;
        int coord2 = 0;
        boolean inputValid = false;
        Scanner scanner = new Scanner(System.in);

        while (!inputValid) { // Begin while loop

            System.out.print("Enter the coordinates: ");
            String userInput = scanner.nextLine();
            try {
                coord1 = Character.getNumericValue(userInput.charAt(0));
                coord2 = Character.getNumericValue(userInput.charAt(2));
                if (coord1 > 8 || coord2 > 8) {
                    System.out.println("You should enter numbers!");
                } else if (coord1 > 3 || coord2 > 3 || coord1 < 1 || coord2 < 1){
                    System.out.println("Coordinates should be from 1 to 3!");
                } else if (gameBoard[coord1 - 1][coord2 - 1] != ' ') {
                    System.out.println("This cell is occupied!");
                } else {
                    inputValid = true;
                }
            } catch (Exception e) {
                System.out.println("You should enter numbers!");
            }

        } // End while loop

        // Placing X in appropriate location
        gameBoard[coord1 - 1][coord2 - 1] = player;

    } // end method

    private static void computerPlaceRandom(char[][] gameBoard, char player) {
        Random random = new Random();
        int coord1 = 0;
        int coord2 = 0;
        boolean inputValid = false;

        while (!inputValid) { // Begin while loop

            coord1 = random.nextInt(3);
            coord2 = random.nextInt(3);
            if (gameBoard[coord1][coord2] == ' ') {
                inputValid = true;
            }

        } // End while loop

        // Placing O in appropriate location
        gameBoard[coord1][coord2] = player;

    } //end method

    private static boolean playMediumComputer(char[][] gameBoard, char player) {

        boolean ifValidMove = true;
        char a = gameBoard[0][0];
        char b = gameBoard[0][1];
        char c = gameBoard[0][2];
        char d = gameBoard[1][0];
        char e = gameBoard[1][1];
        char f = gameBoard[1][2];
        char g = gameBoard[2][0];
        char h = gameBoard[2][1];
        char j = gameBoard[2][2];

        if (a == b && c == ' ' && a != ' ') {        // First horizontal test
            gameBoard[0][2] = player;
        } else if (a == c && b == ' ' && a != ' ') {
            gameBoard[0][1] = player;
        } else if (b == c && a == ' ' && b != ' ') {
            gameBoard[0][0] = player;
        } else if (d == e && f == ' ' && d != ' ') { // Second horizontal test
            gameBoard[1][2] = player;
        } else if (d == f && e == ' ' && d != ' ') {
            gameBoard[1][1] = player;
        } else if (e == f && d == ' ' && e != ' ') {
            gameBoard[1][0] = player;
        } else if (g == h && j == ' ' && g != ' ') { // Third horizontal test
            gameBoard[2][2] = player;
        } else if (g == j && h == ' ' && g != ' ') {
            gameBoard[2][1] = player;
        } else if (h == j && g == ' ' && h != ' ') {
            gameBoard[2][0] = player;
        } else if (a == d && g == ' ' && a != ' ') { // First vertical test
            gameBoard[2][0] = player;
        } else if (a == g && d == ' ' && a != ' ') {
            gameBoard[1][0] = player;
        } else if (d == g && a == ' ' && d != ' ') {
            gameBoard[0][0] = player;
        } else if (b == e && h == ' ' && b != ' ') { // Second vertical test
            gameBoard[2][1] = player;
        } else if (b == h && e == ' ' && b != ' ') {
            gameBoard[1][1] = player;
        } else if (e == h && b == ' ' && e != ' ') {
            gameBoard[0][1] = player;
        } else if (c == f && j == ' ' && c != ' ') { // Third vertical test
            gameBoard[2][2] = player;
        } else if (c == j && f == ' ' && c != ' ') {
            gameBoard[1][2] = player;
        } else if (f == j && c == ' ' && f != ' ') {
            gameBoard[0][2] = player;
        } else if (e == j && a == ' ' && e != ' ') { // First diagonal test
            gameBoard[0][0] = player;
        } else if (a == j && e == ' ' && a != ' ') {
            gameBoard[1][1] = player;
        } else if (a == e && j == ' ' && a != ' ') {
            gameBoard[2][2] = player;
        } else if (g == e && c == ' ' && g != ' ') { // Second diagonal test
            gameBoard[0][2] = player;
        } else if (g == c && e == ' ' && g != ' ') {
            gameBoard[1][1] = player;
        } else if (e == c && g == ' ' && e != ' ') {
            gameBoard[2][0] = player;
        } else {
            ifValidMove = false;
        }
        return ifValidMove;
    } // end method

    private static void playBestMove(char[][] gameBoard, char player, char opponent) {
        int bestVal = -1000;
        int row = -1;
        int column = -1;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameBoard[i][j] == ' ') {
                    gameBoard[i][j] = player;

                    // see how good this move is
                    int moveVal = minimax(gameBoard, 0, false, player, opponent);

                    gameBoard[i][j] = ' ';

                    if (moveVal > bestVal) {
                        row = i;
                        column = j;
                        bestVal = moveVal;
                    }
                }
            }
        }
        gameBoard[row][column] = player;

    } //end method

    private static Boolean isMovesAvailable(char[][] gameBoard) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameBoard[i][j] == ' ') {
                    return true;
                }
            }
        }
        return false;
    } // end method

    private static int minimax (char gameBoard[][], int depth, Boolean isMaxTurn, char player, char opponent) {
        int score = evaluateCurrentBoard(gameBoard, player);

        if (score == 10){
            return score;
        }
        if (score == -10) {
            return score;
        }
        if (isMovesAvailable(gameBoard) == false) {
            return 0;
        }

        // Maximizer move
        if (isMaxTurn) {
            int best = -1000;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {

                    if (gameBoard[i][j] == ' ') {
                        gameBoard[i][j] = player;

                        // Returns highest value
                        best = Math.max(best, minimax(gameBoard, depth + 1, !isMaxTurn, player, opponent));

                        gameBoard[i][j] = ' ';
                    }
                }
            }
            return best;
        }

        // Minimizer move
        else {
            int best = 1000;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {

                    if (gameBoard[i][j] == ' ') {
                        gameBoard[i][j] = opponent;

                        // Returns lowest value
                        best = Math.min(best, minimax(gameBoard, depth + 1, !isMaxTurn, player, opponent));

                        gameBoard[i][j] = ' ';
                    }
                }
            }
            return best;
        }

    } //end method

    private static int evaluateCurrentBoard(char[][] gameBoard, char player) {

        char a = gameBoard[0][0];
        char b = gameBoard[0][1];
        char c = gameBoard[0][2];
        char d = gameBoard[1][0];
        char e = gameBoard[1][1];
        char f = gameBoard[1][2];
        char g = gameBoard[2][0];
        char h = gameBoard[2][1];
        char j = gameBoard[2][2];

        if (a == b && b == c && c != ' ') {
            if (a == player) {
                return 10;
            } else {
                return -10;
            }
        } else if (d == e && e == f && f != ' ') {
            if (d == player) {
                return 10;
            } else {
                return -10;
            }
        } else if (g == h && h == j && j != ' ') {
            if (g == player) {
                return 10;
            } else {
                return -10;
            }
        } else if (a == d && d == g && g != ' ') {
            if (a == player) {
                return 10;
            } else {
                return -10;
            }
        } else if (b == e && e == h && h != ' ') {
            if (b == player) {
                return 10;
            } else {
                return -10;
            }
        } else if (c == f && f == j && j != ' ') {
            if (c == player) {
                return 10;
            } else {
                return -10;
            }
        } else if (a == e && e == j && j != ' ') {
            if (a == player) {
                return 10;
            } else {
                return -10;
            }
        } else if (c == e && e == g && g != ' ') {
            if (c == player) {
                return 10;
            } else {
                return -10;
            }
        } else {
            return 0;
        }

    } // end method


} // close class

/*

a b c  0 1 2
d e f  1
g h j  2

 */