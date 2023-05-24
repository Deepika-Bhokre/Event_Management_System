

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddUserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public AddUserRegister() {
        super();
        // TODO Auto-generated constructor stub
    }
    String url = "jdbc:mysql://localhost:3306/EMS";
    String user = "root";
    String password = "Deepika@12";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            String type = "user";
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            if(checkShopkeepername(email,type))
            {
            	 request.setAttribute("error", "UserName Already exits");
                 RequestDispatcher view = request.getRequestDispatcher("error.jsp");
                 view.forward(request, response);
            }
            else
            {
            	
                String itemInsertQuery = "insert into Register values(?,?,?,?,?)";
                PreparedStatement Item = con.prepareStatement(itemInsertQuery);
                Item.setString(1, name);
                Item.setString(2, email);
                String pass = request.getParameter("password");
                Item.setString(3, pass);
                String mobile = request.getParameter("mobile");
                Item.setString(4, mobile);
                Item.setString(5, type);
                Item.execute();
                response.sendRedirect("home.jsp");
              
            }
//           
//            response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
//            response.setHeader("Location", "home.jsp");
        } catch (Exception ex) {
            request.setAttribute("error", ex);
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	public boolean checkShopkeepername(String Name , String type) {
        String query = "select count(*) from  Register"  + " where Email=\"" + Name + "\" and Usertype=\"" + type + "\";";
        PreparedStatement ps;
        try {
        	 Class.forName("com.mysql.cj.jdbc.Driver");
             Connection con = DriverManager.getConnection(url, user, password);
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                if (rs.getInt(1) == 0) {
                    return false;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return true;
    }

}
