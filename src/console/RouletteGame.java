package console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
public class RouletteGame {

    public static void main(String[] args) {

        Scanner input = new Scanner (System.in);

        System.out.println("Welcome to the Roulette Game!");
        System.out.println("The payout of winning bets are 1:1 for color bets and 35:1 for number bets.");

        System.out.println("Enter your name");
        String name = input.nextLine();

        System.out.println("Enter your age");
        int age = input.nextInt();

        System.out.println("How much money do you want your starting amount to be?");
        int startAmount = input.nextInt();

        System.out.println("Okay, " + name + " lets get ready to play some Roulette! \n");
        System.out.println("---------------------------");
        
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Black");

        for (String str : colors) {
          System.out.println(str);

        
        int randomNum = (int) Math.random();
        
        Random randomNum = new Random();
        int randomNum = randomNum.nextInt(37);
        System.out.println(randomNum);

        while(true) {
            System.out.println("Place your bets (The maximum you can bet is $50)\n");

            int bet = input.nextInt();

            if(bet > 50) {
                System.out.println("You cannot bet over $50");
            }

            System.out.println("Enter 1 to choose RED, Enter 2 to choose BLACK, or 3 to choose a number!(If you choose a number, it has to be between -1 and 36 inclusive)");
            int chosenNumber = input.nextInt();

            if(chosenNumber == 1) {
                System.out.println("Bets for this round:");
                System.out.println("--------------------");
                System.out.println("You chose the color Red, and bet $" + bet + " this round.");
            }
        }

    }

}
}