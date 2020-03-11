<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Edit user</title>
		<style>
			body, html {   
    			width: 100%;
    			height: 100%;
    			margin: 0;
    			padding: 0;
    			display: table;
			}
			
			#header {
				padding: 10px;
				text-align: left;
				background: #AEAEAE;
				color: white;
				font-size: 12px;
			}

			h2, h3 {
   				text-align: center;
			}

			input {
    			font-size: 16px;
    			text-align: center;
			}
			
			button {
				width: 100%;
				margin-top: 20px;
			}
			
			form {
    			display: table;
    			margin: auto;
			}
			
			table {
				 border-spacing: 10px;
    		     font-size: 18px;
			}
			
			.field {
				width = 100%;
			}			
		</style>
	</head>
	<body>
		<div id = "header">
			<h1>Admin panel v 1.0</h1>
		</div>
		
		<h2>Edit user</h2>
        <h3>for continue, you need fill the edit form</h3>
        <form action = "EditUser" method = "post">
        	<table>
        		<tbody>
        			<tr>
        				<td><label for = "username">Username: </label></td>
        				<td><input class = "field" id = "username" name = "username" type = "text" required = "required" pattern = "[A-Za-z]{3,18}" title = "Only words (3-18)"> <td>
        			</tr>
        			
        			<tr>
        				<td><label for = "username">New username: </label></td>
        				<td><input class = "field" id = "newusername" name = "newusername" type = "text" pattern = "[A-Za-z]{3,18}" title = "Only words (3-18)"> <td>
        			</tr>
        			
        			<tr>
        				<td><label for = "password">New password: </label></td>
        				<td><input class = "field" id = "newpassword" name = "newpassword" type = "text" pattern = "[0-9]{3, 18}" title = "Only numbers (3-18)"></td>
        			</tr>
        			
        			<tr>
        				<td></td>
        				<td><button type = "submit" name = "button" value = "edit">Edit user</button></td>
        			</tr>
        		</tbody>
        	</table>
        </form>
	</body>
</html>