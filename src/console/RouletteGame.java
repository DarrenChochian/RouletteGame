package console;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RouletteGame {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		int bet = 0;
		String str = "";
		int randomNumber = 0;
		int balance = 0;
		String color = "";

		System.out.println("Welcome to the Roulette Game!");
		System.out.println("The payout of winning bets are 1:1 for color bets and 35:1 for number bets.\n");

		System.out.println("Enter your name");
		String name = input.nextLine();

		while (balance <= 0) {

			System.out.println("How much money do you want your starting amount to be?");

			balance = input.nextInt();
			if (balance <= 0) {
				System.out.println("You can not bet a negative number");
				balance = -1;
			}
		}

		boolean playAgain = true;

		while (playAgain) {

			System.out.println("Okay, " + name + " lets get ready to play some Roulette! \n");
			System.out.println("---------------------------");

			Random random = new Random();
			randomNumber = random.nextInt(36);

			if (randomNumber == 0 || randomNumber == 1) {
				color = "GREEN";
			} else if (randomNumber % 2 == 0) {
				color = "RED";
			} else {
				color = "BLACK";
			}

			while (bet > 50 || bet <= 0) {
				System.out.println("Place your bets (The maximum you can bet is $50)\n");
				bet = input.nextInt();

				if (bet > 50) {
					System.out.println("You cannot bet over $50");
					continue;
				} else if (bet <= 0) {
					System.out.println("You cannot bet under $50");
					bet = 0;
				}
			}

			System.out.println(
					"Enter 1 to choose RED, Enter 2 to choose BLACK, or 3 to choose a number!(If you choose a number, it has to be between 1 and 36 inclusive)");
			int chosenNumber = input.nextInt();

			if (chosenNumber == 1) {
				printStatement(bet, color, randomNumber, false, balance, 0, "RED");
			}

			else if (chosenNumber == 2) {
				printStatement(bet, color, randomNumber, false, balance, 0, "BLACK");
			}

			else if (chosenNumber == 3) {
				int number = -1;
				while (number <= 1 || number > 36) {
					System.out.println("Choose a number");
					number = input.nextInt();
					if (number <= 0 || number > 36) {
						System.out.println("Your number has to be between 0 and 36 inclusive");
						number = -2;
					}
				}
				printStatement(bet, color, randomNumber, true, balance, number, "");
			}

			input.nextLine();

			playAgain = repeaterProcess(balance);
		}

	}

	public static void printStatement(int bet, String color, int randomNumber, boolean numberThree, int balance,
			int number, String guessColor) {
		System.out.println("Bets for this round:");
		System.out.println("--------------------");
		System.out.println("You chose the color " + guessColor + ", and bet $" + bet + " this round.\n");
		System.out.println("THE SPIN IS " + color + " " + randomNumber + "\n");
		System.out.println("Results");
		System.out.println("----------------");
		if (numberThree) {
			if (randomNumber == number) {
				balance += bet;
				System.out.println("YOU WON! (you currently have $" + (balance) + " left)\n");
			} else {
				balance -= bet;
				System.out.println("You lost (you currently have $" + (balance) + " left)\n");
			}
		} else {
			if (color.equals(guessColor)) {
				balance += bet;
				System.out.println("YOU WON! (you currently have $" + (balance) + " left)\n");
			} else {
				balance -= bet;
				System.out.println("You lost (you currently have $" + (balance) + " left)\n");

			}
		}

	}

	public static boolean repeaterProcess(int balance) {
		Scanner input = new Scanner(System.in);
		System.out.println("Do you want to play again? (enter Y for yes and N for no)");
		String answer = input.nextLine();
		if (answer.equalsIgnoreCase("N")) {
			System.out.print("Thank you for playing!");
			return false;
		} else if (answer.equalsIgnoreCase("Y")) {
			System.out.println("Get ready to play again");
			return true;
		}
		return false;
	}
}
