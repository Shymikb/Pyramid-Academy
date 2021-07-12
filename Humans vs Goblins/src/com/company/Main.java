package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static char[][] land;


    static ArrayList<Integer> humanPositions = new ArrayList<Integer>();
    static ArrayList<Integer> goblinPositions = new ArrayList<Integer>();
    public static String userAnswer;
    public static String result;
    public static int humanEnergy;
    public static int goblinEnergy;

    public static void main(String[] args) {

        do {
            humanPositions = new ArrayList<Integer>();
            goblinPositions = new ArrayList<Integer>();
            humanEnergy = 10;
            goblinEnergy = 10;

            System.out.println("====================");
            System.out.println("Humans vs Goblins");
            System.out.println("====================");
            System.out.println("This game uses the cardinal compass for movement");
            System.out.println("                 n\n" +
                    "               w + e\n" +
                    "                 s");

            land = new char[][]
                    {{' ', ' ', ' ', '0', ' ', '1', ' ', '2', ' ', '3', ' ', '4', ' ', '5', ' ', '6', ' ', '7', ' ', '8', ' ', '9'},
                            {'0', ' ', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.'},
                            {'1', ' ', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.'},
                            {'2', ' ', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.'},
                            {'3', ' ', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.'},
                            {'4', ' ', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.'},
                            {'5', ' ', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.'},
                            {'6', ' ', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.'},
                            {'7', ' ', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.'},
                            {'8', ' ', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.'},
                            {'9', ' ', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.'}};


            Random rand = new Random();
            int humanPos = rand.nextInt(100) + 1;
            placePiece(land, humanPos, "human");



            rand = new Random();
            int goblinPos = rand.nextInt(100) + 1;
            placePiece(land, goblinPos, "goblin");
            printGameBoard(land);

            System.out.println("\nLet's Play!\n" + "Human(H) and Goblin(G)\n" + "You are the playing as the Human\n" + "Survive the Goblin attack!!!");

            while (true) {


                land = new char[][]
                        {{' ', ' ', ' ', '0', ' ', '1', ' ', '2', ' ', '3', ' ', '4', ' ', '5', ' ', '6', ' ', '7', ' ', '8', ' ', '9'},
                                {'0', ' ', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.'},
                                {'1', ' ', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.'},
                                {'2', ' ', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.'},
                                {'3', ' ', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.'},
                                {'4', ' ', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.'},
                                {'5', ' ', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.'},
                                {'6', ' ', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.'},
                                {'7', ' ', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.'},
                                {'8', ' ', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.'},
                                {'9', ' ', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.'}};


                System.out.println("    # (Human Energy: " + humanEnergy + ")\n" +
                        "    @ (Goblin Energy: " + goblinEnergy + ")");


                humanPositions = new ArrayList<Integer>();
                goblinPositions = new ArrayList<Integer>();


                Scanner scan = new Scanner(System.in);
                System.out.println("Next Move? (n/s/e/w)");
                char nextHumanPos = scan.next().charAt(0);

                if (nextHumanPos == 'n') {
                    humanPos = humanPos - 10;
                    if (humanPos < 1) {
                        humanPos = humanPos + 100;

                    }

                } else if (nextHumanPos == 's') {
                    humanPos = humanPos + 10;
                    if (humanPos > 100) {
                        humanPos = humanPos - 100;

                    }
                } else if (nextHumanPos == 'e') {
                    humanPos = humanPos + 1;
                    if (humanPos > 100) {
                        humanPos = humanPos + 100;

                    }
                } else if (nextHumanPos == 'w') {
                    humanPos = humanPos - 1;
                    if (humanPos < 1) {
                        humanPos = humanPos + 100;

                    }

                }

                while (humanPositions.contains(humanPos) || goblinPositions.contains(humanPos) ||
                        humanPos - goblinPos == 1 || goblinPos - humanPos == 1 || humanPos - goblinPos == 10 || goblinPos - humanPos == 10) {
                    System.out.println("Human and goblin collied. The Battle Begins!");
                    int min = 1;
                    int max = 10;
                    int randomHumanPower = (int) (Math.random() * (max - min)) + min;
                    System.out.println("Human's power is" + randomHumanPower + ".");

                    int randomGoblinPower = (int) (Math.random() * (max - min)) + min;
                    System.out.println("goblin's power is" + randomGoblinPower + ".");

                    if (randomHumanPower > randomGoblinPower) {
                        System.out.println("=> Human won! (Human +3, goblin -5)");
                        humanEnergy = humanEnergy + 3;
                        goblinEnergy = goblinEnergy - 5;
                        break;
                    } else if (randomHumanPower < randomGoblinPower) {
                        System.out.println("=> Goblin won! (Human -5, goblin +3)");
                        humanEnergy = humanEnergy - 5;
                        goblinEnergy = goblinEnergy + 3;
                        break;
                    } else if (randomHumanPower == randomGoblinPower) {
                        System.out.println("=> DRAW!");
                        break;
                    }
                }

                placePiece(land, humanPos, "human");


                String result = checkWinner();
                if (result.length() > 0) {
                    System.out.println(result);
                    break;
                }

                Random random = new Random();
                String nextGoblinPosString = "nesw";
                int randomInt = random.nextInt(nextGoblinPosString.length());
                char nextGoblinPos = nextGoblinPosString.charAt(randomInt);

                if (nextGoblinPos == 'n') {
                    goblinPos = goblinPos - 10;
                    if (goblinPos < 1) {
                        goblinPos = goblinPos + 100;

                    }

                } else if (nextGoblinPos == 's') {
                    goblinPos = goblinPos + 10;
                    if (goblinPos < 100) {
                        goblinPos = goblinPos + 100;

                    }
                } else if (nextGoblinPos == 'e') {
                    goblinPos = goblinPos + 1;
                    if (goblinPos < 100) {
                        goblinPos = goblinPos + 100;

                    }
                } else if (nextGoblinPos == 'w') {
                    goblinPos = goblinPos - 1;
                    if (goblinPos < 1) {
                        goblinPos = goblinPos + 100;

                    }

                }

                while (humanPositions.contains(goblinPos) || goblinPositions.contains(goblinPos) ||
                        humanPos - goblinPos == 1 || goblinPos - humanPos == 1 || humanPos - goblinPos == 10 || goblinPos - humanPos == 10) {
                    System.out.println("Human and goblin collied. The Battle Begins!");
                    int min = 1;
                    int max = 10;
                    int randomHumanPower = (int) (Math.random() * (max - min)) + min;
                    System.out.println("Human's power is " + randomHumanPower + ".");

                    int randomGoblinPower = (int) (Math.random() * (max - min)) + min;
                    System.out.println("goblin's power is " + randomGoblinPower + ".");

                    if (randomHumanPower > randomGoblinPower) {
                        System.out.println("=> Human won! (Human +3, goblin- 5)");
                        humanEnergy = humanEnergy + 3;
                        goblinEnergy = goblinEnergy - 5;
                        break;
                    } else if (randomHumanPower < randomGoblinPower) {
                        System.out.println("=> Goblin won! (Human -5, goblin +3)");
                        humanEnergy = humanEnergy - 5;
                        goblinEnergy = goblinEnergy + 3;
                        break;
                    } else if (randomHumanPower == randomGoblinPower) {
                        System.out.println("=> DRAW!");
                        break;
                    }
                }

                placePiece(land, goblinPos, "goblin");
                printGameBoard(land);


                result = checkWinner();
                if (result.length() > 0) {
                    System.out.println(result);
                    break;
                }
            }

            System.out.println("Do you want to play again? (Y or N)");
            Scanner againAnswer = new Scanner(System.in);
            userAnswer = againAnswer.nextLine();

        } while (userAnswer.charAt(0) == 'y');
    }



    private static void printGameBoard(char[][] land) {

        for(char[] row : land) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    private static void placePiece(char[][] land, int pos, String user) {

        char symbol = '#';

        if(user.equals("human")){
            symbol = 'H';
            humanPositions.add(pos);
        } else if (user.equals("goblin")){
            symbol = 'G';
            goblinPositions.add(pos);
        }

        switch(pos) {
            case 1:
                land[1][3] = symbol;
                break;
            case 2:
                land[1][5] = symbol;
                break;
            case 3:
                land[1][7] = symbol;
                break;
            case 4:
                land[1][9] = symbol;
                break;
            case 5:
                land[1][11] = symbol;
                break;
            case 6:
                land[1][13] = symbol;
                break;
            case 7:
                land[1][15] = symbol;
                break;
            case 8:
                land[1][17] = symbol;
                break;
            case 9:
                land[1][19] = symbol;
                break;
            case 10:
                land[1][21] = symbol;
                break;

            case 11:
                land[2][3] = symbol;
                break;
            case 12:
                land[2][5] = symbol;
                break;
            case 13:
                land[2][7] = symbol;
                break;
            case 14:
                land[2][9] = symbol;
                break;
            case 15:
                land[2][11] = symbol;
                break;
            case 16:
                land[2][13] = symbol;
                break;
            case 17:
                land[2][15] = symbol;
                break;
            case 18:
                land[2][17] = symbol;
                break;
            case 19:
                land[2][19] = symbol;
                break;
            case 20:
                land[2][21] = symbol;
                break;


            case 21:
                land[3][3] = symbol;
                break;
            case 22:
                land[3][5] = symbol;
                break;
            case 23:
                land[3][7] = symbol;
                break;
            case 24:
                land[3][9] = symbol;
                break;
            case 25:
                land[3][11] = symbol;
                break;
            case 26:
                land[3][13] = symbol;
                break;
            case 27:
                land[3][15] = symbol;
                break;
            case 28:
                land[3][17] = symbol;
                break;
            case 29:
                land[3][19] = symbol;
                break;
            case 30:
                land[3][21] = symbol;
                break;


            case 31:
                land[4][3] = symbol;
                break;
            case 32:
                land[4][5] = symbol;
                break;
            case 33:
                land[4][7] = symbol;
                break;
            case 34:
                land[4][9] = symbol;
                break;
            case 35:
                land[4][11] = symbol;
                break;
            case 36:
                land[4][13] = symbol;
                break;
            case 37:
                land[4][15] = symbol;
                break;
            case 38:
                land[4][17] = symbol;
                break;
            case 39:
                land[4][19] = symbol;
                break;
            case 40:
                land[4][21] = symbol;
                break;


            case 41:
                land[5][3] = symbol;
                break;
            case 42:
                land[5][5] = symbol;
                break;
            case 43:
                land[5][7] = symbol;
                break;
            case 44:
                land[5][9] = symbol;
                break;
            case 45:
                land[5][11] = symbol;
                break;
            case 46:
                land[5][13] = symbol;
                break;
            case 47:
                land[5][15] = symbol;
                break;
            case 48:
                land[5][17] = symbol;
                break;
            case 49:
                land[5][19] = symbol;
                break;
            case 50:
                land[5][21] = symbol;
                break;


            case 51:
                land[6][3] = symbol;
                break;
            case 52:
                land[6][5] = symbol;
                break;
            case 53:
                land[6][7] = symbol;
                break;
            case 54:
                land[6][9] = symbol;
                break;
            case 55:
                land[6][11] = symbol;
                break;
            case 56:
                land[6][13] = symbol;
                break;
            case 57:
                land[6][15] = symbol;
                break;
            case 58:
                land[6][17] = symbol;
                break;
            case 59:
                land[6][19] = symbol;
                break;
            case 60:
                land[6][21] = symbol;
                break;



            case 61:
                land[7][3] = symbol;
                break;
            case 62:
                land[7][5] = symbol;
                break;
            case 63:
                land[7][7] = symbol;
                break;
            case 64:
                land[7][9] = symbol;
                break;
            case 65:
                land[7][11] = symbol;
                break;
            case 66:
                land[7][13] = symbol;
                break;
            case 67:
                land[7][15] = symbol;
                break;
            case 68:
                land[7][17] = symbol;
                break;
            case 69:
                land[7][19] = symbol;
                break;
            case 70:
                land[7][21] = symbol;
                break;



            case 71:
                land[8][3] = symbol;
                break;
            case 72:
                land[8][5] = symbol;
                break;
            case 73:
                land[8][7] = symbol;
                break;
            case 74:
                land[8][9] = symbol;
                break;
            case 75:
                land[8][11] = symbol;
                break;
            case 76:
                land[8][13] = symbol;
                break;
            case 77:
                land[8][15] = symbol;
                break;
            case 78:
                land[8][17] = symbol;
                break;
            case 79:
                land[8][19] = symbol;
                break;
            case 80:
                land[8][21] = symbol;
                break;



            case 81:
                land[9][3] = symbol;
                break;
            case 82:
                land[9][5] = symbol;
                break;
            case 83:
                land[9][7] = symbol;
                break;
            case 84:
                land[9][9] = symbol;
                break;
            case 85:
                land[9][11] = symbol;
                break;
            case 86:
                land[9][13] = symbol;
                break;
            case 87:
                land[9][15] = symbol;
                break;
            case 88:
                land[9][17] = symbol;
                break;
            case 89:
                land[9][19] = symbol;
                break;
            case 90:
                land[9][21] = symbol;
                break;



            case 91:
                land[10][3] = symbol;
                break;
            case 92:
                land[10][5] = symbol;
                break;
            case 93:
                land[10][7] = symbol;
                break;
            case 94:
                land[10][9] = symbol;
                break;
            case 95:
                land[10][11] = symbol;
                break;
            case 96:
                land[10][13] = symbol;
                break;
            case 97:
                land[10][15] = symbol;
                break;
            case 98:
                land[10][17] = symbol;
                break;
            case 99:
                land[10][19] = symbol;
                break;
            case 100:
                land[10][21] = symbol;
                break;


            default:
                break;
        }

    }

    private static String checkWinner() {

        if(humanEnergy <=0) {

            return "Human Energy: " + humanEnergy + "\n" +
                    "Goblin Energy: " + goblinEnergy + "\n" +
                    "Goblin won!\n" + "========= Game Over ==========";

        } else if (goblinEnergy <=0) {

            return "Human Energy: " + humanEnergy + "\n" +
                    "Goblin Energy: " + goblinEnergy + "\n" +
                    "Human won!\n" + "========= Game Over ==========";
        }
        return "";
    }
}
