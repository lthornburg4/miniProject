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
 * Servlet implementation class CreateNewListServlet
 */
@WebServlet("/createNewListServlet")
public class CreateNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PersonHelper ph = new PersonHelper();
		String listName = request.getParameter("listName");
		System.out.println("List Name: " + listName);
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String contact = request.getParameter("contact");
		
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		}
		catch(NumberFormatException e) {
			ld = LocalDate.now();
		}
		
		String[] selected = request.getParameterValues("allPeopleToAdd");
		List<Person> selectedPeopleInList = new ArrayList<Person>();
		
		// Make sure something was selected
		if(selected != null && selected.length > 0) {
			for(int i = 0; i < selected.length ; ++i ) {
				System.out.println(selected[i]);
				Person p = ph.searchForPersonById(Integer.parseInt(selected[i]));
				selectedPeopleInList.add(p);
			}
		}
		
		Contact c = new Contact(contact);
		ListDetails mpd = new ListDetails(listName, ld, c);
		mpd.setPerson(selectedPeopleInList);
		ListDetailsHelper mpdh = new ListDetailsHelper();
		mpdh.insertNewListDetails(mpd);
		
		System.out.println(mpd.toString());
		
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
