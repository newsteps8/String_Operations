import java.util.Scanner;

public class Pro4_150116027 {
	Scanner input = new Scanner(System.in);

	// BÜÞRA GÖKMEN_150116027
	// In this homework, I write a program which will take an input string and
	// return this string by several methods.
	public static void main(String[] args) {
		// I created an infinite loop
		Scanner input = new Scanner(System.in);
		Scanner input2 = new Scanner(System.in);
		boolean newline = true;
		int count = 0;      //I defined values
		int numberOfLetters = 0;
		int numberOfWords = 0;
		int offset = 0;
		while (newline) {
			System.out.println("Please enter a string: ");
			String line = input.nextLine();
			if (line.equals("exit") || line.equals("quit")) {
				newline = false;
				System.out.println("Program ends. Bye");
			} else if (line.equals("stat"))
				printStat(numberOfWords, numberOfLetters);
			else {
				numberOfLetters += updateLetterCount(count, line);//Update the count of letters
				numberOfWords += updateWordCount(count, line); //Update the count of words
				System.out.print(
						"1. Change Case\n2. Count vowels and consonants\n3. Capitalize the first letter\n4. Encrypt or Decrypt\n");
				System.out.println("Please choose an option: ");
				int option = input2.nextInt();
				if (option == 1)
					System.out.println(changeCase(line));
				else if (option == 2)
					countVC(line);                          //I defined the other methods in main method
				else if (option == 3)
					System.out.println(capitalize(line));
				else if (option == 4)
					System.out.println(encryptOrDecrypt(line, offset));
				else
					System.out.println("Invalid option.");
			}
		}
		input.close();
		input2.close();
	}

	public static String changeCase(String line) {
		//I created a new string that converts uppercase letters to lowercase letters and lowercase letters to uppercase letters



		String newline = " "; // I returned an empty string

		for (int i = 0; i < line.length(); i++) {
			if (line.charAt(i) == Character.toUpperCase(line.charAt(i)))
				newline += Character.toLowerCase(line.charAt(i)); //Update line
			else if (line.charAt(i) == Character.toLowerCase(line.charAt(i)))
				newline += Character.toUpperCase(line.charAt(i)); //Update line
			else
				newline += line.charAt(i);
		}
		return newline;
	}

	public static void countVC(String line) {// displays the number of vowels and quiet letters in an input string
		int vowel = 0;
		int consonants = 0;
		for (int i = 0; i < line.length(); i++) {
			if ((line.charAt(i) == 'A') || (line.charAt(i) == 'E') || (line.charAt(i) == 'O') || (line.charAt(i) == 'U')
					|| (line.charAt(i) == 'I') || (line.charAt(i) == 'a') || (line.charAt(i) == 'e')
					|| (line.charAt(i) == 'o') || (line.charAt(i) == 'u') || (line.charAt(i) == 'i'))
				vowel++;
			else if (line.charAt(i) == ' ')
				;
			else
				consonants++;
		}
		System.out.println("The number of vowels: " + vowel);
		System.out.println("The number of consonants:" + consonants);
	}

	public static String capitalize(String line) {// an input string and
		//the first of every calf
		// uppercase letters
		// a new string to be written
		// returns.

		char k = Character.toUpperCase(line.charAt(0));
		//I made the first letter bigger than before
		line = k + line.substring(1);
		//we added the letters of the heel after the first letter.
		String space = " ";//I returned an empty string
		for (int i = 1; i < line.length(); i++) {
			if (line.charAt(i) == ' ') {
				k = Character.toUpperCase(line.charAt(i + 1));
				line = line.substring(0, i) + space + k + line.substring(i + 2);//Update line

			}

		}

		return line;
	}

	public static String encryptOrDecrypt(String line, int offset) {
		//encodes or decodes the input sequence based on a slip offset.
		int ChangeValue = 0;
		String addedline = " ";
		Scanner input = new Scanner(System.in);
		System.out.println("Enter an offset value : ");
		int offset1 = input.nextInt();// The method takes an input string, converts it to uppercase, and then processes it using scrolling offset.
		for (int i = 0; i < line.length(); i++) {
			if ((int) line.charAt(i) <= 90 && 65 <= (int) line.charAt(i)
					|| (int) line.charAt(i) <= 122 && 97 <= (int) line.charAt(i)) {
				if (line.charAt(i) == Character.toLowerCase(line.charAt(i)))
					line = line.toUpperCase(); //Update line
			}

			if (offset1 < -25 || offset1 > 25) {
				System.out.println("Invalid offset. ");
			} else {
				if ((int) line.charAt(i) <= 90 && 65 <= (int) line.charAt(i)) {
					ChangeValue = (int) (line.charAt(i)) + offset1;
					if (ChangeValue >= 91)
						ChangeValue -= 26;
					addedline += (char) ChangeValue;//add a new line
				} else {
					ChangeValue = (int) line.charAt(i);
					addedline += (char) ChangeValue;//add a new line
				}
			}
		}

		return addedline;
	}


	//I defined method for numbers of count and numbers of letters
	public static int updateLetterCount(int count, String line) {

		for (int i = 0; i < line.length(); i++) {
			if ((int) line.charAt(i) >= 65 && (int) line.charAt(i) <= 90
					|| (int) line.charAt(i) >= 97 && (int) line.charAt(i) <= 122)
				count++;//Update count
         }

		return count;
	}

	public static int updateWordCount(int count, String line) {
		count = 0;
		for (int i = 0; i < line.length(); i++) {
			if (line.substring(i, i + 1).equals(" ")) {
				count++;//When seeing the space will increase the number of words
				if (line.substring(i, i + 1).equals(" ") && line.substring(i + 1, i + 2).equals(" "))
					count--;
			}

		}

		count++;
		//I added the number of first words
		return count;
	}

	public static void printStat(int wordCount, int letterCount) {// I printed the number of words and letters of the entries which entered up to now

		System.out.println("number of words:" + wordCount);
		System.out.println("number of letters: " + letterCount);
	}
}
