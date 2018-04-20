import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Homework 5-3: List movies by category
 * @author Kuei-Lin Yang
 * Feb 27, 2018
 */
public class MovieListApp {
	
	public static void main(String[] args) {
		System.out.println("Welcome to the Movie List Application.");
		System.out.println();
		System.out.println("There are 100 movies in the list.");
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		
		ArrayList<Movie> movieArrayList = new ArrayList<Movie>();
		// use MovieIO static getMovie() method to fill the array list
		for(int i=1; i<=100; i++) {
			movieArrayList.add(MovieIO.getMovie(i));
		}
		
		while(choice.equalsIgnoreCase("y")) {
			Movie.displayMenu();
			String category = Validator.getRequiredString(sc, "What category are you interested in (1-6/animated...)? ");
			if( Character.isDigit(category.trim().toCharArray()[0]) ) {
				// first is digit cases
				category = Movie.movieMapping( Character.getNumericValue(category.trim().toCharArray()[0]) );
				if( category.isEmpty() ){
					System.out.println("NO SUCH CATEGORY!!!");
					continue;
				}
			}else {
				// string cases
				if( !Arrays.asList(Movie.getDefinedCategory()).contains(category.toLowerCase()) ) {
					System.out.println("NO SUCH CATEGORY!!!");
					continue;
				}
			}

			
			Iterator iterator = movieArrayList.iterator();
			while(iterator.hasNext()) {
				Movie movie = (Movie) iterator.next();
				if(category.equalsIgnoreCase(movie.getCategory()))
					System.out.println(movie.getTitle());	
			}
			System.out.println();
			
			choice = Validator.getChoiceString(sc, "Continue? (y/n): ", "y", "n");
		}

	}

}
