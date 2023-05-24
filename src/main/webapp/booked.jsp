<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ include file="header.jsp" %>
   <style>
   .con
   {
   display : flex;
   margin-left: 110px;
margin-top: -20px;
   }
 .img 
 {
 height: 82px;
width: 99px;
 }
 .con div
 {
 margin : 30px;
 margin-left: 55px;
 }
 .info div
 {
   margin-top: 40px;

width: 127px;
 }
 .info
 {
    display : flex;
    font-size :18px;
 }
 .con
 {
  margin-left: 329px;
margin-top: 20px;
margin-right: 339px;
border: 3px solid black;
<%
if (request.getParameter("userType")!= null && request.getParameter("userType").equals("admin")) {
%>
 margin-right:140px;
 margin-left: 224px;
<%}
%>
}
}
.cartcon
{
display : inline-block;
margin-left: 110px;
  margin-top: 40px;
}
.title
{
  display: flex;
margin-left: 328px;
<%
if (request.getParameter("userType")!= null && request.getParameter("userType").equals("admin")) {
%>
 margin-left: 228px;
<%}
%>
margin-top: 10px;
border: 3px solid black;
box-shadow: 2px 2px 3px 3px;
background-color: #f0f0f9;
}
}
td
{
margin-top: 50px;
height: 40px;
width: 196px;	
}
table
{
  margin-bottom : 20px;
}
.red
{
   width: 80px;
height: 30px;

}
.red:hover
{
background-color : #ff6666;
}
.center
{
text-align : center;
font-size: 23px;
margin-left: 94px;
}
.flex
{
display: flex;
align-items : center;
margin-top: 50px;

margin: 40px 318px;
}
.flex div
{
   padding: 0 141px;
 }
.order
{width: 100px;
height: 50px;}
.order:hover
{
background-color:cyan;
}
.flexform
{
display : flex;
margin-top : 30px;
justify-content : space-around;

}
.form
{
 display : flex;
}
.form div
{
 margin:5px;
}
info.total
{
<%
if (request.getParameter("userType")!= null && request.getParameter("userType").equals("admin")) {
%>
     margin-left: 176px;
  
<%}
%>
}
   </style>
  

   
  	
    <h1 class="success-para" align="center">
		<%
		String msg = request.getParameter("msg");
		if (msg != null && !msg.equals("null")) {
			out.println(msg);
		}else {
			out.println("Booked Tickets");
		}
		%>
	</h1>
   <table>
   <tr class="title">
 
            
            
             <td style = "margin-top: 40px;
height: 40px;
width: 196px;
font-weight: bold;
font-size: 20px;
margin-left: 68px;
text-align:center"
>City Name</td>
              
            
             <td style = "margin-top:40px;height:40px;width: 196px;margin-right: -16px;
margin-left: 41px;font-weight : bold; font-size:20px">Event_name</td>
             <td style = "margin-top:40px;height:40px;width: 196px;font-weight : bold; font-size:20px ; margin-left:64px">Date</td>
             <td style = "margin-top:40px;height:40px;width: 196px;font-weight : bold; font-size:20px">Time</td>
             <%
					if (request.getParameter("userType")!= null && request.getParameter("userType").equals("admin")) {
					%>
					 <td style = "margin-top:40px;height:40px;width: 196px;font-weight : bold; font-size:20px">UserName</td>
					<%
					}
					%>
             <td style = "margin-top:40px;height:40px;width: 196px;font-weight : bold; font-size:20px">Ticket No</td>
             <td style = "margin-top:40px;height:40px;width: 196px;font-weight : bold; font-size:20px;margin-right: 27px;margin-left:19px">Status</td>
 </tr>
 </tr>
</table>    
<div class="container" style="margin-top: 10px;
border: 1px solid black;
margin-left: 271px;
display : contents">
  <div class="cartcon" ">
 <c:forEach var="i" items="${EventBookList}">
       <div class="con" >
          
            <div class = info>
                <div class="name">${i.getCity_name()}</div>
                <div class="category">${i.getEvent_name()}</div>
                <div class="price">${i.getDate()}</div>
                <div class="qtycss">${i.getTime()}</div>
                 <%
					if (request.getParameter("userType")!= null && request.getParameter("userType").equals("admin")) {
					%>
					<div class="email">${i.getUsername()}</div>
					<%
					}
					%>
			    <div class="total">${i.getTicket_no()}</div>
			    <div class="status">${i.getStatus()}</div>
	       </div> 
       </div>
 </c:forEach>
 </div>

<%@ include file="footer.html"%>