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

.container
{

display:flex;
justify-content:space-evenly;
align-items:center;
flex-wrap:wrap;
font-family: 'Ubuntu', sans-serif;	
font-weight : bold;
font-size: 18px;

}

.card-container
{
border: 1px solid black;
display: inline-block;
margin: 24px;
padding: 70px;
box-shadow: 4px 4px 8px 6px;
background-color: #f9f5f9;

}
label 
{
margin-left : 50px;
margin-top : 100px;
font-size : 20px;
}
.form
{
margin: 100px;
margin-left: 600px;
}

#city
{
   font-size : 18px;
}
.instock
{
   font-size : 23px;
}
.success
{
margin-left: 35px;
font-size: 18px;}
button:hover
{
   cursor:pointer;
   background-color: #dae29d;
   
}


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
<form action="EventsServlet" method="post" class="form">
	<div>
		<label for="city">Choose City to Display Category of events in this city :</label> 
		<select name="city" id="city">
		  <option value="Sangareddy">Sangareddy</option>
                 <option value="Hyderabad">Hyderabad</option>
                    <option value="Chennai">Chennai</option>
                    <option value="Mumbai">Mumbai</option>
                    <option value="Amaravati">Amaravati</option>
         </select>
         <button class="success" type="submit">Enter</button>
	</div>
	
</form>

<div class="container">
<c:forEach var="i" items ="${CategoryList}">
 <a href="cateveservlet?cat=${i}&ct=${c}"><button type="submit" class="card-container">
		<div class="instock">${i}</div>
 </button> 	
 </a>
 
 
</c:forEach>
</div>
 <%} %>
 <%@ include file="footer.html"%>
 
 
      
  
     
  
 