package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.eclipse.persistence.annotations.CascadeOnDelete;

/**
 * @Viktoriia Denys - vdenys
 * CIS175 - Spring 2023
 * Mar 3, 2023
 */
@Entity
@CascadeOnDelete
public class ListDetails {
	@Id
	@GeneratedValue
	private int id;
	private String listName;
	private LocalDate dateCreated;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Contact contact;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<Person> person;
	
	public ListDetails() {
		super();
		
	}
	
	public ListDetails(int id, String listName, LocalDate dateCreated, Contact contact, List<Person> person) {
		this.id = id;
		this.listName = listName;
		this.dateCreated = dateCreated;
		this.contact = contact;
		this.person = person;
	}
	

	public ListDetails(String listName, LocalDate dateCreated, Contact contact, List<Person> person) {
		this.listName = listName;
		this.dateCreated = dateCreated;
		this.contact = contact;
		this.person = person;
	}
	

	public ListDetails(String listName, LocalDate dateCreated, Contact contact) {
		this.listName = listName;
		this.dateCreated = dateCreated;
		this.contact = contact;
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
	 * @return the listName
	 */
	public String getListName() {
		return listName;
	}
	/**
	 * @param listName the listName to set
	 */
	public void setListName(String listName) {
		this.listName = listName;
	}
	/**
	 * @return the dateCreated
	 */
	public LocalDate getDateCreated() {
		return dateCreated;
	}
	/**
	 * @param dateCreated the dateCreated to set
	 */
	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}
	/**
	 * @return the contact
	 */
	public Contact getContact() {
		return contact;
	}
	/**
	 * @param contact the contact to set
	 */
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	/**
	 * @return the person
	 */
	public List<Person> getPerson() {
		return person;
	}
	/**
	 * @param person the person to set
	 */
	public void setPerson(List<Person> person) {
		this.person = person;
	}
	@Override
	public String toString() {
		return "ListDetails [id=" + id + ", listName=" + listName + ", dateCreated=" + dateCreated + ", contact="
				+ contact + ", person=" + person + "]";
	}
	

	
	
	
	

}
