import java.util.Arrays;
import java.util.Scanner;

/**
 * Homework 5-1: Display a sorted list of student scores
 * @author Kuei-Lin Yang
 * Feb 26, 2018
 */
public class StudentScoresApp {
	public static void main(String[] args) {
		System.out.println("Welcome to the Student Scores Application.");
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		int number = Validator.getInt(sc, "Enter number of students to enter: ");
		System.out.println();
		
		Student[] student = new Student[number];
		
		for(int i=0; i<number; i++) {
			int count = i+1;
			String lastname = Validator.getRequiredString(sc, "Student " + count + " last name: ");
			String firstname = Validator.getRequiredString(sc, "Student " + count + " first name: ");
			int score = Validator.getIntWithinRange(sc, "Student " + count + " score: ", 0, 100);
			
			// new an instance
			student[i] = new Student();
			student[i].setLastName(lastname);
			student[i].setFirstName(firstname);
			student[i].setScore(score);
			System.out.println();
		}
		
		// sort arrays
		Arrays.sort(student);
		// display sorted arrays
		for(Student s : student) {
			System.out.println(s.getFormattedInfo());
		}
	}

}
