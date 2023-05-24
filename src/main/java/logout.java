
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
public class logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public logout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 Cookie cookie = null;
	        Cookie[] cookies = null;

	        // Get an array of Cookies associated with this domain
	        cookies = request.getCookies();

	        // Set response content type
	        response.setContentType("text/html");

	        if (cookies != null) {

	            for (int i = 0; i < cookies.length; i++) {
	                cookie = cookies[i];
	                if (cookie.getName().equals("username") || cookie.getName().equals("userType")) {

	                    cookie.setMaxAge(0);
	                    response.addCookie(cookie);
	                }
	            }
	        }
	        response.sendRedirect(".jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
