package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Contact;

/**
 * @Viktoriia Denys - vdenys
 * CIS175 - Spring 2023
 * Mar 3, 2023
 */
public class ContactHelper {
static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("AddressBook");
	
	public void insertContact(Contact p) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Contact> showAllContacts() {
		EntityManager em = emfactory.createEntityManager();
		@SuppressWarnings("unchecked")
		List<Contact> alllists = em.createQuery("SELECT p FROM Contact p").getResultList();
		return alllists;
	}
	
	public Contact findList(String lookupAddress) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Contact> typedQuery = em.createQuery("SELECT p FROM Contact p WHERE p.address =:selectedAddress", Contact.class);
		typedQuery.setParameter("selectedAddress", lookupAddress);
		
		// Set max results to 1
		typedQuery.setMaxResults(1);
		
		Contact foundContact;
		try {
			foundContact = typedQuery.getSingleResult();
		}
		catch(NoResultException e) {
			foundContact = new Contact(lookupAddress);
		}
		em.close();
		
		return foundContact;
	}

}
