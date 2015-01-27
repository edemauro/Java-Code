import java.util.Random;
import java.util.Scanner;

public class Blackjack {
	public static void main(String[] args){
		Scanner keyboard = new Scanner(System.in);
		Random r = new Random();
		
		String choice;
		int x = 2 + r.nextInt(10), y = 2 + r.nextInt(10);
		int player = 0, dealer = 0;
		
		System.out.println("Welcome to Eric's blackjack program!");
		System.out.println("You get a " + x + " and a " + y + ".");
		player = x + y;
		System.out.println("Your total is " + player + ".\n");
		
		x = 2 + r.nextInt(10);
		y = 2 + r.nextInt(10);
		dealer = x + y;
		System.out.println("The dealer has a " + x + " showing, and a hidden card.");
		System.out.println("His total is hidden, too.\n");
		
		System.out.print("Would you like to \"hit\" or \"stay\"? ");
		choice = keyboard.next();
		
		while(!choice.toLowerCase().equals("stay")){
			x = 2 + r.nextInt(10);
			player += x;
			System.out.println("You drew a " + x + ".");
			System.out.println("Your total is " + player + ".\n");
			if(player > 21){
				System.out.println("You bust.\nYou lose!");
				return;
			}
			System.out.print("Would you like to \"hit\" or \"stay\"? " );
			choice = keyboard.next();
		}
		
		System.out.println("\nOkay. Dealer's turn.");
		System.out.println("His hidden card is a " + y + ".");
		System.out.println("His total is " + dealer + ".\n");
		
		while(dealer < 17){
			y = 2 + r.nextInt(10);
			dealer += y;
			System.out.println("Dealer chooses to hit.");
			System.out.println("He draws a " + y + ".");
			System.out.println("His total is " + dealer + ".\n");
		}
		
		if(dealer < 22){
			System.out.println("Dealer stays.\n");
		} else {
			System.out.println("Dealer busts.\nYou win!");
			return;
		}
		
		System.out.println("Dealer's total is " + dealer + ".");
		System.out.println("Your total is " + dealer + ".\n");
		
		if(player > dealer){
			System.out.println("You win!");
		} else if(player == dealer){
			System.out.println("You tie!");
		} else {
			System.out.println("You lose!");
		}
	}
}
