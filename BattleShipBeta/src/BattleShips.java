import java.util.Scanner;

public class BattleShips {
    public static int rows = 10;
    public static int columns = 10;
    public static int playerShips;
    public static int computerShips;
    public static String[][] grid = new String[rows][columns];
    public static int[][] wrongGuesses = new int[rows][columns];

    public void wait(int sec) {
        try {
            Thread.currentThread().sleep(sec * 1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){

        System.out.println("BATTLESHIP");

        //Create the ocean grid
        oceanGrid();

        //Deploy player’s ships
        deployPlayer();

        //Deploy computer's ships
        deployComputer();

        //Battle
        do {
            Battle();
        }while(BattleShips.playerShips != 0 && BattleShips.computerShips != 0);

        //Game over
        gameOver();
    }

    public static void oceanGrid(){
        //First section of Ocean Map
        System.out.print("  ");
        for(int i = 0; i < columns; i++)
            System.out.print(i);
        System.out.println();

        //Middle section of Ocean Map
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = " ";
                if (j == 0)
                    System.out.print(i + "|" + grid[i][j]);
                else if (j == grid[i].length - 1)
                    System.out.print(grid[i][j] + "|" + i);
                else
                    System.out.print(grid[i][j]);
            }
            System.out.println();
        }

        //Last section of Ocean Map
        System.out.print("  ");
        for(int i = 0; i < columns; i++)
            System.out.print(i);
        System.out.println();
    }

    public static void deployPlayer(){
        Scanner input = new Scanner(System.in);
        BattleShips BS = new BattleShips();

        System.out.println("\nDeploy your ships:");
        //Deploying five ships for player
        BattleShips.playerShips = 5;
        for (int i = 1; i <= BattleShips.playerShips; ) {
            System.out.print("Enter X coordinate for your " + i + " ship: ");
            int x = input.nextInt();
            System.out.print("Enter Y coordinate for your " + i + " ship: ");
            int y = input.nextInt();

            if((x >= 0 && x < rows) && (y >= 0 && y < columns) && (grid[x][y] == " "))
            {
                grid[x][y] =   "@";
                i++;
            }
            else if((x >= 0 && x < rows) && (y >= 0 && y < columns) && grid[x][y] == "@")
                System.out.println("You can't place two or more ships on the same location");
            else if((x < 0 || x >= rows) || (y < 0 || y >= columns))
                System.out.println("You can't place ships outside the " + rows + " by " + columns + " grid");
        }
        printOceanMap();
        BS.wait(5);
    }

    public static void deployComputer(){
        System.out.println("\nEnemy is deploying ships");
        //Deploying five ships for computer
        BattleShips.computerShips = 5;
        for (int i = 1; i <= BattleShips.computerShips; ) {
            int x = (int)(Math.random() * 10);
            int y = (int)(Math.random() * 10);

            if((x >= 0 && x < rows) && (y >= 0 && y < columns) && (grid[x][y] == " "))
            {
                grid[x][y] =   "x";
                System.out.println(i + ". ship DEPLOYED");
                i++;
            }
        }
        printOceanMap();

    }

    public static void Battle(){
        playerTurn();
        computerTurn();

        printOceanMap();

        System.out.println();
        System.out.println("Your ships: " + BattleShips.playerShips + " | Enemy ships: " + BattleShips.computerShips);
        System.out.println();
    }

    public static void playerTurn(){
        BattleShips BS = new BattleShips();
        System.out.println("\nYOUR TURN");
        int x = -1, y = -1;
        do {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter X coordinate: ");
            x = input.nextInt();
            System.out.print("Enter Y coordinate: ");
            y = input.nextInt();

            if ((x >= 0 && x < rows) && (y >= 0 && y < columns)) //valid guess
            {
                if (grid[x][y] == "x") //if computer ship is already there; computer loses ship
                {
                    System.out.println("Boom! You sunk the ship!");
                    grid[x][y] = "!"; //Hit mark
                    --BattleShips.computerShips;
                }
                else if (grid[x][y] == "@") {
                    System.out.println("Oh no, you sunk your own ship :(");
                    grid[x][y] = "x";
                    --BattleShips.playerShips;
                    ++BattleShips.computerShips;
                }
                else if (grid[x][y] == " ") {
                    System.out.println("Sorry, you missed");
                    grid[x][y] = "-";
                }
            }
            else if ((x < 0 || x >= rows) || (y < 0 || y >= columns))  //invalid guess
                System.out.println("You can't place ships outside the " + rows + " by " + columns + " grid");
        }while((x < 0 || x >= rows) || (y < 0 || y >= columns));  //keep re-prompting till valid guess
        BS.wait(5);
    }

    public static void computerTurn(){
        BattleShips BS = new BattleShips();
        System.out.println("\nCOMPUTER'S TURN");
        //Guess co-ordinates
        int x = -1, y = -1;
        do {
            x = (int)(Math.random() * 10);
            y = (int)(Math.random() * 10);

            if ((x >= 0 && x < rows) && (y >= 0 && y < columns)) //valid guess
            {
                if (grid[x][y] == "@") //if player ship is already there; player loses ship
                {
                    System.out.println("The Computer sunk one of your ships!");
                    grid[x][y] = "x";
                    --BattleShips.playerShips;
                    ++BattleShips.computerShips;
                }
                else if (grid[x][y] == "x") {
                    System.out.println("The Computer sunk one of its own ships");
                    grid[x][y] = "!";
                }
                else if (grid[x][y] == " ") {
                    System.out.println("Computer missed");
                    //Saving missed guesses for computer
                    if(wrongGuesses[x][y] != 1)
                        wrongGuesses[x][y] = 1;
                }
            }
        }while((x < 0 || x >= rows) || (y < 0 || y >= columns));  //keep re-prompting till valid guess
        BS.wait(5);
    }

    public static void gameOver(){
        System.out.println("Your ships: " + BattleShips.playerShips + " | Computer ships: " + BattleShips.computerShips);
        if(BattleShips.playerShips > 0 && BattleShips.computerShips <= 0)
            System.out.println("YOU ARE THE VICTOR!!!");
        else
            System.out.println("YOUR OPPONENT GOT THE BEST OF YOU TODAY");
        System.out.println();
    }

    public static void printOceanMap(){
        System.out.println();
        //First section of Ocean Map
        System.out.print("  ");
        for(int i = 0; i < columns; i++)
            System.out.print(i);
        System.out.println();

        //Middle section of Ocean Map
        for(int x = 0; x < grid.length; x++) {
            System.out.print(x + "|");

            for (int y = 0; y < grid[x].length; y++){
                System.out.print(grid[x][y]);
            }

            System.out.println("|" + x);
        }

        //Last section of Ocean Map
        System.out.print("  ");
        for(int i = 0; i < columns; i++)
            System.out.print(i);
        System.out.println();
    }
}
