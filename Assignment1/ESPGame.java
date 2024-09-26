import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;


public class ESPGame {
	public static void main(String[] args) throws IOException {
		
		// create scanner object for user input and file input
		Scanner keyboard=new Scanner(System.in);
		System.out.print("Enter file name: ");
		String fileName = keyboard.nextLine();
		Scanner inputFile = new Scanner(new File(fileName));
		
		//Display content
		int lineNumber = 0;
		while (inputFile.hasNextLine())
		{
			lineNumber++;
			System.out.println(inputFile.nextLine());
		}
		inputFile.close();
		System.out.println("There are " + Integer.toString(lineNumber) + " colors from a file:");
		
		//Let the game begins
		Random random = new Random();
		int numberOfGoodGuess = 0;
		for (int roundNumber = 1; roundNumber <= 3; roundNumber++)
		{
			System.out.println("\nRound " + roundNumber);
			//Generate a random number between 0 and 15 and add 1
			int randomColorNumber = random.nextInt(16) + 1; 
			String selectedColor = "";
			
			// Create Scanner file and open file to read
			Scanner colorFile = new Scanner(new File(fileName));
            lineNumber = 0;
            String colorLine = "";
            
            //search for the corresponding line to the random number
            while (colorFile.hasNextLine()) 
            {
                lineNumber++;
                colorLine = colorFile.nextLine();
                if (lineNumber == randomColorNumber) 
                {
                    selectedColor = colorLine.split(" ")[1];
                    break;
                }
            }
            colorFile.close();
            
            //Ask for user to guess
            System.out.println("I am thinking of a color.");
            System.out.println("Is it one in the list of colors above?");
            System.out.print("Enter your guess: ");
            String colorGuess = keyboard.nextLine();
            
            //check if the guess is right
            if (colorGuess.equals(selectedColor))
            {
            	numberOfGoodGuess++;
            }
            System.out.println("I was thinking of " + selectedColor);
            
		}
		
		// End of game summary
        System.out.println("\nGame Over");
        System.out.println("You guessed " + numberOfGoodGuess + " out of 3 colors correctly.");
        
		// Collect and display user information
        System.out.print("\nEnter your name: ");
        String studentName = keyboard.nextLine();

        System.out.print("Describe yourself: ");
        String studentDescription = keyboard.nextLine();

        System.out.print("Due Date: ");
        String dueDate = keyboard.nextLine();

        System.out.println("\nUser Name: " + studentName);
        System.out.println("User Description: " + studentDescription);
        System.out.println("Due Date: " + dueDate);

		keyboard.close();
	}
}
