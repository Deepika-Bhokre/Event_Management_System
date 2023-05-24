import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

  
public class EventsServlet extends HttpServlet {
  
    private static final long serialVersionUID = 1L;
    public EventsServlet() { super(); }
  
    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws ServletException, IOException
    {
    	String cname = request.getParameter("city");
    	Eventmethods dao = new Eventmethods();
    	List<String> list = dao.searchCategoriesfromcity(cname);
    	request.setAttribute("CategoryList", list);
    	String msg = request.getParameter("error");
    	request.setAttribute("c", cname);
        RequestDispatcher view
            = request.getRequestDispatcher("displayevents.jsp");
        view.forward(request, response);
      
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}