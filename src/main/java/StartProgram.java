import java.util.List;
import java.util.Scanner;
import controller.PersonHelper;
import model.Person;
/**
 * @Viktoriia Denys - vdenys
 * CIS175 - Spring 2023
 * Mar 3, 2023
 */
public class StartProgram {
	static Scanner s = new Scanner(System.in);
	static PersonHelper sh = new PersonHelper();

	private static void addPerson() {
		System.out.print("Enter first name: ");
		String fname = s.nextLine();
		System.out.print("Enter the last name: ");
		String lname = s.nextLine();
		
		Person toAdd = new Person(fname, lname);
		sh.insertPerson(toAdd);
	}

	private static void deletePerson() {
		System.out.print("Enter the first name to delete: ");
		String fname = s.nextLine();
		System.out.print("Enter the last name to delete: ");
		String lname = s.nextLine();

		Person toDelete = new Person(fname, lname);
		sh.deletePerson(toDelete);
	}

	private static void editPerson() {
		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by First name");
		System.out.println("2 : Search by Last Name");
		int searchBy = s.nextInt();
		s.nextLine();
		List<Person> foundPeople;
		if (searchBy == 1) {
			System.out.print("Enter the first name: ");
			String personFName = s.nextLine();
			foundPeople = sh.searchForPersonByFname(personFName);
			
		} 
		else {
			System.out.print("Enter the last name: ");
			String personLname = s.nextLine();
			foundPeople = sh.searchForPersonByLname(personLname);

		}

		if (!foundPeople.isEmpty()) {
			System.out.println("Found Results.");
			for (Person s : foundPeople) {
				System.out.println(s.getId() + " : " + s.toString());
			}
			System.out.print("Which ID to edit: ");
			int idToEdit = s.nextInt();

			Person toEdit = sh.searchForPersonById(idToEdit);
			System.out.println("Retrieved '" + toEdit.getFname() + "', by " + toEdit.getLname());
			System.out.println("1 : Update First name");
			System.out.println("2 : Update Last name");
			int update = s.nextInt();
			s.nextLine();

			if (update == 1) {
				System.out.print("New First name: ");
				String newFname = s.nextLine();
				toEdit.setFname(newFname);
			} else if (update == 2) {
				System.out.print("New last name: ");
				String newLname = s.nextLine();
				toEdit.setLname(newLname);
			}

			sh.updatePerson(toEdit);

		} else {
			System.out.println("--- No results found ---");
		}

	}

	public static void main(String[] args) {
		runMenu();

	}

	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Address Book APP! ---");
		while (goAgain) {
			System.out.println("*  Select an option:");
			System.out.println("*  1 -- Add a Person");
			System.out.println("*  2 -- Edit an existing Person");
			System.out.println("*  3 -- Delete a person");
			System.out.println("*  4 -- View the list");
			System.out.println("*  5 -- Exit");
			System.out.print("*  Your selection: ");
			int selection = s.nextInt();
			s.nextLine();

			if (selection == 1) {
				addPerson();
			} else if (selection == 2) {
				editPerson();
			} else if (selection == 3) {
				deletePerson();
			} else if (selection == 4) {
				viewTheList();
			} else {
				sh.cleanUp();
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}

		}

	}

	private static void viewTheList() {
		List<Person> allPeople = sh.showAllPeople();
		
		for(Person singlePerson: allPeople) {
			System.out.println(singlePerson.returnPersonName());
		}
	}

}


