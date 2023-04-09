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

		System.out.println("Welcome to the Roulette Game!");
		System.out.println("The payout of winning bets are 1:1 for color bets and 35:1 for number bets.");

		System.out.println("Enter your name");
		String name = input.nextLine();

		System.out.println("Enter your age");
		int age = input.nextInt();

		System.out.println("How much money do you want your starting amount to be?");

		balance = input.nextInt();

		boolean gameOver = false;
		while (!gameOver) {

			System.out.println("Okay, " + name + " lets get ready to play some Roulette! \n");
			System.out.println("---------------------------");

			Random random = new Random();
			randomNumber = random.nextInt(38);

			String color = "";

			if (randomNumber == 0 || randomNumber == -1) {
				color = "GREEN";
			} else if (randomNumber % 2 == 0) {
				color = "RED";
			} else {
				color = "BLACK";
			}
		}
		

			System.out.println("The wheel landed on " + color + " " + randomNumber);  //YO ON THIS LINE OF CODE ASK JULIAN HOW TO USE THE SAME VALUE OF 'color' THATS IN THE WHILE LOOP THAT THE USER INPUTTED, AS OUT OF THE WHILE LOOP WHICH IS ON THIS LINE


				while (true) {
					System.out.println("Place your bets (The maximum you can bet is $50)\n");
					bet = input.nextInt();

					if (bet > 50) {
						System.out.println("You cannot bet over $50");
						continue;
					}
					break;
				}
			

			System.out.println(
					"Enter 1 to choose RED, Enter 2 to choose BLACK, or 3 to choose a number!(If you choose a number, it has to be between -1 and 36 inclusive)");
			int chosenNumber = input.nextInt();

			if (chosenNumber == 1) {
				System.out.println("Bets for this round:");
				System.out.println("--------------------");
				System.out.println("You chose the color Red, and bet $" + bet + " this round.\n");
				System.out.println("THE SPIN IS " + str + " " + randomNumber + "\n");
				System.out.println("Results");
				System.out.println("----------------");
				if (str == "Red") {
					balance += bet;
					System.out.println("YOU WON! (you currently have $" + (balance) + " left)\n");
				} else {
					balance -= bet;
					System.out.println("You lost (you currently have " + (balance) + " left)\n"); 
				}

				if (chosenNumber == 2) {
					System.out.println("Bets for this round:");
					System.out.println("--------------------");
					System.out.println("You chose the color Red, and bet $" + bet + " this round.\n");
					System.out.println("THE SPIN IS " + str + " " + randomNumber + "\n");
					System.out.println("Results");
					System.out.println("----------------");
					if (str == "Black") {
						balance += bet;
						System.out.println("YOU WON! (you currently have $" + (balance) + " left)\n");
					} else {
						balance -= bet;
						System.out.println("You lost (you currently have " + (balance) + " left)\n");
					}

					if (chosenNumber == 3) {
						System.out.println("Bets for this round:");
						System.out.println("--------------------");
						System.out.println("You chose the color Red, and bet $" + bet + " this round.\n");
						System.out.println("THE SPIN IS " + str + " " + randomNumber + "\n");
						System.out.println("Results");
						System.out.println("----------------");
						if (str == "Red") {
							balance += bet;
							System.out.println("YOU WON! (you currently have $" + (balance) + " left)\n");
						} else {
							balance -= bet;
							System.out.println("You lost (you currently have " + (balance) + " left)\n");
						}

						System.out.println("Do you want to play again (enter Y for yes and N for no)?");
						String answer = input.nextLine();
						if (answer.equalsIgnoreCase("N")) {
						} else {
							answer = "";
						}
					}

				}
			}
			System.out.println("testing");
			if (balance <= 0) {
				gameOver = true;
			}
			System.out.println(gameOver);
		}
		
	}

