import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] gameBoard = new char[3][3];
        int continueGame = 0; // 0 error; 1 continue game; 2 exit game


        // Assigns initial spaces to game board
        Engine.clearBoard(gameBoard);

        while (continueGame != 2) {
            System.out.print("Input command: ");
            String menuInput = scanner.nextLine();
            String[] splitMenuInput = menuInput.split(" ");
            continueGame = Engine.checkIfContinuePlay(splitMenuInput);

            if (continueGame == 1) {
                Engine.clearBoard(gameBoard);
                Engine.playGame(gameBoard, splitMenuInput[1],splitMenuInput[2]);
            }

        }

    }

}