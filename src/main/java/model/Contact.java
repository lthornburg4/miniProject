package model;

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
@Table(name="contact")
@CascadeOnDelete
public class Contact {
	@Id
	@GeneratedValue
	private int id;
	private String address;
	
	public Contact() {
	}

	public Contact(int id, String address) {
		this.id = id;
		this.address = address;
	}
	

	public Contact(String address) {
		this.address = address;
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
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", address=" + address + "]";
	}
	
	
}
