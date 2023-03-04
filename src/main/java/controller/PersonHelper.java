package controller;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Person;

/**
 * @Viktoriia Denys - vdenys
 * CIS175 - Spring 2023
 * Mar 3, 2023
 */
public class PersonHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("AddressBook");
	
	public void insertPerson(Person s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Person> showAllPeople() {
		EntityManager em = emfactory.createEntityManager();
		@SuppressWarnings("unchecked")
		List<Person> allPeople = em.createQuery("SELECT i FROM Person i").getResultList();
		return allPeople;
	}
	
	public void deletePerson(Person toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Person> typedQuery = em.createQuery("SELECT s FROM Person s WHERE s.fname = :selectedFname AND s.lname= :selectedLname", Person.class);
		
		// Substitute parameter with actual data from the toDelete person
		typedQuery.setParameter("selectedFname", toDelete.getFname());
		typedQuery.setParameter("selectedLname", toDelete.getLname());
		
		// Retrieve only one result
		typedQuery.setMaxResults(1);
		
		// Get result and save into a new Person
		Person result = typedQuery.getSingleResult();
		
		// Remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Person> searchForPersonByFname(String personFname) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Person> typedQuery = em.createQuery("SELECT s FROM Person s WHERE s.fname = :selectedFname", Person.class);
		typedQuery.setParameter("selectedFname", personFname);
		
		List<Person> foundPeople = typedQuery.getResultList();
		em.close();
		
		return foundPeople;
	}
	
	public List<Person> searchForPersonByLname(String personLname) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Person> typedQuery = em.createQuery("SELECT s FROM Person s WHERE s.lname = :selectedLname", Person.class);
		typedQuery.setParameter("selectedLname", personLname);
		
		List<Person> foundPeople= typedQuery.getResultList();
		em.close();
		
		return foundPeople;
	}
	
	public Person searchForPersonById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Person found = em.find(Person.class, idToEdit);
		em.close();
		
		return found;
	}
	
	public void updatePerson(Person toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public void cleanUp() {
		emfactory.close();
	}
	
	
}
	


