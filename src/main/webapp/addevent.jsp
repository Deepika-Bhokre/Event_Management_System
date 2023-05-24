<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html lang="en-us">
<head>
<meta charset="UTF-8">
<title>Shopkeeper Register</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Ubuntu&display=swap"
	rel="stylesheet">
</head>
<style>
* {
	box-sizing: border-box;
}

body {
	font-family: 'Ubuntu', sans-serif;
}

input[type=text], input[type=url],input[type=number],select{
	width: 45%;
	padding: 12px;
	border: 1px solid rgb(168, 166, 166);
	border-radius: 4px;
	resize: vertical;
}


h1 {
	font-size: 40px;
	font-style: normal;
	font-weight: bold;
	text-align: center;
}

label {
	padding: 12px 12px 12px 0;
	display: inline-block;
}

input[type=submit] {
	background-color: #4CAF50;
	color: white;
	padding: 12px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	float: left;
	margin-top: 50px;
}

input[type=submit]:hover {
	background-color: #32a336;
}

.container {
	border-radius: 5px;
	margin-left: 550px;
	margin-top: 50px;
	padding: 20px;
	font-family: 'Ubuntu', sans-serif;
}

.col-10 {
	float: left;
	width: 10%;
	margin-top: 6px;
}

.col-90 {
	float: left;
	width: 90%;
	margin-top: 10px;
}

.row:after {
	content: "";
	display: table;
	clear: both;
}
.form-container
{
margin-left : 600px;

}
.row
{
 margin:-2px;
 padding : 10px;
}
.form-error
{
   font-size : 18px;
   color : red;
}




</style>

<body>
	<h1>Add Event</h1>
	<div class="form-container">
		<form method="post" action="AddEvent"  id="add-form" class="add" onsubmit="return validateAddEventForm()">
			<div class="row">
				<div class="col-10">
					<label for="item_name">City Name:</label>
				</div>
				<div class="col-90">
					<select name="item_name" id="item_name">
		  <option value="Sangareddy">Sangareddy</option>
                 <option value="Hyderabad">Hyderabad</option>
                    <option value="Chennai">Chennai</option>
                    <option value="Mumbai">Mumbai</option>
                    <option value="Amaravati">Amaravati</option>
         </select>
				</div>
			</div>
			<div class=row>
			 <div class="col-10">
			  <label for="item_category">Event Category</label>
			  </div>
               <div class="col-90">
                <select name="item_category" id="Category">
                 <option value="comedy show">Comedy Show</option>
                    <option value="motivational talk">Motivational talk</option>
                    <option value="festival celebrations">Festival Celebrations</option>
                    <option value="exhibitions">Exhibitions</option>
                    <option value="blood donation camps">Blood Donation Camps</option>
                </select>
               </div>
            </div>
			<div class="row">
				<div class="col-10">
					<label for="event_name">Event Name:</label>
				</div>
				<div class="col-90">
					<input type="text" id="event_name" name="event_name"
						placeholder="Enter Event Name">
				</div>
			</div>
			<div class="row">
				<div class="col-10">
					<label for="item_price">Event Date :</label>
				</div>
				<div class="col-90">
					<input type="date" id="item_price" name="item_price">
				</div>
			</div>
			<div class="row">
				<div class="col-10">
					<label for="item_item">Event Time :</label>
				</div>
				<div class="col-90">
					<input type="time" id="item_item" name="item_item">
				</div>
			</div>
			<div class="row">
				<div class="col-10">
					<label for="totalseats">Total Seats :</label>
				</div>
				<div class="col-90">
					<input type="number" id="totalseats" name="totalseats">
				</div>
			</div>
			<div class="row">
				<div class="col-10">
					<label for="availableseats">Available Seats :</label>
				</div>
				<div class="col-90">
					<input type="number" id="availableseats" name="availableseats">
				</div>
			</div>
			<div class="row">
				<div class="col-10">
					<label for="ticketprice">Ticket Price :</label>
				</div>
				<div class="col-90">
					<input type="number" id="ticketprice" name="ticketprice">
				</div>
			</div>
			
			<div class="row">
				<div class="col-10">
					<label for="item_img">Image :</label>
				</div>
				<div class="col-90">
					<input type="url" id="item_img" name="item_img">
				</div>
			</div>
			
			<div class="row">
			<p class="form-error" id="error-para"></p>
				<input type="submit" value="Add" onsubmit="return validateAddEventForm()" >
			</div>
		</form>
	</div>
</body>
<%@ include file="footer.html" %>
</html>