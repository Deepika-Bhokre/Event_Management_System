
import java.util.*;
import java.util.Date;
import java.sql.*;
public class EventBook
{
	String City_name;
	String Event_name;
	String Date;
	String Time;
	String Username;
	String Ticket_no;
	String status;
	public String getCity_name() {
		return City_name;
	}
	public void setCity_name(String city_name) {
		City_name = city_name;
	}
	public String getEvent_name() {
		return Event_name;
	}
	public void setEvent_name(String event_name) {
		Event_name = event_name;
	}
	
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getTicket_no() {
		return Ticket_no;
	}
	public void setTicket_no(String ticket_no) {
		Ticket_no = ticket_no;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getTime() {
		return Time;
	}
	public void setTime(String time) {
		Time = time;
	}
	
	
}