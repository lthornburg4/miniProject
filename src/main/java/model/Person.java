package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.eclipse.persistence.annotations.CascadeOnDelete;

/**
 * @Viktoriia Denys - vdenys
 * CIS175 - Spring 2023
 * Mar 3, 2023
 */

@Entity
@Table(name="person")
@CascadeOnDelete
public class Person {
	// Variables
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="FNAME")
	private String fname;
	@Column(name="LNAME")
	private String lname;
	
	//Constructors
	public Person() {
	}

	public Person(String fname, String lname) {
		this.fname = fname;
		this.lname = lname;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the fname
	 */
	public String getFname() {
		return fname;
	}

	/**
	 * @param fname the fname to set
	 */
	public void setFname(String fname) {
		this.fname = fname;
	}

	/**
	 * @return the lname
	 */
	public String getLname() {
		return lname;
	}

	/**
	 * @param lname the lname to set
	 */
	public void setLname(String lname) {
		this.lname = lname;
	}

	
	public String returnPersonName() {
		return "Person`s name is [fname=" + fname + ", lname=" + lname + "]";
	}
	
	
	

}
