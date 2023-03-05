package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contact;
import model.ListDetails;
import model.Person;


/**
 * Servlet implementation class EditListDetailsServlet
 */
@WebServlet("/editListDetailsServlet")
public class EditListDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditListDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		ListDetailsHelper dao = new ListDetailsHelper();
		PersonHelper sh = new PersonHelper();
		ContactHelper ph = new ContactHelper();
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		ListDetails listToUpdate = dao.searchForListDetailsById(tempId);
		
		String newListName = request.getParameter("listName");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		
		String contact = request.getParameter("contact");
		
		// Find new contact
		Contact newlist = ph.findList(contact);
		
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		}
		catch(NumberFormatException e) {
			ld = LocalDate.now();
		}
		
		try {
			
			// People we want to add are selected
			String[] selected = request.getParameterValues("allPeopleToAdd");
			List<Person> selectedPeopleInList = new ArrayList<Person>();
			
			for(int i = 0; i < selected.length ; ++i ) {
				System.out.println(selected[i]);
				Person c = sh.searchForPersonById(Integer.parseInt(selected[i]));
				selectedPeopleInList.add(c);
			}
			listToUpdate.setPerson(selectedPeopleInList);
		}
		catch(NullPointerException n) {
			
			// Set to empty list if nothing was selected
			List<Person> selectedItemsInList = new ArrayList<Person>();
			listToUpdate.setPerson(selectedItemsInList);
		}
		
		listToUpdate.setListName(newListName);
		listToUpdate.setDateCreated(ld);
		listToUpdate.setContact(newlist);
		
		dao.updateList(listToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}
}

