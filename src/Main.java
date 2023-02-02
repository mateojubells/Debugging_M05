import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Tictactoe game = new Tictactoe();
        String player = "X";
        int row;

        do {
            System.out.println(game.printBoard());
            System.out.println();
            row = llegirInt("enter row for " + player + " or -1 to exit: ",-1,2);
            if(row == -1)
                break;
            System.out.println("enter column for " + player + ": ");
            int column = input.nextInt();
            game.setPlay(row,  column, player);
            if(game.isGameOver()) {
                System.out.println(game.printBoard() + "\n" + "x wins!");
                break;
            }
            if(player == "X") {
                player = "O";
            }
            else {
                player = "X";
            }
        }while(row != -1);
        System.out.println("Goodbye!..");

    }

    /**
     * This method is used to input an integer value with max and min
     * @param message to show to the user (instructions of the input)
     * @param min min accepted value
     * @param max max accepted value
     * @return returned int
     */
    private static int llegirInt(String message, int min, int max) {
        Scanner llegir = new Scanner(System.in);
        int x = 0;
        boolean valorCorrecte = false;
        do{
            System.out.println(message);
            valorCorrecte = llegir.hasNextInt();
            if (!valorCorrecte){
                System.out.println("ERROR: Valor no enter.");
                llegir.nextLine();
            }else{ // Tinc un enter
                x = llegir.nextInt();
                llegir.nextLine();
                if (x < min || x > max){
                    System.out.println("Opció no vàlida");
                    valorCorrecte = false;
                }
            }
        }while(!valorCorrecte);

        return x;
    }

}
