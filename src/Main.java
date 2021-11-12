import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] gameBoard = new char[3][3];
        boolean ifWinner = false;
        int continueGame = 0; // 0 error; 1 continue game; 2 exit game


        // Assigns initial spaces to game board
        Engine.clearBoard(gameBoard);

        while (continueGame != 2) {
            System.out.print("Input command: ");
            String menuInput = scanner.nextLine();
            String[] splitMenuInput = menuInput.split(" ");
            continueGame = Engine.checkIfContinuePlay(splitMenuInput);

            if (continueGame == 1) { //begin main if
                Engine.clearBoard(gameBoard);
                if (splitMenuInput[1].equals("user") && splitMenuInput[2].equals("user")) {
                    Engine.playUserUser(gameBoard);
                } else if (splitMenuInput[1].equals("easy") && splitMenuInput[2].equals("easy")) {
                    Engine.playEasyEasy(gameBoard);
                } else if (splitMenuInput[1].equals("user") && splitMenuInput[2].equals("easy")) {
                    Engine.playUserEasy(gameBoard);
                } else if (splitMenuInput[1].equals("easy") && splitMenuInput[2].equals("user")) {
                    Engine.playEasyUser(gameBoard);
                } else if (splitMenuInput[1].equals("medium") && splitMenuInput[2].equals("user")) {
                    Engine.playMediumUser(gameBoard);
                } else if (splitMenuInput[1].equals("user") && splitMenuInput[2].equals("medium")) {
                    Engine.playUserMedium(gameBoard);
                } else if (splitMenuInput[1].equals("medium") && splitMenuInput[2].equals("medium")) {
                    Engine.playMediumMedium(gameBoard);
                } else if (splitMenuInput[1].equals("medium") && splitMenuInput[2].equals("easy")) {
                    Engine.playMediumEasy(gameBoard);
                } else if (splitMenuInput[1].equals("easy") && splitMenuInput[2].equals("medium")) {
                    Engine.playEasyMedium(gameBoard);
                } else if (splitMenuInput[1].equals("user") && splitMenuInput[2].equals("hard")) {
                    Engine.playUserHard(gameBoard);
                } else if (splitMenuInput[1].equals("hard") && splitMenuInput[2].equals("user")) {
                    Engine.playHardUser(gameBoard);
                } else if (splitMenuInput[1].equals("hard") && splitMenuInput[2].equals("hard")) {
                    Engine.playHardHard(gameBoard);
                } else if (splitMenuInput[1].equals("easy") && splitMenuInput[2].equals("hard")) {
                    Engine.playEasyHard(gameBoard);
                } else if (splitMenuInput[1].equals("hard") && splitMenuInput[2].equals("easy")) {
                    Engine.playHardEasy(gameBoard);
                } else if (splitMenuInput[1].equals("medium") && splitMenuInput[2].equals("hard")) {
                    Engine.playMediumHard(gameBoard);
                } else if (splitMenuInput[1].equals("hard") && splitMenuInput[2].equals("medium")) {
                    Engine.playHardMedium(gameBoard);
                }
            } // end main if

        }

    }

}