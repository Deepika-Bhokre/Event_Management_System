

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
public class DisplayBookings extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public DisplayBookings() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cookie[] cookies = null;
        Cookie cookie = null;
        cookies = request.getCookies();
        String username = null;
        String userType = null;
        if (cookies != null) {
            String cookieName1 = "userType";
            String cookieName2 = "username";
            for (int i = 0; i < cookies.length; i++) {
                cookie = cookies[i];
                if (cookie.getName().equals(cookieName1)) {
                    userType = cookie.getValue();
                } else if (cookie.getName().equals(cookieName2)) {
                    username = cookie.getValue();
                }
            }
        }
        if(userType.equals("user")){
        	Eventmethods dao = new Eventmethods();
            List<EventBook> list = dao.viewAllEventswithUsername(username);
            if (list == null) {
                RequestDispatcher view = request.getRequestDispatcher("booked.jsp?msg=No Tickets are Booked");
                view.forward(request, response);
            } else {
                request.setAttribute("EventBookList", list);
                RequestDispatcher view = request.getRequestDispatcher("booked.jsp");
                view.forward(request, response);
            }
        }else if(userType.equals("admin"))
        {
        	Eventmethods dao = new Eventmethods();
        	List<EventBook> list = dao.viewAllEvents();
        	if (list == null) {
                RequestDispatcher view = request.getRequestDispatcher("booked.jsp?msg=No Events Found");
                view.forward(request, response);
            } else {
                request.setAttribute("EventBookList", list);
                RequestDispatcher view = request.getRequestDispatcher("booked.jsp?username="+username+"&userType="+userType);
                view.forward(request, response);
            }
        	
        }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
