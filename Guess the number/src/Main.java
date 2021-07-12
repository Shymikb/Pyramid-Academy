import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String args[]) {
        Random random = new Random();
        Scanner input = new Scanner(System.in);
        int MIN = 1;
        int MAX = 20;
        int comp = random.nextInt(MAX - MIN + 1) + MIN;
        int num;
        int guesses = 0;
        String name = "";
        String choice = "";
        String cont = "y";

        System.out.println("Hello! What is your name? ");
        name = input.next();
        System.out.println("Well " + name + ", I am thinking of a number between 1 and 20");

        do {


            System.out.print("Take a guess: ");
            num = input.nextInt();
            guesses++;
            if (num > comp) {
                System.out.println("Your guess is too high.");
                System.out.print("Take a guess: ");
            }
            else if (num < comp){
                System.out.println("Your guess is too low.");
                System.out.print("Take a guess: ");}
            else {
                System.out.println("Good job, " + name + " ! you guessed my number in " + guesses + " guesses!");
                System.out.println("would you like to play again? (y or n)");
                choice = input.next();

                if (choice.equals(cont)){
                    comp = random.nextInt(MAX - MIN + 1) + MIN;
                }
            }
        } while (num != comp);
    }
}
