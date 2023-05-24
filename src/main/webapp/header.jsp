
<%@ page import="java.io.*"%>
<%@ page import="jakarta.servlet.*"%>
<%@ page import="jakarta.servlet.http.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Ubuntu&display=swap" rel="stylesheet">
<title>EMS</title>
</head>
<style>
body
{

font-family: 'Ubuntu', sans-serif;	
}
.navigation 
{
border:1px solid rgb(21, 12, 12);
box-shadow:2px 2px 4px 4px;
height:70x;
display : flex;
width:100%;	
border-radius:8px;
margin:auto;
background-color: white;
}

.navigation img
{
padding-left:2rem;
height:60px;
width : 110px;
}

.navigation ul
{
 display : flex;
 align-items:center;
 justify-content:center;
 margin-left : 157px;	
}
.navigation ul li
{
margin: 0 14px;
padding :0 19px;
list-style:none;
color : violet;

}
.navigation ul li:hover
{
cursor:pointer;
}
a
{
text-decoration:none;
}

.dropdown .dropbtn {
  font-size: 16px;
  border: none;
  outline: none;
  color: black;
  padding: 14px 16px;
  background-color:inherit;
  font-family: inherit; 
  margin: 0; 
}

.dropdown:hover .dropbtn {
  background-color: #f0f0f0;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 160px;
}
.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
 
}

.dropdown-content a:hover {
  background-color: #ddd;
}
.dropdown:hover .dropdown-content {
  display: block;
}
.searchclass
{
 margin-left:20px;
}

</style>
<body>
<%Cookie[] cks = null;
	Cookie ck = null;
	cks = request.getCookies();
	if (cks != null) {
		String cookieName1 = "userType";
		String cookieName2 = "username";
		boolean username = false;
		String userType = null;
		for (int i = 0; i < cks.length; i++) {
			ck  = cks[i];
			if (ck.getName().equals(cookieName1)) {
		userType = ck.getValue();
			} else if (ck.getName().equals(cookieName2)) {
		username = true;
			}
		}%>
<nav class=navigation>

<ul>
<li><a href="home.jsp">Home</a></li>
<li>
<%
if (userType != null && userType.equals("admin")) {
%>
	<li><a href="addevent.jsp">Add Event</a></li>
<%
}	
%>
       <%
          if (!username && userType == null) {
       %>
       <li>
<div class="dropdown">
    <button class="dropbtn">Login
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="User_Login.jsp">User</a>
      <a href="Admin_Login.jsp">Admin</a>
    </div>
  </div>
</li>
<li>
<div class="dropdown">
    <button class="dropbtn">Register
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="User_Register.jsp">User</a>
      <a href="Admin_Register.jsp">Admin</a>
    </div>
  </div>
</li>
       <%
        } 
      else {
       %>
    <li><a href="displayevents.jsp">Select City to know Events</a></li>
     <li><a href="DisplayBookings">Booked tickets</a></li>
	<li><a href="logout">Logout</a></li>
<%
     }
} 
else {
	
%>
<li>
<div class="dropdown">
    <button class="dropbtn">Login
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="Customer_Login.jsp">User</a>
      <a href="ShopkeeperLogin.jsp">Admin</a>
    </div>
  </div>
</li>

<%
			}
		%>	


</nav>



</body>

</html>