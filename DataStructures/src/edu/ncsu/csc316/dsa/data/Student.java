package edu.ncsu.csc316.dsa.data;

import java.util.Objects;

/**
 * A student is comparable and identifiable.
 * Students have a first name, last name, id number, 
 * number of credit hours, gpa, and unityID.
 * 
 * @author Dr. King
 * @author Will Greene
 */
public class Student implements Comparable<Student>, Identifiable {
		
	/** first name of Student */
	private String first; 
	
	/** last name of Student */
	private String last;
	
	/** id number of Student */
	private int id;
	
	/** number of credit hours being taken by Student */
	private int creditHours;
	
	/** gpa of Student */
	private double gpa;
	
	/** unity ID of Student */
	private String unityID;
	
	/**
	 * Constructs a Student object.
	 * 
	 * @param first first name of Student
	 * @param last last name of Student
	 * @param id id number of Student
	 * @param creditHours number of credit hours being taken by Student
	 * @param gpa gpa of Student
	 * @param unityID unity ID of student
	 */
	public Student( String first, String last, int id, int creditHours, double gpa, String unityID ) {
		this.first = first;
		this.last = last;
		this.id = id;
		this.creditHours = creditHours;
		this.gpa = gpa;
		this.unityID = unityID;
	}
	
	/**
	 * Returns the first name.
	 * @return the first
	 */
	public String getFirst() {
		return first;
	}

	/**
	 * Sets the first name.
	 * @param first the first to set
	 */
	public void setFirst(String first) {
		this.first = first;
	}

	/**
	 * Returns the last name.
	 * @return the last
	 */
	public String getLast() {
		return last;
	}

	/**
	 * Sets the last name.
	 * @param last the last to set
	 */
	public void setLast(String last) {
		this.last = last;
	}

	/**
	 * Returns the id.
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Returns the creditHours.
	 * @return the creditHours
	 */
	public int getCreditHours() {
		return creditHours;
	}

	/**
	 * Sets the creditHours.
	 * @param creditHours the creditHours to set
	 */
	public void setCreditHours(int creditHours) {
		this.creditHours = creditHours;
	}

	/**
	 * Returns the gpa.
	 * @return the gpa
	 */
	public double getGpa() {
		return gpa;
	}

	/**
	 * Sets the gpa.
	 * @param gpa the gpa to set
	 */
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	/**
	 * Returns the unityID.
	 * @return the unityID
	 */
	public String getUnityID() {
		return unityID;
	}

	/**
	 * Sets the unityID.
	 * @param unityID the unityID to set
	 */
	public void setUnityID(String unityID) {
		this.unityID = unityID;
	}
	
	/**
	 * Generates a hashCode for Student using all fields.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(creditHours, first, gpa, id, last, unityID);
	}

	/**
	 * Compares a given object to this object for equality on first, last and id fields.
	 * 
	 * @return true if equal, false if not
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(first, other.first) && id == other.id && Objects.equals(last, other.last);
	}
	
	/**
	 * Returns a string representation of a Student.
	 * @return a string representation of a Student
	 */
	@Override
	public String toString() {
		return "Student [first=" + first + ", last=" + last + ", id=" + id + ", creditHours=" + creditHours + ", gpa="
				+ gpa + ", unityID=" + unityID + "]";
	}

	/**
	 * Determines whether this Student belongs before or after a Student s.
	 * 
	 * @return negative if this Student belongs before s, 
	 * 		   positive if this Student belongs after s
	 */
	@Override
	public int compareTo( Student s ) {
		
		if ( this.last.compareTo( s.getLast() ) < 0 ) {
			return -1;
		} else if ( this.last.compareTo( s.getLast() ) > 0 ) {
			return 1;
		}
		
		if ( this.first.compareTo( s.getFirst() ) < 0 ) {
			return -1;
		} else if ( this.first.compareTo( s.getFirst() ) > 0 ) {
			return 1;
		}
		
		return this.id - s.getId();
	}
}
