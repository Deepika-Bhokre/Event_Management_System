import java.rmi.server.UID;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
public class Eventmethods
{
	Connection connection;
    Statement stmt;
    int noOfRecords;
    private static Connection getConnection() throws SQLException, ClassNotFoundException
    {
        Connection con = ConnectionFactory.getInstance().getConnection();
        return con;
    }
    public List<Event> viewAllEventswithCategory1(String Category , String City)
    {
    	 LocalDate dateObj = LocalDate.now();
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
         String date = dateObj.format(formatter);
        String query = "select * from Event_details where Event_Category=\"" + Category + "\" and City_name= \"" + City + "\" and Event_date >=\"" + date+"\";";
        List<Event> list = new ArrayList<Event>();
        Event card = null;
        try {
            connection = getConnection();
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                card = new Event();
                card.setCity_name(rs.getString(1));
                card.setEvent_category(rs.getString(2));
                card.setEvent_name(rs.getString(3));
                card.setEvent_date(rs.getDate(4));
                card.setEvent_time(rs.getTime(5));
                card.setTotal_seats(rs.getInt(6));
                card.setAvailable_seats(rs.getInt(7));
                card.setTicket_price(rs.getInt(8));
                card.setImage(rs.getString(9));
                list.add(card);
            }
  
            rs.close();
            rs = stmt.executeQuery(query);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public List<EventBook> viewAllEventswithUsername(String name)
    {
        String query = "select * from Event_ticket_booked_details where Username=\"" + name + "\";";
        List<EventBook> list = new ArrayList<EventBook>();
        EventBook card = null;
        try {
            connection = getConnection();
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                card = new EventBook();
                card.setCity_name(rs.getString(1));
                card.setEvent_name(rs.getString(2));
                card.setDate(rs.getString(3));
                card.setTime(rs.getString(4));
                card.setUsername(rs.getString(5));
                card.setStatus(rs.getString(7));
                card.setTicket_no(rs.getString(6));
                list.add(card);
            }
  
            rs.close();
            rs = stmt.executeQuery(query);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public List<String> searchCategoriesfromcity(String Name) {
		// TODO Auto-generated method stub
		 String query = "select DISTINCT Event_category from Event_details where City_name=\""+Name+"\";";
		 List<String> list = new ArrayList<String>();
	     String item = null;
	     try {
	            connection = getConnection();
	            stmt = connection.createStatement();
	            ResultSet rs = stmt.executeQuery(query);
	            while (rs.next()) {
	                item = new String();
	                item = rs.getString(1);
	                list.add(item);
	            }
	            rs.close();
	            connection.close();
	            stmt.close();

	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	        return list;
	     
	}
    public void deleteEvent(String Name) {
        String query="delete from Event_details where Event_name=\""+Name+"\";";
        try {
            connection = getConnection();
            Statement stmt = connection.createStatement();
            stmt.execute(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Event getEvent(String Name)
    { 
    	Event card = new Event();
    	String query = "select * from Event_details where Event_name=\"" + Name + "\";";
    	try {
            connection = getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                card.setCity_name(rs.getString(1));
                card.setEvent_category(rs.getString(2));
                card.setEvent_name(rs.getString(3));
                card.setEvent_date(rs.getDate(4));
                card.setEvent_time(rs.getTime(5));
                card.setTotal_seats(rs.getInt(6));
                card.setAvailable_seats(rs.getInt(7));
                card.setTicket_price(rs.getInt(8));
                card.setImage(rs.getString(9));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    	return card;
    }
    public void addEventoBooked(Event item, String username,int qty) {
        String status = "booked";
        String query = "insert into Event_ticket_booked_details(City_name,Event_name,Date,Time,Username,status)  values(?,?,?,?,?,?);";
        try {
            connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
             for(int i=0;i<qty;i++)
             {
            	 ps.setString(1, item.getCity_name());
                 ps.setString(4, (item.getEvent_time().toString()));
                 ps.setString(3,(item.getEvent_date().toString()));
                 ps.setString(6, status);
                 ps.setString(5, username);
                 ps.setString(2, item.getEvent_name());
                 ps.execute();
                 int oldstock = item.getAvailable_seats();
                 int newStock = oldstock - qty;
                 if (newStock == 0) {
                   Eventmethods dao=new Eventmethods();
                      dao.deleteEvent(username,item.Event_name);
                 } else {
                     updateEventSeats(item.Event_name, newStock);
                  } 
             }
                

            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void updateEventSeats(String name, int seats) {
        String query = "update Event_details set Available_seats=" + seats + " where Event_name=\"" + name + "\";";
        try {
            connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void deleteEvent(String username, String item_id) {
        String query = "delete from Event_details where Event_name=\"" + item_id + "\" and Username=\"" + username + "\";";
        try {
            connection = getConnection();
            Statement stmt = connection.createStatement();
            stmt.execute(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void setNoOfRecords1(int a) {
        noOfRecords=a;
    }
	public List<EventBook> viewAllEvents() {
		String query = "select * from Event_ticket_booked_details ";
        List<EventBook> list = new ArrayList<EventBook>();
        EventBook card = null;
        try {
            connection = getConnection();
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                card = new EventBook();
                card.setCity_name(rs.getString(1));
                card.setEvent_name(rs.getString(2));
                card.setDate(rs.getString(3));
                card.setTime(rs.getString(4));
                card.setUsername(rs.getString(5));
                card.setStatus(rs.getString(7));
                card.setTicket_no(rs.getString(6));
                list.add(card);
            }
  
            rs.close();
            rs = stmt.executeQuery(query);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return list;
		
		
	}
	public void deleteEventfromBookings(String Name) {
		String query="delete from Event_ticket_booked_details where Event_name=\""+Name+"\";";
        try {
            connection = getConnection();
            Statement stmt = connection.createStatement();
            stmt.execute(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		
	}

}