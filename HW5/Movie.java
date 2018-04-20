
/**
 * Homework 5-3: List movies by category
 * @author Kuei-Lin Yang
 * Feb 27, 2018
 */
public class Movie {
	private String title;
	private String category;
	private static String[] definedCategory = {"animated", "comedy", "drama", "horror", "musical", "scifi"};
	
	public Movie() {
		title = "";
		category = "";
	}

	public Movie(String title, String category) {
		this.title = title;
		this.category = category;
	}
	
	protected String getTitle() {
		return title;
	}
	
	protected String getCategory() {
		return category;
	}
	
	protected static String[] getDefinedCategory() {
		return definedCategory;
	}
	
	public static void displayMenu() {
		StringBuilder menu = new StringBuilder("Movie Menu\n");
		for(int i=0; i < definedCategory.length; i++) {
			menu.append(i+1 + ". " + definedCategory[i] + "\n");
		}
		System.out.println(menu.toString());
	}
	
	public static String movieMapping(int movieNumber) {
		int movieIndex = movieNumber-1;
		
		if(movieIndex>=0 && movieIndex < definedCategory.length) {
			return definedCategory[movieIndex];
		}else 
			return "";
	}
}
