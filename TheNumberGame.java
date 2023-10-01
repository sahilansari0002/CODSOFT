/**
 * Program: The Number Guessing Game
 * Developer: Sahil Ali
 * Project: Codsoft Internship Task
 * Date Created: September 15, 2023
 *
 */
import java.util.Random;
import java.util.Scanner;

public class TheNumberGame {

    public static void main(String[] args) 
	{
        Scanner input = new Scanner(System.in);
        Random anything = new Random();

        int low = 1;
        int high= 100;
        int chances = 10;
        int win = 0;

        System.out.println("Welcome, daring soul, to the labyrinth of numerical mysteries, where Numbers Whisper Secrets.");
        boolean onemore = true;

        while (onemore) {
            int aim = anything.nextInt(high - low + 1) + low;
            int attempts = 0;
            boolean roundWon = false;

            System.out.println("Join us as we venture deep into the world of numbers, unraveling the enigma of The Hidden Spectrum Between 1 and 100.");
            
            while (attempts < chances) {
                System.out.print("Prepare to shape the unfolding narrative with Your Key to Revelation.\n Enter the Guessing Realm: ");
                int no = input.nextInt();
                attempts++;

                if (no < aim) {
                    System.out.println("Sky's the Limit: Try a Larger Number...");
                } else if (no > aim) {
                    System.out.println("Narrow Your Aim: Try a Smaller Number...");
                } else {
                    System.out.println("Well Done! You've Revealed the Secret Number. " + aim + " in " + attempts + " attempts.");
                    win++;
                    roundWon = true;
                    break;
                }
            }

            if (!roundWon) {
                System.out.println("Oh no, no more tries left! The accurate number was... " + aim );
            }

            System.out.print("In the mood for another round? (yes/no): ");
            String onemoreInput = input.next().toLowerCase();
            onemore = onemoreInput.equals("yes");
        }

        System.out.println("Appreciate your participation! You're the winner! Don't forget to come back to Codsoft... " + win + " round(s).");
        input.close();
    }
}
