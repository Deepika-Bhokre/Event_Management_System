<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="jakarta.servlet.*"%>
<%@ page import="jakarta.servlet.http.*"%>
 <%@ include file="header.jsp"%>
 <%
boolean username = false;
String userType = null;
cks = request.getCookies();
if (cks != null) {
	String cookieName1 = "userType";
	String cookieName2 = "username";
	for (int i = 0; i < cks.length; i++) {
		ck = cks[i];
		if (ck.getName().equals(cookieName1)) {
	userType = ck.getValue();
		} else if (ck.getName().equals(cookieName2)) {
	username = true;
		}
	}
}%>
<style>
*{
box-sizing:border-box;
}
.container
{

display:flex;
justify-content:space-evenly;
align-items:center;
margin-top:70px;
flex-wrap:wrap;
font-family: 'Ubuntu', sans-serif;	
font-weight : bold;
font-size: 18px;

}
.card-modify
{
display: flex;
justify-content: space-between;
margin-top: 30px;}

.card-container
{
border : 1px solid black;
display:inline-block;
margin : 15px;
padding : 15px;
box-shadow : 1px 1px 2px 2px;

}
img
{
height :250px;
width : 300px;
}
.info
{
   text-align : center;

}
#noOfItems
{
margin: 50px 20px;
}
label 
{
margin-left : 50px;}


.info div
{
margin:3px;
padding:3px;
}
.danger
{
   margin-left : 110px;
   margin-top:10px;
}



.
</style>
<body>
<%
String error = request.getParameter("error");
if (error != null && !error.equals("null")) {
%>
<h2  align="center">
	<%
	out.println(error);
	%>
</h2>
<%}else{
	%>
<div class="container">
<c:forEach var="i" items ="${EventList}">
	 <div class="card-container">
			<div class="image">
				<img src="${i.getImage()}" alt="no image found" >
			</div>
			<div class="info">
			<div class="title">Name :${i.getEvent_name()}</div>
			<div class="date">Date :${i.getEvent_date()}</div>
			<div class="time">Time :${i.getEvent_time()}</div>
			<div class="time">City :${city}</div>
			<div class="totalseats">Total Seats :${i.getTotal_seats()}</div>
			<div class="availableseats">Available seats :${i.getAvailable_seats()}</div>
			<div class="price">Price :Rs.${i.getTicket_price()}</div>
			</div>
			<%
				if (username && userType.equals("user")) {
				%>
				<form action="BookTickets">
				   <input type="text" name="qty" value="0" id="number" /> 
					    <input type="button" onclick="decrementValue()" value="-" /> 
						<input type="button" onclick="incrementValue()" value="+" /> 
				<input type="hidden" name="name" value="${i.getEvent_name()}">
					<button class="primary">Book Ticket</button>
				</form>
				<%
				}else if(username && userType.equals("admin")){
				%>
				<form action="EventDelete">
				<input type="hidden" name="name" value="${i.getEvent_name()}">
					<button class="danger">Delete Event</button>
				</form>
				<%
				}
				%>
				
		</div>
	
			
	</c:forEach>
</div>
 <%} %>
 <%@ include file="footer.html"%>
 
 
      
  
     
  
 