import java.sql.Time;
import java.util.Date;

public class Event{
	String City_name;
    String Event_category;
    String Event_name;
    Date Event_date;
    Time Event_time;
    int Total_seats;
    int Available_seats;
    int Ticket_price;
    String Image;
	public String getCity_name() {
		return City_name;
	}
	public void setCity_name(String city_name) {
		City_name = city_name;
	}
	public String getEvent_category() {
		return Event_category;
	}
	public void setEvent_category(String event_category) {
		Event_category = event_category;
	}
	public String getEvent_name() {
		return Event_name;
	}
	public void setEvent_name(String event_name) {
		Event_name = event_name;
	}
	public Date getEvent_date() {
		return Event_date;
	}
	public void setEvent_date(Date event_date) {
		Event_date = event_date;
	}
	public Time getEvent_time() {
		return Event_time;
	}
	public void setEvent_time(Time event_time) {
		Event_time = event_time;
	}
	public int getTotal_seats() {
		return Total_seats;
	}
	public void setTotal_seats(int total_seats) {
		Total_seats = total_seats;
	}
	public int getAvailable_seats() {
		return Available_seats;
	}
	public void setAvailable_seats(int available_seats) {
		Available_seats = available_seats;
	}
	public int getTicket_price() {
		return Ticket_price;
	}
	public void setTicket_price(int ticket_price) {
		Ticket_price = ticket_price;
	}
	public String getImage() {
		return Image;
	}
	public void setImage(String image) {
		Image = image;
	}
	
}