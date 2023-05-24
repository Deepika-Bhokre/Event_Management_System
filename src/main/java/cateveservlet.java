import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

  
public class cateveservlet extends HttpServlet {
  
    private static final long serialVersionUID = 1L;
    public cateveservlet() { super(); }
 
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws ServletException, IOException
    {
    	String cname = request.getParameter("ct");
    	String cat=request.getParameter("cat");
    	System.out.println(cname);
    	Eventmethods dao = new Eventmethods();
    	List<Event> list = dao.viewAllEventswithCategory1(cat,cname);
    	request.setAttribute("EventList", list);
    	request.setAttribute("city", cname);    	 
    	String msg = request.getParameter("error");
        RequestDispatcher view
            = request.getRequestDispatcher("display.jsp");
        view.forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}