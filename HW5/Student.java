/**
 * Homework 5-1: Display a sorted list of student scores
 * @author Kuei-Lin Yang
 * Feb 26, 2018
 */
public class Student implements Comparable{
	private String lastname;
	private String firstname;
	private int score;
	
	public Student() {
		lastname = "";
		firstname = "";
		score = 0;
	}
	
	protected void setLastName(String lastname) {
		this.lastname = lastname;
	}

	protected void setFirstName(String firstname) {
		this.firstname = firstname;
	}

	protected void setScore(int score) {
		this.score = score;
	}
	
	protected String getLastName() {
		return lastname;
	}
	
	protected String getFirstName() {
		return firstname;
	}
	
	protected String getFormattedInfo() {
		return lastname + ", " + firstname + ": " + score;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Object o) {
		Student s = (Student) o;
		
		if(this.getLastName().equals(s.getLastName())) {
			// the same last names
			if(this.getFirstName().compareTo(s.getFirstName()) < 0 )
				return -1;
			if(this.getFirstName().compareTo(s.getFirstName()) > 0 )
				return 1;
		}else {
			// different last names
			if(this.getLastName().compareTo(s.getLastName()) < 0)
				return -1;
			if(this.getLastName().compareTo(s.getLastName()) > 0)
				return 1;
		}
		return 0;
	}
}
