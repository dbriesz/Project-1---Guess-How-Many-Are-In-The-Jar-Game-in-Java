import java.util.Scanner;

public class Prompter {

    private Scanner input;
    private Jar mJar;

    public Prompter() {
        input = new Scanner(System.in);
    }

    public void play() {
        String itemName = promptForItemName();
        int maxItems = promptForMaxItems(itemName);
        mJar = new Jar(itemName, maxItems);
        promptForGuess();
    }

    public String promptForItemName() {
        System.out.print("What type of item?  ");
        return input.nextLine();
    }

    public int promptForMaxItems(String itemName) {
        System.out.print("What is the maximum amount of " + itemName + "?  ");
        return input.nextInt();
    }

    public void promptForGuess() {
        System.out.println("How many " + mJar.getItemName() + " are in the jar?  "
                + "Pick a number between 1 and " + mJar.getMaxItems() + ".");
    }

    public void isWinner() {
        int guess = 0;
        int tries = 0;

        do {
            try {
                System.out.print("\nGuess:  ");
                guess = input.nextInt();

                if (guess > mJar.getMaxItems()) {
                    throw new IllegalArgumentException("Your guess must be less than " + mJar.getMaxItems() + ".");
                }
                else if (guess < mJar.getAnswer()) {
                    System.out.println("Your guess is too low.  Try again.");
                }
                else if (guess > mJar.getAnswer()) {
                    System.out.println("Your guess is too high.  Try again.");
                }
            } catch (IllegalArgumentException iae){
                System.out.println(iae.getMessage());
                tries--;
            }
            tries++;
            System.out.println(tries + " attempts.");

        } while (guess != mJar.getAnswer());

        System.out.println("\nCongratulations - you guessed that there are " + mJar.getAnswer() + " "
                + mJar.getItemName() + " in the jar!  It took you " + tries + " guess(es) to get it right.");
    }
}