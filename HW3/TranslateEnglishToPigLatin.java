import java.util.Scanner;
//import java.util.regex.Pattern;

/**
 * Homework 3-3: Translate English to Pig Latin
 * @author Kuei-Lin Yang
 * Feb 5, 2018
 */

public class TranslateEnglishToPigLatin {
	// declare and initialize object variable
	//private static final Pattern STARTS_WITH_VOWEL = Pattern.compile("^[aeiou]", Pattern.CASE_INSENSITIVE);	
	private static final String vowels = "aeiou";
	private static final String numbers = "0123456789";
	
	// get the first index of vowel
	public static int getFirstVowelIndex(String word) {
		String loweredWord = word.toLowerCase();

		for(int index=0; index<loweredWord.length(); index++) {
			if(vowels.contains( String.valueOf(loweredWord.charAt(index)) ) || ( !"y".equals( String.valueOf(loweredWord.charAt(0)) ) && "y".equals( String.valueOf(loweredWord.charAt(index)) )) )
			{
				return index;
			}
		}
		return -1;
	}
	
	// check if the first character is vowel
	public static boolean isFirstVowel(String word) {
		String loweredWord = word.toLowerCase();
		if(vowels.contains( String.valueOf(loweredWord.charAt(0)) )){
			return true;
		}else
			return false;
	}
	
	// check if it is alphabetic
	public static boolean isAlphabetic(String word) {
		for(int index=0; index<word.length(); index++) {
			//System.out.println("Character.isAlphabetic(word.charAt(index)):"+ Character.isAlphabetic(word.charAt(index)) );
			if( !Character.isAlphabetic(word.charAt(index)) && !"\'".equals(String.valueOf(word.charAt(index))) )
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to the Pig Latin Translator.");
		
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		while(choice.equalsIgnoreCase("y")) {
			String line = Validator.getRequiredString(sc, "Enter a line to be translated to Pig Latin:\n");
			System.out.println();
			
			String[] words = line.split(" ");
			StringBuilder sb = new StringBuilder("");
			for(int i=0; i< words.length; i++) {
				//System.out.println(words[i]);
				//System.out.println(isAlphabetic(words[i]));
				
				if(isAlphabetic(words[i])) {
					// if the first character is vowel
					//if(STARTS_WITH_VOWEL.matcher(words[i].trim()).find())
					if(isFirstVowel(words[i])){
						words[i] = words[i] + "way";
					}else {
						int index = getFirstVowelIndex(words[i]);
						//System.out.println("index:" + index);
						if(index != -1) {
							words[i] = words[i].substring(index, words[i].length()) + words[i].substring(0, index) + "ay";
						}else {
							System.out.println("Error! No rules for all consonant. Do Nothing!");
						}		
					}
				}/*else
					System.out.println("Do Nothing!");*/
				
				sb.append(words[i]);
				if(i+1 != words.length)
					sb.append(" ");
 			}
			
			System.out.println(sb);
			System.out.println();
			choice = Validator.getChoiceString(sc, "Translate another line? (y/n): ", "y", "n");
		}
	}

}
