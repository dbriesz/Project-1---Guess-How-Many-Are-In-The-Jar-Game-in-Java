import java.util.Scanner;

public class Prompter {
    private Jar mJar;

    public void setJar(Jar jar) {
        mJar = jar;
    }

    Scanner input = new Scanner(System.in);

    private String itemName;
    private int maxItems;

    public void play() {
        promptForItemName();
        mJar.setItemName(itemName);
        promptForMaxItems();
        mJar.setMaxNum(maxItems);
        promptForGuess();
    }

    public String promptForItemName() {
        System.out.print("What type of item?  ");
        itemName = input.nextLine();
        return itemName;
    }

    public int promptForMaxItems() {
        System.out.print("What is the maximum amount of " + itemName + "?  ");
        maxItems = input.nextInt();
        return maxItems;
    }

    public void promptForGuess() {
        System.out.println("How many " + mJar.getItemName() + " are in the jar?  "
                + "Pick a number between 1 and " + mJar.getMaxItems() + ".");
    }

    public void isWinner() {
        int guess;
        int tries = 0;
        int over = 0;

        do {
            System.out.print("\nGuess:  ");
            guess = input.nextInt();

            if (guess > mJar.getMaxItems()) {
                System.out.println("Your guess must be less than " + mJar.getMaxItems() + ".");
                over++;
            } else if (guess < mJar.getAnswer()) {
                System.out.println("Your guess is too low.  Try again.");
            } else if (guess > mJar.getAnswer()) {
                System.out.println("Your guess is too high.  Try again.");
            }
            tries++;

            if ((tries-over) > 1) {
                System.out.println((tries - over) + " attempts.");
            } else {
                System.out.println((tries - over) + " attempt.");
            }

        } while (guess != mJar.getAnswer());

        System.out.println("\nCongratulations - you guessed that there are " + mJar.getAnswer() + " "
                + mJar.getItemName() + " in the jar!  It took you " + (tries-over) + " guess(es) to get it right.");
    }
}